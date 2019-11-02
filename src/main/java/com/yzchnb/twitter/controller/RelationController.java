package com.yzchnb.twitter.controller;

import com.yzchnb.twitter.configs.ExceptionDefinition.UserException;
import com.yzchnb.twitter.service.IRelationService;
import com.yzchnb.twitter.utils.Utils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

@RestController
@Api(tags = "用户关系控制接口")
@RequestMapping(value = "/api/relation")
public class RelationController {

    @Resource
    private IRelationService iRelationService;

    @PostMapping(value = "/queryFollowersFor/{user_id}")
    @ApiOperation("查看关注某人的用户列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "user_id", value = "用户ID",required = true),
            @ApiImplicitParam(name = "start_from", value = "起始位置", required = true),
            @ApiImplicitParam(name = "limitation", value = "长度限制", required = true)
    })
    ArrayList QueryFollowersFor(@RequestParam("user_id") int user_id,
                                @RequestParam("start_from") int start_from,
                                @RequestParam("limitation") int limitation,
                                HttpServletRequest request)throws UserException{
        int userId = Utils.getUserIdFromCookie(request);
        // 登录验证失败时的返回

            if (userId == 0)
                throw new UserException("用户未登录！");

            return iRelationService.QueryFollowersFor(user_id,start_from,limitation);

    }

    @PostMapping(value = "/queryFollowingFor/{user_id}")
    @ApiOperation("查看某人关注的用户列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "user_id", value = "用户ID",required = true),
            @ApiImplicitParam(name = "start_from", value = "起始位置", required = true),
            @ApiImplicitParam(name = "limitation", value = "长度限制", required = true)
    })
    ArrayList QueryFollowingFor(@RequestParam("user_id") int user_id,
                                @RequestParam("start_from") int start_from,
                                @RequestParam("limitation") int limitation,
                                HttpServletRequest request)throws UserException{
        int userId = Utils.getUserIdFromCookie(request);
        // 登录验证失败时的返回

            if (userId == 0)
                throw new UserException("用户未登录！");

            return iRelationService.QueryFollowingFor(user_id,start_from,limitation);

    }

    @GetMapping(value = "/follow/{be_followed_id}")
    @ApiOperation("关注某用户")
    @ApiImplicitParam(name = "be_followed_id", value = "被关注的用户ID", required = true)
    void FollowUser(@RequestParam("be_followed_id") int be_followed_id,
                    HttpServletRequest request) throws UserException{
        int follower_id = Utils.getUserIdFromCookie(request);
        // 登录验证失败时的返回

            if (follower_id == 0)
                throw new UserException("用户未登录！");

           iRelationService.FollowUser(follower_id,be_followed_id);

    }

    @GetMapping(value = "/cancelFollowingTo/{be_followed_id}")
    @ApiOperation("取消关注某用户")
    @ApiImplicitParam(name = "be_followed_id", value = "被取关的用户ID", required = true)
    void CancelFollowingTo(@RequestParam("be_followed_id") int be_followed_id,
                           HttpServletRequest request)throws UserException{
        int follower_id = Utils.getUserIdFromCookie(request);
        // 登录验证失败时的返回

            if (follower_id == 0)
                throw new UserException("用户未登录！");

            iRelationService.CancelFollowingTo(follower_id,be_followed_id);

    }

    @GetMapping(value = "/ifFollowingByMe{be_followed_id}")
    @ApiOperation("用户是否关注be_followed")
    @ApiImplicitParam(name = "be_followed_id", value = "被关注的用户ID", required = true)
    Integer IfFollowing(int be_followed_id,HttpServletRequest request) throws UserException{
        int userId = Utils.getUserIdFromCookie(request);
        // 登录验证失败时的返回

            if (userId == 0)
                throw new UserException("用户未登录！");

            return iRelationService.IfFollowing(userId, be_followed_id);

    }

    @PostMapping(value = "/ifFollowing")
    @ApiOperation("follower是否关注be_followed")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "follower_id",value = "发起关注的用户ID",required = true),
        @ApiImplicitParam(name = "be_followed_id",value = "被关注的用户ID",required = true)
    })
    Integer IfFollowing(@RequestParam("follower_id")int follower_id,
                        @RequestParam("be_followed_id") int be_followed_id){
        return iRelationService.IfFollowing(follower_id,be_followed_id);
    }

}
