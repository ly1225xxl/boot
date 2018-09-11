package com.zero.boot.mapper;

import com.zero.boot.po.Emp;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface EmpMapper {
    @Select("select * from emp")
    @Results({
            @Result(property = "empno",  column = "empno"),
            @Result(property = "ename", column = "ename"),
            @Result(property = "job",  column = "job"),
            @Result(property = "mgr",  column = "mgr"),
            @Result(property = "hiredate",  column = "hiredate"),
            @Result(property = "sal",  column = "sal"),
            @Result(property = "comm",  column = "comm"),
            @Result(property = "deptno",  column = "deptno")
    })
    List<Emp> findAll();

    @Select("select * from emp where empno = #{empno}")
    @Results({
            @Result(property = "empno",  column = "empno"),
            @Result(property = "ename", column = "ename"),
            @Result(property = "job",  column = "job"),
            @Result(property = "mgr",  column = "mgr"),
            @Result(property = "hiredate",  column = "hiredate"),
            @Result(property = "sal",  column = "sal"),
            @Result(property = "comm",  column = "comm"),
            @Result(property = "deptno",  column = "deptno")
    })
    Emp findById(Integer empno);

    @Insert("insert into emp values (#{empno},#{ename},#{job},#{mgr},#{hiredate},#{sal},#{comm},#{deptno})")
    void saveEmp(Emp emp);

    @Delete("delete from emp where empno = #{empno}")
    void deleteEmp(Integer empno);

    @Update("update emp set ename = #{ename}, job = #{job}, mgr = #{mgr}, hiredate = #{hiredate}, sal = #{sal}, comm = #{comm}, deptno = #{deptno} where empno = #{empno}")
    void mergeEmp(Emp emp);

}
