package com.yzchnb.twitter.dao.TableMapper;

import com.yzchnb.twitter.entity.TableEntity.MessageOwnsTopicKey;

public interface MessageOwnsTopicMapper {
    int deleteByPrimaryKey(MessageOwnsTopicKey key);

    int insert(MessageOwnsTopicKey record);

    int insertSelective(MessageOwnsTopicKey record);
}