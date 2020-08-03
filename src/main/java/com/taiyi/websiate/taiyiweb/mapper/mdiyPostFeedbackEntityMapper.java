package com.taiyi.websiate.taiyiweb.mapper;

import com.taiyi.websiate.taiyiweb.entity.mdiyPostFeedbackEntity;
import com.taiyi.websiate.taiyiweb.entity.mdiyPostFeedbackEntityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface mdiyPostFeedbackEntityMapper {
    long countByExample(mdiyPostFeedbackEntityExample example);

    int deleteByExample(mdiyPostFeedbackEntityExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(mdiyPostFeedbackEntity record);

    int insertSelective(mdiyPostFeedbackEntity record);

    /** QuerySignleResultMethodPlugin 生成 by plugn */
    mdiyPostFeedbackEntity singleResultByExample(mdiyPostFeedbackEntityExample example);

    /** QueryMethodPlugin 生成 by plugn */
    List query(mdiyPostFeedbackEntity example);

    List<mdiyPostFeedbackEntity> selectByExample(mdiyPostFeedbackEntityExample example);

    mdiyPostFeedbackEntity selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") mdiyPostFeedbackEntity record, @Param("example") mdiyPostFeedbackEntityExample example);

    int updateByExample(@Param("record") mdiyPostFeedbackEntity record, @Param("example") mdiyPostFeedbackEntityExample example);

    int updateByPrimaryKeySelective(mdiyPostFeedbackEntity record);

    int updateByPrimaryKey(mdiyPostFeedbackEntity record);
}