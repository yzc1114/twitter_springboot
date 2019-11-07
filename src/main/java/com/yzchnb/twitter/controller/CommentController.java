package com.yzchnb.twitter.controller;

import com.yzchnb.twitter.configs.ExceptionDefinition.UserException;
import com.yzchnb.twitter.entity.entityforController.Range;
import com.yzchnb.twitter.service.ICommentService;
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
@Api(tags = "推特评论相关接口")
@RequestMapping("/api/comment")
public class CommentController {

    @Resource
    private ICommentService iCommentService;

    @PostMapping("/queryComments")
    @ApiOperation("获取推特的评论信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "message_id", value = "推特ID", required = true)
    })
    public ArrayList queryComments(@RequestParam("message_id") int message_id,
                                   @RequestBody Range range ){
        return iCommentService.QueryComments(message_id,range.startFrom,range.limitation);
    }

    @PostMapping("/addComment")
    @ApiOperation("给推特添加评论")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "be_commented_id", value = "被评论的推特id", required = true),
            @ApiImplicitParam(name = "content", value = "评论内容", required = true)
    })
    public void addComments (HttpServletRequest request,
                            @RequestParam("be_commented_id") int be_commented_id,
                            @RequestParam("content") String content){
        int user_id = Utils.getUserIdFromCookie(request);
        //登录验证失败处理
        try {
            if (user_id == 0)
                throw new UserException("用户未登录！");
            iCommentService.AddComment(user_id,be_commented_id,content);
        }
        catch (Exception e){
            System.out.println(e);
        }


    }


}
