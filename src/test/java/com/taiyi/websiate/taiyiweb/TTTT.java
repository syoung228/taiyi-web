package com.taiyi.websiate.taiyiweb;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.taiyi.websiate.taiyiweb.utils.AddressUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.Principal;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Map;

/**
 * @Despriction:
 * @Author: syoung
 * @Date:Created in
 * @Modity By:
 */
public class TTTT {
  public static void main(String[] args) {
      String re = AddressUtils.getCityByIp("222.212.185.15");
      JSONObject o = JSON.parseObject(re);
      String regionCode = (String) o.getJSONObject("data").get("region_id");
      String cityCode = (String) o.getJSONObject("data").get("city_id");
    System.out.println(regionCode+"========"+cityCode);
    //
  }
}
