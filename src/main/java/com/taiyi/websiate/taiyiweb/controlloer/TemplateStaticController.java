package com.taiyi.websiate.taiyiweb.controlloer;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.sun.javafx.logging.JFRInputEvent;
import com.taiyi.websiate.taiyiweb.dto.ProjectDto;
import com.taiyi.websiate.taiyiweb.entity.CmsCategoryEntity;
import com.taiyi.websiate.taiyiweb.entity.CmsContentEntity;
import com.taiyi.websiate.taiyiweb.entity.TagsEntity;
import com.taiyi.websiate.taiyiweb.servcice.FooterService;
import com.taiyi.websiate.taiyiweb.servcice.IndexService;
import com.taiyi.websiate.taiyiweb.servcice.ProjectProcessService;
import com.taiyi.websiate.taiyiweb.utils.TemplateStaticUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/generate")
public class TemplateStaticController {
    @Autowired
    IndexService indexService;
    @Autowired
    FooterService footerService;
    @Autowired
    private ProjectProcessService projectProcessService;

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
                    url = "http://localhost:8082/toHtml/lable/"+tag.getId()+"/"+i;
                    TemplateStaticUtil.urlToHtml(url,"E:\\html\\lable\\"+tag.getId()+"_"+i+".html");
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
    @RequestMapping("/{CategoryId}/genernateColumn")
    @ResponseBody
    public void genernateColumn(HttpServletRequest request, HttpServletResponse response, @PathVariable int CategoryId) throws IOException {
        // 获取站点id
        List<CmsCategoryEntity> columns = new ArrayList<CmsCategoryEntity>();
        String url = "";

        // 如果栏目id小于0则更新所有的栏目，否则只更新选中的栏目
        if (CategoryId>0) {
            CmsCategoryEntity cmsCategoryEntity = (CmsCategoryEntity) indexService.getCaseCategory(CategoryId);
            String template = cmsCategoryEntity.getCategoryUrl().substring(0,cmsCategoryEntity.getCategoryUrl().length()-5);
            String categoryList = cmsCategoryEntity.getCategoryListUrl().substring(0,cmsCategoryEntity.getCategoryListUrl().length()-5);
            switch (template){
                case "index":
                    url = "http://localhost:8082/toHtml/index/"+CategoryId;
                    TemplateStaticUtil.urlToHtml(url,"E:\\html\\index.html");
                    break;
                case "about":
                    if (!(cmsCategoryEntity.getCategoryParentId()==null||cmsCategoryEntity.getCategoryParentId().equals("0"))){
                        url = "http://localhost:8082/toHtml/about/"+cmsCategoryEntity.getCategoryParentId();
                        TemplateStaticUtil.urlToHtml(url,"E:\\html\\about.html");

                    }else{
                        url = "http://localhost:8082/toHtml/about/"+cmsCategoryEntity.getId();
                        TemplateStaticUtil.urlToHtml(url,"E:\\html\\about.html");
                    }
                    break;
                case "generation":
                    url = "http://localhost:8082/toHtml/generation/"+cmsCategoryEntity.getId();
                    TemplateStaticUtil.urlToHtml(url,"E:\\html\\generation.html");
                    PageInfo<CmsContentEntity> pages= (PageInfo<CmsContentEntity>) indexService.getcontentByCategory(cmsCategoryEntity.getId(),1,200);
                    for (CmsContentEntity contentItem:pages.getList()
                    ) {

                        TemplateStaticUtil.urlToHtml("http://localhost:8082/toHtml/details/"+cmsCategoryEntity.getId()+"/"+contentItem.getId(),"E:\\html\\"+categoryList+"_"+contentItem.getId()+".html");
                    }
                    break;
                case "lifting":
                    url = "http://localhost:8082/toHtml/lifting/"+cmsCategoryEntity.getId();
                    TemplateStaticUtil.urlToHtml(url,"E:\\html\\lifting.html");
                    break;
                case "construction":
                    url = "http://localhost:8082/toHtml/construction/"+cmsCategoryEntity.getId();
                    TemplateStaticUtil.urlToHtml(url,"E:\\html\\construction.html");
                    List<ProjectDto> projectDtos = projectProcessService.getProjectList();
                    for (ProjectDto projectItem:projectDtos
                    ) {
                        TemplateStaticUtil.urlToHtml("http://localhost:8082/toHtml/progress/"+cmsCategoryEntity.getId()+"/"+projectItem.getId(),"E:\\html\\progress_"+projectItem.getId()+".html");
                    }
                    break;
                case "lamp":
                    if (!(cmsCategoryEntity.getCategoryParentId()==null||cmsCategoryEntity.getCategoryParentId().equals("0"))){
                        PageInfo<CmsContentEntity> lampPages= (PageInfo<CmsContentEntity>)indexService.getcontentByCategory(cmsCategoryEntity.getId(),1,null);
                        int lampTotalPages = lampPages.getPages();
                        if(lampTotalPages>0){
                            TemplateStaticUtil.urlToHtml( "http://localhost:8082/toHtml/lamp/"+cmsCategoryEntity.getId()+"/1","E:\\html\\lamp.html");
                            for (int i=1;i<=lampTotalPages;i++){
                                url = "http://localhost:8082/toHtml/lamp/"+CategoryId+"/"+i;
                                TemplateStaticUtil.urlToHtml(url,"E:\\html\\lamp\\"+cmsCategoryEntity.getId()+"_"+i+".html");
                                PageInfo<CmsContentEntity> lampDetailsPages= (PageInfo<CmsContentEntity>)indexService.getcontentByCategory(cmsCategoryEntity.getId(),i,null);
                                for (CmsContentEntity contentItem:lampDetailsPages.getList()
                                ) {

                                    TemplateStaticUtil.urlToHtml("http://localhost:8082/toHtml/details/"+cmsCategoryEntity.getId()+"/"+contentItem.getId(),"E:\\html\\details_"+contentItem.getId()+".html");
                                }
                            }
                        }
                    }else{
                        url = "http://localhost:8082/toHtml/about/"+cmsCategoryEntity.getId();
                        List<CmsCategoryEntity> cmsCategoryEntities2 = (List<CmsCategoryEntity>) indexService.getCaseCategory(cmsCategoryEntity.getId());
                        TemplateStaticUtil.urlToHtml( "http://localhost:8082/toHtml/lamp/"+cmsCategoryEntities2.get(0).getId()+"/1","E:\\html\\lamp.html");
                        for (CmsCategoryEntity lampCategory:cmsCategoryEntities2
                        ) {
                            int lampCategoryId = lampCategory.getId();
                            PageInfo<CmsContentEntity> lampPages= (PageInfo<CmsContentEntity>)indexService.getcontentByCategory(lampCategoryId,1,null);
                            int lampTotalPages = lampPages.getPages();
                            if(lampTotalPages>0){
                                TemplateStaticUtil.urlToHtml( "http://localhost:8082/toHtml/lamp/"+lampCategoryId+"/1","E:\\html\\lamp.html");
                                for (int i=1;i<=lampTotalPages;i++){
                                    url = "http://localhost:8082/toHtml/lamp/"+lampCategoryId+"/"+i;
                                    TemplateStaticUtil.urlToHtml(url,"E:\\html\\lamp\\"+lampCategoryId+"_"+i+".html");
                                    PageInfo<CmsContentEntity> lampDetailsPages= (PageInfo<CmsContentEntity>)indexService.getcontentByCategory(lampCategoryId,i,null);
                                    for (CmsContentEntity contentItem:lampDetailsPages.getList()
                                    ) {

                                        TemplateStaticUtil.urlToHtml("http://localhost:8082/toHtml/details/"+lampCategoryId+"/"+contentItem.getId(),"E:\\html\\details_"+contentItem.getId()+".html");
                                    }
                                }
                            }
                        }
                    }
                    break;
                case "case":
                    if (!(cmsCategoryEntity.getCategoryParentId()==null||cmsCategoryEntity.getCategoryParentId().equals("0"))){
                        PageInfo<CmsContentEntity> lampPages= (PageInfo<CmsContentEntity>)indexService.getcontentByCategory(cmsCategoryEntity.getId(),1,null);
                        int lampTotalPages = lampPages.getPages();
                        if(lampTotalPages>0){
                            TemplateStaticUtil.urlToHtml( "http://localhost:8082/toHtml/case/"+cmsCategoryEntity.getId()+"/1","E:\\html\\case.html");
                            for (int i=1;i<=lampTotalPages;i++){
                                url = "http://localhost:8082/toHtml/case/"+CategoryId+"/"+i;
                                TemplateStaticUtil.urlToHtml(url,"E:\\html\\case\\"+cmsCategoryEntity.getId()+"_"+i+".html");
                                PageInfo<CmsContentEntity> lampDetailsPages= (PageInfo<CmsContentEntity>)indexService.getcontentByCategory(cmsCategoryEntity.getId(),i,null);
                                for (CmsContentEntity contentItem:lampDetailsPages.getList()
                                ) {

                                    TemplateStaticUtil.urlToHtml("http://localhost:8082/toHtml/contentDetails/"+cmsCategoryEntity.getId()+"/"+contentItem.getId(),"E:\\html\\contentDetails_"+contentItem.getId()+".html");
                                }
                            }
                        }
                    }else{
                        List<CmsCategoryEntity> cmsCategoryEntities2 = (List<CmsCategoryEntity>) indexService.getCaseCategory(cmsCategoryEntity.getId());
                        TemplateStaticUtil.urlToHtml( "http://localhost:8082/toHtml/case/"+cmsCategoryEntities2.get(0).getId()+"/1","E:\\html\\case.html");
                        for (CmsCategoryEntity lampCategory:cmsCategoryEntities2
                        ) {
                            int lampCategoryId = lampCategory.getId();
                            PageInfo<CmsContentEntity> lampPages= (PageInfo<CmsContentEntity>)indexService.getcontentByCategory(lampCategoryId,1,null);
                            int lampTotalPages = lampPages.getPages();
                            if(lampTotalPages>0){
                                TemplateStaticUtil.urlToHtml( "http://localhost:8082/toHtml/case/"+lampCategoryId+"/1","E:\\html\\case.html");
                                for (int i=1;i<=lampTotalPages;i++){
                                    url = "http://localhost:8082/toHtml/case/"+lampCategoryId+"/"+i;
                                    TemplateStaticUtil.urlToHtml(url,"E:\\html\\case\\"+lampCategoryId+"_"+i+".html");
                                    PageInfo<CmsContentEntity> lampDetailsPages= (PageInfo<CmsContentEntity>)indexService.getcontentByCategory(lampCategoryId,i,null);
                                    for (CmsContentEntity contentItem:lampDetailsPages.getList()
                                    ) {

                                        TemplateStaticUtil.urlToHtml("http://localhost:8082/toHtml/contentDetails/"+lampCategoryId+"/"+contentItem.getId(),"E:\\html\\contentDetails_"+contentItem.getId()+".html");
                                    }
                                }
                            }
                        }
                    }
                    break;
                case "news":
                    if (!(cmsCategoryEntity.getCategoryParentId()==null||cmsCategoryEntity.getCategoryParentId().equals("0"))){
                        PageInfo<CmsContentEntity> lampPages= (PageInfo<CmsContentEntity>)indexService.getcontentByCategory(cmsCategoryEntity.getId(),1,null);
                        int lampTotalPages = lampPages.getPages();
                        if(lampTotalPages>0){
                            TemplateStaticUtil.urlToHtml( "http://localhost:8082/toHtml/news/"+cmsCategoryEntity.getId()+"/1","E:\\html\\news.html");
                            for (int i=1;i<=lampTotalPages;i++){
                                url = "http://localhost:8082/toHtml/news/"+cmsCategoryEntity.getId()+"/"+i;
                                TemplateStaticUtil.urlToHtml(url,"E:\\html\\news\\"+cmsCategoryEntity.getId()+"_"+i+".html");
                                PageInfo<CmsContentEntity> lampDetailsPages= (PageInfo<CmsContentEntity>)indexService.getcontentByCategory(cmsCategoryEntity.getId(),i,null);
                                for (CmsContentEntity contentItem:lampDetailsPages.getList()
                                ) {

                                    TemplateStaticUtil.urlToHtml("http://localhost:8082/toHtml/contentDetails/"+cmsCategoryEntity.getId()+"/"+contentItem.getId(),"E:\\html\\contentDetails_"+contentItem.getId()+".html");
                                }
                            }
                        }
                    }else{
                        List<CmsCategoryEntity> cmsCategoryEntities2 = (List<CmsCategoryEntity>) indexService.getCaseCategory(cmsCategoryEntity.getId());
                        TemplateStaticUtil.urlToHtml( "http://localhost:8082/toHtml/news/"+cmsCategoryEntities2.get(0).getId()+"/1","E:\\html\\news.html");
                        for (CmsCategoryEntity lampCategory:cmsCategoryEntities2
                        ) {
                            int lampCategoryId = lampCategory.getId();
                            PageInfo<CmsContentEntity> lampPages= (PageInfo<CmsContentEntity>)indexService.getcontentByCategory(lampCategoryId,1,null);
                            int lampTotalPages = lampPages.getPages();
                            if(lampTotalPages>0){
                                TemplateStaticUtil.urlToHtml( "http://localhost:8082/toHtml/news/"+lampCategoryId+"/1","E:\\html\\news.html");
                                for (int i=1;i<=lampTotalPages;i++){
                                    url = "http://localhost:8082/toHtml/news/"+lampCategoryId+"/"+i;
                                    TemplateStaticUtil.urlToHtml(url,"E:\\html\\news\\"+lampCategoryId+"_"+i+".html");
                                    PageInfo<CmsContentEntity> lampDetailsPages= (PageInfo<CmsContentEntity>)indexService.getcontentByCategory(lampCategoryId,i,null);
                                    for (CmsContentEntity contentItem:lampDetailsPages.getList()
                                    ) {

                                        TemplateStaticUtil.urlToHtml("http://localhost:8082/toHtml/contentDetails/"+lampCategoryId+"/"+contentItem.getId(),"E:\\html\\contentDetails_"+contentItem.getId()+".html");
                                    }
                                }
                            }
                        }
                    }
                    break;
                case "contact":
                    url = "http://localhost:8082/toHtml/contact/"+cmsCategoryEntity.getId();
                    TemplateStaticUtil.urlToHtml(url,"E:\\html\\contact.html");
            }



        } else {
            // 获取所有的内容管理栏目
            List<CmsCategoryEntity> cmsCategoryEntities  = (List<CmsCategoryEntity>) indexService.headerList();
            for (CmsCategoryEntity categoryItem:cmsCategoryEntities) {
                String template = categoryItem.getCategoryUrl().substring(0,categoryItem.getCategoryUrl().length()-5);
                String categoryList = categoryItem.getCategoryListUrl().substring(0,categoryItem.getCategoryListUrl().length()-5);
                switch (template){
                    case "index":
                        url = "http://localhost:8082/toHtml/index/"+categoryItem.getId();
                        TemplateStaticUtil.urlToHtml(url,"E:\\html\\index.html");
                        break;
                    case "about":
                        if (!(categoryItem.getCategoryParentId()==null||categoryItem.getCategoryParentId().equals("0"))){
                            url = "http://localhost:8082/toHtml/about/"+categoryItem.getCategoryParentId();
                            TemplateStaticUtil.urlToHtml(url,"E:\\html\\about.html");

                        }else{
                            url = "http://localhost:8082/toHtml/about/"+categoryItem.getId();
                            TemplateStaticUtil.urlToHtml(url,"E:\\html\\about.html");
                        }
                        break;
                    case "generation":
                        url = "http://localhost:8082/toHtml/generation/"+categoryItem.getId();
                        TemplateStaticUtil.urlToHtml(url,"E:\\html\\generation.html");
                        PageInfo<CmsContentEntity> pages= (PageInfo<CmsContentEntity>) indexService.getcontentByCategory(categoryItem.getId(),1,200);
                        for (CmsContentEntity contentItem:pages.getList()
                        ) {

                            TemplateStaticUtil.urlToHtml("http://localhost:8082/toHtml/details/"+categoryItem.getId()+"/"+contentItem.getId(),"E:\\html\\"+categoryList+"_"+contentItem.getId()+".html");
                        }
                        break;
                    case "lifting":
                        url = "http://localhost:8082/toHtml/lifting/"+categoryItem.getId();
                        TemplateStaticUtil.urlToHtml(url,"E:\\html\\lifting.html");
                        break;
                    case "construction":
                        url = "http://localhost:8082/toHtml/construction/"+categoryItem.getId();
                        TemplateStaticUtil.urlToHtml(url,"E:\\html\\construction.html");
                        List<ProjectDto> projectDtos = projectProcessService.getProjectList();
                        for (ProjectDto projectItem:projectDtos
                        ) {
                            TemplateStaticUtil.urlToHtml("http://localhost:8082/toHtml/progress/"+categoryItem.getId()+"/"+projectItem.getId(),"E:\\html\\progress_"+projectItem.getId()+".html");
                        }
                        break;
                    case "lamp":
                        if (!(categoryItem.getCategoryParentId()==null||categoryItem.getCategoryParentId().equals("0"))){
                            PageInfo<CmsContentEntity> lampPages= (PageInfo<CmsContentEntity>)indexService.getcontentByCategory(categoryItem.getId(),1,null);
                            int lampTotalPages = lampPages.getPages();
                            if(lampTotalPages>0){
                                TemplateStaticUtil.urlToHtml( "http://localhost:8082/toHtml/lamp/"+categoryItem.getId()+"/1","E:\\html\\lamp.html");
                                for (int i=1;i<=lampTotalPages;i++){
                                    url = "http://localhost:8082/toHtml/lamp/"+CategoryId+"/"+i;
                                    TemplateStaticUtil.urlToHtml(url,"E:\\html\\lamp\\"+categoryItem.getId()+"_"+i+".html");
                                    PageInfo<CmsContentEntity> lampDetailsPages= (PageInfo<CmsContentEntity>)indexService.getcontentByCategory(categoryItem.getId(),i,null);
                                    for (CmsContentEntity contentItem:lampDetailsPages.getList()
                                    ) {

                                        TemplateStaticUtil.urlToHtml("http://localhost:8082/toHtml/details/"+categoryItem.getId()+"/"+contentItem.getId(),"E:\\html\\details_"+contentItem.getId()+".html");
                                    }
                                }
                            }
                        }else{
                            url = "http://localhost:8082/toHtml/about/"+categoryItem.getId();
                            List<CmsCategoryEntity> cmsCategoryEntities2 = (List<CmsCategoryEntity>) indexService.getCaseCategory(categoryItem.getId());
                            TemplateStaticUtil.urlToHtml( "http://localhost:8082/toHtml/lamp/"+cmsCategoryEntities2.get(0).getId()+"/1","E:\\html\\lamp.html");
                            for (CmsCategoryEntity lampCategory:cmsCategoryEntities2
                            ) {
                                int lampCategoryId = lampCategory.getId();
                                PageInfo<CmsContentEntity> lampPages= (PageInfo<CmsContentEntity>)indexService.getcontentByCategory(lampCategoryId,1,null);
                                int lampTotalPages = lampPages.getPages();
                                if(lampTotalPages>0){

                                    for (int i=1;i<=lampTotalPages;i++){
                                        url = "http://localhost:8082/toHtml/lamp/"+lampCategoryId+"/"+i;
                                        TemplateStaticUtil.urlToHtml(url,"E:\\html\\lamp\\"+lampCategoryId+"_"+i+".html");
                                        PageInfo<CmsContentEntity> lampDetailsPages= (PageInfo<CmsContentEntity>)indexService.getcontentByCategory(lampCategoryId,i,null);
                                        for (CmsContentEntity contentItem:lampDetailsPages.getList()
                                        ) {

                                            TemplateStaticUtil.urlToHtml("http://localhost:8082/toHtml/details/"+lampCategoryId+"/"+contentItem.getId(),"E:\\html\\details_"+contentItem.getId()+".html");
                                        }
                                    }
                                }
                            }
                        }
                        break;
                    case "case":
                        if (!(categoryItem.getCategoryParentId()==null||categoryItem.getCategoryParentId().equals("0"))){
                            PageInfo<CmsContentEntity> lampPages= (PageInfo<CmsContentEntity>)indexService.getcontentByCategory(categoryItem.getId(),1,null);
                            int lampTotalPages = lampPages.getPages();
                            if(lampTotalPages>0){
                                TemplateStaticUtil.urlToHtml( "http://localhost:8082/toHtml/case/"+categoryItem.getId()+"/1","E:\\html\\case.html");
                                for (int i=1;i<=lampTotalPages;i++){
                                    url = "http://localhost:8082/toHtml/case/"+CategoryId+"/"+i;
                                    TemplateStaticUtil.urlToHtml(url,"E:\\html\\case\\"+categoryItem.getId()+"_"+i+".html");
                                    PageInfo<CmsContentEntity> lampDetailsPages= (PageInfo<CmsContentEntity>)indexService.getcontentByCategory(categoryItem.getId(),i,null);
                                    for (CmsContentEntity contentItem:lampDetailsPages.getList()
                                    ) {

                                        TemplateStaticUtil.urlToHtml("http://localhost:8082/toHtml/contentDetails/"+categoryItem.getId()+"/"+contentItem.getId(),"E:\\html\\contentDetails_"+contentItem.getId()+".html");
                                    }
                                }
                            }
                        }else{
                            List<CmsCategoryEntity> cmsCategoryEntities2 = (List<CmsCategoryEntity>) indexService.getCaseCategory(categoryItem.getId());
                            TemplateStaticUtil.urlToHtml( "http://localhost:8082/toHtml/case/"+cmsCategoryEntities2.get(0).getId()+"/1","E:\\html\\case.html");
                            for (CmsCategoryEntity lampCategory:cmsCategoryEntities2
                            ) {
                                int lampCategoryId = lampCategory.getId();
                                PageInfo<CmsContentEntity> lampPages= (PageInfo<CmsContentEntity>)indexService.getcontentByCategory(lampCategoryId,1,null);
                                int lampTotalPages = lampPages.getPages();
                                if(lampTotalPages>0){
                                    for (int i=1;i<=lampTotalPages;i++){
                                        url = "http://localhost:8082/toHtml/case/"+lampCategoryId+"/"+i;
                                        TemplateStaticUtil.urlToHtml(url,"E:\\html\\case\\"+lampCategoryId+"_"+i+".html");
                                        PageInfo<CmsContentEntity> lampDetailsPages= (PageInfo<CmsContentEntity>)indexService.getcontentByCategory(lampCategoryId,i,null);
                                        for (CmsContentEntity contentItem:lampDetailsPages.getList()
                                        ) {

                                            TemplateStaticUtil.urlToHtml("http://localhost:8082/toHtml/contentDetails/"+lampCategoryId+"/"+contentItem.getId(),"E:\\html\\contentDetails_"+contentItem.getId()+".html");
                                        }
                                    }
                                }
                            }
                        }
                        break;
                    case "news":
                        if (!(categoryItem.getCategoryParentId()==null||categoryItem.getCategoryParentId().equals("0"))){
                            PageInfo<CmsContentEntity> lampPages= (PageInfo<CmsContentEntity>)indexService.getcontentByCategory(categoryItem.getId(),1,null);
                            int lampTotalPages = lampPages.getPages();
                            if(lampTotalPages>0){
                                TemplateStaticUtil.urlToHtml( "http://localhost:8082/toHtml/news/"+categoryItem.getId()+"/1","E:\\html\\news.html");
                                for (int i=1;i<=lampTotalPages;i++){
                                    url = "http://localhost:8082/toHtml/news/"+categoryItem.getId()+"/"+i;
                                    TemplateStaticUtil.urlToHtml(url,"E:\\html\\news\\"+categoryItem.getId()+"_"+i+".html");
                                    PageInfo<CmsContentEntity> lampDetailsPages= (PageInfo<CmsContentEntity>)indexService.getcontentByCategory(categoryItem.getId(),i,null);
                                    for (CmsContentEntity contentItem:lampDetailsPages.getList()
                                    ) {

                                        TemplateStaticUtil.urlToHtml("http://localhost:8082/toHtml/contentDetails/"+categoryItem.getId()+"/"+contentItem.getId(),"E:\\html\\contentDetails_"+contentItem.getId()+".html");
                                    }
                                }
                            }
                        }else{
                            List<CmsCategoryEntity> cmsCategoryEntities2 = (List<CmsCategoryEntity>) indexService.getCaseCategory(categoryItem.getId());
                            TemplateStaticUtil.urlToHtml( "http://localhost:8082/toHtml/news/"+cmsCategoryEntities2.get(0).getId()+"/1","E:\\html\\news.html");
                            for (CmsCategoryEntity lampCategory:cmsCategoryEntities2
                            ) {
                                int lampCategoryId = lampCategory.getId();
                                PageInfo<CmsContentEntity> lampPages= (PageInfo<CmsContentEntity>)indexService.getcontentByCategory(lampCategoryId,1,null);
                                int lampTotalPages = lampPages.getPages();
                                if(lampTotalPages>0){
                                    for (int i=1;i<=lampTotalPages;i++){
                                        url = "http://localhost:8082/toHtml/news/"+lampCategoryId+"/"+i;
                                        TemplateStaticUtil.urlToHtml(url,"E:\\html\\news\\"+lampCategoryId+"_"+i+".html");
                                        PageInfo<CmsContentEntity> lampDetailsPages= (PageInfo<CmsContentEntity>)indexService.getcontentByCategory(lampCategoryId,i,null);
                                        for (CmsContentEntity contentItem:lampDetailsPages.getList()
                                        ) {

                                            TemplateStaticUtil.urlToHtml("http://localhost:8082/toHtml/contentDetails/"+lampCategoryId+"/"+contentItem.getId(),"E:\\html\\contentDetails_"+contentItem.getId()+".html");
                                        }
                                    }
                                }
                            }
                        }
                        break;
                    case "contact":
                        url = "http://localhost:8082/toHtml/contact/"+categoryItem.getId();
                        TemplateStaticUtil.urlToHtml(url,"E:\\html\\contact.html");
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
    public void genernateContent(HttpServletRequest request, HttpServletResponse response, @PathVariable int CategoryId) throws IOException {
        List<CmsContentEntity> headerList = (List<CmsContentEntity>) indexService.headerList();
        if(CategoryId>0){
            //获取当前页面
            CmsCategoryEntity cmsCategoryEntity = (CmsCategoryEntity) indexService.getCaseCategory(CategoryId);
            if(cmsCategoryEntity.getCategoryParentId()!=null||!("0").equals(cmsCategoryEntity.getCategoryParentId())){
                //只更新子栏目

            }
        }

    }
}
