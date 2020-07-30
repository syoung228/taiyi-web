
package com.taiyi.websiate.taiyiweb.utils;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URLDecoder;

/**
 * httpclient工具类
    * @ClassName: HttpClientUtil
    * @Description: TODO(这里用一句话描述这个类的作用)
    * @author lixingcheng
    *
 */
public class HttpClientUtil {

	public static final String token_key = "token";


	private static PoolingHttpClientConnectionManager cm;

	static {
		init();
	}

	private static void init() {
		if (cm == null) {
			cm = new PoolingHttpClientConnectionManager();
			// 整个连接池最大连接数
			cm.setMaxTotal(50);
			// 每路由最大连接数，默认值是2
			cm.setDefaultMaxPerRoute(5);
		}
	}


	/**
	 * 通过连接池获取httpclient
	 * @Title: getHttpClient
	 * @Description:TODO(这里用一句话描述这个方法的作用)
	 * @param
	 * @return 参数
	 * @return CloseableHttpClient
	 * 返回类型 @throws
	 */
	private static CloseableHttpClient getHttpClient() {
		return HttpClients.custom().setConnectionManager(cm).build();
	}


	public static String httpPost(String url, Object jsonParam, String token) {

		return httpPost(url, jsonParam, false, token);
	}


	public static String httpPost(
		String url, Object jsonParam, boolean noNeedResponse, String token) {
		String strResult = "";
		try {
			CloseableHttpClient httpClient = getHttpClient();
			HttpPost method = new HttpPost(url);
			if(StringUtils.isNotEmpty(token)){
				method.setHeader(token_key, token);
			}
			if (null != jsonParam) {
				// 解决中文乱码问题
				StringEntity entity =
					new StringEntity(jsonParam.toString(), "utf-8");
				entity.setContentEncoding("UTF-8");
				entity.setContentType("application/json");
				method.setEntity(entity);
			}
			CloseableHttpResponse result = httpClient.execute(method);
			url = URLDecoder.decode(url, "UTF-8");
			/** 请求发送成功，并得到响应 **/
			if (result.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				try {
					/** 读取服务器返回过来的json字符串数据 **/
					strResult = EntityUtils.toString(result.getEntity());
					if (noNeedResponse) {
						return null;
					}
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		return strResult;
	}

	public static String httpGet(String url){
		return httpGet(url, null);
	}

	public static String httpGet(String url, String token) {

		// get请求返回结果
		String strResult = "";
		try {
			CloseableHttpClient httpClient = getHttpClient();
			// 发送get请求
			HttpGet request = new HttpGet(url);
			if(StringUtils.isNotEmpty(token)){
				request.setHeader(token_key, token);
			}
			HttpResponse response = httpClient.execute(request);

			/** 请求发送成功，并得到响应 **/
			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				/** 读取服务器返回过来的json字符串数据 **/
				strResult = EntityUtils.toString(response.getEntity());
			}
			else {
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		return strResult;
	}
}
