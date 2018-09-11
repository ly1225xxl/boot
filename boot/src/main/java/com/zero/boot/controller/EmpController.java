package com.zero.boot.controller;

import com.zero.boot.po.Emp;
import com.zero.boot.service.EmpService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class EmpController {

    @Resource
    private EmpService service;


    @RequestMapping(value="viewemp")
    public String viewEmp(HttpServletRequest request){
        List<Emp> list = service.findAll();
        request.setAttribute("emplist",list);
        return "viewemp";
    }

    @RequestMapping(value="premergeemp")
    public String findById(Integer empno,HttpServletRequest request){
        Emp emp = service.findById(empno);
        request.setAttribute("emp",emp);
        return "premergeemp";
    }

    @RequestMapping(value="mergeemp")
    public String mergeEmp(Emp emp){
        service.mergeEmp(emp);
        return "redirect:viewemp";
    }

    @RequestMapping(value="deleteemp")
    public String deleteEmp(Integer empno){
        service.deleteEmp(empno);
        return "redirect:viewemp";
    }

    @RequestMapping(value="saveemp")
    public String saveEmp(Emp emp){
        service.saveEmp(emp);
        return "redirect:viewemp";
    }
}
