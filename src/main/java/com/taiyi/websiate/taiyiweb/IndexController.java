package com.taiyi.websiate.taiyiweb;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.taiyi.websiate.taiyiweb.utils.AddressUtils;
import com.taiyi.websiate.taiyiweb.utils.HttpClientUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @Despriction:
 * @Author: syoung
 * @Date:Created in
 * @Modity By:
 */
@RestController
@RequestMapping("/index")
public class IndexController {
    public Object indexDate(HttpServletRequest request){

        String resultStr = AddressUtils.getCityByIp(request.getRemoteAddr());
        JSONObject json = JSON.parseObject(resultStr);
        return null;
    }

}
