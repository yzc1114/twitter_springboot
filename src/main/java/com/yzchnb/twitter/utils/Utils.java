package com.yzchnb.twitter.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

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
}
