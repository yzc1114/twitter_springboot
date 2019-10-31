package com.yzchnb.twitter.controller;

import com.yzchnb.twitter.configs.ExceptionDefinition.UserException;
import com.yzchnb.twitter.entity.TableEntity.UserPublicInfo;
import com.yzchnb.twitter.service.IUserService;
import com.yzchnb.twitter.utils.Utils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import sun.security.x509.OtherName;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Map;

@RestController
@Api(tags = "用户管理相关接口")
@RequestMapping("/api/user")
public class UserController {

    @Resource
    private IUserService iUserService;

    @GetMapping("/getUserPublicInfo/{userId}")
    @ApiOperation("查看某人可公开的信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户id", required = true)
    })
    public Map GetUserPublicInfo(@PathVariable int userId){
        return iUserService.GetUserPublicInfo(userId);
    }

    @PostMapping(value = "/signUp")
    @ApiOperation("注册接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "email", value = "邮箱", required = true),
            @ApiImplicitParam(name = "nickname", value = "昵称", required = true),
            @ApiImplicitParam(name = "password", value = "密码", required = true)
    })
    public void SignUp(@RequestParam("email") String email,
                         @RequestParam("nickname") String nickname,
                         @RequestParam("password") String password){
        iUserService.SignUp(email, nickname, password);
    }

    @PostMapping(value = "/signIn")
    @ApiOperation("登录接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "email", value = "邮箱", required = true),
            @ApiImplicitParam(name = "password", value = "密码", required = true)
    })
    public boolean SignIn(@RequestParam("email")String email,
                          @RequestParam("password")String password,
                          HttpServletResponse response){
        Integer userId = iUserService.SignIn(email, password);
        if(userId.equals(0)){
            return false;
        }
        //写入cookie的方法
        response.addCookie(new Cookie("userId", userId.toString()));
        return true;
    }

    @GetMapping(value = "/logout")
    @ApiOperation("退出登录")
    public void logout(HttpServletRequest request , HttpServletResponse response){
        Cookie[] cookies = request.getCookies();
        if (cookies != null){
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("userId")){
                    cookie.setValue(null);
                    cookie.setMaxAge(0);
                    cookie.setPath("/");
                    response.addCookie(cookie);
                    break;
                }

            }
        }


    }

    @GetMapping(value = "/checkIfSignUp")
    @ApiOperation("检查是否登录")
    public boolean checkIfSignUp(HttpServletRequest request) {
        //从cookie中取用户id的方法
        Integer userId = Utils.getUserIdFromCookie(request);
        return userId != 0;
    }

    @GetMapping(value = "/getRecommend")
    @ApiOperation("获得推荐用户")
    public ArrayList GetRecommend() {
        return iUserService.GetRecommend();
    }

    @GetMapping(value = "/getAllUserInfo")
    @ApiOperation("查看用户所有信息")
    public Map GetAllUserInfo(HttpServletRequest request){
        int user_id = Utils.getUserIdFromCookie(request);
        //验证登录
        try {
            if (user_id == 0) throw new UserException("用户未登录");
            return iUserService.GetAllInfo(user_id);

        }catch (Exception e){
            System.out.println(e);
        }

        return null;
    }
}

