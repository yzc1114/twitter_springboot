package com.yzchnb.twitter;

import com.yzchnb.twitter.dao.TableMapper.UserPublicInfoMapper;
import com.yzchnb.twitter.entity.TableEntity.UserPublicInfo;
import com.yzchnb.twitter.utils.Utils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.FileNotFoundException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TwitterApplicationTests {

    @Autowired
    UserPublicInfoMapper userDao;

    @Resource
    Utils utils;

    @Test
    public void testGetMessageById(){
        int messageId = 1;
        utils.getAvatarUrlById(messageId);
    }

    @Test
    public void testGetImgLocation() throws FileNotFoundException {
        System.out.println(utils.getImageLocation());
    }

    @Test
    public void contextLoads() {
    }

    @Test
    public void testUserDao(){
        UserPublicInfo userPublicInfo = userDao.selectByPrimaryKey((short)1);
        System.out.println(userPublicInfo);
    }

}
