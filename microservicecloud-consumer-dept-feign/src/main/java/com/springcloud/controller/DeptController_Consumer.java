package com.springcloud.controller;

import com.springcloud.entities.Dept;
import com.springcloud.service.DeptClientService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class DeptController_Consumer {

    //接口
    @Resource
    private DeptClientService deptClientService;

    //增加

    //删除

    //修改


    //查询
    @RequestMapping("showDeptAllByConsumer")
    public List<Dept> showDeptAllByConsumer(){
        List<Dept> list = deptClientService.findAll();
        return list;
    }
}
