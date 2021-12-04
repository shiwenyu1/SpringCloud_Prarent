package com.springcloud.dao;

import com.springcloud.entities.Dept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 数据访问层
 */

@Mapper
public interface DeptDao {

    //增加

    //删除

    //修改

    //查询
    List<Dept> selectAll();
}
