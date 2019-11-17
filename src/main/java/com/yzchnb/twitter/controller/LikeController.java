package com.yzchnb.twitter.controller;


import com.yzchnb.twitter.configs.ExceptionDefinition.UserException;
import com.yzchnb.twitter.entity.entityforController.Range;
import com.yzchnb.twitter.service.ILikeService;
import com.yzchnb.twitter.utils.Utils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

@RestController
@Api(tags = "点赞相关接口")
@RequestMapping("/api/like")
public class LikeController {

    @Resource
    private ILikeService iLikeService;
    @Resource
    private Utils utils;

    @GetMapping(value = "/addLike/{messageId}")
    @ApiOperation("给某个推特点赞")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "messageId", value = "推特ID", required = true)
    })
    public void addLike(@PathVariable int messageId, HttpServletRequest request){
        int userId = utils.getUserIdFromCookie(request);
        try {
            if (userId == 0) throw new UserException("用户未登录");
            iLikeService.AddLike(userId,messageId);
        } catch (UserException e) {
            System.out.println(e);
        }
    }

    @GetMapping(value = "/cancelLike/{messageId}")
    @ApiOperation("取消某个推特点赞")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "messageId", value = "推特ID", required = true)
    })
    public void cancelLike(@PathVariable int messageId, HttpServletRequest request){
        int userId = utils.getUserIdFromCookie(request);
        try {
            if (userId == 0) throw new UserException("用户未登录");
            iLikeService.CancelLike(userId,messageId);
        } catch (UserException e) {
            System.out.println(e);
        }
    }

    @PostMapping(value = "/queryLikes/{userId}")
    @ApiOperation("查看某人点赞过的推特")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户Id", required = true),
    })
    public ArrayList queryLikes(@PathVariable int userId,
                                @RequestBody Range range){
        return iLikeService.QueryLikes(userId,range.startFrom,range.limitation);
    }

    @PostMapping("/checkUserLikesMessage")
    @ApiOperation("查看是否点赞过推特")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户id", required = true),
            @ApiImplicitParam(name = "message_id", value = "推特id", required = true)
    })
    public Integer checkUserLikesMessage(@RequestParam("user_id") int userId, @RequestParam("message_id") int messageId){
        return iLikeService.IfLike(userId, messageId);
    }
}
