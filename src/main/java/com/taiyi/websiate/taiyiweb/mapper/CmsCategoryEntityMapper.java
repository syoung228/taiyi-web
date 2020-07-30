package com.taiyi.websiate.taiyiweb.mapper;

import com.taiyi.websiate.taiyiweb.entity.CmsCategoryEntity;
import com.taiyi.websiate.taiyiweb.entity.CmsCategoryEntityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CmsCategoryEntityMapper {
    long countByExample(CmsCategoryEntityExample example);

    int deleteByExample(CmsCategoryEntityExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CmsCategoryEntity record);

    int insertSelective(CmsCategoryEntity record);

    /** QuerySignleResultMethodPlugin 生成 by plugn */
    CmsCategoryEntity singleResultByExample(CmsCategoryEntityExample example);

    /** QueryMethodPlugin 生成 by plugn */
    List query(CmsCategoryEntity example);

    List<CmsCategoryEntity> selectByExample(CmsCategoryEntityExample example);

    CmsCategoryEntity selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CmsCategoryEntity record, @Param("example") CmsCategoryEntityExample example);

    int updateByExample(@Param("record") CmsCategoryEntity record, @Param("example") CmsCategoryEntityExample example);

    int updateByPrimaryKeySelective(CmsCategoryEntity record);

    int updateByPrimaryKey(CmsCategoryEntity record);
}