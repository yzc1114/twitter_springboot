package com.yzchnb.twitter.UnitTest;

import com.yzchnb.twitter.utils.Utils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UtilsTest {
    @Resource
    Utils utils;

    @Test
    public void testGetTopicContents(){
        Assert.assertArrayEquals(new String[0],utils.getTopicContent("").toArray());
        Assert.assertArrayEquals(new String[0],utils.getTopicContent("#aa").toArray());
        Assert.assertArrayEquals(new String[0],utils.getTopicContent("aa#").toArray());
        Assert.assertArrayEquals(new String[0],utils.getTopicContent("##").toArray());

        Assert.assertArrayEquals(new String[]{"aa"},utils.getTopicContent("#aa#").toArray());
        Assert.assertArrayEquals(new String[]{"aa"},utils.getTopicContent("#aa#bb#").toArray());
        Assert.assertArrayEquals(new String[]{"aa"},utils.getTopicContent("b#aa#b").toArray());
        Assert.assertArrayEquals(new String[]{"aa"},utils.getTopicContent("#aa##b").toArray());

        Assert.assertArrayEquals(new String[]{"aa","bb"},utils.getTopicContent("#aa##bb#").toArray());
        Assert.assertArrayEquals(new String[]{"aa","bb"},utils.getTopicContent("b#aa#b#bb#b").toArray());

    }

    @Test
    public void testGetAtContents(){
        Assert.assertArrayEquals(new String[0],utils.getAtContent("").toArray());
        Assert.assertArrayEquals(new String[0],utils.getAtContent("@ ").toArray());
        Assert.assertArrayEquals(new String[0],utils.getAtContent("a @").toArray());

        Assert.assertArrayEquals(new String[]{"yyy"},utils.getAtContent("@yyy ").toArray());
        Assert.assertArrayEquals(new String[]{"yyy"},utils.getAtContent("@yyy @").toArray());
        Assert.assertArrayEquals(new String[]{"yyy"},utils.getAtContent(" @@yyy").toArray());

        Assert.assertArrayEquals(new String[]{"yyy","YaYa"},utils.getAtContent("@yyy@YaYa").toArray());
    }
}
