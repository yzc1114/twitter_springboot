package com.yzchnb.twitter.dao.FunctionCaller;

import com.yzchnb.twitter.dao.FunctionCaller.BaseCaller.FuncBaseCaller;
import com.yzchnb.twitter.dao.FunctionMapper.FuncRemoveRelationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Repository
public class FuncRemoveRelationCaller extends FuncBaseCaller {
	@Autowired
	private FuncRemoveRelationMapper funcRemoveRelationMapper;

	public void call(java.lang.Integer followerId, java.lang.Integer beFollowedId){
		Map map = new HashMap();
		map.put("followerId", followerId);
		map.put("beFollowedId", beFollowedId);
		resolveVoid(funcRemoveRelationMapper, map);
	}
}
