package com.virtual.lab.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import com.virtual.lab.common.utils.E3Result;
import com.virtual.lab.mapper.TbUserMapper;
import com.virtual.lab.pojo.TbUser;
import com.virtual.lab.pojo.TbUserExample;
import com.virtual.lab.pojo.TbUserExample.Criteria;
import com.virtual.lab.service.LoginService;

/**
 * 用户登录Service
 * @author xiaoqiang
 *
 */
@Service
public class LoginServiceImpl implements LoginService{
	
	@Autowired
	private TbUserMapper userMapper;
	
	/**
	 * 用户登录
	 */
	public E3Result login(String username, String password) {
		//1. 判断用户名和密码是否正确
		//根据用户名查询用户信息
		TbUserExample example = new TbUserExample();
		Criteria criteria = example.createCriteria();
		criteria.andUsernameEqualTo(username);
		//执行查询
		List<TbUser> list = userMapper.selectByExample(example);
		if(list == null || list.size() == 0){
			//返回登录失败
			return E3Result.build(400, "用户名或者密码错误");
		}
		//取用户信息
		TbUser user = list.get(0);
		//判断密码是否正确
		if(!user.getPassword().equals(DigestUtils.md5DigestAsHex(password.getBytes()))){
			//密码不相等
			return E3Result.build(400, "用户名或者密码错误");
		}
		//到这一步，说明用户名和密码都正确。将登录信息写入session里面去
		return E3Result.ok(user);
	}

}
