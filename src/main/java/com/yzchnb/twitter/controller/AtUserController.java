package com.yzchnb.twitter.controller;


import com.yzchnb.twitter.configs.ExceptionDefinition.UserException;
import com.yzchnb.twitter.entity.entityforController.Range;
import com.yzchnb.twitter.service.IAtUserService;
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
@Api(tags = "艾特用户相关接口")
@RequestMapping("/api/at")
public class AtUserController {

    @Resource
    private IAtUserService iAtUserService;

    @PostMapping(value = "/query")
    @ApiOperation("根据limitation查找最近几条At自己的推特id")
    public ArrayList query(HttpServletRequest request,
                           @RequestBody Range range){
        int user_id = Utils.getUserIdFromCookie(request);
        // 登录验证失败时的返回
        try {
            if (user_id == 0)
                throw new UserException("用户未登录！");

            return iAtUserService.Query(user_id,range.startFrom,range.limitation);
        }
        catch (Exception e){
            System.out.println(e);
        }

        return null;
    }

    @GetMapping(value = "/queryUnreadAt")
    @ApiOperation("返回对自己的未读的At数")
    public Integer queryUnreadAt(HttpServletRequest request){
        int user_id = Utils.getUserIdFromCookie(request);
        //处理登录验证
        try {
            if (user_id == 0)
                throw new UserException("用户未登录！");
            return iAtUserService.QueryUnreadAt(user_id);
        }
        catch (Exception e){
            System.out.println(e);
        }


        return null;
    }


}
