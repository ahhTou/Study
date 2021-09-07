package com.tou.shiro.cache;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.cache.CacheManager;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component("shiroRedisCacheManager")
public class RedisCacheManager implements CacheManager {

    @Resource
    RedisCache<?, ?> redisCache;

    @Override
    @SuppressWarnings("unchecked")
    public <K, V> Cache<K, V> getCache(String cacheName) throws CacheException {
        return (Cache<K, V>) redisCache.setCacheName(cacheName);
    }
}
