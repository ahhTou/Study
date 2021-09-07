package com.tou.spring_lite.entity;

import com.tou.spring_lite.annotation.Autowired;
import com.tou.spring_lite.annotation.Component;
import com.tou.spring_lite.annotation.Qualifier;
import com.tou.spring_lite.annotation.Value;
import lombok.Data;

@Data
@Component
public class Account {

    @Value("1")
    private Integer id;
    @Value("ahhTou")
    private String name;

    @Autowired
    private Order order;
}
