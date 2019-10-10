package com.yzchnb.twitter.dao.TableMapper;

import com.yzchnb.twitter.entity.TableEntity.Message;

public interface MessageMapper {
    int deleteByPrimaryKey(Short messageId);

    int insert(Message record);

    int insertSelective(Message record);

    Message selectByPrimaryKey(Short messageId);

    int updateByPrimaryKeySelective(Message record);

    int updateByPrimaryKey(Message record);
}