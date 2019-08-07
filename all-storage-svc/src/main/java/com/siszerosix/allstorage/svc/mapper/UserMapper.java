package com.siszerosix.allstorage.svc.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.siszerosix.allstorage.svc.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author canyu
 * @data 2019/8/4 15:01
 */
@Mapper
@Repository
public interface UserMapper extends BaseMapper<User> {
    IPage<User> selectPageVo(Page page, @Param("age") Integer state);
}
