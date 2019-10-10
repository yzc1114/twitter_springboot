package com.yzchnb.twitter.dao.FunctionCaller;

import com.yzchnb.twitter.dao.FunctionCaller.BaseCaller.FuncBaseCaller;
import com.yzchnb.twitter.dao.FunctionMapper.FuncUserSignUpMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Repository
public class FuncUserSignUpCaller extends FuncBaseCaller {
	@Autowired
	private FuncUserSignUpMapper funcUserSignUpMapper;

	public void call(java.lang.String email, java.lang.String nickname, java.lang.String password){
		Map map = new HashMap();
		map.put("email", email);
		map.put("nickname", nickname);
		map.put("password", password);
		resolveVoid(funcUserSignUpMapper, map);
	}
}
