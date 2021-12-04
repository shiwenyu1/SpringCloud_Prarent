package com.springcloud;


import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.ApplicationContext;

/**
 * 当前“消费者”子项目的启动类
 */
@Slf4j
@SpringBootApplication
@EnableEurekaClient
public class DeptConsumer8080_App {
    public static void main(String[] args) {
        ApplicationContext run =  SpringApplication.run(DeptConsumer8080_App.class,args);
        String property = run.getEnvironment().getProperty("server.port");
        log.info("http://localhost:"+property+"/showDeptAllByConsumer");
//        摘要信息
        log.info("摘要信息：http://localhost:"+property+"/getServiceInfoConsumer");

    }
}
