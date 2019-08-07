package com.siszerosix.allstorage.svc.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.siszerosix.allstorage.svc.domain.User;
import com.siszerosix.allstorage.svc.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * 探活
 *
 * @author canyu
 * @data 2019/8/4 0:55
 */
@RestController
@RequestMapping("online")
public class OkController {

    private static final Logger logger = LoggerFactory.getLogger(OkController.class);

    @Value("${properties.owner}")
    private String owner;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "ok", method = RequestMethod.GET)
    public String isOk() {
        logger.info("test");
        return owner + ": ok";
    }

    @RequestMapping(value = "db", method = RequestMethod.GET)
    public String testDb(@RequestParam("id") String id) {
        User user = userService.findById(Long.valueOf(id));
        Page<User> page = new Page<>(1, 20);
        IPage<User> userIPage = userService.listByAge(page, 11);
        return user.getUsername() + user.getAge() + userIPage.getRecords().size();
    }
}
