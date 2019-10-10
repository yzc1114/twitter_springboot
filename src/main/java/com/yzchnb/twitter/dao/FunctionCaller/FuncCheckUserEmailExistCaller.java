package com.yzchnb.twitter.dao.FunctionCaller;

import com.yzchnb.twitter.dao.FunctionCaller.BaseCaller.FuncBaseCaller;
import com.yzchnb.twitter.dao.FunctionMapper.FuncCheckUserEmailExistMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Repository
public class FuncCheckUserEmailExistCaller extends FuncBaseCaller {
	@Autowired
	private FuncCheckUserEmailExistMapper funcCheckUserEmailExistMapper;

	public void call(java.lang.String email){
		Map map = new HashMap();
		map.put("email", email);
		resolveVoid(funcCheckUserEmailExistMapper, map);
	}
}
