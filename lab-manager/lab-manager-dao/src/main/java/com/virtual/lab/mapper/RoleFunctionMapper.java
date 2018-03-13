package com.virtual.lab.mapper;

import com.virtual.lab.pojo.RoleFunctionExample;
import com.virtual.lab.pojo.RoleFunctionKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RoleFunctionMapper {
    int countByExample(RoleFunctionExample example);

    int deleteByExample(RoleFunctionExample example);

    int deleteByPrimaryKey(RoleFunctionKey key);

    int insert(RoleFunctionKey record);

    int insertSelective(RoleFunctionKey record);

    List<RoleFunctionKey> selectByExample(RoleFunctionExample example);

    int updateByExampleSelective(@Param("record") RoleFunctionKey record, @Param("example") RoleFunctionExample example);

    int updateByExample(@Param("record") RoleFunctionKey record, @Param("example") RoleFunctionExample example);

    //根据权限的id删除role_function表里的权限信息
    void deleteByFunctionId(String id);
   
    //根据角色的id删除role_function表里的权限信息
    int deleteByRoleId(String id);
}