package com.virtual.lab.mapper;

import com.virtual.lab.pojo.TbResport;
import com.virtual.lab.pojo.TbResportExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbResportMapper {
    int countByExample(TbResportExample example);

    int deleteByExample(TbResportExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TbResport record);

    int insertSelective(TbResport record);

    List<TbResport> selectByExample(TbResportExample example);

    TbResport selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TbResport record, @Param("example") TbResportExample example);

    int updateByExample(@Param("record") TbResport record, @Param("example") TbResportExample example);

    int updateByPrimaryKeySelective(TbResport record);

    int updateByPrimaryKey(TbResport record);
}