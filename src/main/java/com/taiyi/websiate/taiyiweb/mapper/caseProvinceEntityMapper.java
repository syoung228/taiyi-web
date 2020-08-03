package com.taiyi.websiate.taiyiweb.mapper;

import com.taiyi.websiate.taiyiweb.entity.caseProvinceEntity;
import com.taiyi.websiate.taiyiweb.entity.caseProvinceEntityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface caseProvinceEntityMapper {
    long countByExample(caseProvinceEntityExample example);

    int deleteByExample(caseProvinceEntityExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(caseProvinceEntity record);

    int insertSelective(caseProvinceEntity record);

    /** QuerySignleResultMethodPlugin 生成 by plugn */
    caseProvinceEntity singleResultByExample(caseProvinceEntityExample example);

    /** QueryMethodPlugin 生成 by plugn */
    List query(caseProvinceEntity example);

    List<caseProvinceEntity> selectByExample(caseProvinceEntityExample example);

    caseProvinceEntity selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") caseProvinceEntity record, @Param("example") caseProvinceEntityExample example);

    int updateByExample(@Param("record") caseProvinceEntity record, @Param("example") caseProvinceEntityExample example);

    int updateByPrimaryKeySelective(caseProvinceEntity record);

    int updateByPrimaryKey(caseProvinceEntity record);
}