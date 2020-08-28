package com.taiyi.websiate.taiyiweb;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.taiyi.websiate.taiyiweb.entity.CmsContentEntity;
import com.taiyi.websiate.taiyiweb.utils.AddressUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.security.Principal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Despriction:
 * @Author: syoung
 * @Date:Created in
 * @Modity By:
 */
public class TTTT {
  public static void main(String[] args) throws IOException, ParseException {
      InputStream inputStream;//接收字节输入流
      InputStreamReader inputStreamReader;//将字节输入流转换成字符输入流
      BufferedReader bufferedReader;//为字符输入流加缓冲
      FileOutputStream fileOutputStream;//字节输出流
      OutputStreamWriter outputStreamWriter;//将字节输出流转换成字符输出流

      URL wangyi = new URL("http://localhost:8082/index/indexData");
      inputStream = wangyi.openStream();
      inputStreamReader = new InputStreamReader(inputStream);
      bufferedReader = new BufferedReader(inputStreamReader);
      String s;
      File dest = new File("E:\\bbb\\wangyi.html");
      fileOutputStream = new FileOutputStream(dest);
      outputStreamWriter = new OutputStreamWriter(fileOutputStream);
      while ((s = bufferedReader.readLine()) != null) {
          outputStreamWriter.write(s);
      }

      outputStreamWriter.close();
      fileOutputStream.close();
      bufferedReader.close();
      inputStreamReader.close();
      inputStream.close();
  }
}
