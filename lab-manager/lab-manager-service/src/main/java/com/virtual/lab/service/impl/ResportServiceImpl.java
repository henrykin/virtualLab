package com.virtual.lab.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.virtual.lab.common.pojo.EasyUIDataGridResult;
import com.virtual.lab.common.utils.E3Result;
import com.virtual.lab.common.utils.IDUtils;
import com.virtual.lab.mapper.TbResportDescMapper;
import com.virtual.lab.mapper.TbResportMapper;
import com.virtual.lab.pojo.TbItem;
import com.virtual.lab.pojo.TbItemDesc;
import com.virtual.lab.pojo.TbItemExample;
import com.virtual.lab.pojo.TbResport;
import com.virtual.lab.pojo.TbResportDesc;
import com.virtual.lab.pojo.TbResportExample;
import com.virtual.lab.pojo.TbResportExample.Criteria;
import com.virtual.lab.service.ResportService;

/**
 * 实验报告Service
 * @author xiaoqiang
 *
 */
@Service
public class ResportServiceImpl implements ResportService{
	
	//实验报告表
	@Autowired
	private TbResportMapper resportMapper;
	
	//实验报告描述表
	@Autowired
	private TbResportDescMapper resportDescMapper;
	
	/**
	 * 添加实验报告
	 */
	public E3Result addResport(TbResport resport, String desc) {
		//1. 生成实验报告id
		long resportId = IDUtils.genItemId();
		//2. 补全TbResport对象的属性
		resport.setId(resportId);
		//实验状态，1-正常，2-下架，3-删除
		resport.setStatus((byte)1);
		Date date = new Date();
		resport.setCreated(date);
		resport.setUpdated(date);
		//3. 向实验报告表中插入数据
		resportMapper.insert(resport);
		
		//4 创建一个TbResportDesc对象
		TbResportDesc resportDesc = new TbResportDesc();
		//5. 补全TbResportDesc对象的属性
		resportDesc.setResportId(resportId);
		resportDesc.setResportDesc(desc);
		resportDesc.setCreated(date);
		resportDesc.setUpdated(date);
		
		//6. 向实验报告描述表中插入数据
		resportDescMapper.insert(resportDesc);
		
		//7. 返回ok
		return E3Result.ok();
	}

	/**
	 * 老师查询所有的实验报告列表，要进行分页处理
	 */
	public EasyUIDataGridResult getResportList(int page, int rows) {
		//设置分页信息
		PageHelper.startPage(page, rows);
		//执行查询
		TbResportExample example = new TbResportExample();
		List<TbResport> list = resportMapper.selectByExample(example);
		
		//取分页信息
		PageInfo<TbResport> pageInfo = new PageInfo<>(list);
				
		//创建返回结果对象
		EasyUIDataGridResult result = new EasyUIDataGridResult();
		result.setTotal(pageInfo.getTotal());//总记录数
		result.setRows(list);///当前页的商品页表
				
		return result;
	}

	/**
	 * 老师评阅实验报告,只更新“指导评阅”
	 */
	public E3Result editResport(TbResport resport, String desc) {
		//1. 补全TbResport对象中的属性
		//实验状态，1-正常，2-下架，3-删除
		resport.setStatus((byte)1);
		//获取创建时间
		TbResport tbResport = resportMapper.selectByPrimaryKey(resport.getId());
		Date created = tbResport.getCreated();
		resport.setCreated(created);
		
		//创建更新时间
		Date date = new Date();
		resport.setUpdated(date);
		//2. 向实验报告表中更新数据
		resportMapper.updateByPrimaryKey(resport);
		
		//3. 根据实验报告id查询TbResportmDesc对象
		TbResportDesc tbResportDesc = resportDescMapper.selectByPrimaryKey(resport.getId());
		//4. 修改TbResportmDesc对象的属性
		tbResportDesc.setUpdated(date);
		tbResportDesc.setResportDesc(desc);
		//5. 向实验报告描述表中更新数据
		resportDescMapper.updateByPrimaryKeySelective(tbResportDesc);
		
		//6. 返回ok
		return E3Result.ok();
	}

	/**
	 * 学生查询自己的实验报告列表，要进行分页处理
	 */
	public EasyUIDataGridResult getStudentResportList(int page, int rows, String username) {
		//设置分页信息
		PageHelper.startPage(page, rows);
		//执行查询
		TbResportExample example = new TbResportExample();
		Criteria criteria = example.createCriteria();
		criteria.andNameEqualTo(username);
		List<TbResport> list = resportMapper.selectByExample(example);
				
		//取分页信息
		PageInfo<TbResport> pageInfo = new PageInfo<>(list);
						
		//创建返回结果对象
		EasyUIDataGridResult result = new EasyUIDataGridResult();
		result.setTotal(pageInfo.getTotal());//总记录数
		result.setRows(list);///当前页的商品页表
						
		return result;
	}
	
	/**
	 * 学生修改实验报告，只能修改学生提交的部分，无法修改老师的指导评阅
	 */
	public E3Result studentEditResport(TbResport resport, String desc) {
		//1. 补全TbResport对象中的属性
		//实验状态，1-正常，2-下架，3-删除
		resport.setStatus((byte)1);
		//获取创建时间
		TbResport tbResport = resportMapper.selectByPrimaryKey(resport.getId());
		Date created = tbResport.getCreated();
		resport.setCreated(created);
		//获取指导评阅部分
		String review = tbResport.getReview();
		resport.setReview(review);
		
		//创建更新时间
		Date date = new Date();
		resport.setUpdated(date);
		//2. 向实验报告表中更新数据
		resportMapper.updateByPrimaryKey(resport);
		
		//3. 根据实验报告id查询TbResportmDesc对象
		TbResportDesc tbResportDesc = resportDescMapper.selectByPrimaryKey(resport.getId());
		//4. 修改TbResportmDesc对象的属性
		tbResportDesc.setUpdated(date);
		tbResportDesc.setResportDesc(desc);
		//5. 向实验报告描述表中更新数据
		resportDescMapper.updateByPrimaryKeySelective(tbResportDesc);
		
		//6. 返回ok
		return E3Result.ok();
	}
	
}
