package com.taiyi.websiate.taiyiweb.utils;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Value;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @Despriction:
 * @Author: syoung
 * @Date:Created in
 * @Modity By:
 */
public class AddressUtils {
    @Value("${taobao.ip.api}")
    private  static String getAddressApi ;
    @Value("${taobao.ip.accessKey}")
    private static String accessKey ;
    public static String getCityByIp(String address){

        // 创建Get请求
        String url = "http://ip.taobao.com/outGetIpInfo?ip="+address+"&accessKey=alibaba-inc";
        String strResult = "";
        try {
            // 获得Http客户端(可以理解为:你得先有一个浏览器;注意:实际上HttpClient与浏览器是不一样的)
            CloseableHttpClient httpClient = HttpClientBuilder.create().build();
            // 发送get请求
            HttpGet request = new HttpGet(url);
            HttpResponse response = httpClient.execute(request);

            /** 请求发送成功，并得到响应 **/
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                /** 读取服务器返回过来的json字符串数据 **/
                strResult = EntityUtils.toString(response.getEntity());
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return strResult;
    }
}
