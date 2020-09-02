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

    @Value("${template.root}")
    private String rootPath;

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
                    url = "http://localhost:8082/toHtml/lable/"+tag.getId()+"/"+i;
                    TemplateStaticUtil.urlToHtml(url,"lable\\"+tag.getId()+"_"+i+".html");
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
                    TemplateStaticUtil.urlToHtml(url,"index.html");
                    break;
                case "about":
                    if (!(cmsCategoryEntity.getCategoryParentId()==null||cmsCategoryEntity.getCategoryParentId().equals("0"))){
                        url = "http://localhost:8082/toHtml/about/"+cmsCategoryEntity.getCategoryParentId();
                        TemplateStaticUtil.urlToHtml(url,"about.html");

                    }else{
                        url = "http://localhost:8082/toHtml/about/"+cmsCategoryEntity.getId();
                        TemplateStaticUtil.urlToHtml(url,"about.html");
                    }
                    break;
                case "generation":
                    url = "http://localhost:8082/toHtml/generation/"+cmsCategoryEntity.getId();
                    TemplateStaticUtil.urlToHtml(url,"generation.html");
                    PageInfo<CmsContentEntity> pages= (PageInfo<CmsContentEntity>) indexService.getcontentByCategory(cmsCategoryEntity.getId(),1,200);
                    for (CmsContentEntity contentItem:pages.getList()
                    ) {

                        TemplateStaticUtil.urlToHtml("http://localhost:8082/toHtml/details/"+cmsCategoryEntity.getId()+"/"+contentItem.getId(),""+categoryList+"_"+contentItem.getId()+".html");
                    }
                    break;
                case "lifting":
                    url = "http://localhost:8082/toHtml/lifting/"+cmsCategoryEntity.getId();
                    TemplateStaticUtil.urlToHtml(url,"lifting.html");
                    break;
                case "construction":
                    url = "http://localhost:8082/toHtml/construction/"+cmsCategoryEntity.getId();
                    TemplateStaticUtil.urlToHtml(url,"construction.html");
                    List<ProjectDto> projectDtos = projectProcessService.getProjectList();
                    for (ProjectDto projectItem:projectDtos
                    ) {
                        TemplateStaticUtil.urlToHtml("http://localhost:8082/toHtml/progress/"+cmsCategoryEntity.getId()+"/"+projectItem.getId(),"progress_"+projectItem.getId()+".html");
                    }
                    break;
                case "lamp":
                    if (!(cmsCategoryEntity.getCategoryParentId()==null||cmsCategoryEntity.getCategoryParentId().equals("0"))){
                        PageInfo<CmsContentEntity> lampPages= (PageInfo<CmsContentEntity>)indexService.getcontentByCategory(cmsCategoryEntity.getId(),1,null);
                        int lampTotalPages = lampPages.getPages();
                        if(lampTotalPages>0){
                            TemplateStaticUtil.urlToHtml( "http://localhost:8082/toHtml/lamp/"+cmsCategoryEntity.getId()+"/1","lamp.html");
                            for (int i=1;i<=lampTotalPages;i++){
                                url = "http://localhost:8082/toHtml/lamp/"+CategoryId+"/"+i;
                                TemplateStaticUtil.urlToHtml(url,"lamp\\"+cmsCategoryEntity.getId()+"_"+i+".html");
                                PageInfo<CmsContentEntity> lampDetailsPages= (PageInfo<CmsContentEntity>)indexService.getcontentByCategory(cmsCategoryEntity.getId(),i,null);
                                for (CmsContentEntity contentItem:lampDetailsPages.getList()
                                ) {

                                    TemplateStaticUtil.urlToHtml("http://localhost:8082/toHtml/details/"+cmsCategoryEntity.getId()+"/"+contentItem.getId(),"details_"+contentItem.getId()+".html");
                                }
                            }
                        }
                    }else{
                        url = "http://localhost:8082/toHtml/about/"+cmsCategoryEntity.getId();
                        List<CmsCategoryEntity> cmsCategoryEntities2 = (List<CmsCategoryEntity>) indexService.getCaseCategory(cmsCategoryEntity.getId());
                        TemplateStaticUtil.urlToHtml( "http://localhost:8082/toHtml/lamp/"+cmsCategoryEntities2.get(0).getId()+"/1","lamp.html");
                        for (CmsCategoryEntity lampCategory:cmsCategoryEntities2
                        ) {
                            int lampCategoryId = lampCategory.getId();
                            PageInfo<CmsContentEntity> lampPages= (PageInfo<CmsContentEntity>)indexService.getcontentByCategory(lampCategoryId,1,null);
                            int lampTotalPages = lampPages.getPages();
                            if(lampTotalPages>0){
                                TemplateStaticUtil.urlToHtml( "http://localhost:8082/toHtml/lamp/"+lampCategoryId+"/1","lamp.html");
                                for (int i=1;i<=lampTotalPages;i++){
                                    url = "http://localhost:8082/toHtml/lamp/"+lampCategoryId+"/"+i;
                                    TemplateStaticUtil.urlToHtml(url,"lamp\\"+lampCategoryId+"_"+i+".html");
                                    PageInfo<CmsContentEntity> lampDetailsPages= (PageInfo<CmsContentEntity>)indexService.getcontentByCategory(lampCategoryId,i,null);
                                    for (CmsContentEntity contentItem:lampDetailsPages.getList()
                                    ) {

                                        TemplateStaticUtil.urlToHtml("http://localhost:8082/toHtml/details/"+lampCategoryId+"/"+contentItem.getId(),"details_"+contentItem.getId()+".html");
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
                            TemplateStaticUtil.urlToHtml( "http://localhost:8082/toHtml/case/"+cmsCategoryEntity.getId()+"/1","case.html");
                            for (int i=1;i<=lampTotalPages;i++){
                                url = "http://localhost:8082/toHtml/case/"+CategoryId+"/"+i;
                                TemplateStaticUtil.urlToHtml(url,"case\\"+cmsCategoryEntity.getId()+"_"+i+".html");
                                PageInfo<CmsContentEntity> lampDetailsPages= (PageInfo<CmsContentEntity>)indexService.getcontentByCategory(cmsCategoryEntity.getId(),i,null);
                                for (CmsContentEntity contentItem:lampDetailsPages.getList()
                                ) {

                                    TemplateStaticUtil.urlToHtml("http://localhost:8082/toHtml/contentDetails/"+cmsCategoryEntity.getId()+"/"+contentItem.getId(),"contentDetails_"+contentItem.getId()+".html");
                                }
                            }
                        }
                    }else{
                        List<CmsCategoryEntity> cmsCategoryEntities2 = (List<CmsCategoryEntity>) indexService.getCaseCategory(cmsCategoryEntity.getId());
                        TemplateStaticUtil.urlToHtml( "http://localhost:8082/toHtml/case/"+cmsCategoryEntities2.get(0).getId()+"/1","case.html");
                        for (CmsCategoryEntity lampCategory:cmsCategoryEntities2
                        ) {
                            int lampCategoryId = lampCategory.getId();
                            PageInfo<CmsContentEntity> lampPages= (PageInfo<CmsContentEntity>)indexService.getcontentByCategory(lampCategoryId,1,null);
                            int lampTotalPages = lampPages.getPages();
                            if(lampTotalPages>0){
                                TemplateStaticUtil.urlToHtml( "http://localhost:8082/toHtml/case/"+lampCategoryId+"/1","case.html");
                                for (int i=1;i<=lampTotalPages;i++){
                                    url = "http://localhost:8082/toHtml/case/"+lampCategoryId+"/"+i;
                                    TemplateStaticUtil.urlToHtml(url,"case\\"+lampCategoryId+"_"+i+".html");
                                    PageInfo<CmsContentEntity> lampDetailsPages= (PageInfo<CmsContentEntity>)indexService.getcontentByCategory(lampCategoryId,i,null);
                                    for (CmsContentEntity contentItem:lampDetailsPages.getList()
                                    ) {

                                        TemplateStaticUtil.urlToHtml("http://localhost:8082/toHtml/contentDetails/"+lampCategoryId+"/"+contentItem.getId(),"contentDetails_"+contentItem.getId()+".html");
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
                            TemplateStaticUtil.urlToHtml( "http://localhost:8082/toHtml/news/"+cmsCategoryEntity.getId()+"/1","news.html");
                            for (int i=1;i<=lampTotalPages;i++){
                                url = "http://localhost:8082/toHtml/news/"+cmsCategoryEntity.getId()+"/"+i;
                                TemplateStaticUtil.urlToHtml(url,"news\\"+cmsCategoryEntity.getId()+"_"+i+".html");
                                PageInfo<CmsContentEntity> lampDetailsPages= (PageInfo<CmsContentEntity>)indexService.getcontentByCategory(cmsCategoryEntity.getId(),i,null);
                                for (CmsContentEntity contentItem:lampDetailsPages.getList()
                                ) {

                                    TemplateStaticUtil.urlToHtml("http://localhost:8082/toHtml/contentDetails/"+cmsCategoryEntity.getId()+"/"+contentItem.getId(),"contentDetails_"+contentItem.getId()+".html");
                                }
                            }
                        }
                    }else{
                        List<CmsCategoryEntity> cmsCategoryEntities2 = (List<CmsCategoryEntity>) indexService.getCaseCategory(cmsCategoryEntity.getId());
                        TemplateStaticUtil.urlToHtml( "http://localhost:8082/toHtml/news/"+cmsCategoryEntities2.get(0).getId()+"/1","news.html");
                        for (CmsCategoryEntity lampCategory:cmsCategoryEntities2
                        ) {
                            int lampCategoryId = lampCategory.getId();
                            PageInfo<CmsContentEntity> lampPages= (PageInfo<CmsContentEntity>)indexService.getcontentByCategory(lampCategoryId,1,null);
                            int lampTotalPages = lampPages.getPages();
                            if(lampTotalPages>0){
                                TemplateStaticUtil.urlToHtml( "http://localhost:8082/toHtml/news/"+lampCategoryId+"/1","news.html");
                                for (int i=1;i<=lampTotalPages;i++){
                                    url = "http://localhost:8082/toHtml/news/"+lampCategoryId+"/"+i;
                                    TemplateStaticUtil.urlToHtml(url,"news\\"+lampCategoryId+"_"+i+".html");
                                    PageInfo<CmsContentEntity> lampDetailsPages= (PageInfo<CmsContentEntity>)indexService.getcontentByCategory(lampCategoryId,i,null);
                                    for (CmsContentEntity contentItem:lampDetailsPages.getList()
                                    ) {

                                        TemplateStaticUtil.urlToHtml("http://localhost:8082/toHtml/contentDetails/"+lampCategoryId+"/"+contentItem.getId(),"contentDetails_"+contentItem.getId()+".html");
                                    }
                                }
                            }
                        }
                    }
                    break;
                case "contact":
                    url = "http://localhost:8082/toHtml/contact/"+cmsCategoryEntity.getId();
                    TemplateStaticUtil.urlToHtml(url,"contact.html");
                    break;
                default:
                    break;
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
                        TemplateStaticUtil.urlToHtml(url,"index.html");
                        break;
                    case "about":
                        if (!(categoryItem.getCategoryParentId()==null||categoryItem.getCategoryParentId().equals("0"))){
                            url = "http://localhost:8082/toHtml/about/"+categoryItem.getCategoryParentId();
                            TemplateStaticUtil.urlToHtml(url,"about.html");

                        }else{
                            url = "http://localhost:8082/toHtml/about/"+categoryItem.getId();
                            TemplateStaticUtil.urlToHtml(url,"about.html");
                        }
                        break;
                    case "generation":
                        url = "http://localhost:8082/toHtml/generation/"+categoryItem.getId();
                        TemplateStaticUtil.urlToHtml(url,"generation.html");
                        PageInfo<CmsContentEntity> pages= (PageInfo<CmsContentEntity>) indexService.getcontentByCategory(categoryItem.getId(),1,200);
                        for (CmsContentEntity contentItem:pages.getList()
                        ) {

                            TemplateStaticUtil.urlToHtml("http://localhost:8082/toHtml/details/"+categoryItem.getId()+"/"+contentItem.getId(),""+categoryList+"_"+contentItem.getId()+".html");
                        }
                        break;
                    case "lifting":
                        url = "http://localhost:8082/toHtml/lifting/"+categoryItem.getId();
                        TemplateStaticUtil.urlToHtml(url,"lifting.html");
                        break;
                    case "construction":
                        url = "http://localhost:8082/toHtml/construction/"+categoryItem.getId();
                        TemplateStaticUtil.urlToHtml(url,"construction.html");
                        List<ProjectDto> projectDtos = projectProcessService.getProjectList();
                        for (ProjectDto projectItem:projectDtos
                        ) {
                            TemplateStaticUtil.urlToHtml("http://localhost:8082/toHtml/progress/"+categoryItem.getId()+"/"+projectItem.getId(),"progress_"+projectItem.getId()+".html");
                        }
                        break;
                    case "lamp":
                        if (!(categoryItem.getCategoryParentId()==null||categoryItem.getCategoryParentId().equals("0"))){
                            PageInfo<CmsContentEntity> lampPages= (PageInfo<CmsContentEntity>)indexService.getcontentByCategory(categoryItem.getId(),1,null);
                            int lampTotalPages = lampPages.getPages();
                            if(lampTotalPages>0){
                                TemplateStaticUtil.urlToHtml( "http://localhost:8082/toHtml/lamp/"+categoryItem.getId()+"/1","lamp.html");
                                for (int i=1;i<=lampTotalPages;i++){
                                    url = "http://localhost:8082/toHtml/lamp/"+CategoryId+"/"+i;
                                    TemplateStaticUtil.urlToHtml(url,"lamp\\"+categoryItem.getId()+"_"+i+".html");
                                    PageInfo<CmsContentEntity> lampDetailsPages= (PageInfo<CmsContentEntity>)indexService.getcontentByCategory(categoryItem.getId(),i,null);
                                    for (CmsContentEntity contentItem:lampDetailsPages.getList()
                                    ) {

                                        TemplateStaticUtil.urlToHtml("http://localhost:8082/toHtml/details/"+categoryItem.getId()+"/"+contentItem.getId(),"details_"+contentItem.getId()+".html");
                                    }
                                }
                            }
                        }else{
                            url = "http://localhost:8082/toHtml/lamp/"+categoryItem.getId();
                            List<CmsCategoryEntity> cmsCategoryEntities2 = (List<CmsCategoryEntity>) indexService.getCaseCategory(categoryItem.getId());
                            TemplateStaticUtil.urlToHtml( "http://localhost:8082/toHtml/lamp/"+cmsCategoryEntities2.get(0).getId()+"/1","lamp.html");
                            for (CmsCategoryEntity lampCategory:cmsCategoryEntities2
                            ) {
                                int lampCategoryId = lampCategory.getId();
                                PageInfo<CmsContentEntity> lampPages= (PageInfo<CmsContentEntity>)indexService.getcontentByCategory(lampCategoryId,1,null);
                                int lampTotalPages = lampPages.getPages();
                                if(lampTotalPages>0){

                                    for (int i=1;i<=lampTotalPages;i++){
                                        url = "http://localhost:8082/toHtml/lamp/"+lampCategoryId+"/"+i;
                                        TemplateStaticUtil.urlToHtml(url,"lamp\\"+lampCategoryId+"_"+i+".html");
                                        PageInfo<CmsContentEntity> lampDetailsPages= (PageInfo<CmsContentEntity>)indexService.getcontentByCategory(lampCategoryId,i,null);
                                        for (CmsContentEntity contentItem:lampDetailsPages.getList()
                                        ) {

                                            TemplateStaticUtil.urlToHtml("http://localhost:8082/toHtml/details/"+lampCategoryId+"/"+contentItem.getId(),"details_"+contentItem.getId()+".html");
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
                                TemplateStaticUtil.urlToHtml( "http://localhost:8082/toHtml/case/"+categoryItem.getId()+"/1","case.html");
                                for (int i=1;i<=lampTotalPages;i++){
                                    url = "http://localhost:8082/toHtml/case/"+CategoryId+"/"+i;
                                    TemplateStaticUtil.urlToHtml(url,"case\\"+categoryItem.getId()+"_"+i+".html");
                                    PageInfo<CmsContentEntity> lampDetailsPages= (PageInfo<CmsContentEntity>)indexService.getcontentByCategory(categoryItem.getId(),i,null);
                                    for (CmsContentEntity contentItem:lampDetailsPages.getList()
                                    ) {

                                        TemplateStaticUtil.urlToHtml("http://localhost:8082/toHtml/contentDetails/"+categoryItem.getId()+"/"+contentItem.getId(),"contentDetails_"+contentItem.getId()+".html");
                                    }
                                }
                            }
                        }else{
                            List<CmsCategoryEntity> cmsCategoryEntities2 = (List<CmsCategoryEntity>) indexService.getCaseCategory(categoryItem.getId());
                            TemplateStaticUtil.urlToHtml( "http://localhost:8082/toHtml/case/"+cmsCategoryEntities2.get(0).getId()+"/1","case.html");
                            for (CmsCategoryEntity lampCategory:cmsCategoryEntities2
                            ) {
                                int lampCategoryId = lampCategory.getId();
                                PageInfo<CmsContentEntity> lampPages= (PageInfo<CmsContentEntity>)indexService.getcontentByCategory(lampCategoryId,1,null);
                                int lampTotalPages = lampPages.getPages();
                                if(lampTotalPages>0){
                                    for (int i=1;i<=lampTotalPages;i++){
                                        url = "http://localhost:8082/toHtml/case/"+lampCategoryId+"/"+i;
                                        TemplateStaticUtil.urlToHtml(url,"case\\"+lampCategoryId+"_"+i+".html");
                                        PageInfo<CmsContentEntity> lampDetailsPages= (PageInfo<CmsContentEntity>)indexService.getcontentByCategory(lampCategoryId,i,null);
                                        for (CmsContentEntity contentItem:lampDetailsPages.getList()
                                        ) {

                                            TemplateStaticUtil.urlToHtml("http://localhost:8082/toHtml/contentDetails/"+lampCategoryId+"/"+contentItem.getId(),"contentDetails_"+contentItem.getId()+".html");
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
                                TemplateStaticUtil.urlToHtml( "http://localhost:8082/toHtml/news/"+categoryItem.getId()+"/1","news.html");
                                for (int i=1;i<=lampTotalPages;i++){
                                    url = "http://localhost:8082/toHtml/news/"+categoryItem.getId()+"/"+i;
                                    TemplateStaticUtil.urlToHtml(url,"news\\"+categoryItem.getId()+"_"+i+".html");
                                    PageInfo<CmsContentEntity> lampDetailsPages= (PageInfo<CmsContentEntity>)indexService.getcontentByCategory(categoryItem.getId(),i,null);
                                    for (CmsContentEntity contentItem:lampDetailsPages.getList()
                                    ) {

                                        TemplateStaticUtil.urlToHtml("http://localhost:8082/toHtml/contentDetails/"+categoryItem.getId()+"/"+contentItem.getId(),"contentDetails_"+contentItem.getId()+".html");
                                    }
                                }
                            }
                        }else{
                            List<CmsCategoryEntity> cmsCategoryEntities2 = (List<CmsCategoryEntity>) indexService.getCaseCategory(categoryItem.getId());
                            TemplateStaticUtil.urlToHtml( "http://localhost:8082/toHtml/news/"+cmsCategoryEntities2.get(0).getId()+"/1","news.html");
                            for (CmsCategoryEntity lampCategory:cmsCategoryEntities2
                            ) {
                                int lampCategoryId = lampCategory.getId();
                                PageInfo<CmsContentEntity> lampPages= (PageInfo<CmsContentEntity>)indexService.getcontentByCategory(lampCategoryId,1,null);
                                int lampTotalPages = lampPages.getPages();
                                if(lampTotalPages>0){
                                    for (int i=1;i<=lampTotalPages;i++){
                                        url = "http://localhost:8082/toHtml/news/"+lampCategoryId+"/"+i;
                                        TemplateStaticUtil.urlToHtml(url,"news\\"+lampCategoryId+"_"+i+".html");
                                        PageInfo<CmsContentEntity> lampDetailsPages= (PageInfo<CmsContentEntity>)indexService.getcontentByCategory(lampCategoryId,i,null);
                                        for (CmsContentEntity contentItem:lampDetailsPages.getList()
                                        ) {

                                            TemplateStaticUtil.urlToHtml("http://localhost:8082/toHtml/contentDetails/"+lampCategoryId+"/"+contentItem.getId(),"contentDetails_"+contentItem.getId()+".html");
                                        }
                                    }
                                }
                            }
                        }
                        break;
                    case "contact":
                        url = "http://localhost:8082/toHtml/contact/"+categoryItem.getId();
                        TemplateStaticUtil.urlToHtml(url,"contact.html");
                        break;
                    default:
                        break;
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
        ThymeleafViewObject.footer.set(footerService.getCompany());
        ThymeleafViewObject.headerList.set(headerList);
        CmsCategoryEntity header;
        if(CategoryId>0){
            //获取当前页面
            CmsCategoryEntity cmsCategoryEntity = (CmsCategoryEntity) indexService.getCaseCategory(CategoryId);
            if(cmsCategoryEntity.getCategoryParentId()!=null||!("0").equals(cmsCategoryEntity.getCategoryParentId())){
                //只更新子栏目
                header = indexService.getById(Integer.parseInt(cmsCategoryEntity.getCategoryParentId()));
                ThymeleafViewObject.header.set(header);
            }else{
                header = indexService.getById(CategoryId);
                ThymeleafViewObject.header.set(header);
            }
            String url = "";
            String template = cmsCategoryEntity.getCategoryUrl().substring(0,cmsCategoryEntity.getCategoryUrl().length()-5);
            String categoryList = cmsCategoryEntity.getCategoryListUrl().substring(0,cmsCategoryEntity.getCategoryListUrl().length()-5);
            Map<String,Object> result = new HashMap<>();
            switch (template){
                case "index":
                    url = "http://localhost:8082/toHtml/index/"+CategoryId;
                    TemplateStaticUtil.urlToHtml(url,"index.html");
                    break;
                case "about":
                    if (!(cmsCategoryEntity.getCategoryParentId()==null||cmsCategoryEntity.getCategoryParentId().equals("0"))){
                        url = "http://localhost:8082/toHtml/about/"+cmsCategoryEntity.getCategoryParentId();
                        TemplateStaticUtil.urlToHtml(url,"about.html");

                    }else{
                        url = "http://localhost:8082/toHtml/about/"+cmsCategoryEntity.getId();
                        TemplateStaticUtil.urlToHtml(url,"about.html");
                    }
                    break;
                case "generation":
                    url = "http://localhost:8082/toHtml/generation/"+cmsCategoryEntity.getId();
                    TemplateStaticUtil.urlToHtml(url,"generation.html");
                    ThymeleafViewObject.tags.set(indexService.getTags());
                    ThymeleafViewObject.news.set(indexService.getNewsByMainCategory());
                    ThymeleafViewObject.relateCase65.set(indexService.getcontentByCategory(65,1,3));
                    ThymeleafViewObject.relateCase67.set(indexService.getcontentByCategory(67,1,3));
                    List<CmsContentEntity> pages= (List<CmsContentEntity>) indexService.getcontentByCategory(cmsCategoryEntity.getId());

                    for (int i=0;i<pages.size();i++){
                        if(i==0){
                            result.put("last",new CmsContentEntity());
                        }else{
                            result.put("last",pages.get(i-1));
                        }
                        if(i==pages.size()-1){
                            result.put("next",new CmsContentEntity());
                        }else{
                            result.put("next",pages.get(i+1));
                        }
                        ThymeleafViewObject.lastAndNextProgress.set(result);
                        ThymeleafViewObject.contentResult.set(pages.get(i));
                        TemplateStaticUtil.urlToHtml("http://localhost:8082/toHtml/details/"+cmsCategoryEntity.getId()+"/"+pages.get(i).getId(),""+categoryList+"_"+pages.get(i).getId()+".html");
                    }

                    break;
                case "lifting":
                    url = "http://localhost:8082/toHtml/lifting/"+cmsCategoryEntity.getId();
                    TemplateStaticUtil.urlToHtml(url,"lifting.html");
                    break;
                case "construction":
                    url = "http://localhost:8082/toHtml/construction/"+cmsCategoryEntity.getId();
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
                        ThymeleafViewObject.lastAndNextProgress.set(result);
                        ThymeleafViewObject.contentResult.set(projectDtos.get(i));
                        TemplateStaticUtil.urlToHtml("http://localhost:8082/toHtml/progress/"+cmsCategoryEntity.getId()+"/"+projectDtos.get(i).getId(),"progress_"+projectDtos.get(i).getId()+".html");
                    }
                    break;
                case "lamp":
                    ThymeleafViewObject.tags.set(indexService.getTags());
                    ThymeleafViewObject.news.set(indexService.getNewsByMainCategory());
                    ThymeleafViewObject.relateCase65.set(indexService.getcontentByCategory(65,1,3));
                    ThymeleafViewObject.relateCase67.set(indexService.getcontentByCategory(67,1,3));
                    if (!(cmsCategoryEntity.getCategoryParentId()==null||cmsCategoryEntity.getCategoryParentId().equals("0"))){
                        //获取分类下所有文章
                        List<CmsContentEntity> lampPages= (List<CmsContentEntity>)indexService.getcontentByCategory(cmsCategoryEntity.getId());
                        //获取分类所有同级分类
                        List<CmsCategoryEntity> lampCategoryEntity = (List<CmsCategoryEntity>) indexService.getCaseCategory(Integer.parseInt(cmsCategoryEntity.getCategoryParentId()));
                        if(lampCategoryEntity.get(0).getId().equals(CategoryId)){
                            TemplateStaticUtil.urlToHtml( "http://localhost:8082/toHtml/lamp/"+cmsCategoryEntity.getId()+"/1","lamp.html");
                        }
                        ThymeleafViewObject.categoryList.set(cmsCategoryEntity);
                        int lampTotalPages = lampPages.size()%pageSize>0 ? lampPages.size()/pageSize+1:lampPages.size()/pageSize;
                        if(lampTotalPages>0){
                           for (int i=1;i<=lampTotalPages;i++){
                               ThymeleafViewObject.contentList.set(getByPage(lampPages,i,lampTotalPages));
                               url = "http://localhost:8082/toHtml/lamp/"+CategoryId+"/"+i;
                               TemplateStaticUtil.urlToHtml(url,"lamp\\"+cmsCategoryEntity.getId()+"_"+i+".html");
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
                                ThymeleafViewObject.lastAndNextProgress.set(result);
                                ThymeleafViewObject.contentResult.set(lampPages.get(i));
                                TemplateStaticUtil.urlToHtml("http://localhost:8082/toHtml/details/"+cmsCategoryEntity.getId()+"/"+lampPages.get(i).getId(),""+categoryList+"_"+lampPages.get(i).getId()+".html");
                            }
                        }
                    }else{
                        List<CmsCategoryEntity> cmsCategoryEntities2 = (List<CmsCategoryEntity>) indexService.getCaseCategory(cmsCategoryEntity.getId());
                        TemplateStaticUtil.urlToHtml( "http://localhost:8082/toHtml/lamp/"+cmsCategoryEntities2.get(0).getId()+"/1","lamp.html");
                        for (CmsCategoryEntity lampCategory:cmsCategoryEntities2
                        ) {
                            int lampCategoryId = lampCategory.getId();
                            List<CmsContentEntity> lampPages= (List<CmsContentEntity>) (PageInfo<CmsContentEntity>)indexService.getcontentByCategory(lampCategoryId);
                            int lampTotalPages = lampPages.size()%pageSize>0 ? lampPages.size()/pageSize+1:lampPages.size()/pageSize;
                            if(lampTotalPages>0){
                                for (int i=1;i<=lampTotalPages;i++){
                                    ThymeleafViewObject.contentList.set(getByPage(lampPages,i,lampTotalPages));
                                    url = "http://localhost:8082/toHtml/lamp/"+CategoryId+"/"+i;
                                    TemplateStaticUtil.urlToHtml(url,"lamp\\"+lampCategoryId+"_"+i+".html");
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
                                    ThymeleafViewObject.lastAndNextProgress.set(result);
                                    ThymeleafViewObject.contentResult.set(lampPages.get(i));
                                    TemplateStaticUtil.urlToHtml("http://localhost:8082/toHtml/details/"+cmsCategoryEntity.getId()+"/"+lampPages.get(i).getId(),""+categoryList+"_"+lampPages.get(i).getId()+".html");
                                }
                            }
                        }
                    }
                    break;
                case "case":
                    ThymeleafViewObject.tags.set(indexService.getTags());
                    ThymeleafViewObject.news.set(indexService.getNewsByMainCategory());
                    if (!(cmsCategoryEntity.getCategoryParentId()==null||cmsCategoryEntity.getCategoryParentId().equals("0"))){
                        //获取分类下所有文章
                        List<CmsContentEntity> lampPages= (List<CmsContentEntity>)indexService.getcontentByCategory(cmsCategoryEntity.getId());
                        //获取分类所有同级分类
                        List<CmsCategoryEntity> lampCategoryEntity = (List<CmsCategoryEntity>) indexService.getCaseCategory(Integer.parseInt(cmsCategoryEntity.getCategoryParentId()));
                        if(lampCategoryEntity.get(0).getId().equals(CategoryId)){
                            TemplateStaticUtil.urlToHtml( "http://localhost:8082/toHtml/case/"+cmsCategoryEntity.getId()+"/1","case.html");
                        }
                        ThymeleafViewObject.categoryList.set(cmsCategoryEntity);
                        int lampTotalPages = lampPages.size()%pageSize>0 ? lampPages.size()/pageSize+1:lampPages.size()/pageSize;
                        if(lampTotalPages>0){
                            for (int i=1;i<=lampTotalPages;i++){
                                ThymeleafViewObject.contentList.set(getByPage(lampPages,i,lampTotalPages));
                                url = "http://localhost:8082/toHtml/case/"+CategoryId+"/"+i;
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
                                ThymeleafViewObject.lastAndNextProgress.set(result);
                                ThymeleafViewObject.contentResult.set(lampPages.get(i));
                                TemplateStaticUtil.urlToHtml("http://localhost:8082/toHtml/contentDetails/"+cmsCategoryEntity.getId()+"/"+lampPages.get(i).getId(),""+categoryList+"_"+lampPages.get(i).getId()+".html");
                            }
                        }
                    }else{
                        List<CmsCategoryEntity> cmsCategoryEntities2 = (List<CmsCategoryEntity>) indexService.getCaseCategory(cmsCategoryEntity.getId());
                        TemplateStaticUtil.urlToHtml( "http://localhost:8082/toHtml/case/"+cmsCategoryEntities2.get(0).getId()+"/1","case.html");
                        for (CmsCategoryEntity lampCategory:cmsCategoryEntities2
                        ) {
                            int lampCategoryId = lampCategory.getId();
                            List<CmsContentEntity> lampPages= (List<CmsContentEntity>) (PageInfo<CmsContentEntity>)indexService.getcontentByCategory(lampCategoryId);
                            int lampTotalPages = lampPages.size()%pageSize>0 ? lampPages.size()/pageSize+1:lampPages.size()/pageSize;
                            if(lampTotalPages>0){
                                for (int i=1;i<=lampTotalPages;i++){
                                    ThymeleafViewObject.contentList.set(getByPage(lampPages,i,lampTotalPages));
                                    url = "http://localhost:8082/toHtml/case/"+CategoryId+"/"+i;
                                    TemplateStaticUtil.urlToHtml(url,"case\\"+lampCategoryId+"_"+i+".html");
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
                                    ThymeleafViewObject.lastAndNextProgress.set(result);
                                    ThymeleafViewObject.contentResult.set(lampPages.get(i));
                                    TemplateStaticUtil.urlToHtml("http://localhost:8082/toHtml/contentDetails/"+cmsCategoryEntity.getId()+"/"+lampPages.get(i).getId(),""+categoryList+"_"+lampPages.get(i).getId()+".html");
                                }
                            }
                        }
                    }
                    break;
                case "news":
                    ThymeleafViewObject.tags.set(indexService.getTags());
                    ThymeleafViewObject.news.set(indexService.getNewsByMainCategory());
                    if (!(cmsCategoryEntity.getCategoryParentId()==null||cmsCategoryEntity.getCategoryParentId().equals("0"))){
                        //获取分类下所有文章
                        List<CmsContentEntity> lampPages= (List<CmsContentEntity>)indexService.getcontentByCategory(cmsCategoryEntity.getId());
                        //获取分类所有同级分类
                        List<CmsCategoryEntity> lampCategoryEntity = (List<CmsCategoryEntity>) indexService.getCaseCategory(Integer.parseInt(cmsCategoryEntity.getCategoryParentId()));
                        if(lampCategoryEntity.get(0).getId().equals(CategoryId)){
                            TemplateStaticUtil.urlToHtml( "http://localhost:8082/toHtml/news/"+cmsCategoryEntity.getId()+"/1","news.html");
                        }
                        ThymeleafViewObject.categoryList.set(cmsCategoryEntity);
                        int lampTotalPages = lampPages.size()%pageSize>0 ? lampPages.size()/pageSize+1:lampPages.size()/pageSize;
                        if(lampTotalPages>0){
                            for (int i=1;i<=lampTotalPages;i++){
                                ThymeleafViewObject.contentList.set(getByPage(lampPages,i,lampTotalPages));
                                url = "http://localhost:8082/toHtml/news/"+CategoryId+"/"+i;
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
                                ThymeleafViewObject.lastAndNextProgress.set(result);
                                ThymeleafViewObject.contentResult.set(lampPages.get(i));
                                TemplateStaticUtil.urlToHtml("http://localhost:8082/toHtml/contentDetails/"+cmsCategoryEntity.getId()+"/"+lampPages.get(i).getId(),""+categoryList+"_"+lampPages.get(i).getId()+".html");
                            }
                        }
                    }else{
                        List<CmsCategoryEntity> cmsCategoryEntities2 = (List<CmsCategoryEntity>) indexService.getCaseCategory(cmsCategoryEntity.getId());
                        TemplateStaticUtil.urlToHtml( "http://localhost:8082/toHtml/news/"+cmsCategoryEntities2.get(0).getId()+"/1","news.html");
                        for (CmsCategoryEntity lampCategory:cmsCategoryEntities2
                        ) {
                            int lampCategoryId = lampCategory.getId();
                            List<CmsContentEntity> lampPages= (List<CmsContentEntity>) (PageInfo<CmsContentEntity>)indexService.getcontentByCategory(lampCategoryId);
                            int lampTotalPages = lampPages.size()%pageSize>0 ? lampPages.size()/pageSize+1:lampPages.size()/pageSize;
                            if(lampTotalPages>0){
                                for (int i=1;i<=lampTotalPages;i++){
                                    ThymeleafViewObject.contentList.set(getByPage(lampPages,i,lampTotalPages));
                                    url = "http://localhost:8082/toHtml/news/"+CategoryId+"/"+i;
                                    TemplateStaticUtil.urlToHtml(url,"news\\"+lampCategoryId+"_"+i+".html");
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
                                    ThymeleafViewObject.lastAndNextProgress.set(result);
                                    ThymeleafViewObject.contentResult.set(lampPages.get(i));
                                    TemplateStaticUtil.urlToHtml("http://localhost:8082/toHtml/contentDetails/"+cmsCategoryEntity.getId()+"/"+lampPages.get(i).getId(),""+categoryList+"_"+lampPages.get(i).getId()+".html");
                                }
                            }
                        }
                    }
                    break;
                case "contact":
                    url = "http://localhost:8082/toHtml/contact/"+cmsCategoryEntity.getId();
                    TemplateStaticUtil.urlToHtml(url,"contact.html");
                    break;
                default:
                    break;
            }

        }else {
            for (CmsCategoryEntity categoryItem:headerList) {
                //获取当前页面
                CmsCategoryEntity cmsCategoryEntity = (CmsCategoryEntity) indexService.getCaseCategory(categoryItem.getId());
                if(cmsCategoryEntity.getCategoryParentId()!=null||!("0").equals(cmsCategoryEntity.getCategoryParentId())){
                    //只更新子栏目
                    header = indexService.getById(Integer.parseInt(cmsCategoryEntity.getCategoryParentId()));
                    ThymeleafViewObject.header.set(header);
                }else{
                    header = indexService.getById(categoryItem.getId());
                    ThymeleafViewObject.header.set(header);
                }
                String url = "";
                String template = cmsCategoryEntity.getCategoryUrl().substring(0,cmsCategoryEntity.getCategoryUrl().length()-5);
                String categoryList = cmsCategoryEntity.getCategoryListUrl().substring(0,cmsCategoryEntity.getCategoryListUrl().length()-5);
                Map<String,Object> result = new HashMap<>();
                switch (template){
                    case "index":
                        url = "http://localhost:8082/toHtml/index/"+categoryItem.getId();
                        TemplateStaticUtil.urlToHtml(url,"index.html");
                        break;
                    case "about":
                        if (!(cmsCategoryEntity.getCategoryParentId()==null||cmsCategoryEntity.getCategoryParentId().equals("0"))){
                            url = "http://localhost:8082/toHtml/about/"+cmsCategoryEntity.getCategoryParentId();
                            TemplateStaticUtil.urlToHtml(url,"about.html");

                        }else{
                            url = "http://localhost:8082/toHtml/about/"+cmsCategoryEntity.getId();
                            TemplateStaticUtil.urlToHtml(url,"about.html");
                        }
                        break;
                    case "generation":
                        url = "http://localhost:8082/toHtml/generation/"+cmsCategoryEntity.getId();
                        TemplateStaticUtil.urlToHtml(url,"generation.html");
                        ThymeleafViewObject.tags.set(indexService.getTags());
                        ThymeleafViewObject.news.set(indexService.getNewsByMainCategory());
                        ThymeleafViewObject.relateCase65.set(indexService.getcontentByCategory(65,1,3));
                        ThymeleafViewObject.relateCase67.set(indexService.getcontentByCategory(67,1,3));
                        List<CmsContentEntity> pages= (List<CmsContentEntity>) indexService.getcontentByCategory(cmsCategoryEntity.getId());

                        for (int i=0;i<pages.size();i++){
                            if(i==0){
                                result.put("last",new CmsContentEntity());
                            }else{
                                result.put("last",pages.get(i-1));
                            }
                            if(i==pages.size()-1){
                                result.put("next",new CmsContentEntity());
                            }else{
                                result.put("next",pages.get(i+1));
                            }
                            ThymeleafViewObject.lastAndNextProgress.set(result);
                            ThymeleafViewObject.contentResult.set(pages.get(i));
                            TemplateStaticUtil.urlToHtml("http://localhost:8082/toHtml/details/"+cmsCategoryEntity.getId()+"/"+pages.get(i).getId(),""+categoryList+"_"+pages.get(i).getId()+".html");
                        }

                        break;
                    case "lifting":
                        url = "http://localhost:8082/toHtml/lifting/"+cmsCategoryEntity.getId();
                        TemplateStaticUtil.urlToHtml(url,"lifting.html");
                        break;
                    case "construction":
                        url = "http://localhost:8082/toHtml/construction/"+cmsCategoryEntity.getId();
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
                            ThymeleafViewObject.lastAndNextProgress.set(result);
                            ThymeleafViewObject.contentResult.set(projectDtos.get(i));
                            TemplateStaticUtil.urlToHtml("http://localhost:8082/toHtml/progress/"+cmsCategoryEntity.getId()+"/"+projectDtos.get(i).getId(),"progress_"+projectDtos.get(i).getId()+".html");
                        }
                        break;
                    case "lamp":
                        ThymeleafViewObject.tags.set(indexService.getTags());
                        ThymeleafViewObject.news.set(indexService.getNewsByMainCategory());
                        ThymeleafViewObject.relateCase65.set(indexService.getcontentByCategory(65,1,3));
                        ThymeleafViewObject.relateCase67.set(indexService.getcontentByCategory(67,1,3));
                        if (!(cmsCategoryEntity.getCategoryParentId()==null||cmsCategoryEntity.getCategoryParentId().equals("0"))){
                            //获取分类下所有文章
                            List<CmsContentEntity> lampPages= (List<CmsContentEntity>)indexService.getcontentByCategory(cmsCategoryEntity.getId());
                            //获取分类所有同级分类
                            List<CmsCategoryEntity> lampCategoryEntity = (List<CmsCategoryEntity>) indexService.getCaseCategory(Integer.parseInt(cmsCategoryEntity.getCategoryParentId()));
                            if(lampCategoryEntity.get(0).getId().equals(categoryItem.getId())){
                                TemplateStaticUtil.urlToHtml( "http://localhost:8082/toHtml/lamp/"+cmsCategoryEntity.getId()+"/1","lamp.html");
                            }
                            ThymeleafViewObject.categoryList.set(cmsCategoryEntity);
                            int lampTotalPages = lampPages.size()%pageSize>0 ? lampPages.size()/pageSize+1:lampPages.size()/pageSize;
                            if(lampTotalPages>0){
                                for (int i=1;i<=lampTotalPages;i++){
                                    ThymeleafViewObject.contentList.set(getByPage(lampPages,i,lampTotalPages));
                                    url = "http://localhost:8082/toHtml/lamp/"+categoryItem.getId()+"/"+i;
                                    TemplateStaticUtil.urlToHtml(url,"lamp\\"+cmsCategoryEntity.getId()+"_"+i+".html");
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
                                    ThymeleafViewObject.lastAndNextProgress.set(result);
                                    ThymeleafViewObject.contentResult.set(lampPages.get(i));
                                    TemplateStaticUtil.urlToHtml("http://localhost:8082/toHtml/details/"+cmsCategoryEntity.getId()+"/"+lampPages.get(i).getId(),""+categoryList+"_"+lampPages.get(i).getId()+".html");
                                }
                            }
                        }else{
                            List<CmsCategoryEntity> cmsCategoryEntities2 = (List<CmsCategoryEntity>) indexService.getCaseCategory(cmsCategoryEntity.getId());
                            TemplateStaticUtil.urlToHtml( "http://localhost:8082/toHtml/lamp/"+cmsCategoryEntities2.get(0).getId()+"/1","lamp.html");
                            for (CmsCategoryEntity lampCategory:cmsCategoryEntities2
                            ) {
                                int lampCategoryId = lampCategory.getId();
                                List<CmsContentEntity> lampPages= (List<CmsContentEntity>) (PageInfo<CmsContentEntity>)indexService.getcontentByCategory(lampCategoryId);
                                int lampTotalPages = lampPages.size()%pageSize>0 ? lampPages.size()/pageSize+1:lampPages.size()/pageSize;
                                if(lampTotalPages>0){
                                    for (int i=1;i<=lampTotalPages;i++){
                                        ThymeleafViewObject.contentList.set(getByPage(lampPages,i,lampTotalPages));
                                        url = "http://localhost:8082/toHtml/lamp/"+lampCategoryId+"/"+i;
                                        TemplateStaticUtil.urlToHtml(url,"lamp\\"+lampCategoryId+"_"+i+".html");
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
                                        ThymeleafViewObject.lastAndNextProgress.set(result);
                                        ThymeleafViewObject.contentResult.set(lampPages.get(i));
                                        TemplateStaticUtil.urlToHtml("http://localhost:8082/toHtml/details/"+cmsCategoryEntity.getId()+"/"+lampPages.get(i).getId(),""+categoryList+"_"+lampPages.get(i).getId()+".html");
                                    }
                                }
                            }
                        }
                        break;
                    case "case":
                        ThymeleafViewObject.tags.set(indexService.getTags());
                        ThymeleafViewObject.news.set(indexService.getNewsByMainCategory());
                        if (!(cmsCategoryEntity.getCategoryParentId()==null||cmsCategoryEntity.getCategoryParentId().equals("0"))){
                            //获取分类下所有文章
                            List<CmsContentEntity> lampPages= (List<CmsContentEntity>)indexService.getcontentByCategory(cmsCategoryEntity.getId());
                            //获取分类所有同级分类
                            List<CmsCategoryEntity> lampCategoryEntity = (List<CmsCategoryEntity>) indexService.getCaseCategory(Integer.parseInt(cmsCategoryEntity.getCategoryParentId()));
                            if(lampCategoryEntity.get(0).getId().equals(categoryItem.getId())){
                                TemplateStaticUtil.urlToHtml( "http://localhost:8082/toHtml/case/"+cmsCategoryEntity.getId()+"/1","case.html");
                            }
                            ThymeleafViewObject.categoryList.set(cmsCategoryEntity);
                            int lampTotalPages = lampPages.size()%pageSize>0 ? lampPages.size()/pageSize+1:lampPages.size()/pageSize;
                            if(lampTotalPages>0){
                                for (int i=1;i<=lampTotalPages;i++){
                                    ThymeleafViewObject.contentList.set(getByPage(lampPages,i,lampTotalPages));
                                    url = "http://localhost:8082/toHtml/case/"+cmsCategoryEntity.getId()+"/"+i;
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
                                    ThymeleafViewObject.lastAndNextProgress.set(result);
                                    ThymeleafViewObject.contentResult.set(lampPages.get(i));
                                    TemplateStaticUtil.urlToHtml("http://localhost:8082/toHtml/contentDetails/"+cmsCategoryEntity.getId()+"/"+lampPages.get(i).getId(),""+categoryList+"_"+lampPages.get(i).getId()+".html");
                                }
                            }
                        }else{
                            List<CmsCategoryEntity> cmsCategoryEntities2 = (List<CmsCategoryEntity>) indexService.getCaseCategory(cmsCategoryEntity.getId());
                            TemplateStaticUtil.urlToHtml( "http://localhost:8082/toHtml/case/"+cmsCategoryEntities2.get(0).getId()+"/1","case.html");
                            for (CmsCategoryEntity lampCategory:cmsCategoryEntities2
                            ) {
                                int lampCategoryId = lampCategory.getId();
                                List<CmsContentEntity> lampPages= (List<CmsContentEntity>) (PageInfo<CmsContentEntity>)indexService.getcontentByCategory(lampCategoryId);
                                int lampTotalPages = lampPages.size()%pageSize>0 ? lampPages.size()/pageSize+1:lampPages.size()/pageSize;
                                if(lampTotalPages>0){
                                    for (int i=1;i<=lampTotalPages;i++){
                                        ThymeleafViewObject.contentList.set(getByPage(lampPages,i,lampTotalPages));
                                        url = "http://localhost:8082/toHtml/case/"+lampCategoryId+"/"+i;
                                        TemplateStaticUtil.urlToHtml(url,"case\\"+lampCategoryId+"_"+i+".html");
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
                                        ThymeleafViewObject.lastAndNextProgress.set(result);
                                        ThymeleafViewObject.contentResult.set(lampPages.get(i));
                                        TemplateStaticUtil.urlToHtml("http://localhost:8082/toHtml/contentDetails/"+cmsCategoryEntity.getId()+"/"+lampPages.get(i).getId(),""+categoryList+"_"+lampPages.get(i).getId()+".html");
                                    }
                                }
                            }
                        }
                        break;
                    case "news":
                        ThymeleafViewObject.tags.set(indexService.getTags());
                        ThymeleafViewObject.news.set(indexService.getNewsByMainCategory());
                        if (!(cmsCategoryEntity.getCategoryParentId()==null||cmsCategoryEntity.getCategoryParentId().equals("0"))){
                            //获取分类下所有文章
                            List<CmsContentEntity> lampPages= (List<CmsContentEntity>)indexService.getcontentByCategory(cmsCategoryEntity.getId());
                            //获取分类所有同级分类
                            List<CmsCategoryEntity> lampCategoryEntity = (List<CmsCategoryEntity>) indexService.getCaseCategory(Integer.parseInt(cmsCategoryEntity.getCategoryParentId()));
                            if(lampCategoryEntity.get(0).getId().equals(CategoryId)){
                                TemplateStaticUtil.urlToHtml( "http://localhost:8082/toHtml/news/"+cmsCategoryEntity.getId()+"/1","news.html");
                            }
                            ThymeleafViewObject.categoryList.set(cmsCategoryEntity);
                            int lampTotalPages = lampPages.size()%pageSize>0 ? lampPages.size()/pageSize+1:lampPages.size()/pageSize;
                            if(lampTotalPages>0){
                                for (int i=1;i<=lampTotalPages;i++){
                                    ThymeleafViewObject.contentList.set(getByPage(lampPages,i,lampTotalPages));
                                    url = "http://localhost:8082/toHtml/news/"+cmsCategoryEntity.getId()+"/"+i;
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
                                    ThymeleafViewObject.lastAndNextProgress.set(result);
                                    ThymeleafViewObject.contentResult.set(lampPages.get(i));
                                    TemplateStaticUtil.urlToHtml("http://localhost:8082/toHtml/contentDetails/"+cmsCategoryEntity.getId()+"/"+lampPages.get(i).getId(),""+categoryList+"_"+lampPages.get(i).getId()+".html");
                                }
                            }
                        }else{
                            List<CmsCategoryEntity> cmsCategoryEntities2 = (List<CmsCategoryEntity>) indexService.getCaseCategory(cmsCategoryEntity.getId());
                            TemplateStaticUtil.urlToHtml( "http://localhost:8082/toHtml/news/"+cmsCategoryEntities2.get(0).getId()+"/1","news.html");
                            for (CmsCategoryEntity lampCategory:cmsCategoryEntities2
                            ) {
                                int lampCategoryId = lampCategory.getId();
                                List<CmsContentEntity> lampPages= (List<CmsContentEntity>) (PageInfo<CmsContentEntity>)indexService.getcontentByCategory(lampCategoryId);
                                int lampTotalPages = lampPages.size()%pageSize>0 ? lampPages.size()/pageSize+1:lampPages.size()/pageSize;
                                if(lampTotalPages>0){
                                    for (int i=1;i<=lampTotalPages;i++){
                                        ThymeleafViewObject.contentList.set(getByPage(lampPages,i,lampTotalPages));
                                        url = "http://localhost:8082/toHtml/news/"+lampCategoryId+"/"+i;
                                        TemplateStaticUtil.urlToHtml(url,"news\\"+lampCategoryId+"_"+i+".html");
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
                                        ThymeleafViewObject.lastAndNextProgress.set(result);
                                        ThymeleafViewObject.contentResult.set(lampPages.get(i));
                                        TemplateStaticUtil.urlToHtml("http://localhost:8082/toHtml/contentDetails/"+cmsCategoryEntity.getId()+"/"+lampPages.get(i).getId(),""+categoryList+"_"+lampPages.get(i).getId()+".html");
                                    }
                                }
                            }
                        }
                        break;
                    case "contact":
                        url = "http://localhost:8082/toHtml/contact/"+cmsCategoryEntity.getId();
                        TemplateStaticUtil.urlToHtml(url,"contact.html");
                        break;
                    default:
                        break;
                }
            }
        }

    }

    private List<CmsContentEntity> getByPage(List<CmsContentEntity> contentEntities,Integer pageNum,Integer totalPages){
        if(pageNum<totalPages){
            return contentEntities.subList((pageNum-1)*pageSize,pageNum*pageSize-1);
        }else{
            return contentEntities.subList((pageNum-1)*pageSize,contentEntities.size()-1);
        }

    }
}
