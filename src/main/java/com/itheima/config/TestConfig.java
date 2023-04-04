package com.itheima.config;

import com.itheima.condition.ClassCondition;
import com.itheima.condition.ConditionOnClass;
import com.itheima.domain.TestCondition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfig {

    @Bean
    @ConditionOnClass("redis.clients.jedis.Jedis")
    public TestCondition testCondition(){
        return new TestCondition();
    }
}
