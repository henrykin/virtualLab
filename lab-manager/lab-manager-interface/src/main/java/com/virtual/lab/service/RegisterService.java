package com.virtual.lab.service;

import com.virtual.lab.common.utils.E3Result;
import com.virtual.lab.pojo.TbUser;

/**
 * 用户注册功能interface
 * @author xiaoqiang
 *
 */
public interface RegisterService {
	
	/**
	 * 注册用户数据校验
	 * @return
	 */
	E3Result checkData(String param, int type);
	
	/**
	 * 注册用户
	 */
	E3Result register(TbUser user);
}
