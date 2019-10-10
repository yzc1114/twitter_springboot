package com.yzchnb.twitter.dao.TableMapper;

import com.yzchnb.twitter.entity.TableEntity.UserPublicInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


@Mapper
@Repository
public interface UserPublicInfoMapper {
    int deleteByPrimaryKey(Short userId);

    int insert(UserPublicInfo record);

    int insertSelective(UserPublicInfo record);

    UserPublicInfo selectByPrimaryKey(Short userId);

    int updateByPrimaryKeySelective(UserPublicInfo record);

    int updateByPrimaryKey(UserPublicInfo record);
}