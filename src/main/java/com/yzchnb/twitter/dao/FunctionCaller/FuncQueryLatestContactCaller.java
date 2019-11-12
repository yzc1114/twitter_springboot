package com.yzchnb.twitter.dao.FunctionCaller;

import com.yzchnb.twitter.dao.FunctionCaller.BaseCaller.FuncBaseCaller;
import com.yzchnb.twitter.dao.FunctionMapper.FuncQueryLatestContactMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Repository
public class FuncQueryLatestContactCaller extends FuncBaseCaller {
	@Autowired
	private FuncQueryLatestContactMapper funcQueryLatestContactMapper;

	public java.util.ArrayList call(java.lang.Integer userid, java.lang.Integer startfrom, java.lang.Integer limitation){
		Map map = new HashMap();
		map.put("userid", userid);
		map.put("startfrom", startfrom);
		map.put("limitation", limitation);
		return resolveArrayList(funcQueryLatestContactMapper, map);
	}
}
