package com.yzchnb.twitter.controller;

import com.yzchnb.twitter.configs.ExceptionDefinition.UserException;
import com.yzchnb.twitter.entity.entityforController.Range;
import com.yzchnb.twitter.service.IMessageService;
import com.yzchnb.twitter.utils.Utils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Map;

@RestController
@Api(tags = "推特（动态）控制接口")
@RequestMapping("/api/message")

public class MessageController {
    @Resource
    private IMessageService iMessageService;

    @Autowired
    private Utils utils;

    //用于发送推特时的模型
    private static class MessageForSender {

        public String message_content;


        public int message_has_image;


        public int message_image_count;

    }

    //用于转发推特时的模型
    public static class MessageForTransponder {

        //推特内容
        public String message_content;

        //转发来源推特ID
        public int message_transpond_message_id;

        //是否转发
        public int message_source_is_transponder;
    }

    @PostMapping("/queryMessage")
    @ApiOperation("查看推特详情")
    @ApiImplicitParam(name = "message_id", value = "推特ID", required = true)
    public Map QueryMessage(@RequestParam("message_id") int message_id) {
        return iMessageService.QueryMessage(message_id);
    }

    @PostMapping("/queryUserMessage")
    @ApiOperation("根据范围返回相应用户的推特信息，按照时间排序")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "user_id", value = "用户ID", required = true)
    })
    public ArrayList QueryUserMessage(@RequestParam("user_id") int user_id,
                               @RequestBody Range range) {
        return iMessageService.QueryUserMessage(user_id, range.startFrom, range.limitation);
    }

    @PostMapping("/queryNewest")
    @ApiOperation("根据范围返回前几条推荐的推特，按照时间排序")
    public ArrayList QueryNewest(@RequestBody Range range) {
        return iMessageService.QueryNewest(range.startFrom, range.limitation);
    }

    @PostMapping("/queryFollowMessage")
    @ApiOperation("根据范围返回自身和用户关注的人的推特，按照时间排序")

    public ArrayList QueryFollowMessage(@RequestBody Range range, HttpServletRequest request) throws UserException {
        int user_id = utils.getUserIdFromCookie(request);
        // 登录验证失败时的返回

        if (user_id == 0)
            throw new UserException("用户未登录！");

        return iMessageService.QueryFollowMessage(user_id, range.startFrom, range.limitation);

    }

    @PostMapping("/addMessage")
    @ApiOperation("发送推特")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "message_content", value = "推特内容", required = true),
            @ApiImplicitParam(name = "message_has_image", value = "是否含有图片", required = true),
            @ApiImplicitParam(name = "message_image_count", value = "图片数量", required = true)
    })
    public Integer AddMessage(MessageForSender message, HttpServletRequest request) throws UserException {
        int userId = utils.getUserIdFromCookie(request);
        // 登录验证失败时的返回

        if (userId == 0)
            throw new UserException("用户未登录！");

        return iMessageService.AddMessage(message.message_content, message.message_has_image, userId, message.message_image_count);


    }

    @PostMapping("/retweet")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "message_content",value = "推特内容",required = true),
            @ApiImplicitParam(name = "message_source_is_transponder",value = "是否转发",required = true),
            @ApiImplicitParam(name = "message_transpond_message_id",value = "转发推特的ID",required = true)
    })
    public Integer TransponderMessage( MessageForTransponder message,HttpServletRequest request) throws UserException {
        int userId = utils.getUserIdFromCookie(request);
        // 登录验证失败时的返回

        if (userId == 0)
            throw new UserException("用户未登录！");

        return iMessageService.TransponderMessage(message.message_content, message.message_source_is_transponder,
                userId, message.message_transpond_message_id);

    }

    @PostMapping("/delete")
    @ApiOperation("删除推特")
    @ApiImplicitParam(name = "message_id",value = "推特ID",required = true)
    public void Delete(int message_id, HttpServletRequest request) throws UserException {
        int userId = utils.getUserIdFromCookie(request);
        // 登录验证失败时的返回

        if (userId == 0)
            throw new UserException("用户未登录！");
        iMessageService.Delete(message_id);

    }
}
