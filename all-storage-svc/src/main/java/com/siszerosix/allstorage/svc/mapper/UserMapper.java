package com.siszerosix.allstorage.svc.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.siszerosix.allstorage.svc.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author canyu
 * @data 2019/8/4 15:01
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
