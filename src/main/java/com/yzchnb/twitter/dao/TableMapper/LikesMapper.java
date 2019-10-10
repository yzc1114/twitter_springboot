package com.yzchnb.twitter.dao.TableMapper;

import com.yzchnb.twitter.entity.TableEntity.Likes;
import com.yzchnb.twitter.entity.TableEntity.LikesKey;

public interface LikesMapper {
    int deleteByPrimaryKey(LikesKey key);

    int insert(Likes record);

    int insertSelective(Likes record);

    Likes selectByPrimaryKey(LikesKey key);

    int updateByPrimaryKeySelective(Likes record);

    int updateByPrimaryKey(Likes record);
}