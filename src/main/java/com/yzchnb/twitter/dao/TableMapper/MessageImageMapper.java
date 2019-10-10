package com.yzchnb.twitter.dao.TableMapper;

import com.yzchnb.twitter.entity.TableEntity.MessageImage;

public interface MessageImageMapper {
    int deleteByPrimaryKey(Short messageId);

    int insert(MessageImage record);

    int insertSelective(MessageImage record);

    MessageImage selectByPrimaryKey(Short messageId);

    int updateByPrimaryKeySelective(MessageImage record);

    int updateByPrimaryKey(MessageImage record);
}