package com.fish.configtest.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: luo
 * @Time: 2019-03-14 16:02
 **/
@RestController
@RequestMapping("/config")
public class ConfigTestController {

    @Value("${profile}")
    private String profile;

    @GetMapping("profile")
    public String hello() {
        return this.profile;
    }

}
