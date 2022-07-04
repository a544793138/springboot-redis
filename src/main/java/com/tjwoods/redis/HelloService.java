package com.tjwoods.redis;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicInteger;

@Service
public class HelloService {

    private static AtomicInteger count = new AtomicInteger(0);

    public static AtomicInteger getCount() {
        return count;
    }

    @Cacheable(cacheNames = "myCache")
    public String hello(String name) {
        System.out.println("=================== in method hello ===================");
        count.incrementAndGet();
        return "hello" + name;
    }

    @CachePut(cacheNames = "myCache")
    public String update(String name) {
        System.out.println("=================== in method update ===================");
        return "helloUpdate" + name;
    }

    @CacheEvict(cacheNames = "myCache")
    public void delete(String name) {
        System.out.println("=================== in method delete ===================");
        count.decrementAndGet();
    }
}
