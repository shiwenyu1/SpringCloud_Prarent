package com.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Dept {
    private Long deptno;    //部门编号

    private String dname;   //部门名称

    private String db_source;   //来自哪个数据库

    public static void main(String[] args) {
        Dept dept = new Dept();
        dept.setDeptno(1L);
        dept.setDname("测试数据");
        dept.setDb_source("测试数据库");
        System.out.println(dept);
    }
}
