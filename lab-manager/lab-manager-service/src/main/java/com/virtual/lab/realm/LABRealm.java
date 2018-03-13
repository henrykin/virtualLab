package com.virtual.lab.realm;

import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.virtual.lab.common.utils.E3Result;
import com.virtual.lab.mapper.AuthFunctionMapper;
import com.virtual.lab.mapper.TbUserMapper;
import com.virtual.lab.pojo.AuthFunction;
import com.virtual.lab.pojo.TbUser;
import com.virtual.lab.pojo.TbUserExample;
import com.virtual.lab.pojo.TbUserExample.Criteria;

public class LABRealm extends AuthorizingRealm{
	//角色表
	@Autowired
	private TbUserMapper userMapper;
	
	//权限表
	@Autowired
	private AuthFunctionMapper authFunctionMapper;
	
	/**
	 * 认证方法
	 */
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		//获取页面输入的用户名
		UsernamePasswordToken mytoken = (UsernamePasswordToken) token;
		String username = mytoken.getUsername();
		
		//根据用户名查询用户信息
		TbUserExample example = new TbUserExample();
		Criteria criteria = example.createCriteria();
		criteria.andUsernameEqualTo(username);
		//执行查询
		List<TbUser> list = userMapper.selectByExample(example);
		if(list == null || list.size() == 0){
			//页面输入的用户名不存在
			return null;
		}
		//取查询到的用户信息
		TbUser user = list.get(0);
		
		
		//简单认证信息对象
		AuthenticationInfo info = new SimpleAuthenticationInfo(user, user.getPassword(), this.getName());
		//框架负责比对数据库中的密码和页面输入的密码是否一致
		return info;
	}
	
	/**
	 * 授权方法
	 */
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		//获取当前登录用户对象
		TbUser user = (TbUser) SecurityUtils.getSubject().getPrincipal();
		//根据当前登录用户查询数据库，获取实际对应的权限
		List<AuthFunction> list = authFunctionMapper.findAuthFunctionByUserId(user.getUsername());
		
		//遍历该用户的权限数据
		for (AuthFunction authFunction : list) {
			info.addStringPermission(authFunction.getCode());
		}
		return info;
	}

}
