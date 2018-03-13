package com.virtual.lab.service;

import com.virtual.lab.common.pojo.EasyUIDataGridResult;
import com.virtual.lab.pojo.TbUser;

/**
 * 用户表操作
 * @author xiaoqiang
 *
 */
public interface UserService {
	
	/**
	 * 根据用户名查询用户信息
	 * @param username
	 * @return
	 */
	TbUser selectUserByUsername(String username);
	
	/**
	 * 更新用户信息
	 * @param user
	 * @return
	 */
	boolean update(TbUser user);
	
	/**
	 * 分页查询用户信息
	 */
	EasyUIDataGridResult getUserList(int page, int rows);
	
	/**
	 * 添加一个用户对应的角色信息
	 */
	void saveUserAndRole(TbUser user, String roleIds);
}
