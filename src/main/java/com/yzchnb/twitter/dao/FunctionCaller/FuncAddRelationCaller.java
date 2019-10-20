package com.yzchnb.twitter.dao.FunctionCaller;

import com.yzchnb.twitter.dao.FunctionCaller.BaseCaller.FuncBaseCaller;
import com.yzchnb.twitter.dao.FunctionMapper.FuncAddRelationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Repository
public class FuncAddRelationCaller extends FuncBaseCaller {
	@Autowired
	private FuncAddRelationMapper funcAddRelationMapper;

	public void call(java.lang.Integer followerId, java.lang.Integer beFollowedId){
		Map map = new HashMap();
		map.put("followerId", followerId);
		map.put("beFollowedId", beFollowedId);
		resolveVoid(funcAddRelationMapper, map);
	}
}
