package org.ticketbox.service.redis;

import lombok.AllArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
@AllArgsConstructor
public class RedisService {
    private RedisTemplate<String, Object> redisTemplate;

    public void set(String key, Object value, Integer time) {
        redisTemplate.opsForValue().set(key, value, time, TimeUnit.SECONDS);
    }

    public Object get(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    public void delete(String key) {
        redisTemplate.delete(key);
    }

    public void increment(String key) {
        redisTemplate.opsForValue().increment(key, 1);
    }

    public boolean isExist(String key) {
        return redisTemplate.hasKey(key);
    }
}

