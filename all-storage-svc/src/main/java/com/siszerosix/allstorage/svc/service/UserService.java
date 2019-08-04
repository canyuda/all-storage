package com.siszerosix.allstorage.svc.service;

import com.siszerosix.allstorage.svc.domain.User;

/**
 * @author canyu
 * @data 2019/8/4 15:05
 */
public interface UserService {
    User findById(Long id);
}
