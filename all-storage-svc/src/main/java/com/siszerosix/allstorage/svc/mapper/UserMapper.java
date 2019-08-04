package com.siszerosix.allstorage.svc.mapper;

import com.siszerosix.allstorage.svc.domain.User;
import org.apache.ibatis.annotations.Param;

/**
 * @author canyu
 * @data 2019/8/4 15:01
 */
public interface UserMapper {
    User findById(@Param("id") Long id);
}
