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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public List<ProjectDto> getProjectList(){
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

    public ProjectDto getProjectDetail(Integer progressId){
        ProjectProcessEntity entity = projectProcessEntityMapper.selectByPrimaryKey(progressId);
            ProjectDto projectDto = new ProjectDto();
            BeanUtils.copyProperties(entity,projectDto);
            projectDto.setProjectProcessInfo(projectProcessInfoEntityMapper.getByProject(entity.getId()));
        return projectDto;
    }

    public Object getLastAndNextContent(Integer contentId){
        Map<String,Object> result = new HashMap<>();
        result.put("last",projectProcessEntityMapper.getLastProgress(contentId));
        result.put("next",projectProcessEntityMapper.getNextProgress(contentId));
        return result;
    }

}
