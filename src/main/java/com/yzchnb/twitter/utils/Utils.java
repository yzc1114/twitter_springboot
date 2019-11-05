package com.yzchnb.twitter.utils;

import com.yzchnb.twitter.dao.FunctionCaller.FuncGetUserAvatarCaller;
import com.yzchnb.twitter.dao.FunctionCaller.FuncShowMessageByIdCaller;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Map;

@Component
public class Utils {

    private static FuncGetUserAvatarCaller funcGetUserAvatarCaller;
    private static FuncShowMessageByIdCaller funcShowMessageByIdCaller;
    @Autowired
    public Utils(FuncGetUserAvatarCaller funcGetUserAvatarCaller,FuncShowMessageByIdCaller funcShowMessageByIdCaller){
        Utils.funcGetUserAvatarCaller=funcGetUserAvatarCaller;
        Utils.funcShowMessageByIdCaller=funcShowMessageByIdCaller;
    }

    public static Integer getUserIdFromCookie(HttpServletRequest request) {
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
        Object value=request.getSession().getAttribute("userId");
        if(value==null){
            return 0;
        }else{
            return Integer.parseInt(value.toString());
        }

    }
    public static void setSession(HttpServletRequest request,int user_id){
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
    public static String getAvatarsLocation() throws FileNotFoundException {
        return ResourceUtils.getURL("classpath:").getPath()+"avatar/";
    }
    public static String getImageLocation() throws FileNotFoundException{
        return ResourceUtils.getURL("classpath:").getPath()+"img/";
    }

    public static String getAvatarUrlById(int user_id){
        return "/avatars/"+funcGetUserAvatarCaller.call(user_id).toString();
    }
    public static void setAvatarUrl(Map user){
        user.put("avatarUrl",getAvatarUrlById(Integer.parseInt(user.get("userId").toString())));
    }
    public static Map getMessageById(int message_id){
        Map result=(Map)funcShowMessageByIdCaller.call(message_id).get(0);
        setMessageUrl(result);
        return result;
    }
    public static Map getMessageById(Object message_id){
        return getMessageById(Integer.parseInt(message_id.toString()));
    }
    public static ArrayList<Map> getMessageFromArray(ArrayList<Map> message_ids){
        ArrayList<Map> result=new ArrayList<>();
        for(Map id:message_ids){
            result.add(getMessageById(id.get("messageId")));
        }
        return result;
    }
    public static void setMessageUrl(Map message){
    }

    public static ArrayList getTopicContent(String message){
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

    public static ArrayList getAtContent(String message){
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
    static public class Range{
        public int startFrom;
        public int limitation;
    }
}
