package com.yzchnb.twitter.dao.FunctionCaller;

import com.yzchnb.twitter.dao.FunctionCaller.BaseCaller.FuncBaseCaller;
import com.yzchnb.twitter.dao.FunctionMapper.FuncCheckUserIdExistMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Repository
public class FuncCheckUserIdExistCaller extends FuncBaseCaller {
	@Autowired
	private FuncCheckUserIdExistMapper funcCheckUserIdExistMapper;

	public void call(java.lang.String userid){
		Map map = new HashMap();
		map.put("userid", userid);
		resolveVoid(funcCheckUserIdExistMapper, map);
	}
}
