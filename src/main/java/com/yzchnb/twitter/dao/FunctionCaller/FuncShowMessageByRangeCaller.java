package com.yzchnb.twitter.dao.FunctionCaller;

import com.yzchnb.twitter.dao.FunctionCaller.BaseCaller.FuncBaseCaller;
import com.yzchnb.twitter.dao.FunctionMapper.FuncShowMessageByRangeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Repository
public class FuncShowMessageByRangeCaller extends FuncBaseCaller {
	@Autowired
	private FuncShowMessageByRangeMapper funcShowMessageByRangeMapper;

	public java.util.ArrayList call(java.lang.Integer userId, java.lang.Integer rangestart, java.lang.Integer rangelimitation){
		Map map = new HashMap();
		map.put("userId", userId);
		map.put("rangestart", rangestart);
		map.put("rangelimitation", rangelimitation);
		return resolveArrayList(funcShowMessageByRangeMapper, map);
	}
}
