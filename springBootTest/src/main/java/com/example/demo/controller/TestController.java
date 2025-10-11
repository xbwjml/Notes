package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class TestController {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @GetMapping("test1")
    public String test1(){
        redisTemplate.opsForValue().set("key1", "20250913_test");
        String res = redisTemplate.opsForValue().get("key1");
        return res;
    }
}
