package com.yzchnb.twitter.dao.FunctionCaller;

import com.yzchnb.twitter.dao.FunctionCaller.BaseCaller.FuncBaseCaller;
import com.yzchnb.twitter.dao.FunctionMapper.FuncSetUserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Repository
public class FuncSetUserInfoCaller extends FuncBaseCaller {
	@Autowired
	private FuncSetUserInfoMapper funcSetUserInfoMapper;

	public void call(java.lang.String nickname, java.lang.String selfIntroduction, java.lang.String password, java.lang.String realname, java.lang.String gender, java.lang.Integer id, java.lang.Integer setMode){
		Map map = new HashMap();
		map.put("nickname", nickname);
		map.put("selfIntroduction", selfIntroduction);
		map.put("password", password);
		map.put("realname", realname);
		map.put("gender", gender);
		map.put("id", id);
		map.put("setMode", setMode);
		resolveVoid(funcSetUserInfoMapper, map);
	}
}
