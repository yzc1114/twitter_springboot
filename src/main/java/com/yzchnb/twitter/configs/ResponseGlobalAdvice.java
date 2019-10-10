package com.yzchnb.twitter.configs;

import com.yzchnb.twitter.utils.ResponseFormat;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@ControllerAdvice
public class ResponseGlobalAdvice implements ResponseBodyAdvice<Object> {
    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    @ExceptionHandler({ Exception.class })
    @ResponseBody
    public Exception handleUserException(Exception e) {
        e.printStackTrace();
        //TODO combine with global response data format
        return e;
    }
    /**
     * 过滤
     *
     */
    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType,
                                  Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request,
                                  ServerHttpResponse response) {
        System.out.println("starting filter");
        String requestPath = request.getURI().getPath();// 普通response不进行过滤
        if (!requestPath.startsWith("/api")) {
            return body;
        }
        ResponseFormat res = new ResponseFormat();
        if(body instanceof Boolean) {
            res.setCode(200);
            res.setMessage(body.equals(true) ? "success" : "fail");
            return res;
        }
        if(body instanceof Exception) {
            System.out.println("Exception Encountered");
            res.setCode(500);
            res.setMessage("fail");
            res.setData(((Exception)body).getMessage());
            return res;
        }
        res.setCode(200);
        res.setMessage("success");
        res.setData(body);
        return res;
    }
}
