package com.yzchnb.twitter.service.impls;

import com.yzchnb.twitter.dao.FunctionCaller.FuncAddTopicCaller;
import com.yzchnb.twitter.dao.FunctionCaller.FuncGetTopicIdByNameCaller;
import com.yzchnb.twitter.dao.FunctionCaller.FuncQueryMessageByTopicCaller;
import com.yzchnb.twitter.dao.FunctionCaller.FuncQueryTopicsByHeatCaller;
import com.yzchnb.twitter.service.ITopicService;
import com.yzchnb.twitter.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

public class TopicServiceImpl implements ITopicService {
    @Autowired
    private FuncGetTopicIdByNameCaller funcGetTopicIdByNameCaller;
    @Autowired
    private FuncAddTopicCaller funcAddTopicCaller;
    @Autowired
    private FuncQueryTopicsByHeatCaller funcQueryTopicsByHeatCaller;
    @Autowired
    private FuncQueryMessageByTopicCaller funcQueryMessageByTopicCaller;
    @Override
    public ArrayList QueryMessageByTopic(int topic_id, int start_from, int limitation) {
        return Utils.getMessageFromArray(funcQueryMessageByTopicCaller.call(topic_id,start_from,limitation));
    }

    @Override
    public ArrayList QueryTopicsBaseOnHeat(int start_from, int limitation) {
        return funcQueryTopicsByHeatCaller.call(start_from,limitation);
    }

    @Override
    public Integer GetTopicIdByName(String topic_name) {
        return funcGetTopicIdByNameCaller.call(topic_name);
    }

    @Override
    public void AddTopicWithMessage(String topic_content, int message_id) {
        funcAddTopicCaller.call(topic_content,message_id);
    }
}
