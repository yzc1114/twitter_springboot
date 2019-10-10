package com.yzchnb.twitter.dao.FunctionCaller;

import com.yzchnb.twitter.dao.FunctionCaller.BaseCaller.FuncBaseCaller;
import com.yzchnb.twitter.dao.FunctionMapper.FuncGetUserPublicInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Repository
public class FuncGetUserPublicInfoCaller extends FuncBaseCaller {
	@Autowired
	private FuncGetUserPublicInfoMapper funcGetUserPublicInfoMapper;

	public java.util.ArrayList call(java.lang.Integer userid){
		Map map = new HashMap();
		map.put("userid", userid);
		return resolveArrayList(funcGetUserPublicInfoMapper, map);
	}
}
