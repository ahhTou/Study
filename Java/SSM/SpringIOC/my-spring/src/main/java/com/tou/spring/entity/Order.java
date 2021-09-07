package com.tou.spring.entity;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class Order {
    @Value("xxx123")
    private String orderID;

    @Value("1000.0")
    private Float price;

}
