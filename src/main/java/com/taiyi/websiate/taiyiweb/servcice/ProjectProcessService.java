package com.taiyi.websiate.taiyiweb.servcice;

import com.taiyi.websiate.taiyiweb.mapper.ProjectProcessEntityMapper;
import com.taiyi.websiate.taiyiweb.mapper.ProjectProcessInfoEntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


}
