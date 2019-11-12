package com.yzchnb.twitter.dao.FunctionCaller;

import com.yzchnb.twitter.dao.FunctionCaller.BaseCaller.FuncBaseCaller;
import com.yzchnb.twitter.dao.FunctionMapper.FuncQuerySpecifiedMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Repository
public class FuncQuerySpecifiedCaller extends FuncBaseCaller {
	@Autowired
	private FuncQuerySpecifiedMapper funcQuerySpecifiedMapper;

	public java.util.ArrayList call(java.lang.Integer senderid, java.lang.Integer receiverid, java.lang.Integer startfrom, java.lang.Integer limitation){
		Map map = new HashMap();
		map.put("senderid", senderid);
		map.put("receiverid", receiverid);
		map.put("startfrom", startfrom);
		map.put("limitation", limitation);
		return resolveArrayList(funcQuerySpecifiedMapper, map);
	}
}
