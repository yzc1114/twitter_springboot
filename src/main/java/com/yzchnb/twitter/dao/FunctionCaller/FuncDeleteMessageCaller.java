package com.yzchnb.twitter.dao.FunctionCaller;

import com.yzchnb.twitter.dao.FunctionCaller.BaseCaller.FuncBaseCaller;
import com.yzchnb.twitter.dao.FunctionMapper.FuncDeleteMessageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Repository
public class FuncDeleteMessageCaller extends FuncBaseCaller {
	@Autowired
	private FuncDeleteMessageMapper funcDeleteMessageMapper;

	public java.lang.Integer call(java.lang.Integer messageIdInput){
		Map map = new HashMap();
		map.put("message_id_input", messageIdInput);
		return resolveInteger(funcDeleteMessageMapper, map);
	}
}
