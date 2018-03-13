package com.virtual.lab.service.impl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.virtual.lab.common.pojo.EasyUIDataGridResult;
import com.virtual.lab.mapper.TbUserMapper;
import com.virtual.lab.pojo.AuthRole;
import com.virtual.lab.pojo.TbUser;
import com.virtual.lab.pojo.TbUserAndRole;
import com.virtual.lab.pojo.TbUserExample;
import com.virtual.lab.pojo.TbUserExample.Criteria;
import com.virtual.lab.service.UserService;

/**
 * 用户表Service
 * @author xiaoqiang
 *
 */
@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private TbUserMapper userMapper;
	/**
	 * 根据用户名查询用户信息
	 */
	public TbUser selectUserByUsername(String username) {
		TbUserExample example = new TbUserExample();
		Criteria criteria = example.createCriteria();
		criteria.andUsernameEqualTo(username);
		List<TbUser> userList = userMapper.selectByExample(example);
		if(userList != null){
			TbUser user = userList.get(0);
			return user;
		}
		return null;
	}
	
	/**
	 * 更新用户信息
	 */
	public boolean update(TbUser user) {
		int key = userMapper.updateByPrimaryKey(user);
		if(key > 0){
			return true;
		}
		return false;
	}

	/**
	 * 分页查询用户信息
	 */
	public EasyUIDataGridResult getUserList(int page, int rows) {
		
		//设置分页信息
		PageHelper.startPage(page, rows);
		
		List<TbUserAndRole> list = userMapper.selectUserAndRole();
		
		//取分页信息
		PageInfo<TbUserAndRole> pageInfo = new PageInfo<>(list);
		
		//创建返回结果对象
		EasyUIDataGridResult result = new EasyUIDataGridResult();
		result.setTotal(pageInfo.getTotal());//总记录数
		result.setRows(list);//当前页的商品列表
						
		return result;
	}

	/**
	 * 修改一个用户对应的权限
	 */
	public void saveUserAndRole(TbUser user, String roleIds) {
		
		/*if(StringUtils.isNotBlank(functionIds)){
			String[] fIds = functionIds.split(",");
			Map<String,Object> saveParams = new HashMap<>();
			saveParams.put("roleId", authRole.getId());
			saveParams.put("functionId", Arrays.asList(fIds));
			
			authRoleMapper.saveRoleOrFunction(saveParams);
		}*/
		if(StringUtils.isNotBlank(roleIds)){
			String[] rIds = roleIds.split(",");
			Map<String, Object> saveParams = new HashMap<>();
			saveParams.put("userId", user.getId());
			saveParams.put("roleIds", Arrays.asList(rIds));
			
			userMapper.saveUserOrRole(saveParams);
		}
		
	}
	
}
