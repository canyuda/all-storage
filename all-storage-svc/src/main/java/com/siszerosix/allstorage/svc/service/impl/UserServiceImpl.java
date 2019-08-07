package com.siszerosix.allstorage.svc.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.siszerosix.allstorage.svc.domain.User;
import com.siszerosix.allstorage.svc.mapper.UserMapper;
import com.siszerosix.allstorage.svc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author canyu
 * @data 2019/8/4 15:05
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;


    @Override
    public User findById(Long id) {
        return userMapper.selectById(id);
    }

    @Override
    public User findByUsername(String username) {
        QueryWrapper<User> objectQueryWrapper = new QueryWrapper<>();
        objectQueryWrapper.eq("username", username);
        return userMapper.selectOne(objectQueryWrapper);
    }

    @Override
    public IPage<User> listByAge(Page page, Integer age) {
        return userMapper.selectPageVo(page, age);
    }
}
