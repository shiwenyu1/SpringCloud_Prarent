package com.springcloud.controller;

import com.springcloud.entities.Dept;
import com.springcloud.service.DeptService;
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

    //增加

    //删除

    //修改

    //查询
    @RequestMapping(value = "showDeptAll")
    public List<Dept> showDeptAll(){
            List<Dept> list = deptService.findAll();
        return list;
    }

}
