package com.virtual.lab.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtual.lab.common.utils.E3Result;
import com.virtual.lab.mapper.TbResportDescMapper;
import com.virtual.lab.pojo.TbResportDesc;
import com.virtual.lab.service.ResportDescService;
import com.virtual.lab.service.ResportService;

/**
 * 实验报告描述Service
 * @author xiaoqiang
 *
 */

@Service
public class ResportDescServiceImpl implements ResportDescService{
	
	//实验报告描述表
	@Autowired
	private TbResportDescMapper resportDescMapper;
	
	/**
	 * 根据实验报告ID查询实验描述
	 */
	public E3Result getResportDesc(long resportId) {
		TbResportDesc result = resportDescMapper.selectByPrimaryKey(resportId);
		return E3Result.ok(result);
	}
	
}
