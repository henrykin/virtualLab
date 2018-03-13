package com.virtual.lab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.virtual.lab.common.utils.E3Result;
import com.virtual.lab.pojo.TbUser;
import com.virtual.lab.service.RegisterService;

/**
 * 注册功能Controller
 * @author xiaoqiang
 *
 */
@Controller
public class RegisterController {
	
	@Autowired
	private RegisterService registerService;
	
	/**
	 * 访问注册页面
	 * @return
	 */
	@RequestMapping("/page/register")
	public String showRegister(){
		return "register";
	}
	
	/**
	 * 注册用户数据校验
	 * @param param
	 * @param type
	 * @return
	 */
	@RequestMapping("/user/register/check/{param}/{type}")
	@ResponseBody
	public E3Result checkData(@PathVariable String param, @PathVariable Integer type){
		E3Result result = registerService.checkData(param, type);
		return result;
	}
	
	/**
	 * 注册用户
	 */
	@RequestMapping(value="/user/register", method=RequestMethod.POST)
	@ResponseBody
	public E3Result register(TbUser user){
		E3Result result = registerService.register(user);
		return result;
	}
	
}
