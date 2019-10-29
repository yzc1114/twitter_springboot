package com.yzchnb.twitter.controller;

import com.yzchnb.twitter.entity.TableEntity.UserPublicInfo;
import com.yzchnb.twitter.service.IUserService;
import com.yzchnb.twitter.utils.Utils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

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
    @ApiOperation("添加用户的接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "user_id", value = "用户id", required = true)
    })
    @ResponseBody
    public Map GetUserPublicInfo(@PathVariable int userId){
        return iUserService.GetUserPublicInfo(userId);
    }

    @PostMapping(value = "/signIn")
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

    @PostMapping(value = "/signUp")
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
}
