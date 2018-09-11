package com.zero.boot.mapper;

import com.zero.boot.po.Permission;

import java.util.List;

/**
 * @authon yuan
 * @date 2018/1/25 0025
 * @time 10:42
 **/

public interface PermissionMapperCustom {

	//根据用户id查询菜单
	public List<Permission> findMenuListByUserId(String userid)throws Exception;
	//根据用户id查询url
	public List<Permission> findPermissionListByUserId(String userid)throws Exception;

}
