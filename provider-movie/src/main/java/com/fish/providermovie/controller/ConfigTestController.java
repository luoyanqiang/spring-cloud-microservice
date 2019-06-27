package com.fish.providermovie.controller;

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

    private String profile = "ss";

    @GetMapping("profile")
    public String hello() {
        return this.profile;
    }

}
