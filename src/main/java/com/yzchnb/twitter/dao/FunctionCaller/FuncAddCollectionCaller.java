package com.yzchnb.twitter.dao.FunctionCaller;

import com.yzchnb.twitter.dao.FunctionCaller.BaseCaller.FuncBaseCaller;
import com.yzchnb.twitter.dao.FunctionMapper.FuncAddCollectionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Repository
public class FuncAddCollectionCaller extends FuncBaseCaller {
	@Autowired
	private FuncAddCollectionMapper funcAddCollectionMapper;

	public void call(java.lang.Integer userId, java.lang.Integer beCollectedId){
		Map map = new HashMap();
		map.put("userId", userId);
		map.put("beCollectedId", beCollectedId);
		resolveVoid(funcAddCollectionMapper, map);
	}
}
