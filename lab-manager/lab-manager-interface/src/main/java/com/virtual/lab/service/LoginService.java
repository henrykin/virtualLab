package com.virtual.lab.service;

import com.virtual.lab.common.utils.E3Result;

/**
 * 用户登录interface
 * @author xiaoqiang
 *
 */
public interface LoginService {
	
	/**
	 * 用户登录
	 * @param username
	 * @param password
	 * @return
	 */
	E3Result login(String username, String password);
}
