package com.tou.shiro.cache;

import lombok.Data;
import lombok.experimental.Accessors;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Set;

@Component
@Data
@Accessors(chain = true)
@SuppressWarnings("unchecked")
public class RedisCache<K, V> implements Cache<K, V> {

    private String cacheName;

    @Autowired
    @Qualifier("redisTemplate4shiro")
    RedisTemplate<String, Object> redisTemplate;

    @Override
    public V get(K k) throws CacheException {
        return (V) redisTemplate.opsForHash().get(this.cacheName, k);
    }

    @Override
    public V put(K k, V v) throws CacheException {
        System.out.println("Shiro-Redis-Put");
        redisTemplate.opsForHash().put(this.cacheName, k, v);
        return v;
    }

    @Override
    public V remove(K k) throws CacheException {
        return (V) redisTemplate.opsForHash().delete(this.cacheName, k.toString());
    }

    @Override
    public void clear() throws CacheException {
        redisTemplate.opsForHash().delete(this.cacheName);
    }

    @Override
    public int size() {
        return getRedisTemplate().opsForHash().size(this.cacheName).intValue();
    }

    @Override
    public Set<K> keys() {
        return (Set<K>) redisTemplate.opsForHash().keys(this.cacheName);
    }

    @Override
    public Collection<V> values() {
        return (Collection<V>) redisTemplate.opsForHash().values(this.cacheName);
    }
}
