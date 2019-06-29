package com.fish.providermovie.feign;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: luo
 * @Time: 2019-03-14 11:15
 **/
@Component
public class UserFallBack implements UserFeignClient {
    @Override
    public Map findById(Integer id) {
        Map map = new HashMap(3);
        map.put("id", 0);
        map.put("name", "default");
        map.put("age", 8);
        return map;
    }
}
