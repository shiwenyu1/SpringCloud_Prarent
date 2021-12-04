package com.springcloud;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@Slf4j
@EnableZuulProxy
public class Zuul9527_App {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(Zuul9527_App.class).web(true).run(args);
        String property = context.getEnvironment().getProperty("server.port");
        log.info("http://localhost:"+ property + "/");
    }
}
