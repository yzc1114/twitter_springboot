package com.yzchnb.twitter.dao.FunctionCaller;

import com.yzchnb.twitter.dao.FunctionCaller.BaseCaller.FuncBaseCaller;
import com.yzchnb.twitter.dao.FunctionMapper.FuncGetUserPrivateInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Repository
public class FuncGetUserPrivateInfoCaller extends FuncBaseCaller {
	@Autowired
	private FuncGetUserPrivateInfoMapper funcGetUserPrivateInfoMapper;

	public java.util.ArrayList call(java.lang.Integer mUserId){
		Map map = new HashMap();
		map.put("mUserId", mUserId);
		return resolveArrayList(funcGetUserPrivateInfoMapper, map);
	}
}
