package com.tou.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class HelloController {

    @GetMapping("/test")
    public String test(String username, HttpServletRequest request) {
        request.getSession().setAttribute("username", username);

        return "Login OK";
    }
}
