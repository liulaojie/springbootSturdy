package com.itheima;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
//通个@Value来获取配置文件中的属性
    //    @Value("${name}")
    @Value("${person.name}")
    private String name1;

    @Value("${address[0]}")
    private String address;

    @Value("${msg1}")
    private String msg1;

    @Value("${msg2}")
    private String msg2;
    //通个Environment对象来获取配置文件中的属性
    @Autowired
    private Environment environment;
    @Autowired
    private Person person;

    /**
     * 测试从配置文件中读取到的值
     * @return
     */
    @RequestMapping("/getArg")
    public String getArg (){
        System.out.println(name1);
        System.out.println(address);
        System.out.println(msg1);
        System.out.println(msg2);
        System.out.println("-----------");
        System.out.println(environment.getProperty("name"));
        System.out.println("-----------");
        System.out.println(person.toString());
        return  "";
    }


    @RequestMapping("/hello")
    public String hello (){
        return  "hello SpringBoot";
    }
}
