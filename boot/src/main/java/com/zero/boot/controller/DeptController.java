package com.zero.boot.controller;

import com.zero.boot.po.Dept;
import com.zero.boot.po.Emp;
import com.zero.boot.service.DeptService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.List;

@Controller
public class DeptController {
    @Resource
    private DeptService deptService;

    @RequestMapping(value="viewdept")
    public String findAll(HttpServletRequest request){
        List<Dept> list=deptService.findAll();
        request.setAttribute("dept",list);
        return "viewdept";
    }

    @RequestMapping(value = "savedept",method = RequestMethod.POST,produces="text/plain;charset=UTF-8")
    public String adddept(Dept dept){
        deptService.saveDept(dept);
        return "redirect:viewdept";
    }

    @RequestMapping(value = "deletedept")
    public String deletedept(Integer deptno){
        deptService.deleteDept(deptno);
        return "redirect:viewdept";
    }

    @RequestMapping(value = "premergedept")
    public String premergedept(Integer deptno,HttpServletRequest request){
        Dept dept=deptService.findById(deptno);
        request.setAttribute("dept",dept);
        return "premergedept";
    }

    @RequestMapping(value = "mergedept",method = RequestMethod.POST,produces="text/plain;charset=UTF-8")
    public String mergedept(Dept dept){
        deptService.mergeDept(dept);
        return "redirect:viewdept";
    }
}
