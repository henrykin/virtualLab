package com.virtual.lab.mapper;

import com.virtual.lab.pojo.TbResportDesc;
import com.virtual.lab.pojo.TbResportDescExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbResportDescMapper {
    int countByExample(TbResportDescExample example);

    int deleteByExample(TbResportDescExample example);

    int deleteByPrimaryKey(Long resportId);

    int insert(TbResportDesc record);

    int insertSelective(TbResportDesc record);

    List<TbResportDesc> selectByExampleWithBLOBs(TbResportDescExample example);

    List<TbResportDesc> selectByExample(TbResportDescExample example);

    TbResportDesc selectByPrimaryKey(Long resportId);

    int updateByExampleSelective(@Param("record") TbResportDesc record, @Param("example") TbResportDescExample example);

    int updateByExampleWithBLOBs(@Param("record") TbResportDesc record, @Param("example") TbResportDescExample example);

    int updateByExample(@Param("record") TbResportDesc record, @Param("example") TbResportDescExample example);

    int updateByPrimaryKeySelective(TbResportDesc record);

    int updateByPrimaryKeyWithBLOBs(TbResportDesc record);

    int updateByPrimaryKey(TbResportDesc record);
}