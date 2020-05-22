package com.alibaba.nacosuserservice.controller;

import com.alibaba.nacosuserservice.entity.Result;
import com.alibaba.nacosuserservice.entity.User;
import com.alibaba.nacosuserservice.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @program: demo
 * @description: 用户控制类
 * @author: HyJan
 * @create: 2020-05-21 18:22
 **/
@RestController
@Slf4j
@RequestMapping(value = "/user",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/get-list")
    public Result getUserList(){
        List<User> userList = userService.getUserList();
        return Result.success(userList);
    }

    @GetMapping("/get/{id}")
    public Result getUserById(@PathVariable Long id){
        User user = userService.getUserById(id);
        return Result.success(user);
    }

    @GetMapping("/get-by-name")
    public Result getByName(String userName){
        User user = userService.getByName(userName);
        log.info("the result is {}",user.toString());
        return Result.success(user);
    }
}
