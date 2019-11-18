package com.yzchnb.twitter.dao.FunctionCaller;

import com.yzchnb.twitter.dao.FunctionCaller.BaseCaller.FuncBaseCaller;
import com.yzchnb.twitter.dao.FunctionMapper.FuncCheckUserinfoExistMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Repository
public class FuncCheckUserinfoExistCaller extends FuncBaseCaller {
	@Autowired
	private FuncCheckUserinfoExistMapper funcCheckUserinfoExistMapper;

	public java.lang.Integer call(java.lang.String email, java.lang.String nickname){
		Map map = new HashMap();
		map.put("email", email);
		map.put("nickname", nickname);
		return resolveInteger(funcCheckUserinfoExistMapper, map);
	}
}
