package com.virtual.lab.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.virtual.lab.common.pojo.EasyUIDataGridResult;
import com.virtual.lab.common.utils.E3Result;
import com.virtual.lab.common.utils.IDUtils;
import com.virtual.lab.mapper.TbItemCatMapper;
import com.virtual.lab.mapper.TbItemDescMapper;
import com.virtual.lab.mapper.TbItemMapper;
import com.virtual.lab.pojo.TbItem;
import com.virtual.lab.pojo.TbItemCat;
import com.virtual.lab.pojo.TbItemDesc;
import com.virtual.lab.pojo.TbItemExample;
import com.virtual.lab.service.ItemService;

/**
 * 实验Service
 * @author xiaoqiang
 *
 */
@Service
public class ItemServiceImpl implements ItemService{
	
	//实验表
	@Autowired
	private TbItemMapper itemMapper;
	
	//实验描述表
	@Autowired
	private TbItemDescMapper itemDescMapper;
	
	//实验类目表
	@Autowired
	private TbItemCatMapper itemCatMapper;
	
	/**
	 * 添加实验
	 */
	public E3Result addItem(TbItem item, String desc) {
		//1. 生成实验id
		long itemId = IDUtils.genItemId();
		//2. 补全TbItem对象的属性
		item.setId(itemId);
		//实验状态，1-正常，2-下架，3-删除
		item.setStatus((byte)1);
		Date date = new Date();
		item.setCreated(date);
		item.setUpdated(date);
		//3. 向实验表中插入数据
		itemMapper.insert(item);
		
		//4. 创建一个TbItemDesc对象
		TbItemDesc itemDesc = new TbItemDesc();
		//5. 补全TbItemDesc对象的属性
		itemDesc.setItemId(itemId);
		itemDesc.setItemDesc(desc);
		itemDesc.setCreated(date);
		itemDesc.setUpdated(date);
		//6. 向实验描述表中插入数据
		itemDescMapper.insert(itemDesc);
		
		//7. 返回ok
		return E3Result.ok();
	}
	
	/**
	 * 编辑实验
	 */
	public E3Result editItem(TbItem item, String desc) {
		//1. 补全TbItem对象中的属性
		//实验状态，1-正常，2-下架，3-删除
		item.setStatus((byte)1);
		//获取创建时间
		TbItem item1 = itemMapper.selectByPrimaryKey(item.getId());
		Date created = item1.getCreated();
		item.setCreated(created);
		//创建更新时间
		Date date = new Date();
		item.setUpdated(date);
		//2. 向实验表中更新数据
		itemMapper.updateByPrimaryKey(item);
		
		//3. 根据id查询TbItemDesc对象
		TbItemDesc itemDesc = itemDescMapper.selectByPrimaryKey(item.getId());
		//4. 修改TbItemDesc对象的属性
		itemDesc.setUpdated(date);
		itemDesc.setItemDesc(desc);
		//5. 向实验描述表中更新数据
		itemDescMapper.updateByPrimaryKeySelective(itemDesc);
		
		//6. 返回ok
		return E3Result.ok();
	}
	
	/**
	 * 批量删除实验
	 * @param ids
	 * @return
	 */
	public E3Result deleteItem(String ids) {
		if(StringUtils.isNotBlank(ids)){
			String[] itemId = ids.split(",");
			for (String idStr : itemId) {
				long id = Long.parseLong(idStr);
				//根据id删除实验表中数据
				itemMapper.deleteByPrimaryKey(id);
				//根据id删除实验描述表中数据
				itemDescMapper.deleteByPrimaryKey(id);
			}
		}
		//返回ok
		return E3Result.ok();
	}
	
	/**
	 * 查询所有的实验列表，要进行分页处理
	 */
	@Override
	public EasyUIDataGridResult getItemList(int page, int rows) {
		//设置分页信息
		PageHelper.startPage(page, rows);
		//执行查询
		TbItemExample example = new TbItemExample();
		List<TbItem> list = itemMapper.selectByExample(example);
		//取分页信息
		PageInfo<TbItem> pageInfo = new PageInfo<>(list);
		
		//创建返回结果对象
		EasyUIDataGridResult result = new EasyUIDataGridResult();
		result.setTotal(pageInfo.getTotal());
		result.setRows(list);
		
		return result;
	}
	
}
