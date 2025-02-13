package com.example.demo.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.RedisService;

@RestController
@RequestMapping("/redis")
public class RedisController {
	@Autowired
    private  RedisService redisService;

    

    @PostMapping("/save")
    public String saveData(@RequestParam String key, @RequestParam String value) {
        redisService.saveData(key, value);
        return "Data saved!";
    }

    @GetMapping("/get")
    public String getData(@RequestParam String key) {
        return redisService.getData(key);
    }
}
