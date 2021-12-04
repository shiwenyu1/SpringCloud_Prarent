package com.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.springcloud.entities.Dept;
import com.springcloud.service.DeptService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class DeptController {

    @Resource
    private DeptService service;

    @RequestMapping(value = "showDeptAll/{id}",method = RequestMethod.GET)
    //一旦调用服务方法失败并抛出了错误信息后，会自动调用@HystrixCommand标注好的fallbackMethod调用类中的指定方法
    @HystrixCommand(fallbackMethod = "processHystrix_Get")
    public Dept getDeptById(@PathVariable("id") Long id){

        Dept dept = this.service.get(id);
        if (null == dept) {
            throw new RuntimeException("ID:" + id + "没有相应的信息");
        }
        return dept;
    }

    /**
     * 当要查询的编号，在数据库中没有对象的信息时，调用该方法
     */
    public Dept processHystrix_Get(@PathVariable("id") Long id){
        return new Dept().setDeptno(id).setDname("该ID：" + id + "没有对应的信息,null--@HystrixCommand")
                .setDb_source("no this database in MySQL");
    }
}
