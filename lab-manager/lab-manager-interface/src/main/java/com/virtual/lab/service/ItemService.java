package com.virtual.lab.service;

import com.virtual.lab.common.pojo.EasyUIDataGridResult;
import com.virtual.lab.common.utils.E3Result;
import com.virtual.lab.pojo.TbItem;

/**
 * 实验interface
 * @author xiaoqiang
 *
 */
public interface ItemService {
	
	/**
	 * 添加实验
	 * @param item
	 * @param desc
	 * @return
	 */
	E3Result addItem(TbItem item, String desc);
	
	/**
	 * 编辑实验
	 * @param item
	 * @param desc
	 * @return
	 */
	E3Result editItem(TbItem item, String desc);
	
	/**
	 * 删除实验
	 * @param ids
	 * @return
	 */
	E3Result deleteItem(String ids);
	
	/**
	 * 查询所有的实验列表，要进行分页处理
	 * @param page
	 * @param rows
	 * @return
	 */
	EasyUIDataGridResult getItemList(int page, int rows);
	
}
