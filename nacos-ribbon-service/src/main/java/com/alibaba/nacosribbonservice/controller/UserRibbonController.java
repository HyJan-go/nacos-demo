package com.alibaba.nacosribbonservice.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.nacosribbonservice.entity.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

/**
 * @program: demo
 * @description: 负载均衡控制器测试
 * @author: HyJan
 * @create: 2020-05-21 19:49
 */
@RestController
@Slf4j
@RequestMapping(value = "/user", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class UserRibbonController {

  @Autowired
  private RestTemplate restTemplate;

  @Value("${spring.service-url.nacos-user-service}")
  private String userServiceUrl;

  @GetMapping("/{id}")
  public Result getUserById(@PathVariable Long id) {
    return restTemplate.getForObject(
        new StringBuilder().append(userServiceUrl).append("/user/get/{1}").toString(),
        Result.class,
        id);
  }

  @GetMapping("/get-list")
  public Result getUsers() {
    log.info("userServiceUrl is {}",userServiceUrl);
    return restTemplate.getForObject(
        new StringBuilder(userServiceUrl).append("/user/get-list").toString(), Result.class);
  }

  @GetMapping("/get-by-name")
  public Result getUserByName(String userName) {
    log.info("用户名查询 come in ...");
    ResponseEntity<Result> entity =
        restTemplate.getForEntity(
            new StringBuilder().append(userServiceUrl).append("/user/get-by-name?userName={1}").toString(),
            Result.class,
            userName);
    if (Objects.nonNull(entity)){
        log.info("获取到的结果为：{}", entity.getBody().toString());
        return entity.getBody();
    }
    return Result.error();
  }

}
