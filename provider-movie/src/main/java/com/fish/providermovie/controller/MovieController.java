package com.fish.providermovie.controller;

import com.fish.providermovie.feign.UserFeignClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: luo
 * @Time: 2019-03-14 09:15
 **/
@RestController
@RequestMapping("/movie")
public class MovieController {

    private static final Logger logger = LoggerFactory.getLogger(MovieController.class);

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("user/{id}")
    public Map findById(@PathVariable Integer id) {
        Map map = restTemplate.getForObject("http://provider-user/user/" + id, HashMap.class);
        return map;
    }

    @Autowired
    private UserFeignClient userFeignClient;

    @GetMapping("user2/{id}")
    public Map findById2(@PathVariable Integer id) {
        Map map = userFeignClient.findById(id);
        map.put("age", 18);
        return map;
    }

    @GetMapping("log-user-instance")
    public void logUserInstance() {
        ServiceInstance serviceInstance = this.loadBalancerClient.choose("provider-user");
        MovieController.logger.info("=========================");
        MovieController.logger.info("{}:{}:{}", serviceInstance.getServiceId(), serviceInstance.getHost(),
                serviceInstance.getPort());
    }


}
