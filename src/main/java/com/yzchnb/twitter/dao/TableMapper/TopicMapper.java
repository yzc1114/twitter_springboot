package com.yzchnb.twitter.dao.TableMapper;

import com.yzchnb.twitter.entity.TableEntity.Topic;

public interface TopicMapper {
    int deleteByPrimaryKey(Short topicId);

    int insert(Topic record);

    int insertSelective(Topic record);

    Topic selectByPrimaryKey(Short topicId);

    int updateByPrimaryKeySelective(Topic record);

    int updateByPrimaryKey(Topic record);
}