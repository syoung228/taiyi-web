package com.taiyi.websiate.taiyiweb.servcice;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taiyi.websiate.taiyiweb.dto.CmsCategoryDto;
import com.taiyi.websiate.taiyiweb.entity.*;
import com.taiyi.websiate.taiyiweb.mapper.CmsCategoryEntityMapper;
import com.taiyi.websiate.taiyiweb.mapper.CmsContentEntityMapper;
import com.taiyi.websiate.taiyiweb.mapper.ContactEntityMapper;
import com.taiyi.websiate.taiyiweb.mapper.TagsEntityMapper;
import com.taiyi.websiate.taiyiweb.utils.AddressUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class IndexService {
    @Autowired
    CmsCategoryEntityMapper cmsCategoryEntityMapper;

    @Autowired
    CmsContentEntityMapper cmsContentEntityMapper;

    @Autowired
    TagsEntityMapper tagsEntityMapper;
    @Autowired
    ProjectProcessService projectProcessService;
    @Autowired
    ContactEntityMapper contactEntityMapper;
    /**
     * 案例id
     */
    private Integer caseCategory = 7;
    /**
     * 首页banner
     */
    private Integer bannerCategory = 147;

    private Integer newsCategory = 8;

    public Object getCaseRegion(HttpServletRequest request){
        String address = AddressUtils.getIPAddress(request);
        System.out.println("城市真是ip======="+address);
        String resultStr = AddressUtils.getCityByIp(address);
        JSONObject json = JSON.parseObject(resultStr);
        String cityCode = (String) json.getJSONObject("data").get("city_id");
        System.out.println(json);
        Integer cityCodeInt =0;
        try{
            cityCodeInt = Integer.parseInt(cityCode);
        }catch (Exception e){

        }
        //推荐案例
        List<CmsContentEntity> cmsContentEntities = cmsContentEntityMapper.getByRegion(cityCodeInt);
        if(cmsContentEntities ==null || cmsContentEntities.size()<=0){
            return cmsContentEntityMapper.getByRegion(0);
        }else{
            return cmsContentEntities;
        }
    }
    public Object index(){
        Map<String,Object> result = new HashMap<>();

        List<CmsCategoryDto> cmsCaseDtos = entityToDto(caseCategory);
        for(int i=0;i<cmsCaseDtos.size();i++){
            //获取案例 关联城市
            List<CmsContentEntity> cityCmsContent = cmsContentEntityMapper.getByCategoryId2(cmsCaseDtos.get(i).getId());
            cmsCaseDtos.get(i).setCmsContentEntities(cityCmsContent);
        }



        //案例分类
        result.put("caseCategory",cmsCaseDtos);
        //获取banner
        result.put("banner", cmsContentEntityMapper.getByCategoryId2(bannerCategory));
        //行业新闻
        result.put("news", entityToDto(newsCategory));
        //工程进度
        projectProcessService.getProjectList();
        result.put("projects", projectProcessService.getProjectList());

        return result;
    }

    private List<CmsCategoryDto> entityToDto(Integer categoryId){
        CmsCategoryEntityExample cmsCategoryEntityExample = new CmsCategoryEntityExample();
        cmsCategoryEntityExample.setOrderByClause(" category_sort desc");
        cmsCategoryEntityExample.createCriteria().andCategoryParentIdEqualTo(categoryId+"").andDelEqualTo(0);
        List<CmsCategoryEntity> caseCategories =  cmsCategoryEntityMapper.selectByExample(cmsCategoryEntityExample);
        List<CmsCategoryDto> cmsCategoryDtos = new ArrayList<>();
        for (CmsCategoryEntity entity: caseCategories) {
            CmsCategoryDto cmsCategoryDto = new CmsCategoryDto();
            BeanUtils.copyProperties(entity,cmsCategoryDto);
            CmsContentEntityExample cmsContentEntityExample = new CmsContentEntityExample();
            cmsContentEntityExample.createCriteria().andContentCategoryIdEqualTo(entity.getId()+"").andDelEqualTo(0);
            cmsContentEntityExample.setOrderByClause(" content_datetime desc");
            cmsCategoryDto.setCmsContentEntities(cmsContentEntityMapper.selectByExample(cmsContentEntityExample));
            cmsCategoryDtos.add(cmsCategoryDto);
        }
        return cmsCategoryDtos;
    }

    public Object getcontentByCategory(Integer categoryId,Integer pageNum,Integer pageSize){
        pageNum=pageNum==null || pageNum==0?1:pageNum;
        pageSize=pageSize==null||pageSize==0?12:pageSize;
        PageHelper.startPage(pageNum,pageSize);
        List<CmsContentEntity> cmsContentEntities = cmsContentEntityMapper.getByCategoryId2(categoryId);
        return new PageInfo<>(cmsContentEntities);
    }
    public Object getcontentByCategory(Integer categoryId){
        List<CmsContentEntity> cmsContentEntities = cmsContentEntityMapper.getByCategoryId2(categoryId);
        return cmsContentEntities;
    }

    public Object getCaseCategory(Integer categoryId){
        CmsCategoryEntityExample cmsCategoryEntityExample = new CmsCategoryEntityExample();
        cmsCategoryEntityExample.setOrderByClause(" category_sort desc");
        cmsCategoryEntityExample.createCriteria().andCategoryParentIdEqualTo(categoryId+"").andDelEqualTo(0);
        return cmsCategoryEntityMapper.selectByExample(cmsCategoryEntityExample);
    }

    public CmsCategoryEntity getById(Integer categoryId){
        return cmsCategoryEntityMapper.selectByPrimaryKey(categoryId);
    }
    public Object getContenDetail(Integer id){
        return cmsContentEntityMapper.selectByPrimaryKey(id);
    }

    public Object getNewsByMainCategory(){
        return cmsContentEntityMapper.getByMainCategory(newsCategory);
    }

    public Object getTags(){
        return tagsEntityMapper.selectByExample(new TagsEntityExample());
    }

    public Object getcontentByTags(Integer tagsId,Integer pageNum,Integer pageSize){
        pageNum=pageNum==null || pageNum==0?1:pageNum;
        pageSize=pageSize==null || pageSize==0?10:pageSize;
        PageHelper.startPage(pageNum,pageSize);
        List<CmsContentEntity> entityList = cmsContentEntityMapper.getByTags(tagsId);
        for (CmsContentEntity item : entityList) {
            String detailUrl = cmsCategoryEntityMapper.selectByPrimaryKey(Integer.parseInt(item.getContentCategoryId())).getCategoryListUrl();
            if("contentDetails.html".equals(detailUrl)){
                item.setContentUrl("contentDetails");
            }
            if("details.html".equals(detailUrl)){
                item.setContentUrl("details");
            }
        }
        return new PageInfo<>(entityList);
    }
    public TagsEntity getTasgById(Integer tagsId){
        return tagsEntityMapper.selectByPrimaryKey(tagsId);
    }


    public Object getLastAndNextContent(Integer contentId,Integer categoryId){
        Map<String,Object> result = new HashMap<>();
        CmsContentEntity next = cmsContentEntityMapper.getNextContent(contentId,categoryId);
        CmsContentEntity last = cmsContentEntityMapper.getLastContent(contentId,categoryId);
        result.put("last",last!=null?last:new CmsContentEntity());
        result.put("next",next!=null?next:new CmsContentEntity());
        return result;
    }

    public Object headerList(){
        CmsCategoryEntityExample cmsCategoryEntityExample = new CmsCategoryEntityExample();
        cmsCategoryEntityExample.createCriteria().andCategoryParentIdIsNull();
        cmsCategoryEntityExample.setOrderByClause(" category_sort desc");
        return cmsCategoryEntityMapper.selectByExample(cmsCategoryEntityExample);
    }

    public Object getContact(){
        return contactEntityMapper.selectByExample(new ContactEntityExample()).get(0);
    }
}
