package com.alibaba.nacosuserservice.service.impl;

import com.alibaba.nacosuserservice.entity.User;
import com.alibaba.nacosuserservice.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @program: demo
 * @description: 用户服务业务逻辑具体实现
 * @author: HyJan
 * @create: 2020-05-21 17:39
 */
@Service
public class UserServiceImpl implements UserService {

  private List<User> users;

  @PostConstruct
  public void init() {
    users = new ArrayList<>();
    users.add(new User(124584L, "xiaoMing", "12569784"));
    users.add(new User(124585L, "xiaoLing", "12569784"));
    users.add(new User(124586L, "xiaoYing", "12569784"));
    users.add(new User(124587L, "xiaoNing", "12569784"));
  }

  @Override
  public List<User> getUserList() {
    return users;
  }

  @Override
  public User getUserById(Long id) {
    List<User> collect =
        users.stream()
            .filter(user -> Objects.equals(id, user.getId()))
            .collect(Collectors.toList());
    return Objects.nonNull(collect) ? collect.get(0) : null;
  }

  @Override
  public User getByName(String name) {
    List<User> collect =
        users.stream()
            .filter(user -> Objects.equals(user.getUserName(), name))
            .collect(Collectors.toList());
    return ObjectUtils.isEmpty(collect) ? null : collect.get(0);
  }

  /**
   * 这里可以巧妙调用别的方法，简便自己的开发
   *
   * @param id
   */
  @Override
  public void deleteUserById(Long id) {
    User userById = getUserById(id);
    users.remove(userById);
  }

  @Override
  public void updateUser(User user) {
    users.stream()
        .filter(user1 -> Objects.equals(user.getId(), user1.getId()))
        // 符合条件的任何一个都应该被修改
        .forEach(
            user1 -> {
              user1.setUserName(user.getUserName());
              user1.setPassword(user.getPassword());
            });
  }

  @Override
  public void insertUser(User user) {
    users.add(user);
  }
}
