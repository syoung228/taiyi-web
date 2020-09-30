package com.taiyi.websiate.taiyiweb.controlloer;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.sun.javafx.logging.JFRInputEvent;
import com.taiyi.websiate.taiyiweb.dto.ProjectDto;
import com.taiyi.websiate.taiyiweb.entity.CmsCategoryEntity;
import com.taiyi.websiate.taiyiweb.entity.CmsContentEntity;
import com.taiyi.websiate.taiyiweb.entity.ProjectProcessEntity;
import com.taiyi.websiate.taiyiweb.entity.TagsEntity;
import com.taiyi.websiate.taiyiweb.servcice.FooterService;
import com.taiyi.websiate.taiyiweb.servcice.IndexService;
import com.taiyi.websiate.taiyiweb.servcice.ProjectProcessService;
import com.taiyi.websiate.taiyiweb.utils.TemplateStaticUtil;
import com.taiyi.websiate.taiyiweb.utils.ThymeleafViewObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/generate")
public class TemplateStaticController {
    @Autowired
    IndexService indexService;
    @Autowired
    FooterService footerService;
    @Autowired
    private ProjectProcessService projectProcessService;


    @Value("${template.pageSize}")
    private Integer pageSize;

    @RequestMapping("/generateTags")
    @ResponseBody
    public void generateTags() throws IOException {
        String url = "";
        List<TagsEntity> tags = (List<TagsEntity>) indexService.getTags();
        for (TagsEntity tag: tags
        ) {
            PageInfo<CmsContentEntity> pageInfo = (PageInfo<CmsContentEntity>) indexService.getcontentByTags(tag.getId(),1,null);
            int tagTotalPages = pageInfo.getPages();
            if(tagTotalPages>0){
                for (int i=1;i<=tagTotalPages;i++){
                    url = "http://localhost:8081/toHtml/lable/"+tag.getId()+"/"+i;
                    TemplateStaticUtil.urlToHtml(url,"lable/"+tag.getId()+"_"+i+".html");
                }
            }
        }
    }


