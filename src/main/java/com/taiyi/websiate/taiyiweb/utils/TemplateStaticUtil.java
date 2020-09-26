package com.taiyi.websiate.taiyiweb.utils;

import org.springframework.beans.factory.annotation.Value;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;

public class TemplateStaticUtil {

    private static String rootPath = "/taiyi/html/";

   /* public  static void urlToHtml(String url,String path) throws IOException {
        InputStream inputStream;//接收字节输入流
        InputStreamReader inputStreamReader;//将字节输入流转换成字符输入流
        BufferedReader bufferedReader;//为字符输入流加缓冲
        FileOutputStream fileOutputStream;//字节输出流
        OutputStreamWriter outputStreamWriter;//将字节输出流转换成字符输出流

        URL wangyi = new URL(url);
        inputStream = wangyi.openStream();
        inputStreamReader = new InputStreamReader(inputStream);
        bufferedReader = new BufferedReader(inputStreamReader);
        String s;
        File dest = new File(rootPath+path);
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
    }*/

    public static void urlToHtml(String urlString,String path) throws IOException {
        URL url = new URL(urlString);
        URLConnection connection = url.openConnection();
        //获得字节流
        InputStream inputStream = connection.getInputStream();
        //获得字节缓冲流
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        FileOutputStream fileOutputStream = new FileOutputStream(rootPath+path);
        byte[] bytes = new byte[1024];
        int total_number=0;
        while((total_number = inputStream.read(bytes,0,1024)) >0) {
            //写入文件
            fileOutputStream.write(bytes,0,total_number);
        }
        fileOutputStream.close();
    }


}
