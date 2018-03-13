package com.virtual.lab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.virtual.lab.common.utils.E3Result;
import com.virtual.lab.service.ResportDescService;

/**
 * 实验报告描述Controller
 * @author xiaoqiang
 *
 */
@Controller
public class ResportDescController {
	
	@Autowired
	private ResportDescService resportDescService;
	
	/**
	 * 根据实验报告id查询实验描述信息
	 */
	@RequestMapping("rest/resport/query/resport/desc/{resportId}")
	@ResponseBody
	public E3Result getItemDesc(@PathVariable long resportId){
		//直接调用实验描述service服务
		E3Result result = resportDescService.getResportDesc(resportId);
		return result;
	}
}
