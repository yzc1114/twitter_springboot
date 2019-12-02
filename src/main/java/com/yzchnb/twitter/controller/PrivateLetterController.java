package com.yzchnb.twitter.controller;

import com.yzchnb.twitter.configs.ExceptionDefinition.UserException;
import com.yzchnb.twitter.entity.entityforController.PrivateLetter;
import com.yzchnb.twitter.entity.entityforController.Range;
import com.yzchnb.twitter.service.IPrivateLetterService;
import com.yzchnb.twitter.utils.Utils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import oracle.jdbc.proxy.annotation.Post;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private Utils utils;


    @PostMapping("/send/{receiver_user_id}")
    @ApiOperation("发送私信")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "receiver_user_id", value = "接收私信的用户ID", required = true),
            @ApiImplicitParam(name = "content", value = "私信内容", required = true)
    })
    public void AddPrivateLetter(@PathVariable()int receiver_user_id,
                          @RequestBody() PrivateLetter content,
                          HttpServletRequest request) throws UserException{
        int sender_user_id = utils.getUserIdFromCookie(request);

            if (sender_user_id == 0) throw new UserException("用户未登录");
            iPrivateLetterService.AddPrivateLetter(sender_user_id,receiver_user_id,content.getContent());

    }

    @GetMapping("/delete/{private_letter_id}")
    @ApiOperation("删除私信")
    @ApiImplicitParam(name = "private_letter_id",value = "私信ID",required = true)
    public void DeletePrivateLetter(@PathVariable() int private_letter_id,
                             HttpServletRequest request) throws UserException{
        int userId = utils.getUserIdFromCookie(request);

            if (userId == 0) throw new UserException("用户未登录");
            iPrivateLetterService.DeletePrivateLetter(private_letter_id);

    }


    @PostMapping("/queryForMe")
    @ApiOperation("查询发送给自己的私信列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId",value = "用户ID",required = true)
    })
    public ArrayList QueryPrivateLetters(@RequestBody Range range, HttpServletRequest request) throws UserException{
        int userId = utils.getUserIdFromCookie(request);

            if (userId == 0) throw new UserException("用户未登录");
            return iPrivateLetterService.QueryPrivateLetters(userId,range.startFrom,range.limitation);

    }

    @PostMapping("/queryLatestContact")
    @ApiOperation("查询最近给自己发过私信的人")
    public ArrayList QueryLatestContact(@RequestBody Range range,
                                        HttpServletRequest request) throws UserException{
        int userId = utils.getUserIdFromCookie(request);
        if (userId==0) throw new UserException("用户未登录");
        return iPrivateLetterService.QueryLatestContact(userId,range.startFrom,range.limitation);
    }

    @PostMapping("/querySpecified/{opposingId}")
    @ApiOperation("查询自己和某人的所有私信列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "opposingId",value = "对方ID",required = true)
    })
    public ArrayList QuerySpecified(@RequestBody Range range,
                                    @PathVariable int opposingId,
                                    HttpServletRequest request)throws UserException{
        int userId = utils.getUserIdFromCookie(request);
        if (userId==0) throw new UserException("用户未登录");
        return iPrivateLetterService.QuerySpecified(userId,opposingId,range.startFrom,range.limitation);
    }
}
