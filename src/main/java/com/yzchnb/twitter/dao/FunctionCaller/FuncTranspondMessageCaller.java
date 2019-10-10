package com.yzchnb.twitter.dao.FunctionCaller;

import com.yzchnb.twitter.dao.FunctionCaller.BaseCaller.FuncBaseCaller;
import com.yzchnb.twitter.dao.FunctionMapper.FuncTranspondMessageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Repository
public class FuncTranspondMessageCaller extends FuncBaseCaller {
	@Autowired
	private FuncTranspondMessageMapper funcTranspondMessageMapper;

	public java.lang.Integer call(java.lang.String messageContent, java.lang.Integer messageSourceIsTranspond, java.lang.Integer messageSenderUserId, java.lang.Integer messageTranspondMessageId){
		Map map = new HashMap();
		map.put("message_content", messageContent);
		map.put("message_source_is_transpond", messageSourceIsTranspond);
		map.put("message_sender_user_id", messageSenderUserId);
		map.put("message_transpond_message_id", messageTranspondMessageId);
		return resolveInteger(funcTranspondMessageMapper, map);
	}
}
