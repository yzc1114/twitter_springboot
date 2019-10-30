package com.yzchnb.twitter.controller;


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
    @ApiImplicitParams({
            @ApiImplicitParam(name = "startFrom", value = "起始位置",required = true),
            @ApiImplicitParam(name = "limitation", value = "长度限制", required = true)

    })
    public ArrayList query(HttpServletRequest request, @RequestParam("startFrom") int start_from, @RequestParam("limitation") int limitation ){
        int user_id = Utils.getUserIdFromCookie(request);
        // 还需要登录验证失败时的返回
        return iAtUserService.Query(user_id,start_from,limitation);
    }

    @GetMapping(value = "/queryUnreadAt")
    @ApiOperation("返回对自己的未读的At数")
    public Integer queryUnreadAt(HttpServletRequest request){
        int user_id = Utils.getUserIdFromCookie(request);
        //仍需处理登录验证
        return iAtUserService.QueryUnreadAt(user_id);
    }


}
