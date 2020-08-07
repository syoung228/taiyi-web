package com.taiyi.websiate.taiyiweb.servcice;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.taiyi.websiate.taiyiweb.dto.CmsCategoryDto;
import com.taiyi.websiate.taiyiweb.entity.CmsCategoryEntity;
import com.taiyi.websiate.taiyiweb.entity.CmsCategoryEntityExample;
import com.taiyi.websiate.taiyiweb.entity.CmsContentEntity;
import com.taiyi.websiate.taiyiweb.entity.CmsContentEntityExample;
import com.taiyi.websiate.taiyiweb.mapper.CmsCategoryEntityMapper;
import com.taiyi.websiate.taiyiweb.mapper.CmsContentEntityMapper;
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
    ProjectProcessService projectProcessService;
    /**
     * 案例id
     */
    private Integer caseCategory = 61;
    /**
     * 首页banner
     */
    private Integer bannerCategory = 147;

    private Integer newsCategory = 59;

    public Object index(HttpServletRequest request){
        Map<String,Object> result = new HashMap<>();
        String resultStr = AddressUtils.getCityByIp(request.getRemoteAddr());
        JSONObject json = JSON.parseObject(resultStr);
        String cityCode = (String) json.getJSONObject("data").get("city_id");
        Integer cityCodeInt =0;
        try{
            cityCodeInt = Integer.parseInt(cityCode);
        }catch (Exception e){

        }

        List<CmsCategoryDto> cmsCaseDtos = entityToDto(caseCategory);
        for(int i=0;i<cmsCaseDtos.size();i++){
            //获取案例 关联城市
            List<CmsContentEntity> cityCmsContent = cmsContentEntityMapper.getByCategoryId(cmsCaseDtos.get(i).getId(),cityCodeInt);
            if(cityCmsContent==null||cityCmsContent.size()<=0){
                cmsCaseDtos.get(i).setCmsContentEntities(cmsContentEntityMapper.getByCategoryId(caseCategory,0));
            }else{
                cmsCaseDtos.get(i).setCmsContentEntities(cityCmsContent);
            }
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
        cmsCategoryEntityExample.createCriteria().andCategoryParentIdEqualTo(categoryId+"").andDelEqualTo(0);
        List<CmsCategoryEntity> caseCategories =  cmsCategoryEntityMapper.selectByExample(cmsCategoryEntityExample);
        List<CmsCategoryDto> cmsCategoryDtos = new ArrayList<>();
        for (CmsCategoryEntity entity: caseCategories) {
            CmsCategoryDto cmsCategoryDto = new CmsCategoryDto();
            BeanUtils.copyProperties(entity,cmsCategoryDto);
            CmsContentEntityExample cmsContentEntityExample = new CmsContentEntityExample();
            cmsContentEntityExample.createCriteria().andContentCategoryIdEqualTo(entity.getId()+"").andDelEqualTo(0);
            cmsCategoryDto.setCmsContentEntities(cmsContentEntityMapper.selectByExample(cmsContentEntityExample));
            cmsCategoryDtos.add(cmsCategoryDto);
        }
        return cmsCategoryDtos;
    }

    public Object getcontentByCategory(Integer categoryId){

        return null;
    }
}
