package com.taiyi.websiate.taiyiweb.mapper;

import com.taiyi.websiate.taiyiweb.entity.CmsContentEntity;
import com.taiyi.websiate.taiyiweb.entity.CmsContentEntityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CmsContentEntityMapper {
    long countByExample(CmsContentEntityExample example);

    int deleteByExample(CmsContentEntityExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CmsContentEntity record);

    int insertSelective(CmsContentEntity record);

    List<CmsContentEntity> selectByExampleWithBLOBs(CmsContentEntityExample example);

    /** QuerySignleResultMethodPlugin 生成 by plugn */
    CmsContentEntity singleResultByExample(CmsContentEntityExample example);

    /** QueryMethodPlugin 生成 by plugn */
    List query(CmsContentEntity example);

    List<CmsContentEntity> selectByExample(CmsContentEntityExample example);

    CmsContentEntity selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CmsContentEntity record, @Param("example") CmsContentEntityExample example);

    int updateByExampleWithBLOBs(@Param("record") CmsContentEntity record, @Param("example") CmsContentEntityExample example);

    int updateByExample(@Param("record") CmsContentEntity record, @Param("example") CmsContentEntityExample example);

    int updateByPrimaryKeySelective(CmsContentEntity record);

    int updateByPrimaryKeyWithBLOBs(CmsContentEntity record);

    int updateByPrimaryKey(CmsContentEntity record);
}