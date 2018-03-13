package com.virtual.lab.controller;

import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;

import com.virtual.lab.common.utils.E3Result;
import com.virtual.lab.common.utils.MD5Utils;
import com.virtual.lab.pojo.TbUser;
import com.virtual.lab.service.LoginService;

/**
 * 用户登录Controller
 * @author xiaoqiang
 *
 */
@Controller
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	/**
	 * 访问用户登录页面
	 */
	@RequestMapping("/page/login")
	public String showLogin(){
		return "login";
	}
	
	/**
	 * 用户登录
	 */
	@RequestMapping(value="/user/login", method=RequestMethod.POST)
	@ResponseBody
	public E3Result login(String username, String password, HttpSession session){
		//使用shiro框架提供的方式进行验证
		Subject subject = SecurityUtils.getSubject();//获得当前登录用户对象，现在状态为“未认证”
		//创建用户名密码令牌
		AuthenticationToken token = new UsernamePasswordToken(username,MD5Utils.md5(password));
		E3Result result = null;
		try{
			//shiro框架提供的登录方法
			subject.login(token);
		}catch(Exception e){
			//登录失败
			result = E3Result.build(400, "用户名或者密码错误");
			return result;
		}
		
		TbUser user = (TbUser) subject.getPrincipal();
		//登录成功，封装到E3Result中
		result = E3Result.ok(user);
		
		//登录成功，将用户信息存入sssion中
		session.setAttribute("loginUser", user);
		//web聊天室
		session.setAttribute("userid", user.getUsername());
		session.setAttribute("login_status", true);
		
		return result;
	}
	
	/**
	 * 用户登录
	 */
	/*@RequestMapping(value="/user/login", method=RequestMethod.POST)
	@ResponseBody
	public E3Result login_bak(String username, String password, HttpSession session){
		E3Result result = loginService.login(username, password);
		if(result.getStatus() == 200){
			TbUser user = (TbUser) result.getData();
			//登录成功，将用户信息存入sssion中
			session.setAttribute("loginUser", user);
			//web聊天室
			session.setAttribute("userid", user.getUsername());
			session.setAttribute("login_status", true);
		}
		return result;
	}*/
	
	/**
	 * 用户注销
	 */
	@RequestMapping("/logout/index")
	public String logout(HttpSession session){
		session.invalidate();
		return "redirect:/page/login";
	}
	
	/**
	 * 以访客的身份登录
	 */
	@RequestMapping("visitor/login")
	@ResponseBody
	public E3Result loginAsVisitor(HttpSession session) {
		session.setAttribute("visitor", true);
		return E3Result.ok("visitor login success");
	}
	
}
