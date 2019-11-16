package com.yzchnb.twitter.controller;

import com.yzchnb.twitter.configs.ExceptionDefinition.UserException;
import com.yzchnb.twitter.utils.UploadTool;
import com.yzchnb.twitter.entity.entityforController.UserEntity.Account;
import com.yzchnb.twitter.entity.entityforController.UserEntity.UserInfoEdit;
import com.yzchnb.twitter.service.IAvatarService;
import com.yzchnb.twitter.service.IUserService;
import com.yzchnb.twitter.utils.Utils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

@RestController
@Api(tags = "用户管理相关接口")
@RequestMapping("/api/user")
public class UserController {

    @Resource
    private IUserService iUserService;
    @Resource
    private IAvatarService iAvatarService;
    @Autowired
    private Utils utils;
    @Autowired
    private UploadTool uploadTool;



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
            @ApiImplicitParam(name = "nickname", value = "昵称", required = true),
    })
    public void SignUp(@RequestParam("nickname") String nickname,
                       @RequestBody Account account){
        iUserService.SignUp(account.email, nickname, account.password);
    }

    @PostMapping(value = "/signIn")
    @ApiOperation("登录接口")
    public Integer SignIn(HttpServletRequest request,
                          HttpServletResponse response,
                          @RequestBody Account account){
        Integer userId = iUserService.SignIn(account.email, account.password);
        if(userId.equals(0)){
            return 0;
        }
        /*Cookie cookie=utils.createNewCookie(userId,60*60);
        System.out.println(cookie.getName()+" "+cookie.getValue());
        //写入cookie的方法
        response.addCookie(cookie);*/

        utils.setSession(request,userId);
        return userId;
    }

    @GetMapping(value = "/logout")
    @ApiOperation("退出登录")
    public void logout(HttpServletRequest request){
        //response.addCookie(utils.createNewCookie(0,0));
        utils.setSession(request,0);
    }

    @GetMapping(value = "/checkIfSignUp")
    @ApiOperation("检查是否登录")
    public boolean checkIfSignUp(HttpServletRequest request) {
        //从cookie中取用户id的方法
        Integer userId = utils.getUserIdFromCookie(request);
        //System.out.println(userId);
        return (userId != 0);
    }
    @GetMapping(value = "/getRecommend")
    @ApiOperation("获得推荐用户")
    public ArrayList GetRecommend() {
        return iUserService.GetRecommend();
    }

    @GetMapping(value = "/getAllUserInfo")
    @ApiOperation("查看用户所有信息")
    public Map GetAllUserInfo(HttpServletRequest request){
        int user_id = utils.getUserIdFromCookie(request);
        //验证登录
            if (user_id == 0) throw new UserException("用户未登录");
            return iUserService.GetAllInfo(user_id);


    }


    @PostMapping(value = "/editInfo")
    @ApiOperation("修改用户信息")
    public void EditInfo(HttpServletRequest request,
                         @RequestBody UserInfoEdit userInfoEdit){
        int user_id = utils.getUserIdFromCookie(request);

        if (user_id == 0) throw new UserException("用户未登录");
        iUserService.EditInfo(userInfoEdit,user_id);
    }

    @PostMapping(value = "/uploadAvatar")
    @ApiOperation("上传头像")
    public void uploadAvatar(@RequestParam(value = "avatar")MultipartFile avatar,
                             HttpServletRequest request) throws IOException {

    int user_id = utils.getUserIdFromCookie(request);
    if (user_id == 0 )throw new UserException("用户未登录");

    int avatar_id = iAvatarService.AddAvatar(user_id);
    uploadTool.uploadAvatar(avatar , avatar_id);
    iAvatarService.SetMainAvatar(user_id,avatar_id);
    }
}


