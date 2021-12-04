package com.springcloud;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.ApplicationContext;

/**
 * 当前“提供者者”子项目的启动类
 */

@Slf4j
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient  //开启发现服务信息的功能
public class DeptProvider8003_App {
    public static void main(String[] args) {
        ApplicationContext run = SpringApplication.run(DeptProvider8003_App.class, args);
        String property = run.getEnvironment().getProperty("server.port");
            log.info("http://localhost:"+property+"/showDeptAll");

    }
}
