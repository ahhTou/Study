package com.tou.service.impl;

import com.tou.dao.HelloDao;
import com.tou.factory.BeanFactory;
import com.tou.service.HelloService;

import java.util.List;

public class HelloServiceImpl implements HelloService {


    private final HelloDao helloDao = (HelloDao) BeanFactory.getDao("helloDao");

    @Override
    public List<String> findAll() {
        return this.helloDao.findAll();
    }
}
