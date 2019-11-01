package com.yzchnb.twitter.controller;

import com.yzchnb.twitter.configs.ExceptionDefinition.UserException;
import com.yzchnb.twitter.service.IMessageService;
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
import java.util.Map;

@RestController
@Api(tags = "推特（动态）控制接口")
@RequestMapping("/api/Message")

public class MessageController {
    @Resource
    private IMessageService iMessageService;

    //用于发送推特时的模型
    public class MessageForSender
    {

        public String message_content;


        public int message_has_image ;


        public int message_image_count;

    }
    @PostMapping("/QueryMessage")
    @ApiOperation("查看推特详情")
    @ApiImplicitParam(name = "message_id",value = "推特ID",required = true)
    Map QueryMessage(@RequestParam("message_id") int message_id){
        return iMessageService.QueryMessage(message_id);
    }

    @PostMapping("/QueryUserMessage")
    @ApiOperation("根据范围返回相应用户的推特信息，按照时间排序")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "user_id",value = "用户ID",required = true),
            @ApiImplicitParam(name = "start_from",value = "起始位置",required = true),
            @ApiImplicitParam(name = "limitation",value = "长度限制",required = true)
    })
    ArrayList QueryUserMessage(@RequestParam("user_id") int user_id,
                               @RequestParam("start_from") int start_from,
                               @RequestParam("limitation") int limitation){
        return iMessageService.QueryUserMessage(user_id,start_from,limitation);
    }

    @PostMapping("/QueryNewest")
    @ApiOperation("根据范围返回前几条推荐的推特，按照时间排序")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "start_from",value = "起始位置",required = true),
            @ApiImplicitParam(name = "limitation",value = "长度限制",required = true)
    })
    ArrayList QueryNewest(@RequestParam("start_from") int start_from,
                          @RequestParam("limitation") int limitation){
        return iMessageService.QueryNewest(start_from,limitation);
    }

    @PostMapping("/QueryFollowMessage")
    @ApiOperation("根据范围返回自身和用户关注的人的推特，按照时间排序")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "start_from",value = "起始位置",required = true),
            @ApiImplicitParam(name = "limitation",value = "长度限制",required = true)
    })
    ArrayList QueryFollowMessage(@RequestParam("start_from") int start_from,
                                 @RequestParam("limitation") int limitation, HttpServletRequest request) throws UserException{
        int user_id = Utils.getUserIdFromCookie(request);
        // 登录验证失败时的返回

            if (user_id == 0)
                throw new UserException("用户未登录！");

            return iMessageService.QueryFollowMessage(user_id,start_from,limitation);

    }

    @PostMapping("/AddMessage")
    @ApiOperation("发送推特")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "message_content",value = "推特内容",required = true),
            @ApiImplicitParam(name = "message_has_image",value = "是否含有图片",required = true),
            @ApiImplicitParam(name = "message_image_count",value = "图片数量",required = true)
    })
    Integer AddMessage(MessageForSender message, HttpServletRequest request) throws UserException{
        int userId = Utils.getUserIdFromCookie(request);
        // 登录验证失败时的返回

            if (userId == 0)
                throw new UserException("用户未登录！");

            return iMessageService.AddMessage(message.message_content,message.message_has_image,userId,message.message_image_count);



    }
    Integer TransponderMessage(String message_content,int message_source_is_transponder,
                               int message_sender_user_id,int  transponder_message_id,
                               HttpServletRequest request) throws UserException{
        int userId = Utils.getUserIdFromCookie(request);
        // 登录验证失败时的返回

            if (userId == 0)
                throw new UserException("用户未登录！");

            return iMessageService.TransponderMessage(message_content,message_source_is_transponder,
                    message_sender_user_id,transponder_message_id);

    }
    void Delete(int message_id,HttpServletRequest request) throws UserException{
        int userId = Utils.getUserIdFromCookie(request);
        // 登录验证失败时的返回

            if (userId == 0)
                throw new UserException("用户未登录！");
            iMessageService.Delete(message_id);

    }
}
