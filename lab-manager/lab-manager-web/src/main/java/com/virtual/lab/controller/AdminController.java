package com.virtual.lab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 权限管理
 * @author xiaoqiang
 *
 */
@Controller
public class AdminController {
	
	@RequestMapping("/admin/{page}")
	public String showAdmin(@PathVariable String page){
		
		return page;
	}
	
}
