package com.zero.boot.controller;

import com.zero.boot.po.Role;
import com.zero.boot.po.User;
import com.zero.boot.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @authon yuan
 * @date 2018/1/25 0025
 * @time 10:42
 **/

@Controller
public class UserController {
	@Resource
	private UserService userService;

	//查询所有用户以及角色
	@RequestMapping("selectuser.do")
	public String selectAllUser (HttpServletRequest request) throws Exception {
		List<User> list=userService.selectAllUser();
		List<Role> list2=userService.selectAllRole();
		request.setAttribute("list",list);
		request.setAttribute("list2", list2);
		return "role";

	}

	//给用户角色
	@RequestMapping("saveuserrole.do")
	public String saveUserRole (String username,String rolename) throws Exception {

		userService.saveUserRole(username,rolename);

		return "redirect:selectuser.do";
	}


}
