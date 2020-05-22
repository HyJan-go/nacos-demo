package com.alibaba.nacosribbonservice.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @program: demo
 * @description: 负载均衡配置类
 * @author: HyJan
 * @create: 2020-05-21 19:40
 */
@Configuration
public class RibbonConfig {

  /**
   * 负载均衡注解是关键
   *
   * @return
   */
  @Bean
  @LoadBalanced
  public RestTemplate restTemplate() {
    return new RestTemplate();
  }

  /**
   * 配置负载均衡策略
   *
   * <p>随机 (Random) 轮询 (RoundRobin) 一致性哈希 (ConsistentHash) 哈希 (Hash) 加权（Weighted）
   *
   * @return
   */
  @Bean
  public IRule iRule() {
    return new RoundRobinRule();
  }
}
