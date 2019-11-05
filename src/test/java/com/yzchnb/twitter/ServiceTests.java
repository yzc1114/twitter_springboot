package com.yzchnb.twitter;

import com.yzchnb.twitter.entity.TableEntity.UserPublicInfo;
import com.yzchnb.twitter.service.ICollectionService;
import com.yzchnb.twitter.service.IMessageService;
import com.yzchnb.twitter.service.IRelationService;
import com.yzchnb.twitter.service.IUserService;
import com.yzchnb.twitter.utils.Utils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.swing.plaf.synth.SynthEditorPaneUI;
import java.util.ArrayList;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceTests {
    @Resource
    private IUserService userService;
    @Resource
    private IRelationService relationService;
    @Resource
    private IMessageService messageService;
    @Resource
    private ICollectionService collectionService;
    @Test
    public void main(){
        //relationService.FollowUser(3,7);
        //System.out.println(relationService.QueryFollowersFor(7,0,100));
        //System.out.println(relationService.QueryFollowingFor(3,0,100));
        //System.out.println(relationService.IfFollowing(3,7));
        //System.out.println(messageService.AddMessage("sss",0,7,0));
        //System.out.println(messageService.QueryNewest(0,100));
        //System.out.println(userService.getRecommend());
        //collectionService.Add(7,21);
        //System.out.println(collectionService.QueryCollection(7,0,100));
        //System.out.println(Utils.getTopicContent("jkljkljlag  ##  #          #dfas#2##11#"));
        //System.out.println(Utils.getAtContent("@gddfg aee ffad feew@3324@2@@fffad"));
        System.out.println(relationService.QueryFollowingFor(63,0,63));
    }
}
