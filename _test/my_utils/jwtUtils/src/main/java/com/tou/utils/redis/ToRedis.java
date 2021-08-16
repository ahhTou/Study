package com.tou.utils.redis;


import javax.annotation.PostConstruct;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public interface ToRedis {

    @PostConstruct
    default void init() {
        RedisUtils.setToRedis(this);
    }

    void set(String k, Object v);

    void set(String k, Set<String> v);

    void set(String k, String... v);

    void expire(String k, int timer, TimeUnit timeUnit);


    Object getString(String k);

    boolean hasKey(String k);


}
