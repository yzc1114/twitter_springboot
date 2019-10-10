package com.yzchnb.twitter.dao.FunctionCaller;

import com.yzchnb.twitter.dao.FunctionCaller.BaseCaller.FuncBaseCaller;
import com.yzchnb.twitter.dao.FunctionMapper.FuncGetTopicIdByNameMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Repository
public class FuncGetTopicIdByNameCaller extends FuncBaseCaller {
	@Autowired
	private FuncGetTopicIdByNameMapper funcGetTopicIdByNameMapper;

	public java.lang.Integer call(java.lang.String searchkey){
		Map map = new HashMap();
		map.put("searchkey", searchkey);
		return resolveInteger(funcGetTopicIdByNameMapper, map);
	}
}
