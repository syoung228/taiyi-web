package com.taiyi.websiate.taiyiweb.mapper;

import com.taiyi.websiate.taiyiweb.entity.FeedbackEntity;
import com.taiyi.websiate.taiyiweb.entity.FeedbackEntityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FeedbackEntityMapper {
    long countByExample(FeedbackEntityExample example);

    int deleteByExample(FeedbackEntityExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FeedbackEntity record);

    int insertSelective(FeedbackEntity record);

    /** QuerySignleResultMethodPlugin 生成 by plugn */
    FeedbackEntity singleResultByExample(FeedbackEntityExample example);

    /** QueryMethodPlugin 生成 by plugn */
    List query(FeedbackEntity example);

    List<FeedbackEntity> selectByExample(FeedbackEntityExample example);

    FeedbackEntity selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FeedbackEntity record, @Param("example") FeedbackEntityExample example);

    int updateByExample(@Param("record") FeedbackEntity record, @Param("example") FeedbackEntityExample example);

    int updateByPrimaryKeySelective(FeedbackEntity record);

    int updateByPrimaryKey(FeedbackEntity record);
}