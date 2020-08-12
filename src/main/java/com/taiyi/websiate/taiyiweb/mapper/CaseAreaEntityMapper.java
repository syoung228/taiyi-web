package com.taiyi.websiate.taiyiweb.mapper;

import com.taiyi.websiate.taiyiweb.entity.CaseAreaEntity;
import com.taiyi.websiate.taiyiweb.entity.CaseAreaEntityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CaseAreaEntityMapper {
    long countByExample(CaseAreaEntityExample example);

    int deleteByExample(CaseAreaEntityExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CaseAreaEntity record);

    int insertSelective(CaseAreaEntity record);

    /** QuerySignleResultMethodPlugin 生成 by plugn */
    CaseAreaEntity singleResultByExample(CaseAreaEntityExample example);

    /** QueryMethodPlugin 生成 by plugn */
    List query(CaseAreaEntity example);

    List<CaseAreaEntity> selectByExample(CaseAreaEntityExample example);

    CaseAreaEntity selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CaseAreaEntity record, @Param("example") CaseAreaEntityExample example);

    int updateByExample(@Param("record") CaseAreaEntity record, @Param("example") CaseAreaEntityExample example);

    int updateByPrimaryKeySelective(CaseAreaEntity record);

    int updateByPrimaryKey(CaseAreaEntity record);
}