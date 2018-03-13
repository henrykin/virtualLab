package com.virtual.lab.service.impl;

import java.util.List;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.virtual.lab.common.pojo.EasyUIDataGridResult;
import com.virtual.lab.mapper.AuthFunctionMapper;
import com.virtual.lab.mapper.RoleFunctionMapper;
import com.virtual.lab.pojo.AuthFunction;
import com.virtual.lab.pojo.AuthFunctionExample;
import com.virtual.lab.pojo.AuthFunctionExample.Criteria;
import com.virtual.lab.service.FunctionService;

/**
 * 权限管理service
 * @author xiaoqiang
 *
 */
@Service
public class FunctionServiceImpl implements FunctionService{
	
	//权限表
	@Autowired
	private AuthFunctionMapper authFunctionMapper;
	
	//角色权限表
	@Autowired
	private RoleFunctionMapper roleFunctionMapper;
	
	/**
	 * 查询所有权限
	 */
	@Override
	public List<AuthFunction> findAllFunction() {
		AuthFunctionExample example = new AuthFunctionExample();
		List<AuthFunction> list = authFunctionMapper.selectByExample(example);
		return list;
	}
	
	/**
	 * 添加权限
	 */
	@Override
	public void saveFunction(AuthFunction authFunction) {
		//生成UUID
		String uuid = UUID.randomUUID().toString().replaceAll("-", "");
		//添加主键id
		authFunction.setId(uuid);
		
		String pid = authFunction.getPid();
		if(pid != null && pid.equals("")){
			//没选，是空串,则设置为null表示没有上级
			authFunction.setPid(null);
		}
		
		//执行插入操作
		authFunctionMapper.insert(authFunction);
	}
	
	/**
	 * 查询所有权限列表，要进行分页处理
	 */
	@Override
	public EasyUIDataGridResult getAuthFunctionList(int page, int rows) {
		//设置分页信息
		PageHelper.startPage(page, rows);
		
		//执行查询
		AuthFunctionExample example = new AuthFunctionExample();
		List<AuthFunction> list = authFunctionMapper.selectByExample(example);
		//取分页信息
		PageInfo<AuthFunction> pageInfo = new PageInfo<>(list);
		
		//创建返回结果对象
		EasyUIDataGridResult result = new EasyUIDataGridResult();
		result.setTotal(pageInfo.getTotal());//总记录数
		result.setRows(list);//当前页的商品列表
		
		return result;
	}

	/**
	 * 根据当前登录人查询对应的菜单数据,并且返回json
	 */
	public List<AuthFunction> findMenuByUserId(long id) {
		List<AuthFunction> list = authFunctionMapper.findMenuByUserId(id);
		return list;
	}

	/**
	 * 修改权限
	 */
	public void editFunction(AuthFunction authFunction) {
		//authFunctionMapper.updateByPrimaryKey(authFunction);
		String id = authFunction.getId();
		//自己编写的根据权限id修改权限信息，解除外键约束问题
		authFunctionMapper.updateFunctionById(authFunction);
	}

	
	/**
	 * 批量删除权限
	 */
	public void deleteFunction(String ids) {
		//判断是否不为null
		if(StringUtils.isNotBlank(ids)){
			String[] functionId = ids.split(",");
			for(String fId : functionId){
				//根据权限的id删除role_function表里的权限信息
				roleFunctionMapper.deleteByFunctionId(fId);
				//根据全权限id删除auth_function表里的权限信息
				authFunctionMapper.deleteByPrimaryKey(fId);
			}
		}
	}
	
	
}
