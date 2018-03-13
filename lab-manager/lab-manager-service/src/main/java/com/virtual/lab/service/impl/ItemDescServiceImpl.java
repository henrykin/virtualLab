package com.virtual.lab.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtual.lab.common.utils.E3Result;
import com.virtual.lab.mapper.TbItemDescMapper;
import com.virtual.lab.pojo.TbItemDesc;
import com.virtual.lab.pojo.TbItemDescExample;
import com.virtual.lab.pojo.TbItemDescExample.Criteria;
import com.virtual.lab.service.ItemDescService;

/**
 * 实验描述Service
 * @author xiaoqiang
 *
 */
@Service
public class ItemDescServiceImpl implements ItemDescService{
	
	//实验描述表
	@Autowired
	private TbItemDescMapper itemDescMapper;
	
	/**
	 * 根据实验ID查询实验描述
	 */
	public E3Result getItemDesc(long itemId) {
		//方法一、直接查询dao层方法
		TbItemDesc itemDesc = itemDescMapper.selectByPrimaryKey(itemId);
		return E3Result.ok(itemDesc);
	}
	
	/**
	 * 根据实验ID查询实验描述
	 */
	public TbItemDesc getItemDescById(long itemId) {
		//方法一、直接查询dao层方法
		TbItemDesc itemDesc = itemDescMapper.selectByPrimaryKey(itemId);
		return itemDesc;
	}

}
