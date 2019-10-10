package com.yzchnb.twitter.dao.FunctionCaller;

import com.yzchnb.twitter.dao.FunctionCaller.BaseCaller.FuncBaseCaller;
import com.yzchnb.twitter.dao.FunctionMapper.FuncAddTopicMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Repository
public class FuncAddTopicCaller extends FuncBaseCaller {
	@Autowired
	private FuncAddTopicMapper funcAddTopicMapper;

	public void call(java.lang.String topicName, java.lang.Integer messageId){
		Map map = new HashMap();
		map.put("topic_name", topicName);
		map.put("message_id", messageId);
		resolveVoid(funcAddTopicMapper, map);
	}
}
