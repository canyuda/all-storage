package com.siszerosix.allstorage.svc.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.siszerosix.allstorage.svc.domain.User;

import java.util.List;

/**
 * @author canyu
 * @data 2019/8/4 15:05
 */
public interface UserService {
    User findById(Long id);
    User findByUsername(String username);
    IPage<User> listByAge(Page page, Integer age);
}
