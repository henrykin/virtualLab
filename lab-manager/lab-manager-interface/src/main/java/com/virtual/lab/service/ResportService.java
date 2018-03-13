package com.virtual.lab.service;

import com.virtual.lab.common.pojo.EasyUIDataGridResult;
import com.virtual.lab.common.utils.E3Result;
import com.virtual.lab.pojo.TbItem;
import com.virtual.lab.pojo.TbResport;

/**
 * 实验报告Interface
 * @author xiaoqiang
 *
 */
public interface ResportService {
	
	/**
	 * 添加实验报告
	 */
	E3Result addResport(TbResport resport, String desc);
	
	/**
	 * 查询所有的实验报告列表，要进行分页处理
	 */
	EasyUIDataGridResult getResportList(int page, int rows);
	
	/**
	 * 老师评阅实验报告,更新实验报告
	 */
	E3Result editResport(TbResport resport, String desc);
	
	/**
	 * 学生查询自己的实验报告列表，要进行分页处理
	 */
	EasyUIDataGridResult getStudentResportList(int page, int rows, String username);
	
	/**
	 * 学生修改实验报告，只能修改学生提交的部分，无法修改老师的指导评阅
	 */
	E3Result studentEditResport(TbResport resport, String desc);
}
