package com.itheima.config;

import com.itheima.condition.ClassCondition;
import com.itheima.domain.TestCondition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfig {

    @Bean
    @Conditional(ClassCondition.class)
    public TestCondition testCondition(){
        return new TestCondition();
    }
}
