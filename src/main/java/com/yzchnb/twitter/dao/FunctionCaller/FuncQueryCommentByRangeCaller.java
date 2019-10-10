package com.yzchnb.twitter.dao.FunctionCaller;

import com.yzchnb.twitter.dao.FunctionCaller.BaseCaller.FuncBaseCaller;
import com.yzchnb.twitter.dao.FunctionMapper.FuncQueryCommentByRangeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Repository
public class FuncQueryCommentByRangeCaller extends FuncBaseCaller {
	@Autowired
	private FuncQueryCommentByRangeMapper funcQueryCommentByRangeMapper;

	public java.util.ArrayList call(java.lang.Integer messageId, java.lang.Integer startfrom, java.lang.Integer limitation){
		Map map = new HashMap();
		map.put("message_id", messageId);
		map.put("startfrom", startfrom);
		map.put("limitation", limitation);
		return resolveArrayList(funcQueryCommentByRangeMapper, map);
	}
}
