package com.virtual.lab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.virtual.lab.common.pojo.EasyUIDataGridResult;
import com.virtual.lab.common.utils.E3Result;
import com.virtual.lab.pojo.TbItem;
import com.virtual.lab.service.ItemService;

/**
 * 实验Controller
 * @author xiaoqiang
 *
 */
@Controller
public class ItemController {
	
	//实验服务
	@Autowired
	private ItemService itemService;
	
	/**
	 * 新增实验
	 * @param item
	 * @param desc
	 * @return
	 */
	@RequestMapping("/item/save")
	@ResponseBody
	public E3Result saveItem(TbItem item, String desc){
		//直接调用service层的服务
		E3Result result = itemService.addItem(item, desc);
		return result;
	}
	
	/**
	 * 编辑实验
	 * @param item
	 * @param desc
	 * @return
	 */
	@RequestMapping("/rest/item/update")
	@ResponseBody
	public E3Result editItem(TbItem item, String desc){
		//直接调用service层方法
		E3Result result = itemService.editItem(item, desc);
		return result;
	}
	
	/**
	 * 批量删除实验
	 * @param ids
	 * @return
	 */
	@RequestMapping("/rest/item/delete")
	@ResponseBody
	public E3Result deleteItem(String ids){
		E3Result result = itemService.deleteItem(ids);
		return result;
	}
	
	/**
	 * 展示实验列表
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping("/item/list")
	@ResponseBody
	public EasyUIDataGridResult getItemList(int page, int rows){
		//直接调用service层方法
		EasyUIDataGridResult itemList = itemService.getItemList(page, rows);
		return itemList;
	}
	
}
