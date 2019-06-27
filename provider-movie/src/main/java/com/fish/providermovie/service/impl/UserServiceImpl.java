package com.fish.providermovie.service.impl;

import com.fish.providermovie.entity.FinanceUserEntity;
import com.fish.providermovie.mapper.FinanceUserMapper;
import com.fish.providermovie.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: luoyanqiang
 * @Time: 2019-06-27 20:55
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private FinanceUserMapper financeUserMapper;

    @Override
    public List findList() {
        List<FinanceUserEntity> list =  financeUserMapper.selectAll();
        return list;
    }
}
