package com.springcloud;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.ApplicationContext;

@Slf4j
@SpringBootApplication
@EnableEurekaServer     //开启Eureka功能，让微服务项目能否加进来
public class EurekaServer7002_App {

    public static void main(String[] args) {
        ApplicationContext run =  new SpringApplicationBuilder(EurekaServer7002_App.class).web(true).run(args);

        String property = run.getEnvironment().getProperty("server.port");
        log.info("http://localhost:"+property);

    }
}
