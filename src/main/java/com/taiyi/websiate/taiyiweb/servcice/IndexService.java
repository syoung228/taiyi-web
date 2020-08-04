package com.taiyi.websiate.taiyiweb.servcice;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.taiyi.websiate.taiyiweb.entity.CmsCategoryEntity;
import com.taiyi.websiate.taiyiweb.entity.CmsCategoryEntityExample;
import com.taiyi.websiate.taiyiweb.entity.CmsContentEntity;
import com.taiyi.websiate.taiyiweb.mapper.CmsCategoryEntityMapper;
import com.taiyi.websiate.taiyiweb.mapper.CmsContentEntityMapper;
import com.taiyi.websiate.taiyiweb.utils.AddressUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
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
        Integer regionCode = (Integer) json.getJSONObject("data").get("region_id");
        Integer cityCode = (Integer) json.getJSONObject("data").get("city_id");
        CmsCategoryEntityExample cmsCategoryEntityExample = new CmsCategoryEntityExample();
        cmsCategoryEntityExample.createCriteria().andIdEqualTo(61).andDelEqualTo(0);
        CmsCategoryEntity cmsCategoryEntity =  cmsCategoryEntityMapper.singleResultByExample(cmsCategoryEntityExample);
        //获取案例 关联城市
        List<CmsContentEntity> cityCmsContent = cmsContentEntityMapper.getByCategoryId(caseCategory,cityCode);
        if(cityCmsContent==null||cityCmsContent.size()<=0){
            result.put("case",cmsContentEntityMapper.getByCategoryId(caseCategory,0));
        }else{
            result.put("case",cityCmsContent);
        }
        //获取banner
        result.put("banner", cmsContentEntityMapper.getByCategoryId(bannerCategory,null));
        //行业新闻
        result.put("news", cmsContentEntityMapper.getByCategoryId(newsCategory,null));
        //工程进度
        result.put("projects", projectProcessService.getProjectList());

        return cmsCategoryEntity;
    }
}
