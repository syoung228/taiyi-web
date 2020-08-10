package com.taiyi.websiate.taiyiweb.mapper;

import com.taiyi.websiate.taiyiweb.entity.ContentTagsEntity;
import com.taiyi.websiate.taiyiweb.entity.ContentTagsEntityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ContentTagsEntityMapper {
    long countByExample(ContentTagsEntityExample example);

    int deleteByExample(ContentTagsEntityExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ContentTagsEntity record);

    int insertSelective(ContentTagsEntity record);

    /** QuerySignleResultMethodPlugin 生成 by plugn */
    ContentTagsEntity singleResultByExample(ContentTagsEntityExample example);

    /** QueryMethodPlugin 生成 by plugn */
    List query(ContentTagsEntity example);

    List<ContentTagsEntity> selectByExample(ContentTagsEntityExample example);

    ContentTagsEntity selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ContentTagsEntity record, @Param("example") ContentTagsEntityExample example);

    int updateByExample(@Param("record") ContentTagsEntity record, @Param("example") ContentTagsEntityExample example);

    int updateByPrimaryKeySelective(ContentTagsEntity record);

    int updateByPrimaryKey(ContentTagsEntity record);
}