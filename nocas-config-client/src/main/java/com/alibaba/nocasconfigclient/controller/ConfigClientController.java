package com.alibaba.nocasconfigclient.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: demo
 * @description: 配置中心获取数据示例
 * @author: HyJan
 * @create: 2020-05-21 16:07
 **/
@RestController
@RefreshScope
@Slf4j
public class ConfigClientController {

    @Value("${config.info}")
    private String configInfo;

    /**
     * 将配置文件中的配置读取并返回
     *
     * @return
     */
    @GetMapping("/get-info")
    public String getConfigInfo() {
        log.info("获取到的配置信息为 {}", configInfo);
        return configInfo;
    }
}
