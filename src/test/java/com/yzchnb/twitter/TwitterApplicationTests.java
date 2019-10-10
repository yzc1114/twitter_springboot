package com.yzchnb.twitter;

import com.yzchnb.twitter.dao.TableMapper.UserPublicInfoMapper;
import com.yzchnb.twitter.entity.TableEntity.UserPublicInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TwitterApplicationTests {

    @Autowired
    UserPublicInfoMapper userDao;

    @Test
    public void contextLoads() {
    }

    @Test
    public void testUserDao(){
        UserPublicInfo userPublicInfo = userDao.selectByPrimaryKey((short)1);
        System.out.println(userPublicInfo);
    }

}
