package com.taiyi.websiate.taiyiweb.mapper;

import com.taiyi.websiate.taiyiweb.entity.ProjectProcessEntity;
import com.taiyi.websiate.taiyiweb.entity.ProjectProcessEntityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProjectProcessEntityMapper {
    long countByExample(ProjectProcessEntityExample example);

    int deleteByExample(ProjectProcessEntityExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ProjectProcessEntity record);

    int insertSelective(ProjectProcessEntity record);

    /** QuerySignleResultMethodPlugin 生成 by plugn */
    ProjectProcessEntity singleResultByExample(ProjectProcessEntityExample example);

    /** QueryMethodPlugin 生成 by plugn */
    List query(ProjectProcessEntity example);

    List<ProjectProcessEntity> selectByExample(ProjectProcessEntityExample example);

    ProjectProcessEntity selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ProjectProcessEntity record, @Param("example") ProjectProcessEntityExample example);

    int updateByExample(@Param("record") ProjectProcessEntity record, @Param("example") ProjectProcessEntityExample example);

    int updateByPrimaryKeySelective(ProjectProcessEntity record);

    int updateByPrimaryKey(ProjectProcessEntity record);
}