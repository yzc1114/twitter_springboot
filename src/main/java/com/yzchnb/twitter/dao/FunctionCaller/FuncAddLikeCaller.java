package com.yzchnb.twitter.dao.FunctionCaller;

import com.yzchnb.twitter.dao.FunctionCaller.BaseCaller.FuncBaseCaller;
import com.yzchnb.twitter.dao.FunctionMapper.FuncAddLikeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Repository
public class FuncAddLikeCaller extends FuncBaseCaller {
	@Autowired
	private FuncAddLikeMapper funcAddLikeMapper;

	public void call(java.lang.Integer userId, java.lang.Integer likeMessageId){
		Map map = new HashMap();
		map.put("user_id", userId);
		map.put("like_message_id", likeMessageId);
		resolveVoid(funcAddLikeMapper, map);
	}
}
