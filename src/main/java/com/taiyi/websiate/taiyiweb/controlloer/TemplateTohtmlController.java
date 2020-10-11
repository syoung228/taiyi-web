package com.taiyi.websiate.taiyiweb.controlloer;

import com.taiyi.websiate.taiyiweb.entity.CmsCategoryEntity;
import com.taiyi.websiate.taiyiweb.servcice.FooterService;
import com.taiyi.websiate.taiyiweb.servcice.IndexService;
import com.taiyi.websiate.taiyiweb.servcice.ProjectProcessService;
import com.taiyi.websiate.taiyiweb.utils.ThymeleafViewObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Despriction:
 * @Author: syoung
 * @Date:Created in 2020-09-01
 * @Modity By:
 */
@RequestMapping("/toHtml")
@Controller
public class TemplateTohtmlController {
    @Autowired
    IndexService indexService;
    @Autowired
    FooterService footerService;
    @Autowired
    private ProjectProcessService projectProcessService;

    @RequestMapping("/index/{categoryId}")
    public ModelAndView indexData(HttpServletRequest request, ModelAndView mv, @PathVariable("categoryId") Integer categoryId){
        mvAddObject(mv);
        mv.addObject("index",indexService.index());
        mv.setViewName("index");
        return mv;
    }

    @RequestMapping("/about/{categoryId}")
    public ModelAndView aboutData(HttpServletRequest request, ModelAndView mv, @PathVariable("categoryId") Integer categoryId){
        mvAddObject(mv);
        List<CmsCategoryEntity> cmsCategoryEntities = (List<CmsCategoryEntity>) indexService.getCaseCategory(categoryId);
        mv.addObject("contentIntelligenceIdResult",indexService.getcontentByCategory(cmsCategoryEntities.get(0).getId(),null,null));
        mv.addObject("contentResponsibilityIdResult",indexService.getcontentByCategory(cmsCategoryEntities.get(1).getId(),null,null));
        mv.setViewName("about");
        return mv;
    }
    @RequestMapping("/generation/{categoryId}")
    public ModelAndView generationtData(HttpServletRequest request, ModelAndView mv, @PathVariable("categoryId") Integer categoryId){
        mvAddObject(mv);
        mv.addObject("contentList",ThymeleafViewObject.contentList);
        mv.setViewName("generation");
        return mv;
    }



    @RequestMapping("/progress/{categoryId}/{id}")
    public ModelAndView progressData(HttpServletRequest request, ModelAndView mv, @PathVariable("categoryId") Integer categoryId,@PathVariable("id") Integer id){
        mvAddObject(mv);
        mv.addObject("progressResult",projectProcessService.getProjectDetail(id));
        mv.addObject("lastAndNextProgress",ThymeleafViewObject.lastAndNextProgress);
        mv.addObject("tags", ThymeleafViewObject.tags);
        mv.addObject("news",ThymeleafViewObject.news);
        mv.setViewName("progress");
        return mv;
    }
    @RequestMapping("/lifting/{categoryId}")
    public ModelAndView liftingData(HttpServletRequest request, ModelAndView mv, @PathVariable("categoryId") Integer categoryId){
        mvAddObject(mv);
        mv.addObject("relateCase",indexService.getcontentByCategory(66,1,3));
        mv.setViewName("lifting");
        return mv;
    }


    @RequestMapping("/construction/{categoryId}")
    public ModelAndView constructionData(HttpServletRequest request, ModelAndView mv, @PathVariable("categoryId") Integer categoryId){
        mvAddObject(mv);
        mv.addObject("projectList",projectProcessService.getProjectList());
        mv.setViewName("construction");
        return mv;
    }

    @RequestMapping("/contact/{categoryId}")
    public ModelAndView contactData(HttpServletRequest request, ModelAndView mv, @PathVariable("categoryId") Integer categoryId){
        mvAddObject(mv);
        mv.addObject("contactInfo",indexService.getContact());
        mv.setViewName("contact");
        return mv;
    }


