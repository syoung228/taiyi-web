package com.taiyi.websiate.taiyiweb.mapper;

import com.taiyi.websiate.taiyiweb.dto.ProjectDto;
import com.taiyi.websiate.taiyiweb.dto.ProjectProcessInfoDto;
import com.taiyi.websiate.taiyiweb.entity.ProjectProcessInfoEntity;
import com.taiyi.websiate.taiyiweb.entity.ProjectProcessInfoEntityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProjectProcessInfoEntityMapper {
    long countByExample(ProjectProcessInfoEntityExample example);

    int deleteByExample(ProjectProcessInfoEntityExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ProjectProcessInfoEntity record);

    int insertSelective(ProjectProcessInfoEntity record);

    /** QuerySignleResultMethodPlugin 生成 by plugn */
    ProjectProcessInfoEntity singleResultByExample(ProjectProcessInfoEntityExample example);

    /** QueryMethodPlugin 生成 by plugn */
    List query(ProjectProcessInfoEntity example);

    List<ProjectProcessInfoEntity> selectByExample(ProjectProcessInfoEntityExample example);

    ProjectProcessInfoEntity selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ProjectProcessInfoEntity record, @Param("example") ProjectProcessInfoEntityExample example);

    int updateByExample(@Param("record") ProjectProcessInfoEntity record, @Param("example") ProjectProcessInfoEntityExample example);

    int updateByPrimaryKeySelective(ProjectProcessInfoEntity record);

    int updateByPrimaryKey(ProjectProcessInfoEntity record);

    List<ProjectProcessInfoDto> getByProject(Integer projectId);
}
