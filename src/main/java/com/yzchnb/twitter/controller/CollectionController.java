package com.yzchnb.twitter.controller;

import com.yzchnb.twitter.configs.ExceptionDefinition.UserException;
import com.yzchnb.twitter.entity.entityforController.Range;
import com.yzchnb.twitter.service.ICollectionService;
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
@Api(tags = "推特收藏相关接口")
@RequestMapping("/api/collection")
public class CollectionController {

    @Resource
    private ICollectionService iCollectionService;

    @PostMapping(value = "/add")
    @ApiOperation("添加收藏")
    @ApiImplicitParam(name = "message_id", value = "被收藏推特ID",required = true)
    public boolean addCollection(@RequestParam("message_id") int be_collected_id,
                                 HttpServletRequest request){
        int user_id = Utils.getUserIdFromCookie(request);
        try {
            if (user_id == 0 ) throw new UserException("用户未登录");
            iCollectionService.Add(user_id,be_collected_id);
            return true;
        } catch (UserException e) {
            System.out.println(e);
        }
        return false;
    }

    @PostMapping(value = "/delete")
    @ApiOperation("删除收藏")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "message_id", value = "被收藏推特的ID",required = true)
    })
    public boolean deleteCollection(HttpServletRequest request,
                                    @RequestParam("message_id") int be_collected_id){
        int user_id = Utils.getUserIdFromCookie(request);
        try {
            if (user_id == 0)throw new UserException("用户未登录");
            iCollectionService.Delete(user_id,be_collected_id);
            return true;
        } catch (UserException e) {
            System.out.println(e);
        }
        return false;
    }

    @PostMapping(value = "/queryCollection/{userId}")
    @ApiOperation("查询用户收藏的推特")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户ID", required = true),
    })
    public ArrayList queryCollection(@PathVariable int userId,
                                     @RequestBody Range range){
        return iCollectionService.QueryCollection(userId, range.startFrom,range.limitation);
    }

    @PostMapping(value = "/getCollectionNum/{userId}")
    @ApiOperation("获取用户收藏数量")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户ID", required = true)
    })
    public Integer getCollectionNum(@PathVariable int userId){
        return iCollectionService.GetCollectionNum(userId);
    }
}
