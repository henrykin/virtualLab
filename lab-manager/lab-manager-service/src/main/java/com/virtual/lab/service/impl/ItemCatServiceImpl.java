package com.virtual.lab.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtual.lab.common.pojo.EasyUITreeNode;
import com.virtual.lab.common.utils.E3Result;
import com.virtual.lab.mapper.TbItemCatMapper;
import com.virtual.lab.pojo.TbItemCat;
import com.virtual.lab.pojo.TbItemCatExample;
import com.virtual.lab.pojo.TbItemCatExample.Criteria;
import com.virtual.lab.service.ItemCatService;

@Service
public class ItemCatServiceImpl implements ItemCatService {
	
	//实验类目表
	@Autowired
	private TbItemCatMapper itemCatMapper;
	
	/**
	 * 查询实验类目
	 */
	public List<EasyUITreeNode> getItemCatList(long parentId) {
		//1. 根据parentId查询子节点列表
		TbItemCatExample example = new TbItemCatExample();
		//2. 设置查询条件
		Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(parentId);
		//3. 执行查询
		List<TbItemCat> list = itemCatMapper.selectByExample(example);
		
		//4. 转换成EasyUITreeNode列表
		List<EasyUITreeNode> resultList = new ArrayList<>();
		//5. 遍历
		for (TbItemCat itemCat : list) {
			EasyUITreeNode node = new EasyUITreeNode();
			node.setId(itemCat.getId());
			node.setText(itemCat.getName());
			node.setState(itemCat.getIsParent()?"closed":"open");
			//6. 添加到列表
			resultList.add(node);
		}
		//7. 返回
		return resultList;
	}
}
