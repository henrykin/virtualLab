package com.virtual.lab.common.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * 使用easyui的datagrid数据表格展示实验列表
 * 该pojo是用来转换json数据的，然后把json数据响应给页面
 * 至于该pojo有什么属性，是看页面datagrid控件需要什么样的响应数据
 * @author xiaoqiang
 *
 */
public class EasyUIDataGridResult implements Serializable{
	//查询到的总记录数
	private long total;
	//当前页的结果集
	private List rows;
	
	
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
	public List getRows() {
		return rows;
	}
	public void setRows(List rows) {
		this.rows = rows;
	}
	
}
