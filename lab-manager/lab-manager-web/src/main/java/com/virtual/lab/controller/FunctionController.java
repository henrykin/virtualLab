package com.virtual.lab.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import com.virtual.lab.common.pojo.EasyUIDataGridResult;
import com.virtual.lab.pojo.AuthFunction;
import com.virtual.lab.pojo.TbUser;
import com.virtual.lab.service.FunctionService;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;


/**
 * 权限控制
 * @author xiaoqiang
 *
 */
@Controller
public class FunctionController {
	
	@Autowired
	private FunctionService functionService;
	
	/**
	 * 查询所有权限，返回json数据
	 * @return
	 */
	@RequestMapping("/functionController_listajax")
	public void listajax(HttpServletResponse response){
		//查询所有权限
		List<AuthFunction> list = functionService.findAllFunction();
		
		//将指定Java对象转为json，并响应到客户端页面
		JsonConfig jsonConfig = new JsonConfig();
		//指定哪些属性不需要转json
		String json = JSONArray.fromObject(list,jsonConfig).toString();
		response.setContentType("text/json;charset=utf-8");
		try {
			response.getWriter().print(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	/**
	 * 添加权限
	 */
	@RequestMapping("/functionController_add")
	public String addFunction(AuthFunction authFunction){
		functionService.saveFunction(authFunction);
		return "/function";
	}
	
	/**
	 * 权限分页查询
	 */
	@RequestMapping("/functionController_pageQuery")
	@ResponseBody
	public EasyUIDataGridResult pageQuery(int page, int rows){
		EasyUIDataGridResult result = functionService.getAuthFunctionList(page, rows);
		return result;
	}
	
	/**
	 * 根据当前登录人查询对应的菜单数据,并且返回json
	 */
	@RequestMapping("/functionController_findMenu")
	public void findMenuByUserId(HttpServletResponse response, HttpSession session){
		TbUser user = (TbUser) session.getAttribute("loginUser");
		Long id = user.getId();
		List<AuthFunction> list = functionService.findMenuByUserId(id);
		
		//将指定Java对象转为json，并响应到客户端页面
		JsonConfig jsonConfig = new JsonConfig();
		//指定哪些属性不需要转json
		String json = JSONArray.fromObject(list,jsonConfig).toString();
		response.setContentType("text/json;charset=utf-8");
		try {
			response.getWriter().print(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 修改权限
	 */
	@RequestMapping("/userController_edit")
	public String editFunction(AuthFunction authFunction){
		functionService.editFunction(authFunction);
		return "/function";
	}
	
	/**
	 * 批量删除权限
	 */
	@RequestMapping("/functionController_delete")
	public String deleteFunction(String ids){
		functionService.deleteFunction(ids);
		return "/function";
	}
}
