package com.yzchnb.twitter.dao.FunctionCaller;

import com.yzchnb.twitter.dao.FunctionCaller.BaseCaller.FuncBaseCaller;
import com.yzchnb.twitter.dao.FunctionMapper.FuncCheckUserNicknameExistMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Repository
public class FuncCheckUserNicknameExistCaller extends FuncBaseCaller {
	@Autowired
	private FuncCheckUserNicknameExistMapper funcCheckUserNicknameExistMapper;

	public java.lang.Integer call(java.lang.String nickname){
		Map map = new HashMap();
		map.put("nickname", nickname);
		return resolveInteger(funcCheckUserNicknameExistMapper, map);
	}
}
