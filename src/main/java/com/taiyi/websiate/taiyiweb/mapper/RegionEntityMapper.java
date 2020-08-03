package com.taiyi.websiate.taiyiweb.mapper;

import com.taiyi.websiate.taiyiweb.entity.RegionEntity;
import com.taiyi.websiate.taiyiweb.entity.RegionEntityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RegionEntityMapper {
    long countByExample(RegionEntityExample example);

    int deleteByExample(RegionEntityExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(RegionEntity record);

    int insertSelective(RegionEntity record);

    /** QuerySignleResultMethodPlugin 生成 by plugn */
    RegionEntity singleResultByExample(RegionEntityExample example);

    /** QueryMethodPlugin 生成 by plugn */
    List query(RegionEntity example);

    List<RegionEntity> selectByExample(RegionEntityExample example);

    RegionEntity selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RegionEntity record, @Param("example") RegionEntityExample example);

    int updateByExample(@Param("record") RegionEntity record, @Param("example") RegionEntityExample example);

    int updateByPrimaryKeySelective(RegionEntity record);

    int updateByPrimaryKey(RegionEntity record);
}