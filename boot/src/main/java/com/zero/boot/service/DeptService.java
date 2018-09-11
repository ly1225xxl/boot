package com.zero.boot.service;

import com.zero.boot.mapper.DeptMapper;
import com.zero.boot.po.Dept;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DeptService {
    @Resource
    private DeptMapper deptMapper;
    public List<Dept> findAll(){
        return deptMapper.findAll();
    }
    public void saveDept(Dept dept){
        deptMapper.saveDept(dept);
    }
    public void deleteDept(Integer deptno){
        deptMapper.deleteDept(deptno);
    }
    public void mergeDept(Dept dept){
        deptMapper.mergeDept(dept);
    }
    public Dept findById(Integer deptno){
        return deptMapper.findById(deptno);
    }
}
