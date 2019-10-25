package com.yzchnb.twitter.dao.FunctionCaller;

import com.yzchnb.twitter.dao.FunctionCaller.BaseCaller.FuncBaseCaller;
import com.yzchnb.twitter.dao.FunctionMapper.FuncIfFollowingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Repository
public class FuncIfFollowingCaller extends FuncBaseCaller {
	@Autowired
	private FuncIfFollowingMapper funcIfFollowingMapper;

	public java.lang.Integer call(java.lang.Integer followingId, java.lang.Integer beFollowedId){
		Map map = new HashMap();
		map.put("followingId", followingId);
		map.put("beFollowedId", beFollowedId);
		return resolveInteger(funcIfFollowingMapper, map);
	}
}
