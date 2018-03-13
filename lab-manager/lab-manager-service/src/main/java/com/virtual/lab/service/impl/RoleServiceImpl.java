package com.virtual.lab.service.impl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.virtual.lab.common.pojo.EasyUIDataGridResult;
import com.virtual.lab.mapper.AuthFunctionMapper;
import com.virtual.lab.mapper.AuthRoleMapper;
import com.virtual.lab.mapper.RoleFunctionMapper;
import com.virtual.lab.pojo.AuthFunction;
import com.virtual.lab.pojo.AuthRole;
import com.virtual.lab.pojo.AuthRoleExample;
import com.virtual.lab.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService{
	
	/**
	 * 角色表
	 */
	@Autowired
	private AuthRoleMapper authRoleMapper;
	
	/**
	 * 角色_权限
	 */
	@Autowired
	private RoleFunctionMapper roleFunctionMapper;
	/**
	 * 添加角色
	 */
	public void save(AuthRole authRole, String functionIds) {
		//生成UUID
		String uuid = UUID.randomUUID().toString().replaceAll("-", "");
		//添加主键
		authRole.setId(uuid);
		
		//执行插入
		authRoleMapper.insert(authRole);
		
		if(StringUtils.isNotBlank(functionIds)){
			String[] fIds = functionIds.split(",");
			Map<String,Object> saveParams = new HashMap<>();
			saveParams.put("roleId", authRole.getId());
			saveParams.put("functionId", Arrays.asList(fIds));
			
			authRoleMapper.saveRoleOrFunction(saveParams);
		}
	}
	
	/**
	 * 分页查询角色
	 */
	public EasyUIDataGridResult getAuthRoleList(int page, int rows) {
		//设置分页信息
		PageHelper.startPage(page, rows);
		
		//执行查询
		AuthRoleExample example = new AuthRoleExample();
		List<AuthRole> list = authRoleMapper.selectByExample(example);
		
		//取分页信息
		PageInfo<AuthRole> pageInfo = new PageInfo<>(list);
				
		//创建返回结果对象
		EasyUIDataGridResult result = new EasyUIDataGridResult();
		result.setTotal(pageInfo.getTotal());//总记录数
		result.setRows(list);//当前页的商品列表
				
		return result;
	}

	/**
	 * ajax查询所有的角色数据，并且返回json数据
	 */
	public List<AuthRole> findAllRole() {
		AuthRoleExample example = new AuthRoleExample();
		List<AuthRole> list = authRoleMapper.selectByExample(example );
		return list;
	}

	@Override
	public int delete(String id) {
		return authRoleMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int edit(AuthRole role, String functionIds) {
		int num = authRoleMapper.updateByPrimaryKey(role);
		int delNum = roleFunctionMapper.deleteByRoleId(role.getId());
		if(StringUtils.isNotBlank(functionIds)){
			String[] fIds = functionIds.split(",");
			Map<String,Object> saveParams = new HashMap<>();
			saveParams.put("roleId", role.getId());
			saveParams.put("functionId", Arrays.asList(fIds));
			authRoleMapper.saveRoleOrFunction(saveParams);
		}		
		return num;
	}

}
