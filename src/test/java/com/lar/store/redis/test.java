package com.lar.store.redis;

import com.lar.store.pojo.Category;
import com.lar.store.service.CategoryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import  org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class test {
    @Autowired
    CategoryService categoryService;

    @Autowired
    RedisTemplate<Object, Object> redisTemplate;
    @Test
    public void testredis(){
        Category category=categoryService.get(10);
        redisTemplate.opsForValue().set("category",category);
    }
}
