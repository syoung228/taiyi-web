package com.taiyi.websiate.taiyiweb.servcice;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.taiyi.websiate.taiyiweb.entity.CmsCategoryEntity;
import com.taiyi.websiate.taiyiweb.entity.CmsCategoryEntityExample;
import com.taiyi.websiate.taiyiweb.mapper.CmsCategoryEntityMapper;
import com.taiyi.websiate.taiyiweb.utils.AddressUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
@Service
public class IndexService {
    @Autowired
    CmsCategoryEntityMapper cmsCategoryEntityMapper;

    public Object index(HttpServletRequest request){
        String resultStr = AddressUtils.getCityByIp(request.getRemoteAddr());
        JSONObject json = JSON.parseObject(resultStr);
        String regionCode = (String) json.getJSONObject("data").get("region_id");
        String cityCode = (String) json.getJSONObject("data").get("city_id");
        Map<String,Object> result = new HashMap<>();
        CmsCategoryEntityExample cmsCategoryEntityExample = new CmsCategoryEntityExample();
        cmsCategoryEntityExample.createCriteria().andIdEqualTo(61).andDelEqualTo(0);
        CmsCategoryEntity cmsCategoryEntity =  cmsCategoryEntityMapper.singleResultByExample(cmsCategoryEntityExample);
        cmsCategoryEntity.getId();

        return cmsCategoryEntity;
    }
}
