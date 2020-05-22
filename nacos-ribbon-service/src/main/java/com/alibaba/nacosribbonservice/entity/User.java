package com.alibaba.nacosribbonservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @program: demo
 * @description: 用户实体测试类
 * @author: HyJan
 * @create: 2020-05-21 17:07
 **/
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Long id;
    private String userName;
    private String password;
}
