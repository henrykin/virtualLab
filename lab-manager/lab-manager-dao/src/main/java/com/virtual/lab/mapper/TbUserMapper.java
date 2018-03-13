package com.virtual.lab.mapper;

import com.virtual.lab.pojo.TbUser;
import com.virtual.lab.pojo.TbUserAndRole;
import com.virtual.lab.pojo.TbUserExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface TbUserMapper {
    int countByExample(TbUserExample example);

    int deleteByExample(TbUserExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TbUser record);

    int insertSelective(TbUser record);

    List<TbUser> selectByExample(TbUserExample example);

    TbUser selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TbUser record, @Param("example") TbUserExample example);

    int updateByExample(@Param("record") TbUser record, @Param("example") TbUserExample example);

    int updateByPrimaryKeySelective(TbUser record);

    int updateByPrimaryKey(TbUser record);
    
    /**
     * 查询所有用户，关联查询用户对应的角色信息
     */
    List<TbUserAndRole> selectUserAndRole();
    
    /**
     * 添加用户对应的角色信息
     */
    void saveUserOrRole(Map<String, Object> map);
}