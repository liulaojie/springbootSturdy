package com.itheima.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;
import redis.clients.jedis.Jedis;

import java.util.Map;

public class ClassCondition implements Condition {
    /**
     *
     * @param conditionContext 上下文对象，用于获取环境，IOC容器，ClassLoader对象
     * @param annotatedTypeMetadata 注解的元对象可以用于获取注解的属性值
     * @return
     */
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
//        //需求1：导入Jedis坐标后创建bean
//        //思路：判断redis.clients.jedis.Jedis.class文件是否存在
//        boolean flag = true;
//        try {
//            Class<?> cls = Class.forName("redis.clients.jedis.Jedis");
//        } catch (ClassNotFoundException e) {
//            flag = false;
//        }
//        return flag;
        //需求2：导入通过注解属性值指定的坐标后创建bean
        //思路：获取注解属性值 value
        Map<String, Object> map = annotatedTypeMetadata.getAnnotationAttributes(ConditionOnClass.class.getName());
        String[] value = (String[])map.get("value");
        boolean flag = true;
        try {
            for (String className : value){
                Class<?> cls = Class.forName(className);
            }
        } catch (ClassNotFoundException e) {
            flag = false;
        }
        return flag;
    }
}
