package com.virtual.lab.service;

import java.util.List;

import com.virtual.lab.common.pojo.EasyUITreeNode;
import com.virtual.lab.common.utils.E3Result;

/**
 * 实验类目interface
 * @author xiaoqiang
 *
 */
public interface ItemCatService {
	
	//查询实验分类
	public List<EasyUITreeNode> getItemCatList(long parentId);
	
}
