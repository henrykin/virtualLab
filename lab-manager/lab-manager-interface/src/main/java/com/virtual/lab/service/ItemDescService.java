package com.virtual.lab.service;

import com.virtual.lab.common.utils.E3Result;
import com.virtual.lab.pojo.TbItemDesc;

/**
 * 实验描述interface
 * @author xiaoqiang
 *
 */
public interface ItemDescService {
	
	/**
	 * 根据实验ID查询实验描述
	 * @param itemId
	 * @return
	 */
	E3Result getItemDesc(long itemId);
	
	/**
	 * 根据实验ID查询实验描述
	 * @param itemId
	 * @return
	 */
	TbItemDesc getItemDescById(long itemId);
}
