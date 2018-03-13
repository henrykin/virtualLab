package com.virtual.lab.service;

import java.util.List;

import com.virtual.lab.common.pojo.EasyUIDataGridResult;
import com.virtual.lab.pojo.AuthRole;

/**
 * 权限管理：角色
 * @author xiaoqiang
 *
 */
public interface RoleService {
	
	/**
	 * 添加角色
	 */
	public void save(AuthRole authRole, String functionIds);
	
	/**
	 * 分页查询角色
	 */
	EasyUIDataGridResult getAuthRoleList(int page, int rows);
	
	/**
	 * ajax查询所有的角色数据，并且返回json数据
	 */
	List<AuthRole> findAllRole();
	
	int delete(String id);

	 int edit(AuthRole role, String functionIds);
}
