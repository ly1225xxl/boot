package com.zero.boot.controller;

import com.zero.boot.po.User;
import com.zero.boot.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @authon yuan
 * @date 2018/1/25 0025
 * @time 10:42
 **/

@Controller
public class LoginController {
	@Resource
	private UserService userService;

	//登录
	@RequestMapping("login.do")
	public String login(@Param("user") User user, String rememberMe)throws Exception{
		//System.out.println(user.getUsername());
		//System.out.println(user.getPassword());
		Subject currentUser = SecurityUtils.getSubject();
		if (!currentUser.isAuthenticated()) {
			UsernamePasswordToken token=new UsernamePasswordToken(user.getUsername(), user.getPassword());
			if (rememberMe==null) {
				System.out.println("meiyou");
				token.setRememberMe(false);
			}else if(rememberMe.equals("on")){
				token.setRememberMe(true);
				System.out.println("有");
			}

			try {
				currentUser.login(token);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		//return null;
		return "redirect:findalldept.do";
		//return "redirect:index.jsp";
	}
	//登录时检测用户名和密码是否正确
	@RequestMapping("checkuser.do")
	public @ResponseBody
    Map<String,Object> checkUser(String username, String password) throws Exception{
		System.out.println(username);
		Map<String, Object> map=new HashMap<String, Object>();
		//根据用户名查询数据库
		User u=userService.selectByUsername(username);
		//查不到返回0
		if(u==null) {
			map.put("back",0);
		}else {
			//加密输入的密码
			String pass=this.getPassword(username,password);
			//全部正确返回1
			if (pass.equals(u.getPassword())) {
				map.put("back",1);
			}else {
				//密码错误返回-1
				map.put("back",-1);
			}
		}
		return map;
	}
	//注册时检测用户名是否已存在
	@RequestMapping("checkregister.do")
	public @ResponseBody
    Map<String,Object> registerCheck(String username) throws Exception{
		//System.out.println(username);
		Map<String, Object> map=new HashMap<String, Object>();
		//根据用户名查询数据库
		User u=userService.selectByUsername(username);
		//用户已存在返回1
		if (u!=null) {
			map.put("b", 1);
		}
		return map;
	}
	//用户注册
	@RequestMapping("register.do")
	public String register(@Param("user") User user,String password)throws Exception{
		SimpleDateFormat sf=new SimpleDateFormat("yyyyMMddHHmmss");
		String id=sf.format(new Date());
		user.setId(id);
		//对输入的密码进行加密
		String pass=this.getPassword(user.getUsername(), password);
		user.setPassword(pass);
		user.setLocked("0");
		//调用service注册
		userService.saveRegister(user);
		//跳转到登录
		return "login";
	}

	//对密码进行加密
	public String getPassword (String username,String password) {
		String hashAlgorithmName = "MD5";//加密方法
		Object credentials = password;
		Object salt = ByteSource.Util.bytes(username);//将用户名作为盐
		int hashIterations = 1;//加密次数
		Object result = new SimpleHash(hashAlgorithmName, credentials, salt, hashIterations);
		String pass=result.toString();
		return pass;
	}

}
