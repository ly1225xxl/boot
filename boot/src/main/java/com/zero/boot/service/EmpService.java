package com.zero.boot.service;

import com.zero.boot.mapper.EmpMapper;
import com.zero.boot.po.Emp;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class EmpService {

    @Resource
    private EmpMapper mapper;

    public void saveEmp(Emp emp){
        mapper.saveEmp(emp);
    }

    public void deleteEmp(Integer empno){
        mapper.deleteEmp(empno);
    }

    public void mergeEmp(Emp emp){
        mapper.mergeEmp(emp);
    }

    public List<Emp> findAll(){
        List<Emp> list = mapper.findAll();
        return list;
    }

    public Emp findById(Integer empno){
        Emp emp = mapper.findById(empno);
        return emp;
    }

}
