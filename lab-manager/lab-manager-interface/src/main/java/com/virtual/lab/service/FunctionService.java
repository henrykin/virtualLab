package com.virtual.lab.service;

import java.util.List;

import com.virtual.lab.common.pojo.EasyUIDataGridResult;
import com.virtual.lab.pojo.AuthFunction;


public interface FunctionService {
	
	/**
	 * 查询所有权限
	 */
	public List<AuthFunction> findAllFunction();
	
	/**
	 * 添加权限
	 */
	public void saveFunction(AuthFunction authFunction);
	
	/**
	 * 查询所有权限列表，要进行分页处理
	 */
	public EasyUIDataGridResult getAuthFunctionList(int page, int rows);
	
	/**
	 * 根据当前登录人查询对应的菜单数据,并且返回json
	 */
	public List<AuthFunction> findMenuByUserId(long id);
	
	/**
	 * 修改权限
	 */
	public void editFunction(AuthFunction authFunction);
	
	/**
	 * 批量删除权限
	 */
	void deleteFunction(String ids);
}
