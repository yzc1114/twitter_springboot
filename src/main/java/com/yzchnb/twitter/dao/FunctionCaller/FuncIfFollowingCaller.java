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

	public void call(java.lang.Integer followingId, java.lang.Integer beFollowedId){
		Map map = new HashMap();
		map.put("following_id", followingId);
		map.put("be_followed_id", beFollowedId);
		resolveVoid(funcIfFollowingMapper, map);
	}
}
