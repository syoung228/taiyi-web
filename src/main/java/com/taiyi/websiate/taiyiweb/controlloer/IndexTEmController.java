package com.taiyi.websiate.taiyiweb.controlloer;

import com.taiyi.websiate.taiyiweb.entity.CmsCategoryEntity;
import com.taiyi.websiate.taiyiweb.servcice.FooterService;
import com.taiyi.websiate.taiyiweb.servcice.IndexService;
import com.taiyi.websiate.taiyiweb.servcice.ProjectProcessService;
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
 * @Date:Created in
 * @Modity By:
 */
@RequestMapping("/toHtml")
@Controller
public class IndexTEmController {
    @Autowired
    IndexService indexService;
    @Autowired
    FooterService footerService;
    @Autowired
    private ProjectProcessService projectProcessService;

    @RequestMapping("/index/{categoryId}")
    public ModelAndView indexData(HttpServletRequest request, ModelAndView mv,@PathVariable("categoryId") Integer categoryId){
        mv.addObject("header",indexService.getById(categoryId));
        mv.addObject("headerList",indexService.headerList());
        mv.addObject("index",indexService.index(request));
        mv.addObject("footer",footerService.getCompany());
        mv.setViewName("index");
        return mv;
    }

    @RequestMapping("/about/{categoryId}")
    public ModelAndView aboutData(HttpServletRequest request, ModelAndView mv, @PathVariable("categoryId") Integer categoryId){
        mv.addObject("header",indexService.getById(categoryId));
        mv.addObject("headerList",indexService.headerList());
        mv.addObject("footer",footerService.getCompany());
        List<CmsCategoryEntity> cmsCategoryEntities = (List<CmsCategoryEntity>) indexService.getCaseCategory(categoryId);
        mv.addObject("contentIntelligenceIdResult",indexService.getcontentByCategory(cmsCategoryEntities.get(0).getId(),null,null));
        mv.addObject("contentResponsibilityIdResult",indexService.getcontentByCategory(cmsCategoryEntities.get(1).getId(),null,null));

        mv.setViewName("about");
        return mv;
    }

    @RequestMapping("/generation/{categoryId}")
    public ModelAndView generationtData(HttpServletRequest request, ModelAndView mv, @PathVariable("categoryId") Integer categoryId){
        mv.addObject("header",indexService.getById(categoryId));
        mv.addObject("headerList",indexService.headerList());
        mv.addObject("footer",footerService.getCompany());
        mv.addObject("generationList",indexService.getcontentByCategory(categoryId,null,null));
        mv.setViewName("generation");
        return mv;
    }
    @RequestMapping("/lifting/{categoryId}")
    public ModelAndView liftingData(HttpServletRequest request, ModelAndView mv, @PathVariable("categoryId") Integer categoryId){
        mv.addObject("header",indexService.getById(categoryId));
        mv.addObject("headerList",indexService.headerList());
        mv.addObject("footer",footerService.getCompany());
        mv.addObject("relateCase",indexService.getcontentByCategory(66,1,3));
        mv.setViewName("lifting");
        return mv;
    }

    @RequestMapping("/lamp/{categoryId}")
    public ModelAndView lampData(HttpServletRequest request, ModelAndView mv, @PathVariable("categoryId") Integer categoryId){
        mv.addObject("header",indexService.getById(categoryId));
        mv.addObject("headerList",indexService.headerList());
        mv.addObject("footer",footerService.getCompany());
        mv.addObject("relateCase",indexService.getcontentByCategory(66,1,3));
        mv.setViewName("lamp");
        return mv;
    }

    @RequestMapping("/construction/{categoryId}")
    public ModelAndView constructionData(HttpServletRequest request, ModelAndView mv, @PathVariable("categoryId") Integer categoryId){
        mv.addObject("header",indexService.getById(categoryId));
        mv.addObject("headerList",indexService.headerList());
        mv.addObject("footer",footerService.getCompany());
        mv.addObject("projectList",projectProcessService.getProjectList());
        mv.setViewName("construction");
        return mv;
    }

    @RequestMapping("/contact/{categoryId}")
    public ModelAndView contactData(HttpServletRequest request, ModelAndView mv, @PathVariable("categoryId") Integer categoryId){
        mv.addObject("header",indexService.getById(categoryId));
        mv.addObject("headerList",indexService.headerList());
        mv.addObject("footer",footerService.getCompany());
        mv.addObject("contactInfo",indexService.getContact());
        mv.setViewName("contact");
        return mv;
    }

    @RequestMapping("/progress/{categoryId}/{id}")
    public ModelAndView progressData(HttpServletRequest request, ModelAndView mv, @PathVariable("categoryId") Integer categoryId,@PathVariable("id") Integer id){
        mv.addObject("header",indexService.getById(categoryId));
        mv.addObject("headerList",indexService.headerList());
        mv.addObject("footer",footerService.getCompany());
        mv.addObject("progressResult",projectProcessService.getProjectDetail(id));
        mv.addObject("lastAndNextProgress",projectProcessService.getLastAndNextContent(id));
        mv.addObject("tags",indexService.getTags());
        mv.addObject("news",indexService.getNewsByMainCategory());
        mv.setViewName("progress");
        return mv;
    }
}
