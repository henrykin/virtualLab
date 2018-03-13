package com.virtual.lab.mapper;

import com.virtual.lab.pojo.AuthFunction;
import com.virtual.lab.pojo.AuthFunctionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AuthFunctionMapper {
    int countByExample(AuthFunctionExample example);

    int deleteByExample(AuthFunctionExample example);

    int deleteByPrimaryKey(String id);

    int insert(AuthFunction record);

    int insertSelective(AuthFunction record);

    List<AuthFunction> selectByExample(AuthFunctionExample example);

    AuthFunction selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") AuthFunction record, @Param("example") AuthFunctionExample example);

    int updateByExample(@Param("record") AuthFunction record, @Param("example") AuthFunctionExample example);

    int updateByPrimaryKeySelective(AuthFunction record);

    int updateByPrimaryKey(AuthFunction record);
    
    /**
     * 根据用户id查询该用户对应的权限
     */
    List<AuthFunction> findAuthFunctionByUserId(String username);
    
    /**
     * 根据用户id查询该用户对应的菜单
     */
    List<AuthFunction> findMenuByUserId(long id);
    
    /**
     * 根据权限id修改权限信息
     */
    void updateFunctionById(AuthFunction authFunction);
}