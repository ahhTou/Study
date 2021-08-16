package com.tou.spring.entity;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Data
@Component
public class Account {
    @Value("1")
    private Integer id;
    @Value("ahhTou")
    private String name;
    @Value("22")
    private Integer age;

    // @Autowired 根据类型找
    // @Qualifier("order") 根据名字去找
    @Resource
    private Order order;
}
