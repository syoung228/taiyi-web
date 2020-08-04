package com.taiyi.websiate.taiyiweb.controlloer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.taiyi.websiate.taiyiweb.servcice.IndexService;
import com.taiyi.websiate.taiyiweb.utils.AddressUtils;
import org.springframework.beans.factory.annotation.Autowired;
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

        String resultStr = AddressUtils.getCityByIp(request.getRemoteAddr());
        JSONObject json = JSON.parseObject(resultStr);
        return indexService.index(request);
    }


}
