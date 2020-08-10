package com.taiyi.websiate.taiyiweb.controlloer;

import com.taiyi.websiate.taiyiweb.servcice.ProjectProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Despriction:
 * @Author: syoung
 * @Date:Created in 2020-08-10
 * @Modity By:
 */
@RestController
@RequestMapping("/progress")
public class ProgressController {
    @Autowired
    private ProjectProcessService projectProcessService;
    @GetMapping("/list")
    private Object getProgressList(){
        return projectProcessService.getProjectList();
    }
    @GetMapping("/detail/{id}")
    private Object getProgressDetail(@PathVariable("id") Integer id){
        return projectProcessService.getProjectDetail(id);
    }

    @GetMapping("/getNextAndLast")
    public Object getNextAndLast(Integer currentId){
        return projectProcessService.getLastAndNextContent(currentId);
    }

}
