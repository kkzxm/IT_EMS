package com.lingDream.justDoIT;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Author: 酷酷宅小明
 * @CreateDate: 2021/12/21 0021 15:29
 */
@EnableEurekaServer
@SpringBootApplication
public class JustDoITEurekaServer {
    public static void main(String[] args) {
        SpringApplication.run(JustDoITEurekaServer.class, args);
    }
}
