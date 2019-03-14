package com.fish.providermovie.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Map;

/**
 * @Author: luo
 * @Time: 2019-03-14 10:31
 **/
@FeignClient(name = "provider-user", fallback = UserFallBack.class)
@Component
public interface UserFeignClient {

    @GetMapping("/user/{id}")
    public Map findById(@PathVariable("id") Integer id);

}
