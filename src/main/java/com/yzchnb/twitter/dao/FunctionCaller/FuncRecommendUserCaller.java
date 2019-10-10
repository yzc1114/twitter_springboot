package com.yzchnb.twitter.dao.FunctionCaller;

import com.yzchnb.twitter.dao.FunctionCaller.BaseCaller.FuncBaseCaller;
import com.yzchnb.twitter.dao.FunctionMapper.FuncRecommendUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Repository
public class FuncRecommendUserCaller extends FuncBaseCaller {
	@Autowired
	private FuncRecommendUserMapper funcRecommendUserMapper;

	public java.util.ArrayList call(){
		Map map = new HashMap();
		return resolveArrayList(funcRecommendUserMapper, map);
	}
}
