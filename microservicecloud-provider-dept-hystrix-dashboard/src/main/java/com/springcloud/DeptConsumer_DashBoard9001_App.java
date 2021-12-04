package com.springcloud;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@EnableHystrixDashboard
@Slf4j
public class DeptConsumer_DashBoard9001_App {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(DeptConsumer_DashBoard9001_App.class).web(true).run(args);
        String property = context.getEnvironment().getProperty("server.port");
        log.info("http://localhost:" + property + "/hystrix");
    }
}
