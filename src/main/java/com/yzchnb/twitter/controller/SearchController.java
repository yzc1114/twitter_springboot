package com.yzchnb.twitter.controller;

import com.yzchnb.twitter.entity.entityforController.Range;
import com.yzchnb.twitter.service.ISearchService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;

@RestController
@Api(tags = "搜索相关接口")
@RequestMapping("/api/search")
public class SearchController {

    @Resource
    private ISearchService iSearchService;

    @PostMapping(value = "/getSearchResult")
    @ApiOperation("获得搜索结果，包括Message,User,Topic三类")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "searchKey", value = "搜索关键字", required = true),
    })
    public ArrayList getSearchResults(@RequestParam("searchKey")String searchKey,
                                      @RequestBody Range range){
        ArrayList<ArrayList> result = new ArrayList<ArrayList>();
        result.add(iSearchService.GetTwitterResults(searchKey, range.startFrom, range.limitation));
        result.add(iSearchService.GetUserResults(searchKey,range.startFrom, range.limitation));
        result.add((iSearchService.GetTopicResults(searchKey,range.startFrom, range.limitation)));

        return result;

    }
}
