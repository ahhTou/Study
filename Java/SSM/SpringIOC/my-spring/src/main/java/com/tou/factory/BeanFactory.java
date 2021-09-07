package com.tou.factory;

import com.tou.dao.HelloDao;
import com.tou.dao.impl.HelloDaoImpl;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class BeanFactory {

    private final static Properties properties;

    private final static Map<String, Object> cache = new HashMap<>();

    static {
        properties = new Properties();
        try {
            properties.load(BeanFactory.class.getClassLoader().getResourceAsStream("factory.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Object getDao(String beanName) {
        // 先判断缓存中是否存在bean
        String val = properties.getProperty(beanName);
        // 多线程安全
        if (!cache.containsKey(beanName)) {
            synchronized (BeanFactory.class) {
                if (!cache.containsKey(beanName)) {
                    try {
                        // 通过反射创建对象
                        Class<?> aClass = Class.forName(val);
                        Object o = aClass.getConstructor().newInstance();
                        cache.put(beanName, o);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return cache.get(beanName);

    }
}
