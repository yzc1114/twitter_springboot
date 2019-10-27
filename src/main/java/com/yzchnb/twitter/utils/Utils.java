package com.yzchnb.twitter.utils;

import com.yzchnb.twitter.dao.FunctionCaller.FuncGetUserAvatarCaller;
import com.yzchnb.twitter.dao.FunctionCaller.FuncShowMessageByIdCaller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
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
        System.out.println(request);
        Cookie[] cookies = request.getCookies();
        if(cookies != null){
            for (Cookie cookie: cookies) {
                if(cookie.getName().equals("userId")){
                    return Integer.parseInt(cookie.getValue());
                }
            }
        }
        return 0;
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
            result.add(getMessageById(id.get("message_id")));
        }
        return result;
    }
    public static void setMessageUrl(Map message){
    }
}
