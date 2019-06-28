package com.fish.providermovie.service.impl;

import com.fish.providermovie.ProviderMovieApplication;
import com.fish.providermovie.entity.FinanceUserEntity;
import com.fish.providermovie.service.UserService;
import com.fish.providermovie.utils.RedisUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.AssertTrue;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {ProviderMovieApplication.class})
@Transactional
@Rollback
public class UserServiceImplTest {

    @Autowired
    private UserService userService;
    @Autowired
    private RedisUtils redisUtils;

    @Test
    public void findList() {
        List<FinanceUserEntity> list = userService.findList();
        list.stream().forEach(item -> System.out.println(item.getName()));
        Assert.assertTrue(list.size() > 0);
    }



    @Test
    public void testRedis() {
        redisUtils.set("name", "lisi");
        String name = (String) redisUtils.get("name");
        Assert.assertEquals(name, "lisi");
    }

}