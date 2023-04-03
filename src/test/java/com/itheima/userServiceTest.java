package com.itheima;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * userService的测试类
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = HelloApplication.class)
public class userServiceTest {

    @Autowired
    private userService userService;

    @Test
    public void testAdd(){
        userService.add();
    }
}
