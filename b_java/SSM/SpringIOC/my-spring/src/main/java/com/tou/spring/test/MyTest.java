package com.tou.spring.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MyTest {
    public static void main(String[] args) {
        // 加载 IoC 容器 ( 基于注解的 )
        ApplicationContext context = new AnnotationConfigApplicationContext("com.tou.spring.entity");

        System.out.println(context.getBean("account"));

        System.out.println("Bean 的 个数" + context.getBeanDefinitionCount());
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println("Bean -> " + beanDefinitionName);
        }


    }
}
