package com.fish.provideruser.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: luo
 * @Time: 2019-03-14 09:04
 **/
@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("list")
    public List list() {
        List list = Arrays.asList("ZHANGSAN", "LISI", "WANGWU");
        return list;
    }

    @GetMapping("{id}")
    public Map findById(@PathVariable Integer id) {
        HashMap map = new HashMap();
        map.put("id", 1);
        map.put("name", "lisi");
        return map;
    }


}
