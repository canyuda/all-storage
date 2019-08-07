package com.siszerosix.allstorage.svc.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author canyu
 * @data 2019/8/4 14:59
 */
@Data
@TableName(value = "t_user")
public class User {
    @TableField(value = "id")
    private Long id;
    @TableField(value = "username")
    private String username;
    @TableField(value = "password")
    private String password;
    @TableField(value = "age")
    private Integer age;
}
