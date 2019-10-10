package com.yzchnb.twitter.dao.FunctionCaller;

import com.yzchnb.twitter.dao.FunctionCaller.BaseCaller.FuncBaseCaller;
import com.yzchnb.twitter.dao.FunctionMapper.FuncUserSignInByEmailMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Repository
public class FuncUserSignInByEmailCaller extends FuncBaseCaller {
	@Autowired
	private FuncUserSignInByEmailMapper funcUserSignInByEmailMapper;

	public java.lang.Integer call(java.lang.String email, java.lang.String password){
		Map map = new HashMap();
		map.put("email", email);
		map.put("password", password);
		return resolveInteger(funcUserSignInByEmailMapper, map);
	}
}
