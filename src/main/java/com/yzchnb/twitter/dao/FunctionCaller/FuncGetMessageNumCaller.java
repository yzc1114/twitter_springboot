package com.yzchnb.twitter.dao.FunctionCaller;

import com.yzchnb.twitter.dao.FunctionCaller.BaseCaller.FuncBaseCaller;
import com.yzchnb.twitter.dao.FunctionMapper.FuncGetMessageNumMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Repository
public class FuncGetMessageNumCaller extends FuncBaseCaller {
	@Autowired
	private FuncGetMessageNumMapper funcGetMessageNumMapper;

	public java.lang.Integer call(java.lang.Integer mUserId){
		Map map = new HashMap();
		map.put("mUserId", mUserId);
		return resolveInteger(funcGetMessageNumMapper, map);
	}
}
