package com.taiyi.websiate.taiyiweb.controlloer;

import com.taiyi.websiate.taiyiweb.entity.FeedbackEntity;
import com.taiyi.websiate.taiyiweb.servcice.FooterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Despriction:
 * @Author: syoung
 * @Date:Created in 2020-08-11
 * @Modity By:
 */
@RestController
@RequestMapping("/footer")
public class FooterController {
    @Autowired
    FooterService footerService;

    @GetMapping("/companyInfo")
    public Object getCompanyInfo(){
        return footerService.getCompany();
    }
    @PostMapping("/feedback")
    public Object feedBack(FeedbackEntity entity){
        if(entity == null){
            return -1;
        }
        if(entity.getName()==null||entity.getName().length()<=0||entity.getPhone()==null||entity.getPhone().length()<=0||entity.getWords()==null||entity.getWords().length()<=0){
            return -1;
        }
        return footerService.saveFeed(entity);
    }
}