    @RequestMapping("/lable/{tagId}/{pageNum}")
    public ModelAndView lableData(HttpServletRequest request, ModelAndView mv, @PathVariable("tagId") Integer tagId, @PathVariable("pageNum") Integer pageNum){
        mvAddObject(mv);
        mv.addObject("tag",indexService.getTasgById(tagId));
        mv.addObject("contentList",indexService.getcontentByTags(tagId,pageNum,null));
        mv.setViewName("lable");
        return mv;
    }

    @RequestMapping("/case/{categoryId}/{pageNum}")
    public ModelAndView caseData(HttpServletRequest request, ModelAndView mv, @PathVariable("categoryId") Integer categoryId, @PathVariable("pageNum") Integer pageNum){
        mvAddObject(mv);
        mv.addObject("contentList",ThymeleafViewObject.contentList);
        mv.addObject("categoryList",ThymeleafViewObject.categoryList);
        mv.addObject("categoryId",categoryId);
        mv.setViewName("case");
        return mv;
    }

    @RequestMapping("/news/{categoryId}/{pageNum}")
    public ModelAndView newsData(HttpServletRequest request, ModelAndView mv, @PathVariable("categoryId") Integer categoryId, @PathVariable("pageNum") Integer pageNum){
        mvAddObject(mv);
        mv.addObject("contentList",ThymeleafViewObject.contentList);
        mv.addObject("categoryList",ThymeleafViewObject.categoryList);
        mv.addObject("categoryId",categoryId);
        mv.setViewName("news");
        return mv;
    }

    @RequestMapping("/lamp/{categoryId}/{pageNum}")
    public ModelAndView lampData(HttpServletRequest request, ModelAndView mv, @PathVariable("categoryId") Integer categoryId, @PathVariable("pageNum") Integer pageNum){
        mvAddObject(mv);
        mv.addObject("contentList",ThymeleafViewObject.contentList);
        mv.addObject("categoryList",ThymeleafViewObject.categoryList);
        mv.addObject("categoryId",categoryId);
        mv.setViewName("lamp");
        return mv;
    }

    @RequestMapping("/contentDetails/{categoryId}/{id}")
    public ModelAndView contentDetailsData(HttpServletRequest request, ModelAndView mv, @PathVariable("categoryId") Integer categoryId,@PathVariable("id") Integer id){
        mvAddObject(mv);
        mv.addObject("contentResult",ThymeleafViewObject.contentResult);
        mv.addObject("secondMenu",ThymeleafViewObject.secondMenu);
        mv.addObject("lastAndNextProgress", ThymeleafViewObject.lastAndNextProgress);
        mv.addObject("tags",ThymeleafViewObject.tags);
        mv.addObject("news",ThymeleafViewObject.news);
        mv.setViewName("contentDetails");
        return mv;
    }

    @RequestMapping("/details/{categoryId}/{id}")
    public ModelAndView detailsData(HttpServletRequest request, ModelAndView mv, @PathVariable("categoryId") Integer categoryId,@PathVariable("id") Integer id){
        mvAddObject(mv);
        mv.addObject("details",ThymeleafViewObject.contentResult);
        mv.addObject("secondMenu",ThymeleafViewObject.secondMenu);
        mv.addObject("lastAndNextProgress",ThymeleafViewObject.lastAndNextProgress);
        mv.addObject("tags", ThymeleafViewObject.tags);
        mv.addObject("news",ThymeleafViewObject.news);
        mv.addObject("relateCase65",ThymeleafViewObject.relateCase65);
        mv.addObject("relateCase67",ThymeleafViewObject.relateCase67);
        mv.setViewName("details");
        return mv;
    }

    private void mvAddObject(ModelAndView mv){
        mv.addObject("header", ThymeleafViewObject.header);
        mv.addObject("headerList",ThymeleafViewObject.headerList);
        mv.addObject("footer",ThymeleafViewObject.footer);
    }
}
