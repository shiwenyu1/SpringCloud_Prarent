package com.springcloud.service.impl;

import com.springcloud.dao.DeptDao;
import com.springcloud.entities.Dept;
import com.springcloud.service.DeptService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 业务逻辑层--实现类
 */

@Service
public class DeptServiceImpl implements DeptService{

    //需要数据访问层的接口对象
    @Resource
    private DeptDao deptDao;

    //增加

    //删除

    //修改

    //查询
    public List<Dept> findAll() {
        List<Dept> list = deptDao.selectAll();
        return list;
    }
}
