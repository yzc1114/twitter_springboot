package com.yzchnb.twitter.controller;

import com.yzchnb.twitter.configs.ExceptionDefinition.UserException;
import com.yzchnb.twitter.entity.entityforController.Range;
import com.yzchnb.twitter.service.IPrivateLetterService;
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
@Api(tags = "私信接口")
@RequestMapping("/api/privateLetter")
public class PrivateLetterController {

    @Resource
    private IPrivateLetterService iPrivateLetterService;

    @PostMapping("/addPrivateLetter/{receiver_user_id}")
    @ApiOperation("发送私信")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "receiver_user_id", value = "接收私信的用户ID", required = true),
            @ApiImplicitParam(name = "content", value = "私信内容", required = true)
    })
    void AddPrivateLetter(@PathVariable()int receiver_user_id,
                          @RequestParam("content")String content,
                          HttpServletRequest request) throws UserException{
        int sender_user_id = Utils.getUserIdFromCookie(request);

            if (sender_user_id == 0) throw new UserException("用户未登录");
            iPrivateLetterService.AddPrivateLetter(sender_user_id,receiver_user_id,content);

    }

    @GetMapping("/deletePrivateLetter/{private_letter_id}")
    @ApiOperation("删除私信")
    @ApiImplicitParam(name = "private_letter_id",value = "私信ID",required = true)
    void DeletePrivateLetter(@PathVariable() int private_letter_id,
                             HttpServletRequest request) throws UserException{
        int userId = Utils.getUserIdFromCookie(request);

            if (userId == 0) throw new UserException("用户未登录");
            iPrivateLetterService.DeletePrivateLetter(private_letter_id);

    }

    @PostMapping("/queryPrivateLetters/{user_id}")
    @ApiOperation("查询和某用户的私信")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "user_id",value = "用户ID",required = true)
    })
    ArrayList QueryPrivateLetters(@PathVariable() int user_id,
                                  @RequestBody Range range, HttpServletRequest request) throws UserException{
        int userId = Utils.getUserIdFromCookie(request);

            if (userId == 0) throw new UserException("用户未登录");
            return iPrivateLetterService.QueryPrivateLetters(user_id,range.startFrom,range.limitation);

    }
}
