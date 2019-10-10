package com.yzchnb.twitter.dao.FunctionCaller;

import com.yzchnb.twitter.dao.FunctionCaller.BaseCaller.FuncBaseCaller;
import com.yzchnb.twitter.dao.FunctionMapper.FuncSearchMessageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Repository
public class FuncSearchMessageCaller extends FuncBaseCaller {
	@Autowired
	private FuncSearchMessageMapper funcSearchMessageMapper;

	public java.util.ArrayList call(java.lang.String searchkey, java.lang.Integer startfrom, java.lang.Integer limitation){
		Map map = new HashMap();
		map.put("searchkey", searchkey);
		map.put("startfrom", startfrom);
		map.put("limitation", limitation);
		return resolveArrayList(funcSearchMessageMapper, map);
	}
}
