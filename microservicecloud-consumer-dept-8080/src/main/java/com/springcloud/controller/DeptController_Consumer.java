package com.springcloud.controller;

import com.springcloud.entities.Dept;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;
/**
 * 消费者子项目的控制器类
 */
@RestController
public class DeptController_Consumer {

    //定义变量，用于存放通用的部分网址(使用负载均衡之前)
//    private static final String REST_URL_PREFIX = "http://127.0.0.1:8001";

    //定义变量存放通用的部分地址
    private static final String REST_URL_PREFIX = "http://BIEMINGAPP";

    //需要一个提供增删改查方法的对象
    @Resource
    private RestTemplate restTemplate;

    //增加

    //删除

    //修改

    //查询
    @RequestMapping(value = "showDeptAllByConsumer")
    public List<Dept> showDeptAllByConsumer(){
        //需要用一个对象，调用查询方法
        List<Dept> list = restTemplate.getForObject(REST_URL_PREFIX+"/showDeptAll", List.class);
        return list;
    }
    /*
     * 获取“提供者子项目”中微服务的摘要信息
     */
    @RequestMapping("getServiceInfoConsumer")
    public Object getServiceInfoConsumer() {

        //需要通过一个对象来调用具体方法
        Object obj = restTemplate.getForObject(REST_URL_PREFIX+"/getServiceInfo",Object.class);
        return obj;
    }
}
