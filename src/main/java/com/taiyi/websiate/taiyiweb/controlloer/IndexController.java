package com.taiyi.websiate.taiyiweb.controlloer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.taiyi.websiate.taiyiweb.servcice.IndexService;
import com.taiyi.websiate.taiyiweb.utils.AddressUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author EDZ
 */
@RestController
public class IndexController {
    @Autowired
    IndexService indexService;
    @RequestMapping("/index")
    public Object indexDate(HttpServletRequest request){
        return indexService.index(request);
    }

    @GetMapping("/getCaseCategory")
    public Object getCaseCategory(Integer categoryId){
        return indexService.getCaseCategory(categoryId);
    }

    @GetMapping("/getContentList")
    public Object getContentList(Integer categoryId,Integer pageNum,Integer pageSize){
        return indexService.getcontentByCategory( categoryId, pageNum, pageSize);
    }

    @GetMapping("/getHeaderList")
    public Object getHeaderList(){
        return indexService.headerList();
    }
    @GetMapping("/getContentDetail")
    public Object getContentDetail(Integer id){
        return indexService.getContenDetail(id);
    }

    @GetMapping("/getNews")
    public Object getNews(){
        return indexService.getNewsByMainCategory();
    }

    @GetMapping("/getTags")
    public Object getTags(){
        return indexService.getTags();
    }

    @GetMapping("/getByTags")
    public Object getByTags(Integer tagsId,Integer pageNum,Integer pageSize){
        return indexService.getcontentByTags(tagsId,pageNum,pageSize);
    }

    @GetMapping("/getNextAndLast")
    public Object getNextAndLast(Integer categoryId,Integer currentId){
        return indexService.getLastAndNextContent(currentId,categoryId);
    }

    @GetMapping("/getContact")
    public Object getContact(){
        return indexService.getContact();
    }

}
