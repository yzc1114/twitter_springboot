package com.yzchnb.twitter.controller;

import com.yzchnb.twitter.service.ICollectionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Api(tags = "推特收藏相关接口")
@RequestMapping("/api/collection")
public class CollectionController {

    @Resource
    private ICollectionService iCollectionService;

    @PostMapping(value = "/add")
    @ApiOperation("添加收藏")
    @ApiImplicitParam()
    public void addCollection(int be_collected_id){

    }
}
