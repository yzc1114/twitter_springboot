package com.yzchnb.twitter.dao.FunctionCaller;

import com.yzchnb.twitter.dao.FunctionCaller.BaseCaller.FuncBaseCaller;
import com.yzchnb.twitter.dao.FunctionMapper.FuncShowMessageByIdMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Repository
public class FuncShowMessageByIdCaller extends FuncBaseCaller {
	@Autowired
	private FuncShowMessageByIdMapper funcShowMessageByIdMapper;

	public java.util.ArrayList call(java.lang.Integer messageIdInput){
		Map map = new HashMap();
		map.put("messageIdInput", messageIdInput);
		return resolveArrayList(funcShowMessageByIdMapper, map);
	}
}
