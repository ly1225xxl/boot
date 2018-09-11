package com.zero.boot.service;

import com.zero.boot.mapper.PermissionMapperCustom;
import com.zero.boot.mapper.RoleMapper;
import com.zero.boot.mapper.UserMapper;
import com.zero.boot.mapper.User_RoleMapper;
import com.zero.boot.po.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @authon yuan
 * @date 2018/1/25 0025
 * @time 10:42
 **/

@Service
public class UserService {


	@Resource
	private UserMapper userMapper;
	@Resource
	private RoleMapper roleMapper;
	@Resource
	private User_RoleMapper userRoleMapper;
	@Resource
	private PermissionMapperCustom permissionMapperCustom;


	//用户注册
	public void saveRegister(User user)throws Exception{
		userMapper.insertSelective(user);
	}
	//通过用户名查询用户
	public User selectByUsername(String username)throws Exception {
		UserExample userExample=new UserExample();
		/*userExample.createCriteria().andUsernameEqualTo(username);*/
		UserExample.Criteria criteria=userExample.createCriteria();
		criteria.andUsernameEqualTo(username);
		List<User> list=userMapper.selectByExample(userExample);
		if (list.size()!=0) {
			return list.get(0);
		}
		return null;
	}
	//通过用户ID查询用户的权限
	public List<Permission> selectPermissionsById (String userid)throws Exception{

		return permissionMapperCustom.findPermissionListByUserId(userid);

	}

	//查询所有用户
	public List<User> selectAllUser()throws Exception{

		return userMapper.selectAllUser();

	}
	//查询所有角色
	public List<Role> selectAllRole()throws Exception{

		return roleMapper.selectAllRole();
	}
	//根据角色名查询角色
	public Role selectByRolename(String rolename)throws Exception{
		RoleExample roleExample=new RoleExample();
		RoleExample.Criteria criteria=roleExample.createCriteria();
		criteria.andNameEqualTo(rolename);
		List<Role> list= roleMapper.selectByExample(roleExample);
		if (list.size()!=0) {
			return list.get(0);
		}
		return null;
	}
	//给用户角色
	public void saveUserRole(String username,String rolename)throws Exception{
		Role role=this.selectByRolename(rolename);
		String roleid=role.getId();

		User user=this.selectByUsername(username);
		String userid=user.getId();

		User_Role user_role=new User_Role();

		SimpleDateFormat sf=new SimpleDateFormat("yyyyMMddHHmmss");
		String id=sf.format(new Date());

		user_role.setId(id);
		user_role.setSysUserId(userid);
		user_role.setSysRoleId(roleid);
		
	/*	User_RoleExample example=new User_RoleExample();
		User_RoleExample.Criteria criteria=example.createCriteria();
		criteria.andIdEqualTo(id);
		criteria.andSysUserIdEqualTo(userid);
		criteria.andSysRoleIdEqualTo(roleid);*/
		userRoleMapper.insertSelective(user_role);
		//System.out.println(a);

	}
	
}
