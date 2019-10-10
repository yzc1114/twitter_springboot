package com.yzchnb.twitter.dao.TableMapper;

import com.yzchnb.twitter.entity.TableEntity.AvatarImage;
import com.yzchnb.twitter.entity.TableEntity.AvatarImageKey;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface AvatarImageMapper {
    int deleteByPrimaryKey(AvatarImageKey key);

    int insert(AvatarImage record);

    int insertSelective(AvatarImage record);

    AvatarImage selectByPrimaryKey(AvatarImageKey key);

    int updateByPrimaryKeySelective(AvatarImage record);

    int updateByPrimaryKey(AvatarImage record);
}