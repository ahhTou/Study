package com.tou.utils.redis;

public class StreamRedisUtilsStarter {

    public StreamRedisUtilsSubject set(String k, Object v) {
        return new StreamRedisUtilsSubject(k, v);
    }

    public String getString(String k) {
        return (String) RedisUtils.getToRedis().getString(k);
    }

    public Boolean hasKey(String k) {
        return RedisUtils.getToRedis().hasKey(k);
    }

    public Boolean hasOneKey(String... k) {
        for (String aK : k)
            if (hasKey(aK)) return true;
        return false;
    }
}
