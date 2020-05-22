package com.alibaba.nocasconfigclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class NocasConfigClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(NocasConfigClientApplication.class, args);
    }

}
