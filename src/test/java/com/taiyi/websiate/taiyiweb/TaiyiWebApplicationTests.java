package com.taiyi.websiate.taiyiweb;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.taiyi.websiate.taiyiweb.entity.CmsContentEntity;
import com.taiyi.websiate.taiyiweb.mapper.CmsContentEntityMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.*;
import java.util.Date;
import java.util.List;

@SpringBootTest
class TaiyiWebApplicationTests {
    @Autowired
    CmsContentEntityMapper mapper;
    @Test
    void contextLoads() throws IOException {
      /*  String json = JsonUtil.readJsonData("E:\\demo\\items.json");
        List<CmsContentEntity> array = JSONObject.parseArray(json,CmsContentEntity.class);

        for (CmsContentEntity caseTest:array){
            mapper.insertSelective(caseTest);
        }*/

    }



}
