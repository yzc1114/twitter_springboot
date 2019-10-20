package com.yzchnb.twitter.dao.FunctionCaller;

import com.yzchnb.twitter.dao.FunctionCaller.BaseCaller.FuncBaseCaller;
import com.yzchnb.twitter.dao.FunctionMapper.FuncSendMessageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Repository
public class FuncSendMessageCaller extends FuncBaseCaller {
	@Autowired
	private FuncSendMessageMapper funcSendMessageMapper;

	public java.lang.Integer call(java.lang.String messageContent, java.lang.Integer messageHasImage, java.lang.Integer userId, java.lang.Integer messageImageCount){
		Map map = new HashMap();
		map.put("messageContent", messageContent);
		map.put("messageHasImage", messageHasImage);
		map.put("userId", userId);
		map.put("messageImageCount", messageImageCount);
		return resolveInteger(funcSendMessageMapper, map);
	}
}
