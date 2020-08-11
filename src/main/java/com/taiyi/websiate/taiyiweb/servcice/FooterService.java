package com.taiyi.websiate.taiyiweb.servcice;

import com.taiyi.websiate.taiyiweb.entity.CompanyInfoEntity;
import com.taiyi.websiate.taiyiweb.entity.CompanyInfoEntityExample;
import com.taiyi.websiate.taiyiweb.entity.FeedbackEntity;
import com.taiyi.websiate.taiyiweb.mapper.CompanyInfoEntityMapper;
import com.taiyi.websiate.taiyiweb.mapper.FeedbackEntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Despriction:
 * @Author: syoung
 * @Date:Created in
 * @Modity By:
 */
@Service
public class FooterService {
    @Autowired
    private CompanyInfoEntityMapper companyInfoEntityMapper;
    @Autowired
    private FeedbackEntityMapper feedbackEntityMapper;

    public CompanyInfoEntity getCompany(){
        return companyInfoEntityMapper.selectByExample(new CompanyInfoEntityExample()).get(0);
    }
    public int saveFeed(FeedbackEntity entity){
        entity.setCreateTime(System.currentTimeMillis());
        entity.setStatus(0);
        return feedbackEntityMapper.insertSelective(entity);
    }

}
