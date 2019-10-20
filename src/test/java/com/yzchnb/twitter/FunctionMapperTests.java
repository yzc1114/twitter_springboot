package com.yzchnb.twitter;


import com.yzchnb.twitter.dao.FunctionCaller.FuncShowMessageByRangeCaller;
import com.yzchnb.twitter.dao.FunctionCaller.FuncUserSignInByEmailCaller;
import com.yzchnb.twitter.dao.FunctionCaller.FuncUserSignUpCaller;
import com.yzchnb.twitter.dao.FunctionMapper.FuncRecommendUserMapper;
import com.yzchnb.twitter.dao.FunctionMapper.FuncUserSignUpMapper;
import com.yzchnb.twitter.dao.TableMapper.UserPublicInfoMapper;
import com.yzchnb.twitter.entity.TableEntity.UserPublicInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FunctionMapperTests {

    @Autowired
    FuncUserSignUpMapper funcUserSignUpMapper;

    @Autowired
    UserPublicInfoMapper userPublicInfoMapper;

    @Autowired
    FuncUserSignUpCaller funcUserSignUpCaller;

    @Autowired
    FuncRecommendUserMapper funcRecommendUserMapper;

    @Autowired
    FuncUserSignInByEmailCaller funcUserSignInByEmailCaller;

    @Autowired
    FuncShowMessageByRangeCaller funcShowMessageByRangeCaller;


    @Test
    public void testFuncUserSignUpMapperUsingMybatisConfig() throws IOException {

        String resource = "mybatis-config.xml";
        Reader reader = Resources.getResourceAsReader(resource);
        SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(reader);
        SqlSession session = ssf.openSession();
        try {
            Map map = new HashMap();
            map.put("email", "12333333@qq.com");
            map.put("nickname", "yzchnb1123123123");
            map.put("password", "qweqwe");
            session.selectOne("call", map);
            map.forEach((k, v)->{
                System.out.println(k.toString() + v.toString() + " ");
            });
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Test
    public void testUserPublicInfoMapper(){
        UserPublicInfo userPublicInfo = userPublicInfoMapper.selectByPrimaryKey((short) 1);
        System.out.println(userPublicInfo);
    }

    @Test
    public void testFuncUserSignUpMapper(){
        Map map = new HashMap();
        map.put("email", "unique@qq.com");
        map.put("nickname", "whatever");
        map.put("password", "qweqwe");
        try{
            funcUserSignUpMapper.call(map);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("caught");
        }
        //System.out.println(map);
    }

    @Test
    public void testFuncRecommendUserMapper(){
        Map map = new HashMap();
        try{
            funcRecommendUserMapper.call(map);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("caught");
        }
        System.out.println(map);
    }


    @Test
    public void testFuncUserSignUpCaller(){
        try{
            funcUserSignUpCaller.call("1234567@qq.com", "suibian", "123123");
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testSignIn() {
        try{
            Integer userId = funcUserSignInByEmailCaller.call("102@qq.com", "123456");
            System.out.println(userId);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testfunc_show_message_by_range(){
        try{
            ArrayList res = funcShowMessageByRangeCaller.call(1, 1, 4);
            System.out.println(res);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}
