package com.yzchnb.twitter.dao.FunctionCaller;

import com.yzchnb.twitter.dao.FunctionCaller.BaseCaller.FuncBaseCaller;
import com.yzchnb.twitter.dao.FunctionMapper.FuncAddCommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Repository
public class FuncAddCommentCaller extends FuncBaseCaller {
	@Autowired
	private FuncAddCommentMapper funcAddCommentMapper;

	public void call(java.lang.Integer userId, java.lang.Integer beCommentedId, java.lang.String content){
		Map map = new HashMap();
		map.put("user_id", userId);
		map.put("be_commented_id", beCommentedId);
		map.put("content", content);
		resolveVoid(funcAddCommentMapper, map);
	}
}
