package com.yzchnb.twitter.dao.FunctionCaller;

import com.yzchnb.twitter.dao.FunctionCaller.BaseCaller.FuncBaseCaller;
import com.yzchnb.twitter.dao.FunctionMapper.FuncQueryUserLikesMessageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Repository
public class FuncQueryUserLikesMessageCaller extends FuncBaseCaller {
	@Autowired
	private FuncQueryUserLikesMessageMapper funcQueryUserLikesMessageMapper;

	public void call(java.lang.Integer userId, java.lang.Integer messageId){
		Map map = new HashMap();
		map.put("user_id", userId);
		map.put("message_id", messageId);
		resolveVoid(funcQueryUserLikesMessageMapper, map);
	}
}
