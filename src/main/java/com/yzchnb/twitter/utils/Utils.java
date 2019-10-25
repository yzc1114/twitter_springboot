package com.yzchnb.twitter.utils;

import org.springframework.util.ResourceUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.FileNotFoundException;

public class Utils {
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
}
