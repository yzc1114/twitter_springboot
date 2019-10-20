package com.yzchnb.twitter.dao.FunctionCaller;

import com.yzchnb.twitter.dao.FunctionCaller.BaseCaller.FuncBaseCaller;
import com.yzchnb.twitter.dao.FunctionMapper.FuncDeleteLikeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Repository
public class FuncDeleteLikeCaller extends FuncBaseCaller {
	@Autowired
	private FuncDeleteLikeMapper funcDeleteLikeMapper;

	public void call(java.lang.Integer userId, java.lang.Integer likeMessageId){
		Map map = new HashMap();
		map.put("userId", userId);
		map.put("likeMessageId", likeMessageId);
		resolveVoid(funcDeleteLikeMapper, map);
	}
}
