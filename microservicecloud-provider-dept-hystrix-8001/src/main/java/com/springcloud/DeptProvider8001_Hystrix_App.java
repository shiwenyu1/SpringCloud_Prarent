package com.springcloud;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@EnableEurekaClient  //本服务启动后会自动注册进eureka服务中
@EnableFeignClients  //服务发现
@EnableCircuitBreaker //对hystrix熔断机制的支持
@Slf4j
public class DeptProvider8001_Hystrix_App {
    public static void main(String[] args) {
        ApplicationContext context = new SpringApplicationBuilder(DeptProvider8001_Hystrix_App.class).web(true).run(args);
        String property = context.getEnvironment().getProperty("server.port");
        log.info("http://localhost:" + property + "/showDeptAll/");
    }
}
