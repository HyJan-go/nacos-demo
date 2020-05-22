package com.alibaba.nacosuserservice.service;

import com.alibaba.nacosuserservice.entity.User;

import java.time.LocalDate;
import java.util.List;

/**
 * @program: demo
 * @description: 用户service接口
 * @author: HyJan
 * @create: 2020-05-21 17:24
 **/
public interface UserService {

    /**
     * 获取用户列表
     * @return
     */
    List<User> getUserList();

    /**
     * 通过用户id获取用户信息
     * @param id
     * @return
     */
    User getUserById(Long id);

    /**
     * 通过用户名获取用户信息
     * @param name
     * @return
     */
    User getByName(String name);

    /**
     * 根据id删除用户信息
     * @param id
     */
    void deleteUserById(Long id);

    /**
     * 根性用户信息
     * @param user
     */
    void updateUser(User user);

    /**
     * 插入一条用户信息
     * @param user
     */
    void insertUser(User user);
}
