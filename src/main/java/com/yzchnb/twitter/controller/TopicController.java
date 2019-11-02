package com.yzchnb.twitter.controller;

import com.yzchnb.twitter.service.ITopicService;
import com.yzchnb.twitter.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;

@RestController
@Api(tags = "话题管理接口")
@RequestMapping("api/topic")

public class TopicController {

    @Resource
    private ITopicService iTopicService;

    @PostMapping("/queryMessageByTopic/{topic_id}")
    @ApiOperation("根据话题名字，起始位置和长度限制获取时间最近的几条message_id组成的列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "topic_id",value = "话题ID",required = true),
            @ApiImplicitParam(name = "start_from",value = "起始位置",required = true),
            @ApiImplicitParam(name = "limitation",value = "长度限制",required = true)
    })
    ArrayList QueryMessageByTopic(@PathVariable int topic_id,
                                  @RequestParam("start_from") int start_from,
                                  @RequestParam("limitation") int limitation){
        return iTopicService.QueryMessageByTopic(topic_id,start_from,limitation);
    }

    @PostMapping("/queryTopicsBaseOnHeat")
    @ApiOperation("查找最热的几条话题")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "start_from",value = "起始位置",required = true),
            @ApiImplicitParam(name = "limitation",value = "长度限制",required = true)
    })
    ArrayList QueryTopicsBaseOnHeat( @RequestParam("start_from") int start_from,
                                     @RequestParam("limitation") int limitation){
        return iTopicService.QueryTopicsBaseOnHeat(start_from,limitation);
    }

    @PostMapping("/addTopicWithMessage")
    @ApiOperation("根据传入的内容，将内容中的Topic全都增加")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "topic_content",value = "话题内容",required = true),
            @ApiImplicitParam(name = "message_id",value = "messageID",required = true)
    })
    void AddTopicWithMessage(@RequestParam("topic_content") String topic_content,
                             @RequestParam("message_id") int message_id){
        iTopicService.AddTopicWithMessage(topic_content,message_id);
    }

    @PostMapping("/getTopicIdByName")
    @ApiOperation("通过话题名字返回ID")
    @ApiImplicitParam(name = "topic_name",value = "话题名字",required = true)
    Integer GetTopicIdByName(@RequestParam("topic_name") String topic_name){
        return iTopicService.GetTopicIdByName(topic_name);
    }

}
