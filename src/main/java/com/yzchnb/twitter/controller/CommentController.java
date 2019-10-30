package com.yzchnb.twitter.controller;

import com.yzchnb.twitter.service.ICommentService;
import com.yzchnb.twitter.utils.Utils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
            @ApiImplicitParam(name = "startFrom", value = "起始位置",required = true),
            @ApiImplicitParam(name = "limitation", value = "长度限制", required = true)
    })
    public ArrayList queryComments(int message_id,
                                   @RequestParam("startFrom") int start_from,
                                   @RequestParam("limitation") int limitation){
        return iCommentService.QueryComments(message_id,start_from,limitation);
    }

    @PostMapping("/addComment")
    @ApiOperation("给推特添加评论")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "be_commented_id", value = "被评论的推特id", required = true),
            @ApiImplicitParam(name = "content", value = "评论内容", required = true)
    })
    public void addComments(HttpServletRequest request, int be_commented_id, @RequestParam("content") String content){
        int user_id = Utils.getUserIdFromCookie(request);
        //登录验证失败处理

        iCommentService.AddComment(user_id,be_commented_id,content);
    }


}
