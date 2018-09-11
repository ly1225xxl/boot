package com.zero.boot.mapper;

import com.zero.boot.po.Dept;
import com.zero.boot.po.Emp;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface DeptMapper {
    @Select("select * from dept")
    @Results({
            @Result(property = "deptno",column = "deptno"),
            @Result(property = "dname",column = "dname"),
            @Result(property = "loc",column = "loc")
    })
    List<Dept> findAll();

    @Select("select * from dept where deptno=#{deptno}")
    @Results({
            @Result(property = "deptno",column = "deptno"),
            @Result(property = "dname",column = "dname"),
            @Result(property = "loc",column = "loc")
    })
    Dept findById(Integer deptno);

    @Insert("insert into dept values(#{deptno},#{dname},#{loc})")
    void saveDept(Dept dept);

    @Delete("delete from dept where deptno=#{deptno}")
    void deleteDept(Integer deptno);

    @Update("update dept set dname=#{dname},loc=#{loc} where deptno=#{deptno}")
    void mergeDept(Dept dept);
}
