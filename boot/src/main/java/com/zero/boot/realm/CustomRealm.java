package com.zero.boot.realm;

import com.zero.boot.po.ActiveUser;
import com.zero.boot.po.Permission;
import com.zero.boot.po.User;
import com.zero.boot.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


public class CustomRealm extends AuthorizingRealm {
	//注入service
	@Resource
	private UserService userservice;

	//此方法用于认证，即登录
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// token是用户输入的用户名和密码
		// 第一步从token中取出用户名
		String username = token.getPrincipal().toString();
		//System.out.println(username);
		// 第二步：根据用户输入的username从数据库查询
		User user=new User();
		try {
			user = userservice.selectByUsername(username);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		// 如果查询不到返回null
		if(user==null){//
			return null;
		}
		// 从数据库查询到密码
		String password = user.getPassword();
		//用户身份信息
		ActiveUser activeUser=new ActiveUser();
		activeUser.setUserid(user.getId());
		activeUser.setUsername(user.getUsername());
		//根据用户Id获取权限
		List<Permission> permissions=null;
		try {
			permissions=userservice.selectPermissionsById(user.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		//将用户权限给activeuser
		if (permissions.size()!=0) {
			activeUser.setPermissions(permissions);
		}
		//将activeUser设置simpleAuthenticationInfo
		SimpleAuthenticationInfo simpleAuthenticationInfo =
				new SimpleAuthenticationInfo(activeUser, password, ByteSource.Util.bytes(user.getUsername()), this.getName());
		return simpleAuthenticationInfo;
	}

	//此方法用于授权，即从数据库中获取该登录用户有什么权限
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		//从 principals获取主身份信息
		//将getPrimaryPrincipal方法返回值转为真实身份类型（在上边的doGetAuthenticationInfo认证通过填充到SimpleAuthenticationInfo中身份类型），
		ActiveUser activeUser =  (ActiveUser) principals.getPrimaryPrincipal();
//		ActiveUser用户的身份信息
		//根据身份信息获取权限信息
		//从数据库获取到权限数据
		List<Permission> permissionList = null;
		try {
			permissionList = userservice.selectPermissionsById(activeUser.getUserid());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//单独定一个集合对象
		List<String> permissions = new ArrayList<String>();
		if(permissionList!=null){
			for(Permission permission:permissionList){
				//将数据库中的权限标签 符放入集合
				permissions.add(permission.getPercode());
			}
		}
		//查到权限数据，返回授权信息(要包括 上边的permissions)
		SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
		//将上边查询到授权信息填充到simpleAuthorizationInfo对象中
		simpleAuthorizationInfo.addStringPermissions(permissions);

		return simpleAuthorizationInfo;
	}
}

