package com.yzchnb.twitter.dao.FunctionCaller;

import com.yzchnb.twitter.dao.FunctionCaller.BaseCaller.FuncBaseCaller;
import com.yzchnb.twitter.dao.FunctionMapper.FuncDeletePrivateLetterMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Repository
public class FuncDeletePrivateLetterCaller extends FuncBaseCaller {
	@Autowired
	private FuncDeletePrivateLetterMapper funcDeletePrivateLetterMapper;

	public void call(java.lang.Integer dPrivateLetterId){
		Map map = new HashMap();
		map.put("dPrivateLetterId", dPrivateLetterId);
		resolveVoid(funcDeletePrivateLetterMapper, map);
	}
}
