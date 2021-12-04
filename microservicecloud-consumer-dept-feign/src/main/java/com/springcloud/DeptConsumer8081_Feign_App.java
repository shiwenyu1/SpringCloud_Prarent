package com.springcloud;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

@Slf4j
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = {"com.springcloud.service"})
public class DeptConsumer8081_Feign_App {
    public static void main(String[] args) {
        ApplicationContext context = new SpringApplicationBuilder(DeptConsumer8081_Feign_App.class).web(true).run(args);
        String property = context.getEnvironment().getProperty("server.port");
        log.info("http://localhost:"+property+"/showDeptAllByConsumer");
    }
}
