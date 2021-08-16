package com.tou.utils.redis;

public class RedisUtils {

    private static ToRedis toRedis;

    public static ToRedis getToRedis() {
        return toRedis;
    }

    public static void setToRedis(ToRedis toRedis) {
        RedisUtils.toRedis = toRedis;
    }

    public static StreamRedisUtilsStarter starter = new StreamRedisUtilsStarter();

    public static StreamRedisUtilsSubject set(String k, Object v) {
        return starter.set(k, v);
    }

    public static String getString(String k) {
        return starter.getString(k);
    }

    public static Boolean hasKey(String k) {
        return starter.hasKey(k);
    }

    public static Boolean hasOneKey(String... k) {
        return starter.hasOneKey(k);
    }

}
