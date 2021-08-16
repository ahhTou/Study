package com.tou.utils.redis;

import java.util.concurrent.TimeUnit;

/**
 * redis工具类主体
 */
public class StreamRedisUtilsSubject {

    private final String k;

    int expire = 30;


    public StreamRedisUtilsSubject(String k, Object v) {
        this.k = k;
        RedisUtils.getToRedis().set(k, v);
    }

    public StreamRedisUtilsStarter expire() {
        RedisUtils.getToRedis().expire(k, expire, TimeUnit.MINUTES);
        return new StreamRedisUtilsStarter();
    }

    public StreamRedisUtilsStarter expire(int minutes) {
        RedisUtils.getToRedis().expire(k, minutes, TimeUnit.MINUTES);
        return new StreamRedisUtilsStarter();

    }

    public StreamRedisUtilsStarter expire(TimeUnit time, int amount) {
        RedisUtils.getToRedis().expire(k, amount, time);
        return new StreamRedisUtilsStarter();
    }

    public StreamRedisUtilsSubject set(String k, Object v) {
        return new StreamRedisUtilsSubject(k, v);
    }


}
