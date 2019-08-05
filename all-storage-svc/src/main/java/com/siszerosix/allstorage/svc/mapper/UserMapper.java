package com.siszerosix.allstorage.svc.mapper;

import com.siszerosix.allstorage.svc.domain.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author canyu
 * @data 2019/8/4 15:01
 */
@Repository
public interface UserMapper {
    User findById(@Param("id") Long id);

    User findByUsername(@Param("username") String username);
}
