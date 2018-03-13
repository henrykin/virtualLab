package com.virtual.lab.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.virtual.lab.common.utils.E3Result;
import com.virtual.lab.pojo.TbItemDesc;
import com.virtual.lab.service.ItemDescService;

/**
 * 实验文档Controller
 * @author xiaoqiang
 *
 */
@Controller
public class ItemDescController {
	
	//实验描述服务
	@Autowired
	private ItemDescService itemDescService;
	
	/**
	 * 根据实验id查询实验描述信息
	 * @param itemId
	 * @return
	 */
	@RequestMapping("/rest/item/query/item/desc/{itemId}")
	@ResponseBody
	public E3Result getItemDesc(@PathVariable long itemId){
		//直接调用实验描述service服务
		E3Result result = itemDescService.getItemDesc(itemId);
		return result;
	}
	
	/**
	 * 根据实验id查询实验描述信息
	 * @param itemId
	 * @param model
	 * @return
	 */
	@RequestMapping("/item/{itemId}")
	//@RequiresPermissions("item-id")//执行这个方法，需要当前用户具有item-id这个权限
	public String showItemInfo(@PathVariable long itemId, Model model){
		//根据实验id查询实验描述信息
		TbItemDesc itemDesc = itemDescService.getItemDescById(itemId);
		//把数据传递给页面
		model.addAttribute("itemDesc", itemDesc);
		return "item";
	}
}
