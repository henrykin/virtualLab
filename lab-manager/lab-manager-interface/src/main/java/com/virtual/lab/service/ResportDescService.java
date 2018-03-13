package com.virtual.lab.service;

import com.virtual.lab.common.utils.E3Result;

/**
 * 实验报告描述
 * @author xiaoqiang
 *
 */
public interface ResportDescService {
	/**
	 * 根据实验报告ID查询实验描述
	 */
	E3Result getResportDesc(long resportId);
}
