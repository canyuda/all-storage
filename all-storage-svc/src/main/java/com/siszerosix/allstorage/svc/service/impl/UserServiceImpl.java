package com.siszerosix.allstorage.svc.service.impl;

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
        return userMapper.findById(id);
    }
}
