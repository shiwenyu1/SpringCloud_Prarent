package com.springcloud.controller;

import com.springcloud.entities.Dept;
import com.springcloud.service.DeptService;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import javax.annotation.Resource;
import java.util.List;

/**
 * 控制器层
 */

@RestController
public class DeptController {

//拿到业务逻辑层的接口对象
    @Resource
    private DeptService deptService;


//  DiscoveryClient接口包含
    @Resource
    private DiscoveryClient client;
    //增加

    //删除

    //修改

    //查询
    @RequestMapping(value = "showDeptAll")
    public List<Dept> showDeptAll(){
            List<Dept> list = deptService.findAll();
        return list;
    }

    /*
    拿到当前微服务的摘要信息
     */

    @RequestMapping("getServiceInfo")
    public Object getServiceInfo(){

        //需要通过一个对象来调用具体方法
        List<String> list = client.getServices();
        System.out.println("list:"+list);
        List<ServiceInstance> appList = client.getInstances("biemingApp");
        for (ServiceInstance si : appList){
            System.out.println("si.getHost():"+si.getHost());
            System.out.println("si.getPort():"+si.getPort());
            System.out.println("si.getServiceId():"+si.getServiceId());
            System.out.println("si.getUri():"+si.getUri());
            System.out.println("si.getMetadata():"+si.getMetadata());
        }
        return this.client;
    }
}