    /**
     * 生成列表的静态页面
     *
     * @param request
     * @param response
     * @param CategoryId
     */
    @RequestMapping("/{CategoryId}/genernateContent")
    @ResponseBody
    public void genernateContent(HttpServletRequest request, HttpServletResponse response, @PathVariable Integer CategoryId) throws IOException {
        List<CmsCategoryEntity> headerList = (List<CmsCategoryEntity>) indexService.headerList();
        ThymeleafViewObject.footer=footerService.getCompany();
        ThymeleafViewObject.headerList=headerList;
        ThymeleafViewObject.tags=indexService.getTags();
        ThymeleafViewObject.news=indexService.getNewsByMainCategory();
        CmsCategoryEntity header;
        if(CategoryId>0){
            //获取当前页面
            CmsCategoryEntity cmsCategoryEntity = indexService.getById(CategoryId);
            if(cmsCategoryEntity.getCategoryParentId()!=null && !("0").equals(cmsCategoryEntity.getCategoryParentId())){
                //只更新子栏目
                header = indexService.getById(Integer.parseInt(cmsCategoryEntity.getCategoryParentId()));
                ThymeleafViewObject.header=header;
            }else{
                header = indexService.getById(CategoryId);
                ThymeleafViewObject.header=header;
            }
            String url = "";
            String template = cmsCategoryEntity.getCategoryUrl().substring(0,cmsCategoryEntity.getCategoryUrl().length()-5);
            String categoryList = cmsCategoryEntity.getCategoryListUrl().substring(0,cmsCategoryEntity.getCategoryListUrl().length()-5);
            Map<String,Object> result = new HashMap<>();
            switch (template){
                case "index":
                    url = "http://localhost:8081/toHtml/index/"+CategoryId;
                    TemplateStaticUtil.urlToHtml(url,"index.html");
                    break;
                case "banner":
                    url = "http://localhost:8081/toHtml/index/"+CategoryId;
                    TemplateStaticUtil.urlToHtml(url,"index.html");
                    break;
                case "about":
                    if (!(cmsCategoryEntity.getCategoryParentId()==null||cmsCategoryEntity.getCategoryParentId().equals("0"))){
                        url = "http://localhost:8081/toHtml/about/"+cmsCategoryEntity.getCategoryParentId();
                        TemplateStaticUtil.urlToHtml(url,"about.html");

                    }else{
                        url = "http://localhost:8081/toHtml/about/"+cmsCategoryEntity.getId();
                        TemplateStaticUtil.urlToHtml(url,"about.html");
                    }
                    break;
                case "generation":
                    ThymeleafViewObject.tags=indexService.getTags();
                    ThymeleafViewObject.news=indexService.getNewsByMainCategory();
                    ThymeleafViewObject.relateCase65=indexService.getcontentByCategory(65,1,3);
                    ThymeleafViewObject.relateCase67=indexService.getcontentByCategory(67,1,3);
                    List<CmsContentEntity> genPages= (List<CmsContentEntity>) indexService.getcontentByCategory(cmsCategoryEntity.getId());
                    int genTotalPages = genPages.size()%pageSize>0 ? genPages.size()/pageSize+1:genPages.size()/pageSize;
                    for (int i=1;i<=genTotalPages;i++){
                        ThymeleafViewObject.contentList=getByPage(genPages,i,genTotalPages);
                        url = "http://localhost:8081/toHtml/generation/"+cmsCategoryEntity.getId();
                        if(i==1){
                            TemplateStaticUtil.urlToHtml(url,"generation.html");
                        }
                        TemplateStaticUtil.urlToHtml(url,"generation_"+i+".html");
                    }
                    for (int i=0;i<genPages.size();i++){
                        if(i==0){
                            result.put("last",new CmsContentEntity());
                        }else{
                            result.put("last",genPages.get(i-1));
                        }
                        if(i==genPages.size()-1){
                            result.put("next",new CmsContentEntity());
                        }else{
                            result.put("next",genPages.get(i+1));
                        }
                        ThymeleafViewObject.lastAndNextProgress=result;
                        ThymeleafViewObject.contentResult=genPages.get(i);
                        TemplateStaticUtil.urlToHtml("http://localhost:8081/toHtml/details/"+cmsCategoryEntity.getId()+"/"+genPages.get(i).getId(),""+categoryList+"_"+genPages.get(i).getId()+".html");
                    }

                    break;
                case "lifting":
                    url = "http://localhost:8081/toHtml/lifting/"+cmsCategoryEntity.getId();
                    TemplateStaticUtil.urlToHtml(url,"lifting.html");
                    break;
                case "construction":
                    url = "http://localhost:8081/toHtml/construction/"+cmsCategoryEntity.getId();
                    TemplateStaticUtil.urlToHtml(url,"construction.html");
                    List<ProjectDto> projectDtos = projectProcessService.getProjectList();
                    for (int i=0;i<projectDtos.size();i++){
                        if(i==0){
                            result.put("last",new ProjectProcessEntity());
                        }else{
                            result.put("last",projectDtos.get(i-1));
                        }
                        if(i==projectDtos.size()-1){
                            result.put("next",new ProjectProcessEntity());
                        }else{
                            result.put("next",projectDtos.get(i+1));
                        }
                        ThymeleafViewObject.lastAndNextProgress=result;
                        ThymeleafViewObject.contentResult=projectDtos.get(i);
                        TemplateStaticUtil.urlToHtml("http://localhost:8081/toHtml/progress/"+cmsCategoryEntity.getId()+"/"+projectDtos.get(i).getId(),"progress_"+projectDtos.get(i).getId()+".html");
                    }
                    break;
                case "lamp":
                    ThymeleafViewObject.relateCase65=indexService.getcontentByCategory(65,1,3);
                    ThymeleafViewObject.relateCase67=indexService.getcontentByCategory(67,1,3);
                    if (!(cmsCategoryEntity.getCategoryParentId()==null||cmsCategoryEntity.getCategoryParentId().equals("0"))){
                        //获取分类下所有文章
                        List<CmsContentEntity> lampPages= (List<CmsContentEntity>)indexService.getcontentByCategory(cmsCategoryEntity.getId());

                        //获取分类所有同级分类
                        List<CmsCategoryEntity> lampCategoryEntity = (List<CmsCategoryEntity>) indexService.getCaseCategory(Integer.parseInt(cmsCategoryEntity.getCategoryParentId()));
                        ThymeleafViewObject.categoryList=lampCategoryEntity;
                        if(lampPages.size()==0){
                            ThymeleafViewObject.contentList=getByPage(lampPages,1,0);
                            TemplateStaticUtil.urlToHtml( "http://localhost:8081/toHtml/lamp/"+cmsCategoryEntity.getId()+"/1","lamp/"+cmsCategoryEntity.getId()+"_"+1+".html");
                            if(lampCategoryEntity.get(0).getId().equals(cmsCategoryEntity.getId())){
                                TemplateStaticUtil.urlToHtml( "http://localhost:8081/toHtml/lamp/"+cmsCategoryEntity.getId()+"/1","lamp.html");
                            }
                        }

                        if(lampPages.size()==0){
                            if(lampCategoryEntity.get(0).getId().equals(CategoryId)){
                                ThymeleafViewObject.contentList=getByPage(lampPages,1,0);
                                TemplateStaticUtil.urlToHtml( "http://localhost:8081/toHtml/lamp/"+cmsCategoryEntity.getId()+"/1","lamp.html");
                            }
                        }
                        int lampTotalPages = lampPages.size()%pageSize>0 ? lampPages.size()/pageSize+1:lampPages.size()/pageSize;
                        if(lampCategoryEntity.get(0).getId().equals(CategoryId)){
                            ThymeleafViewObject.contentList=getByPage(lampPages,1,lampTotalPages);
                            TemplateStaticUtil.urlToHtml( "http://localhost:8081/toHtml/lamp/"+cmsCategoryEntity.getId()+"/1","lamp.html");
                        }
                        if(lampTotalPages>0){
                           for (int i=1;i<=lampTotalPages;i++){
                               ThymeleafViewObject.contentList=getByPage(lampPages,i,lampTotalPages);
                               url = "http://localhost:8081/toHtml/lamp/"+cmsCategoryEntity.getId()+"/"+i;
                               TemplateStaticUtil.urlToHtml(url,"lamp/"+cmsCategoryEntity.getId()+"_"+i+".html");
                            }
                            for (int i=0;i<lampPages.size();i++){
                                if(i==0){
                                    result.put("last",new CmsContentEntity());
                                }else{
                                    result.put("last",lampPages.get(i-1));
                                }
                                if(i==lampPages.size()-1){
                                    result.put("next",new CmsContentEntity());
                                }else{
                                    result.put("next",lampPages.get(i+1));
                                }
                                ThymeleafViewObject.lastAndNextProgress=result;
                                ThymeleafViewObject.contentResult=lampPages.get(i);
                                TemplateStaticUtil.urlToHtml("http://localhost:8081/toHtml/details/"+cmsCategoryEntity.getId()+"/"+lampPages.get(i).getId(),""+categoryList+"_"+lampPages.get(i).getId()+".html");
                            }
                        }
                    }else{
                        List<CmsCategoryEntity> cmsCategoryEntities2 = (List<CmsCategoryEntity>) indexService.getCaseCategory(cmsCategoryEntity.getId());
                        ThymeleafViewObject.categoryList=cmsCategoryEntities2;

                        for (CmsCategoryEntity lampCategory:cmsCategoryEntities2
                        ) {
                            int lampCategoryId = lampCategory.getId();
                            List<CmsContentEntity> lampPages= (List<CmsContentEntity>) indexService.getcontentByCategory(lampCategoryId);
                            int lampTotalPages = lampPages.size()%pageSize>0 ? lampPages.size()/pageSize+1:lampPages.size()/pageSize;
                            if(lampPages.size()==0){
                                ThymeleafViewObject.contentList=getByPage(lampPages,1,0);
                                TemplateStaticUtil.urlToHtml( "http://localhost:8081/toHtml/lamp/"+lampCategoryId+"/1","lamp/"+lampCategoryId+"_"+1+".html");
                                if(cmsCategoryEntities2.get(0).getId().equals(lampCategoryId)){
                                    TemplateStaticUtil.urlToHtml( "http://localhost:8081/toHtml/lamp/"+lampCategoryId+"/1","lamp.html");
                                }
                            }
                            if(cmsCategoryEntities2.get(0).getId().equals(lampCategoryId)){
                                ThymeleafViewObject.contentList=getByPage(lampPages,1,lampTotalPages);
                                TemplateStaticUtil.urlToHtml( "http://localhost:8081/toHtml/lamp/"+lampCategoryId+"/1","lamp.html");
                            }
                            if(lampTotalPages>0){
                                for (int i=1;i<=lampTotalPages;i++){
                                    ThymeleafViewObject.contentList=getByPage(lampPages,i,lampTotalPages);
                                    url = "http://localhost:8081/toHtml/lamp/"+lampCategoryId+"/"+i;
                                    TemplateStaticUtil.urlToHtml(url,"lamp/"+lampCategoryId+"_"+i+".html");
                                }
                                for (int i=0;i<lampPages.size();i++){
                                    if(i==0){
                                        result.put("last",new CmsContentEntity());
                                    }else{
                                        result.put("last",lampPages.get(i-1));
                                    }
                                    if(i==lampPages.size()-1){
                                        result.put("next",new CmsContentEntity());
                                    }else{
                                        result.put("next",lampPages.get(i+1));
                                    }
                                    ThymeleafViewObject.lastAndNextProgress=result;
                                    ThymeleafViewObject.contentResult=lampPages.get(i);
                                    TemplateStaticUtil.urlToHtml("http://localhost:8081/toHtml/details/"+cmsCategoryEntity.getId()+"/"+lampPages.get(i).getId(),""+categoryList+"_"+lampPages.get(i).getId()+".html");
                                }
                            }
                        }
                    }
                    break;
                case "case":
                    if (!(cmsCategoryEntity.getCategoryParentId()==null||cmsCategoryEntity.getCategoryParentId().equals("0"))){
                        //获取分类下所有文章
                        List<CmsContentEntity> lampPages= (List<CmsContentEntity>)indexService.getcontentByCategory(cmsCategoryEntity.getId());
                        //获取分类所有同级分类
                        List<CmsCategoryEntity> lampCategoryEntity = (List<CmsCategoryEntity>) indexService.getCaseCategory(Integer.parseInt(cmsCategoryEntity.getCategoryParentId()));
                        ThymeleafViewObject.categoryList=lampCategoryEntity;
                        int lampTotalPages = lampPages.size()%pageSize>0 ? lampPages.size()/pageSize+1:lampPages.size()/pageSize;

                        if(lampPages.size()==0){
                            ThymeleafViewObject.contentList=getByPage(lampPages,1,0);
                            TemplateStaticUtil.urlToHtml( "http://localhost:8081/toHtml/case/"+cmsCategoryEntity.getId()+"/1","case/"+cmsCategoryEntity.getId()+"_"+1+".html");
                            if(lampCategoryEntity.get(0).getId().equals(cmsCategoryEntity.getId())){
                                TemplateStaticUtil.urlToHtml( "http://localhost:8081/toHtml/case/"+cmsCategoryEntity.getId()+"/1","case.html");
                            }
                        }
                        if(lampCategoryEntity.get(0).getId().equals(CategoryId)){
                            ThymeleafViewObject.contentList=getByPage(lampPages,1,lampTotalPages);
                            TemplateStaticUtil.urlToHtml( "http://localhost:8081/toHtml/case/"+cmsCategoryEntity.getId()+"/1","case.html");
                        }
                        if(lampTotalPages>0){
                            for (int i=1;i<=lampTotalPages;i++){
                                ThymeleafViewObject.contentList=getByPage(lampPages,i,lampTotalPages);
                                url = "http://localhost:8081/toHtml/case/"+cmsCategoryEntity.getId()+"/"+i;
                                TemplateStaticUtil.urlToHtml(url,"case/"+cmsCategoryEntity.getId()+"_"+i+".html");
                            }
                            for (int i=0;i<lampPages.size();i++){
                                if(i==0){
                                    result.put("last",new CmsContentEntity());
                                }else{
                                    result.put("last",lampPages.get(i-1));
                                }
                                if(i==lampPages.size()-1){
                                    result.put("next",new CmsContentEntity());
                                }else{
                                    result.put("next",lampPages.get(i+1));
                                }
                                ThymeleafViewObject.lastAndNextProgress=result;
                                ThymeleafViewObject.contentResult=lampPages.get(i);
                                TemplateStaticUtil.urlToHtml("http://localhost:8081/toHtml/contentDetails/"+cmsCategoryEntity.getId()+"/"+lampPages.get(i).getId(),""+categoryList+"_"+lampPages.get(i).getId()+".html");
                            }
                        }
                    }else{
                        List<CmsCategoryEntity> cmsCategoryEntities2 = (List<CmsCategoryEntity>) indexService.getCaseCategory(cmsCategoryEntity.getId());
                        ThymeleafViewObject.categoryList=cmsCategoryEntities2;
                        for (CmsCategoryEntity lampCategory:cmsCategoryEntities2
                        ) {

                            int lampCategoryId = lampCategory.getId();
                            List<CmsContentEntity> lampPages= (List<CmsContentEntity>)indexService.getcontentByCategory(lampCategoryId);
                            int lampTotalPages = lampPages.size()%pageSize>0 ? lampPages.size()/pageSize+1:lampPages.size()/pageSize;
                            if(lampPages.size()==0){
                                ThymeleafViewObject.contentList=getByPage(lampPages,1,0);
                                TemplateStaticUtil.urlToHtml( "http://localhost:8081/toHtml/case/"+lampCategoryId+"/1","case/"+lampCategoryId+"_"+1+".html");
                                if(cmsCategoryEntities2.get(0).getId().equals(lampCategoryId)){
                                    TemplateStaticUtil.urlToHtml( "http://localhost:8081/toHtml/case/"+lampCategoryId+"/1","case.html");
                                }
                            }
                            if(cmsCategoryEntities2.get(0).getId().equals(lampCategoryId)){
                                ThymeleafViewObject.contentList= getByPage(lampPages,1,lampTotalPages);
                                TemplateStaticUtil.urlToHtml( "http://localhost:8081/toHtml/case/"+lampCategoryId+"/1","case.html");
                            }
                            if(lampTotalPages>0){
                                for (int i=1;i<=lampTotalPages;i++){
                                    ThymeleafViewObject.contentList=getByPage(lampPages,i,lampTotalPages);
                                    url = "http://localhost:8081/toHtml/case/"+lampCategoryId+"/"+i;
                                    TemplateStaticUtil.urlToHtml(url,"case/"+lampCategoryId+"_"+i+".html");
                                }
                                for (int i=0;i<lampPages.size();i++){
                                    if(i==0){
                                        result.put("last",new CmsContentEntity());
                                    }else{
                                        result.put("last",lampPages.get(i-1));
                                    }
                                    if(i==lampPages.size()-1){
                                        result.put("next",new CmsContentEntity());
                                    }else{
                                        result.put("next",lampPages.get(i+1));
                                    }
                                    ThymeleafViewObject.lastAndNextProgress=result;
                                    ThymeleafViewObject.contentResult=lampPages.get(i);
                                    TemplateStaticUtil.urlToHtml("http://localhost:8081/toHtml/contentDetails/"+cmsCategoryEntity.getId()+"/"+lampPages.get(i).getId(),""+categoryList+"_"+lampPages.get(i).getId()+".html");
                                }
                            }
                        }
                    }
                    break;
                case "news":
                    if (!(cmsCategoryEntity.getCategoryParentId()==null||cmsCategoryEntity.getCategoryParentId().equals("0"))){
                        //获取分类下所有文章
                        List<CmsContentEntity> lampPages= (List<CmsContentEntity>)indexService.getcontentByCategory(cmsCategoryEntity.getId());
                        //获取分类所有同级分类
                        List<CmsCategoryEntity> lampCategoryEntity = (List<CmsCategoryEntity>) indexService.getCaseCategory(Integer.parseInt(cmsCategoryEntity.getCategoryParentId()));
                        ThymeleafViewObject.categoryList=lampCategoryEntity;
                        if(lampPages.size()==0){
                            ThymeleafViewObject.contentList=getByPage(lampPages,1,0);
                            TemplateStaticUtil.urlToHtml( "http://localhost:8081/toHtml/news/"+cmsCategoryEntity.getId()+"/1","news/"+cmsCategoryEntity.getId()+"_"+1+".html");
                            if(lampCategoryEntity.get(0).getId().equals(cmsCategoryEntity.getId())){
                                TemplateStaticUtil.urlToHtml( "http://localhost:8081/toHtml/news/"+cmsCategoryEntity.getId()+"/1","news.html");
                            }
                        }

                        int lampTotalPages = lampPages.size()%pageSize>0 ? lampPages.size()/pageSize+1:lampPages.size()/pageSize;
                        if(lampCategoryEntity.get(0).getId().equals(CategoryId)){
                            ThymeleafViewObject.contentList=getByPage(lampPages,1,lampTotalPages);
                            TemplateStaticUtil.urlToHtml( "http://localhost:8081/toHtml/news/"+cmsCategoryEntity.getId()+"/1","news.html");
                        }
                        if(lampTotalPages>0){
                            for (int i=1;i<=lampTotalPages;i++){
                                ThymeleafViewObject.contentList=getByPage(lampPages,i,lampTotalPages);
                                url = "http://localhost:8081/toHtml/news/"+cmsCategoryEntity.getId()+"/"+i;
                                TemplateStaticUtil.urlToHtml(url,"news/"+cmsCategoryEntity.getId()+"_"+i+".html");
                            }
                            for (int i=0;i<lampPages.size();i++){
                                if(i==0){
                                    result.put("last",new CmsContentEntity());
                                }else{
                                    result.put("last",lampPages.get(i-1));
                                }
                                if(i==lampPages.size()-1){
                                    result.put("next",new CmsContentEntity());
                                }else{
                                    result.put("next",lampPages.get(i+1));
                                }
                                ThymeleafViewObject.lastAndNextProgress=result;
                                ThymeleafViewObject.contentResult=lampPages.get(i);
                                TemplateStaticUtil.urlToHtml("http://localhost:8081/toHtml/contentDetails/"+cmsCategoryEntity.getId()+"/"+lampPages.get(i).getId(),""+categoryList+"_"+lampPages.get(i).getId()+".html");
                            }
                        }
                    }else{
                        List<CmsCategoryEntity> cmsCategoryEntities2 = (List<CmsCategoryEntity>) indexService.getCaseCategory(cmsCategoryEntity.getId());
                        ThymeleafViewObject.categoryList=cmsCategoryEntities2;
                        for (CmsCategoryEntity lampCategory:cmsCategoryEntities2
                        ) {
                            int lampCategoryId = lampCategory.getId();
                            List<CmsContentEntity> lampPages= (List<CmsContentEntity>) indexService.getcontentByCategory(lampCategoryId);
                            int lampTotalPages = lampPages.size()%pageSize>0 ? lampPages.size()/pageSize+1:lampPages.size()/pageSize;
                            if(lampPages.size()==0){
                                ThymeleafViewObject.contentList=getByPage(lampPages,1,0);
                                TemplateStaticUtil.urlToHtml( "http://localhost:8081/toHtml/news/"+lampCategoryId+"/1","news/"+lampCategoryId+"_"+1+".html");
                                if(cmsCategoryEntities2.get(0).getId().equals(lampCategoryId)){
                                    TemplateStaticUtil.urlToHtml( "http://localhost:8081/toHtml/news/"+lampCategoryId+"/1","news.html");
                                }
                            }
                            if(cmsCategoryEntities2.get(0).getId().equals(lampCategoryId)){
                                ThymeleafViewObject.contentList=getByPage(lampPages,1,lampTotalPages);
                                TemplateStaticUtil.urlToHtml( "http://localhost:8081/toHtml/news/"+lampCategoryId+"/1","news.html");
                            }
                            if(lampTotalPages>0){
                                for (int i=1;i<=lampTotalPages;i++){
                                    ThymeleafViewObject.contentList=getByPage(lampPages,i,lampTotalPages);
                                    url = "http://localhost:8081/toHtml/news/"+lampCategoryId+"/"+i;
                                    TemplateStaticUtil.urlToHtml(url,"news/"+lampCategoryId+"_"+i+".html");
                                }
                                for (int i=0;i<lampPages.size();i++){
                                    if(i==0){
                                        result.put("last",new CmsContentEntity());
                                    }else{
                                        result.put("last",lampPages.get(i-1));
                                    }
                                    if(i==lampPages.size()-1){
                                        result.put("next",new CmsContentEntity());
                                    }else{
                                        result.put("next",lampPages.get(i+1));
                                    }
                                    ThymeleafViewObject.lastAndNextProgress=result;
                                    ThymeleafViewObject.contentResult=lampPages.get(i);
                                    TemplateStaticUtil.urlToHtml("http://localhost:8081/toHtml/contentDetails/"+cmsCategoryEntity.getId()+"/"+lampPages.get(i).getId(),""+categoryList+"_"+lampPages.get(i).getId()+".html");
                                }
                            }
                        }
                    }
                    break;
                case "contact":
                    url = "http://localhost:8081/toHtml/contact/"+cmsCategoryEntity.getId();
                    TemplateStaticUtil.urlToHtml(url,"contact.html");
                    break;
                default:
                    break;
            }

        }else {
            for (CmsCategoryEntity categoryItem:headerList) {
                //获取当前页面
                CmsCategoryEntity cmsCategoryEntity = indexService.getById(categoryItem.getId());
                List<CmsCategoryEntity> cmsCategoryEntities;
                if(cmsCategoryEntity.getCategoryParentId()!=null && !("0").equals(cmsCategoryEntity.getCategoryParentId())){
                    //只更新子栏目
                    header = indexService.getById(Integer.parseInt(cmsCategoryEntity.getCategoryParentId()));
                    cmsCategoryEntities = (List<CmsCategoryEntity>) indexService.getCaseCategory(Integer.parseInt(cmsCategoryEntity.getCategoryParentId()));
                    ThymeleafViewObject.header=header;
                    ThymeleafViewObject.categoryList = cmsCategoryEntities;
                }else{
                    header = indexService.getById(categoryItem.getId());
                    ThymeleafViewObject.header=header;
                    cmsCategoryEntities = (List<CmsCategoryEntity>) indexService.getCaseCategory(categoryItem.getId());
                    ThymeleafViewObject.categoryList = cmsCategoryEntities;
                }
                String url = "";
                String template = cmsCategoryEntity.getCategoryUrl().substring(0,cmsCategoryEntity.getCategoryUrl().length()-5);
                String categoryList = cmsCategoryEntity.getCategoryListUrl().substring(0,cmsCategoryEntity.getCategoryListUrl().length()-5);
                Map<String,Object> result = new HashMap<>();
                switch (template){
                    case "index":
                        url = "http://localhost:8081/toHtml/index/"+categoryItem.getId();
                        TemplateStaticUtil.urlToHtml(url,"index.html");
                        break;
                    case "banner":
                        url = "http://localhost:8081/toHtml/index/"+categoryItem.getId();
                        TemplateStaticUtil.urlToHtml(url,"index.html");
                        break;
                    case "about":
                        if (!(cmsCategoryEntity.getCategoryParentId()==null||cmsCategoryEntity.getCategoryParentId().equals("0"))){
                            url = "http://localhost:8081/toHtml/about/"+cmsCategoryEntity.getCategoryParentId();
                            TemplateStaticUtil.urlToHtml(url,"about.html");

                        }else{
                            url = "http://localhost:8081/toHtml/about/"+cmsCategoryEntity.getId();
                            TemplateStaticUtil.urlToHtml(url,"about.html");
                        }
                        break;
                    case "generation":
                        ThymeleafViewObject.relateCase65=indexService.getcontentByCategory(65,1,3);
                        ThymeleafViewObject.relateCase67=indexService.getcontentByCategory(67,1,3);
                        List<CmsContentEntity> genPages= (List<CmsContentEntity>) indexService.getcontentByCategory(cmsCategoryEntity.getId());
                        int genTotalPages = genPages.size()%pageSize>0 ? genPages.size()/pageSize+1:genPages.size()/pageSize;
                        for (int i=1;i<=genTotalPages;i++){
                            ThymeleafViewObject.contentList=getByPage(genPages,i,genTotalPages);
                            url = "http://localhost:8081/toHtml/generation/"+cmsCategoryEntity.getId();
                            if(i==1){
                                TemplateStaticUtil.urlToHtml(url,"generation.html");
                            }
                            TemplateStaticUtil.urlToHtml(url,"generation_"+i+".html");
                        }
                        for (int i=0;i<genPages.size();i++){
                            if(i==0){
                                result.put("last",new CmsContentEntity());
                            }else{
                                result.put("last",genPages.get(i-1));
                            }
                            if(i==genPages.size()-1){
                                result.put("next",new CmsContentEntity());
                            }else{
                                result.put("next",genPages.get(i+1));
                            }
                            ThymeleafViewObject.lastAndNextProgress=result;
                            ThymeleafViewObject.contentResult=genPages.get(i);
                            TemplateStaticUtil.urlToHtml("http://localhost:8081/toHtml/details/"+cmsCategoryEntity.getId()+"/"+genPages.get(i).getId(),""+categoryList+"_"+genPages.get(i).getId()+".html");
                        }

                        break;
                    case "lifting":
                        url = "http://localhost:8081/toHtml/lifting/"+cmsCategoryEntity.getId();
                        TemplateStaticUtil.urlToHtml(url,"lifting.html");
                        break;
                    case "construction":
                        url = "http://localhost:8081/toHtml/construction/"+cmsCategoryEntity.getId();
                        TemplateStaticUtil.urlToHtml(url,"construction.html");
                        List<ProjectDto> projectDtos = projectProcessService.getProjectList();
                        for (int i=0;i<projectDtos.size();i++){
                            if(i==0){
                                result.put("last",new ProjectProcessEntity());
                            }else{
                                result.put("last",projectDtos.get(i-1));
                            }
                            if(i==projectDtos.size()-1){
                                result.put("next",new ProjectProcessEntity());
                            }else{
                                result.put("next",projectDtos.get(i+1));
                            }
                            ThymeleafViewObject.lastAndNextProgress=result;
                            ThymeleafViewObject.contentResult=projectDtos.get(i);
                            TemplateStaticUtil.urlToHtml("http://localhost:8081/toHtml/progress/"+cmsCategoryEntity.getId()+"/"+projectDtos.get(i).getId(),"progress_"+projectDtos.get(i).getId()+".html");
                        }
                        break;
                    case "lamp":
                        ThymeleafViewObject.relateCase65=indexService.getcontentByCategory(65,1,3);
                        ThymeleafViewObject.relateCase67=indexService.getcontentByCategory(67,1,3);
                        if (!(cmsCategoryEntity.getCategoryParentId()==null||cmsCategoryEntity.getCategoryParentId().equals("0"))){
                            //获取分类下所有文章
                            List<CmsContentEntity> lampPages= (List<CmsContentEntity>)indexService.getcontentByCategory(cmsCategoryEntity.getId());
                            //获取分类所有同级分类
                            List<CmsCategoryEntity> lampCategoryEntity = (List<CmsCategoryEntity>) indexService.getCaseCategory(Integer.parseInt(cmsCategoryEntity.getCategoryParentId()));
                            ThymeleafViewObject.categoryList=lampCategoryEntity;

                            if(lampPages.size()==0){
                                ThymeleafViewObject.contentList=getByPage(lampPages,1,0);
                                TemplateStaticUtil.urlToHtml( "http://localhost:8081/toHtml/lamp/"+cmsCategoryEntity.getId()+"/1","lamp/"+cmsCategoryEntity.getId()+"_"+1+".html");
                                if(lampCategoryEntity.get(0).getId().equals(cmsCategoryEntity.getId())){
                                    TemplateStaticUtil.urlToHtml( "http://localhost:8081/toHtml/lamp/"+cmsCategoryEntity.getId()+"/1","lamp.html");
                                }
                            }
                            int lampTotalPages = lampPages.size()%pageSize>0 ? lampPages.size()/pageSize+1:lampPages.size()/pageSize;
                            if(lampCategoryEntity.get(0).getId().equals(categoryItem.getId())){
                                ThymeleafViewObject.contentList=getByPage(lampPages,1,lampTotalPages);
                                TemplateStaticUtil.urlToHtml( "http://localhost:8081/toHtml/lamp/"+cmsCategoryEntity.getId()+"/1","lamp.html");
                            }
                            if(lampTotalPages>0){
                                for (int i=1;i<=lampTotalPages;i++){
                                    ThymeleafViewObject.contentList=getByPage(lampPages,i,lampTotalPages);
                                    url = "http://localhost:8081/toHtml/lamp/"+cmsCategoryEntity.getId()+"/"+i;
                                    TemplateStaticUtil.urlToHtml(url,"lamp/"+cmsCategoryEntity.getId()+"_"+i+".html");
                                }
                                for (int i=0;i<lampPages.size();i++){
                                    if(i==0){
                                        result.put("last",new CmsContentEntity());
                                    }else{
                                        result.put("last",lampPages.get(i-1));
                                    }
                                    if(i==lampPages.size()-1){
                                        result.put("next",new CmsContentEntity());
                                    }else{
                                        result.put("next",lampPages.get(i+1));
                                    }
                                    ThymeleafViewObject.lastAndNextProgress=result;
                                    ThymeleafViewObject.contentResult=lampPages.get(i);
                                    TemplateStaticUtil.urlToHtml("http://localhost:8081/toHtml/details/"+cmsCategoryEntity.getId()+"/"+lampPages.get(i).getId(),""+categoryList+"_"+lampPages.get(i).getId()+".html");
                                }
                            }
                        }else{
                            List<CmsCategoryEntity> cmsCategoryEntities2 = (List<CmsCategoryEntity>) indexService.getCaseCategory(cmsCategoryEntity.getId());
                            ThymeleafViewObject.categoryList=cmsCategoryEntities2;
                            PageInfo<CmsContentEntity> pageInfo = new PageInfo<>();
                            for (CmsCategoryEntity lampCategory:cmsCategoryEntities2
                            ) {
                                int lampCategoryId = lampCategory.getId();
                                List<CmsContentEntity> lampPages= (List<CmsContentEntity>)indexService.getcontentByCategory(lampCategoryId);
                                int lampTotalPages = lampPages.size()%pageSize>0 ? lampPages.size()/pageSize+1:lampPages.size()/pageSize;
                                if(lampPages.size()==0){
                                    ThymeleafViewObject.contentList=getByPage(lampPages,1,0);
                                    TemplateStaticUtil.urlToHtml( "http://localhost:8081/toHtml/lamp/"+lampCategoryId+"/1","lamp/"+lampCategoryId+"_"+1+".html");
                                    if(cmsCategoryEntities2.get(0).getId().equals(lampCategoryId)){
                                        TemplateStaticUtil.urlToHtml( "http://localhost:8081/toHtml/lamp/"+lampCategoryId+"/1","lamp.html");
                                    }
                                }
                                pageInfo.setPages(lampTotalPages);
                                if(cmsCategoryEntities2.get(0).getId().equals(lampCategoryId)){
                                    ThymeleafViewObject.contentList=getByPage(lampPages,1,lampTotalPages);
                                    TemplateStaticUtil.urlToHtml( "http://localhost:8081/toHtml/lamp/"+lampCategoryId+"/1","lamp.html");
                                }

                                if(lampTotalPages>0){
                                    for (int i=1;i<=lampTotalPages;i++){
                                        ThymeleafViewObject.contentList=getByPage(lampPages,i,lampTotalPages);
                                        url = "http://localhost:8081/toHtml/lamp/"+lampCategoryId+"/"+i;
                                        TemplateStaticUtil.urlToHtml(url,"lamp/"+lampCategoryId+"_"+i+".html");
                                    }
                                    for (int i=0;i<lampPages.size();i++){
                                        if(i==0){
                                            result.put("last",new CmsContentEntity());
                                        }else{
                                            result.put("last",lampPages.get(i-1));
                                        }
                                        if(i==lampPages.size()-1){
                                            result.put("next",new CmsContentEntity());
                                        }else{
                                            result.put("next",lampPages.get(i+1));
                                        }
                                        ThymeleafViewObject.lastAndNextProgress=result;
                                        ThymeleafViewObject.contentResult=lampPages.get(i);
                                        TemplateStaticUtil.urlToHtml("http://localhost:8081/toHtml/details/"+cmsCategoryEntity.getId()+"/"+lampPages.get(i).getId(),""+categoryList+"_"+lampPages.get(i).getId()+".html");
                                    }
                                }
                            }
                        }
                        break;
                    case "case":
                        if (!(cmsCategoryEntity.getCategoryParentId()==null||cmsCategoryEntity.getCategoryParentId().equals("0"))){
                            //获取分类下所有文章
                            List<CmsContentEntity> lampPages= (List<CmsContentEntity>)indexService.getcontentByCategory(cmsCategoryEntity.getId());
                            //获取分类所有同级分类
                            List<CmsCategoryEntity> lampCategoryEntity = (List<CmsCategoryEntity>) indexService.getCaseCategory(Integer.parseInt(cmsCategoryEntity.getCategoryParentId()));

                            ThymeleafViewObject.categoryList=lampCategoryEntity;
                            if(lampPages.size()==0){
                                ThymeleafViewObject.contentList=getByPage(lampPages,1,0);
                                TemplateStaticUtil.urlToHtml( "http://localhost:8081/toHtml/case/"+cmsCategoryEntity.getId()+"/1","case/"+cmsCategoryEntity.getId()+"_"+1+".html");
                                if(lampCategoryEntity.get(0).getId().equals(cmsCategoryEntity.getId())){
                                    TemplateStaticUtil.urlToHtml( "http://localhost:8081/toHtml/case/"+cmsCategoryEntity.getId()+"/1","case.html");
                                }
                            }
                            int lampTotalPages = lampPages.size()%pageSize>0 ? lampPages.size()/pageSize+1:lampPages.size()/pageSize;
                            if(lampCategoryEntity.get(0).getId().equals(categoryItem.getId())){
                                ThymeleafViewObject.contentList=getByPage(lampPages,1,lampTotalPages);
                                TemplateStaticUtil.urlToHtml( "http://localhost:8081/toHtml/case/"+cmsCategoryEntity.getId()+"/1","case.html");
                            }
                            if(lampTotalPages>0){
                                for (int i=1;i<=lampTotalPages;i++){
                                    ThymeleafViewObject.contentList=getByPage(lampPages,i,lampTotalPages);
                                    url = "http://localhost:8081/toHtml/case/"+cmsCategoryEntity.getId()+"/"+i;
                                    TemplateStaticUtil.urlToHtml(url,"case/"+cmsCategoryEntity.getId()+"_"+i+".html");
                                }
                                for (int i=0;i<lampPages.size();i++){
                                    if(i==0){
                                        result.put("last",new CmsContentEntity());
                                    }else{
                                        result.put("last",lampPages.get(i-1));
                                    }
                                    if(i==lampPages.size()-1){
                                        result.put("next",new CmsContentEntity());
                                    }else{
                                        result.put("next",lampPages.get(i+1));
                                    }
                                    ThymeleafViewObject.lastAndNextProgress=result;
                                    ThymeleafViewObject.contentResult=lampPages.get(i);
                                    TemplateStaticUtil.urlToHtml("http://localhost:8081/toHtml/contentDetails/"+cmsCategoryEntity.getId()+"/"+lampPages.get(i).getId(),""+categoryList+"_"+lampPages.get(i).getId()+".html");
                                }
                            }
                        }else{
                            List<CmsCategoryEntity> cmsCategoryEntities2 = (List<CmsCategoryEntity>) indexService.getCaseCategory(cmsCategoryEntity.getId());
                            ThymeleafViewObject.categoryList=cmsCategoryEntities2;

                            for (CmsCategoryEntity lampCategory:cmsCategoryEntities2
                            ) {
                                int lampCategoryId = lampCategory.getId();
                                List<CmsContentEntity> lampPages= (List<CmsContentEntity>) indexService.getcontentByCategory(lampCategoryId);
                                int lampTotalPages = lampPages.size()%pageSize>0 ? lampPages.size()/pageSize+1:lampPages.size()/pageSize;
                                if(lampPages.size()==0){
                                    ThymeleafViewObject.contentList=getByPage(lampPages,1,0);
                                    TemplateStaticUtil.urlToHtml( "http://localhost:8081/toHtml/case/"+lampCategoryId+"/1","case/"+lampCategoryId+"_"+1+".html");
                                    if(cmsCategoryEntities2.get(0).getId().equals(lampCategoryId)){
                                        TemplateStaticUtil.urlToHtml( "http://localhost:8081/toHtml/case/"+lampCategoryId+"/1","case.html");
                                    }
                                }
                                if(cmsCategoryEntities2.get(0).getId().equals(lampCategoryId)){
                                    ThymeleafViewObject.contentList=getByPage(lampPages,1,lampTotalPages);
                                    TemplateStaticUtil.urlToHtml( "http://localhost:8081/toHtml/case/"+lampCategoryId+"/1","case.html");
                                }

                                if(lampTotalPages>0){
                                    for (int i=1;i<=lampTotalPages;i++){
                                        ThymeleafViewObject.contentList=getByPage(lampPages,i,lampTotalPages);
                                        url = "http://localhost:8081/toHtml/case/"+lampCategoryId+"/"+i;
                                        TemplateStaticUtil.urlToHtml(url,"case/"+lampCategoryId+"_"+i+".html");
                                    }
                                    for (int i=0;i<lampPages.size();i++){
                                        if(i==0){
                                            result.put("last",new CmsContentEntity());
                                        }else{
                                            result.put("last",lampPages.get(i-1));
                                        }
                                        if(i==lampPages.size()-1){
                                            result.put("next",new CmsContentEntity());
                                        }else{
                                            result.put("next",lampPages.get(i+1));
                                        }
                                        ThymeleafViewObject.lastAndNextProgress=result;
                                        ThymeleafViewObject.contentResult=lampPages.get(i);
                                        TemplateStaticUtil.urlToHtml("http://localhost:8081/toHtml/contentDetails/"+cmsCategoryEntity.getId()+"/"+lampPages.get(i).getId(),""+categoryList+"_"+lampPages.get(i).getId()+".html");
                                    }
                                }
                            }
                        }
                        break;
                    case "news":
                        if (!(cmsCategoryEntity.getCategoryParentId()==null||cmsCategoryEntity.getCategoryParentId().equals("0"))){
                            //获取分类下所有文章
                            List<CmsContentEntity> lampPages= (List<CmsContentEntity>)indexService.getcontentByCategory(cmsCategoryEntity.getId());
                            //获取分类所有同级分类
                            List<CmsCategoryEntity> lampCategoryEntity = (List<CmsCategoryEntity>) indexService.getCaseCategory(Integer.parseInt(cmsCategoryEntity.getCategoryParentId()));
                            ThymeleafViewObject.categoryList=lampCategoryEntity;
                            if(lampPages.size()==0){
                                ThymeleafViewObject.contentList=getByPage(lampPages,1,0);
                                TemplateStaticUtil.urlToHtml( "http://localhost:8081/toHtml/news/"+cmsCategoryEntity.getId()+"/1","news/"+cmsCategoryEntity.getId()+"_"+1+".html");
                                if(lampCategoryEntity.get(0).getId().equals(cmsCategoryEntity.getId())){
                                    TemplateStaticUtil.urlToHtml( "http://localhost:8081/toHtml/news/"+cmsCategoryEntity.getId()+"/1","news.html");
                                }
                            }
                            int lampTotalPages = lampPages.size()%pageSize>0 ? lampPages.size()/pageSize+1:lampPages.size()/pageSize;
                            if(lampCategoryEntity.get(0).getId().equals(CategoryId)){
                                ThymeleafViewObject.contentList=getByPage(lampPages,1,lampTotalPages);
                                TemplateStaticUtil.urlToHtml( "http://localhost:8081/toHtml/news/"+cmsCategoryEntity.getId()+"/1","news.html");
                            }

                            if(lampTotalPages>0){
                                for (int i=1;i<=lampTotalPages;i++){

                                    url = "http://localhost:8081/toHtml/news/"+cmsCategoryEntity.getId()+"/"+i;
                                    TemplateStaticUtil.urlToHtml(url,"news/"+cmsCategoryEntity.getId()+"_"+i+".html");
                                }
                                for (int i=0;i<lampPages.size();i++){
                                    if(i==0){
                                        result.put("last",new CmsContentEntity());
                                    }else{
                                        result.put("last",lampPages.get(i-1));
                                    }
                                    if(i==lampPages.size()-1){
                                        result.put("next",new CmsContentEntity());
                                    }else{
                                        result.put("next",lampPages.get(i+1));
                                    }
                                    ThymeleafViewObject.lastAndNextProgress=result;
                                    ThymeleafViewObject.contentResult=lampPages.get(i);
                                    TemplateStaticUtil.urlToHtml("http://localhost:8081/toHtml/contentDetails/"+cmsCategoryEntity.getId()+"/"+lampPages.get(i).getId(),""+categoryList+"_"+lampPages.get(i).getId()+".html");
                                }
                            }
                        }else{
                            List<CmsCategoryEntity> cmsCategoryEntities2 = (List<CmsCategoryEntity>) indexService.getCaseCategory(cmsCategoryEntity.getId());
                            ThymeleafViewObject.categoryList=cmsCategoryEntities2;
                            for (CmsCategoryEntity lampCategory:cmsCategoryEntities2
                            ) {
                                int lampCategoryId = lampCategory.getId();
                                List<CmsContentEntity> lampPages= (List<CmsContentEntity>) indexService.getcontentByCategory(lampCategoryId);
                                int lampTotalPages = lampPages.size()%pageSize>0 ? lampPages.size()/pageSize+1:lampPages.size()/pageSize;

                                if(lampPages.size()==0){
                                    ThymeleafViewObject.contentList=getByPage(lampPages,1,0);
                                    TemplateStaticUtil.urlToHtml( "http://localhost:8081/toHtml/news/"+lampCategoryId+"/1","news/"+lampCategoryId+"_"+1+".html");
                                    if(cmsCategoryEntities2.get(0).getId().equals(lampCategoryId)){
                                        TemplateStaticUtil.urlToHtml( "http://localhost:8081/toHtml/news/"+lampCategoryId+"/1","news.html");
                                    }
                                }
                                if(cmsCategoryEntities2.get(0).getId().equals(lampCategoryId)){
                                    ThymeleafViewObject.contentList=getByPage(lampPages,1,lampTotalPages);
                                    TemplateStaticUtil.urlToHtml( "http://localhost:8081/toHtml/news/"+lampCategoryId+"/1","news.html");
                                }
                                if(lampTotalPages>0){
                                    for (int i=1;i<=lampTotalPages;i++){
                                        ThymeleafViewObject.contentList=getByPage(lampPages,i,lampTotalPages);
                                        url = "http://localhost:8081/toHtml/news/"+lampCategoryId+"/"+i;
                                        TemplateStaticUtil.urlToHtml(url,"news/"+lampCategoryId+"_"+i+".html");
                                    }
                                    for (int i=0;i<lampPages.size();i++){
                                        if(i==0){
                                            result.put("last",new CmsContentEntity());
                                        }else{
                                            result.put("last",lampPages.get(i-1));
                                        }
                                        if(i==lampPages.size()-1){
                                            result.put("next",new CmsContentEntity());
                                        }else{
                                            result.put("next",lampPages.get(i+1));
                                        }
                                        ThymeleafViewObject.lastAndNextProgress=result;
                                        ThymeleafViewObject.contentResult=lampPages.get(i);
                                        TemplateStaticUtil.urlToHtml("http://localhost:8081/toHtml/contentDetails/"+cmsCategoryEntity.getId()+"/"+lampPages.get(i).getId(),""+categoryList+"_"+lampPages.get(i).getId()+".html");
                                    }
                                }
                            }
                        }
                        break;
                    case "contact":
                        url = "http://localhost:8081/toHtml/contact/"+cmsCategoryEntity.getId();
                        TemplateStaticUtil.urlToHtml(url,"contact.html");
                        break;
                    default:
                        break;
                }
            }
        }
        generateTags();
    }

    private PageInfo<CmsContentEntity> getByPage(List<CmsContentEntity> contentEntities,Integer pageNum,Integer totalPages){

        PageInfo<CmsContentEntity> pageInfo = new PageInfo<>();
        pageInfo.setPages(totalPages);
        pageInfo.setPageSize(pageSize);
        pageInfo.setTotal(contentEntities.size());
        if(pageNum<totalPages){
            if(pageNum != 1){
                pageInfo.setIsFirstPage(true);
                pageInfo.setPrePage(pageNum-1);
            }
            pageInfo.setHasPreviousPage(true);
            pageInfo.setNextPage(pageNum + 1);
            pageInfo.setHasNextPage(true);
            pageInfo.setList(contentEntities.subList((pageNum-1)*pageSize,pageNum*pageSize));
            return pageInfo;
        }else{
            pageInfo.setIsLastPage(true);
            pageInfo.setHasPreviousPage(true);
            List<CmsContentEntity> contentEntities2 = contentEntities.subList((pageNum-1)*pageSize,contentEntities.size());
            pageInfo.setList(contentEntities2);
            return pageInfo;
        }
    }
}
