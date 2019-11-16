package com.yzchnb.twitter.utils;

import com.yzchnb.twitter.dao.FunctionCaller.*;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Component
public class Utils {

    @Resource
    private  FuncGetUserAvatarCaller funcGetUserAvatarCaller;
    @Resource
    private  FuncShowMessageByIdCaller funcShowMessageByIdCaller;
    @Resource
    private FuncGetTopicIdByNameCaller funcGetTopicIdByNameCaller;
    @Resource
    private FuncGetUserIdByNameCaller funcGetUserIdByNameCaller;

    public  Integer getUserIdFromCookie(HttpServletRequest request) {
        //System.out.println(request);
        /*Cookie[] cookies = request.getCookies();
        for(Cookie i:cookies){
            System.out.println(i.getName()+" "+i.getValue());
        }
        if(cookies != null){
            for (Cookie cookie: cookies) {
                if(cookie.getName().equals("userId")&&!cookie.getValue().equals("")){
                    return Integer.parseInt(cookie.getValue());
                }
            }
        }*/
        Object value=request.getSession(true).getAttribute("userId");
        if(value==null){
            return 0;
        }else{
            return Integer.parseInt(value.toString());
        }

    }
    public  void setSession(HttpServletRequest request, int user_id){
        /*Cookie cookie=new Cookie("userId",null);
        cookie.setPath("/");
        //cookie.setSecure(true);
        cookie.setMaxAge(0);
        if(user_id!=0){
            cookie.setValue(String.valueOf(user_id));
            cookie.setMaxAge(max_time);
        }
        System.out.println(cookie.getValue());
        return cookie;*/
        if(user_id==0){
            request.getSession().removeAttribute("userId");
        }else{
            request.getSession(true).setAttribute("userId",user_id);
        }

    }
    public  String getAvatarsLocation() throws FileNotFoundException {
        return ResourceUtils.getURL("classpath:").getPath()+"upload/avatar/";
    }
    public  String getImageLocation() throws FileNotFoundException{
        return ResourceUtils.getURL("classpath:").getPath()+"upload/img/";
    }

    public  String getAvatarUrlById(int user_id){
        return "/upload/avatar/"+funcGetUserAvatarCaller.call(user_id).toString();
    }


    public  void setAvatarUrl(Map user){
        user.put("avatarUrl", getAvatarUrlById(Integer.parseInt(user.get("userId").toString())));
    }

    public  void setMessageUrl(Map message){
        ArrayList<String> urls = new ArrayList<String>();
        if (!message.get("messageHasImage").toString().equals("0")){
            String messageId = message.get("messageId").toString();
            String path = "/upload/img/" + messageId;
            File file = new File(path);
            File[] allFiles = file.listFiles();
            assert allFiles != null;
            for (File f:allFiles) {
                urls.add(f.getName());
            }
        }
        message.put("messageImageUrls", urls);


    }

    public  Map getMessageById(int message_id){
        Map result=(Map)funcShowMessageByIdCaller.call(message_id).get(0);
        setMessageUrl(result);
        setMessageAt(result);
        setMessageTopic(result);
        return result;
    }


    private void setMessageTopic(Map result) {
        ArrayList<String> names=getTopicContent(result.get("messageContent").toString());
        ArrayList<Map> topics=new ArrayList<>();
        for(String name:names){
            int topic_id=funcGetTopicIdByNameCaller.call(name);
            Map<Object,Object>topic=new HashMap<>();
            topic.put("topicId",topic_id);
            topic.put("topicName",name);
            topics.add(topic);
        }
        result.put("messageTopics",topics);
    }

    private void setMessageAt(Map result) {
        ArrayList<String> names=getAtContent(result.get("messageContent").toString());
        ArrayList<Map> at_users=new ArrayList<>();
        for(String name:names){
            int at_id=funcGetUserIdByNameCaller.call(name);
            Map<Object,Object>topic=new HashMap<>();
            topic.put("atId",at_id);
            topic.put("atName",name);
            at_users.add(topic);
        }
        result.put("messageAts",at_users);
    }

    public  Map getMessageById(Object message_id){
        return getMessageById(Integer.parseInt(message_id.toString()));
    }

    public  ArrayList<Map> getMessageFromArray(ArrayList<Map> message_ids){
        ArrayList<Map> result=new ArrayList<>();
        for(Map id:message_ids){
            result.add(getMessageById(id.get("messageId")));
        }
        return result;
    }


    public  ArrayList getTopicContent(String message){
        int start=-1;
        boolean flag=false;
        ArrayList<String> result=new ArrayList<>();
        for(int i=0;i<message.length();++i){
            if(message.charAt(i)=='#'){
                if(start==-1){
                    start=i+1;
                }else{

                    if(flag){
                        result.add(message.substring(start,i));
                        flag=false;
                    }
                    start=-1;

                }
            }else{
                if(start!=-1&&(!Character.isSpaceChar(message.charAt(i)))){
                    flag=true;
                }
            }
        }
        return result;
    }

    public  ArrayList getAtContent(String message){
        ArrayList<String> result=new ArrayList<>();
        int start=-1;
        boolean flag=false;
        for(int i=0;i<message.length();++i){
            if(message.charAt(i)=='@'){
                if(start!=-1){
                    if(flag){
                        result.add(message.substring(start,i));
                    }
                    flag=false;
                }
                start=i+1;
            }else{
                if(start!=-1){
                    if(Character.isSpaceChar(message.charAt(i))){
                        if(flag){
                            result.add(message.substring(start,i));
                        }
                        flag=false;
                        start=-1;
                    }else{
                        flag=true;
                    }
                }
            }
        }
        if(start!=-1){
            if(flag){
                result.add(message.substring(start));
            }
        }
        return result;
    }
}
