package com.itheima;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * userService的测试类
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = HelloApplication.class)
public class userServiceTest {

    @Autowired
    private com.itheima.service.userService userService;
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired

    @Test
    public void testAdd(){
        userService.add();
    }

    /**
     * 测试Redis的存入和读取
     */
    @Test
    public void testSet(){
        //存入数据
        redisTemplate.boundValueOps("name").set("zhangsan");
    }
    @Test
    public void testGet(){
        //获取数据
        Object name = redisTemplate.boundValueOps("name").get();
        System.out.println(name);
    }

}
