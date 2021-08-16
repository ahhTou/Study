package com.tou.spring_lite.entity;

import com.tou.spring_lite.annotation.Component;
import com.tou.spring_lite.annotation.Value;
import lombok.Data;

@Data
@Component
public class Order {
    @Value("xxx123")
    private String orderID;

    @Value("1000.0")
    private Float price;

}
