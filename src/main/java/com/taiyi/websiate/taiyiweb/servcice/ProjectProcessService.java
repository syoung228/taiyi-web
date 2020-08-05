package com.taiyi.websiate.taiyiweb.servcice;

import com.taiyi.websiate.taiyiweb.dto.ProjectDto;
import com.taiyi.websiate.taiyiweb.entity.ProjectProcessEntity;
import com.taiyi.websiate.taiyiweb.entity.ProjectProcessEntityExample;
import com.taiyi.websiate.taiyiweb.mapper.ProjectProcessEntityMapper;
import com.taiyi.websiate.taiyiweb.mapper.ProjectProcessInfoEntityMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Despriction:
 * @Author: syoung
 * @Date:Created in
 * @Modity By:
 */
@Service
public class ProjectProcessService {
    @Autowired
    ProjectProcessEntityMapper projectProcessEntityMapper;
    @Autowired
    ProjectProcessInfoEntityMapper projectProcessInfoEntityMapper;

    List<ProjectDto> getProjectList(){
        List<ProjectDto> projectDtos = new ArrayList<>();
        ProjectProcessEntityExample entityExample = new ProjectProcessEntityExample();
        entityExample.createCriteria().andIsDeleteEqualTo(1);
        List<ProjectProcessEntity> entities = projectProcessEntityMapper.selectByExample(entityExample);
        for (ProjectProcessEntity entity: entities) {
            ProjectDto projectDto = new ProjectDto();
            BeanUtils.copyProperties(entity,projectDto);
            projectDto.setProjectProcessInfo(projectProcessInfoEntityMapper.getByProject(entity.getId()));
            projectDtos.add(projectDto);
        }
        return projectDtos;
    }

}
