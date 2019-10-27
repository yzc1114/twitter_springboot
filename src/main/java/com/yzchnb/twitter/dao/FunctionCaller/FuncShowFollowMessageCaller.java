package com.yzchnb.twitter.dao.FunctionCaller;

import com.yzchnb.twitter.dao.FunctionCaller.BaseCaller.FuncBaseCaller;
import com.yzchnb.twitter.dao.FunctionMapper.FuncShowFollowMessageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Repository
public class FuncShowFollowMessageCaller extends FuncBaseCaller {
	@Autowired
	private FuncShowFollowMessageMapper funcShowFollowMessageMapper;

	public java.util.ArrayList call(java.lang.Integer startfrom, java.lang.Integer limitation, java.lang.Integer userid){
		Map map = new HashMap();
		map.put("startfrom", startfrom);
		map.put("limitation", limitation);
		map.put("userid", userid);
		return resolveArrayList(funcShowFollowMessageMapper, map);
	}
}
