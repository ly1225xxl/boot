package com.zero.boot.po;

/**
 * @authon yuan
 * @date 2018/1/25 0025
 * @time 10:42
 **/

import java.io.Serializable;
import java.util.List;

public class ActiveUser implements Serializable {

	private String userid;
	private String username;
	private List<Permission> menus;
	private List<Permission> permissions;
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public List<Permission> getMenus() {
		return menus;
	}
	public void setMenus(List<Permission> menus) {
		this.menus = menus;
	}
	public List<Permission> getPermissions() {
		return permissions;
	}
	public void setPermissions(List<Permission> permissions) {
		this.permissions = permissions;
	}
	
	

}
