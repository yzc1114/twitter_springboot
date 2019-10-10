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
		map.put("message_content", messageContent);
		map.put("message_has_image", messageHasImage);
		map.put("user_id", userId);
		map.put("message_image_count", messageImageCount);
		return resolveInteger(funcSendMessageMapper, map);
	}
}
