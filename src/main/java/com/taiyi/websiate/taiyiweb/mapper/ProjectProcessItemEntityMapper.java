package com.taiyi.websiate.taiyiweb.mapper;

import com.taiyi.websiate.taiyiweb.entity.ProjectProcessItemEntity;
import com.taiyi.websiate.taiyiweb.entity.ProjectProcessItemEntityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProjectProcessItemEntityMapper {
    long countByExample(ProjectProcessItemEntityExample example);

    int deleteByExample(ProjectProcessItemEntityExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ProjectProcessItemEntity record);

    int insertSelective(ProjectProcessItemEntity record);

    /** QuerySignleResultMethodPlugin 生成 by plugn */
    ProjectProcessItemEntity singleResultByExample(ProjectProcessItemEntityExample example);

    /** QueryMethodPlugin 生成 by plugn */
    List query(ProjectProcessItemEntity example);

    List<ProjectProcessItemEntity> selectByExample(ProjectProcessItemEntityExample example);

    ProjectProcessItemEntity selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ProjectProcessItemEntity record, @Param("example") ProjectProcessItemEntityExample example);

    int updateByExample(@Param("record") ProjectProcessItemEntity record, @Param("example") ProjectProcessItemEntityExample example);

    int updateByPrimaryKeySelective(ProjectProcessItemEntity record);

    int updateByPrimaryKey(ProjectProcessItemEntity record);
}