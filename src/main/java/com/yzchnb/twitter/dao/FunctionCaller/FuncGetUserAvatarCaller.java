package com.yzchnb.twitter.dao.FunctionCaller;

import com.yzchnb.twitter.dao.FunctionCaller.BaseCaller.FuncBaseCaller;
import com.yzchnb.twitter.dao.FunctionMapper.FuncGetUserAvatarMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Repository
public class FuncGetUserAvatarCaller extends FuncBaseCaller {
	@Autowired
	private FuncGetUserAvatarMapper funcGetUserAvatarMapper;

	public java.lang.Integer call(java.lang.Integer userid){
		Map map = new HashMap();
		map.put("userid", userid);
		return resolveInteger(funcGetUserAvatarMapper, map);
	}
}
