package com.taiyi.websiate.taiyiweb.mapper;

import com.taiyi.websiate.taiyiweb.entity.TagsEntity;
import com.taiyi.websiate.taiyiweb.entity.TagsEntityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TagsEntityMapper {
    long countByExample(TagsEntityExample example);

    int deleteByExample(TagsEntityExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TagsEntity record);

    int insertSelective(TagsEntity record);

    /** QuerySignleResultMethodPlugin 生成 by plugn */
    TagsEntity singleResultByExample(TagsEntityExample example);

    /** QueryMethodPlugin 生成 by plugn */
    List query(TagsEntity example);

    List<TagsEntity> selectByExample(TagsEntityExample example);

    TagsEntity selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TagsEntity record, @Param("example") TagsEntityExample example);

    int updateByExample(@Param("record") TagsEntity record, @Param("example") TagsEntityExample example);

    int updateByPrimaryKeySelective(TagsEntity record);

    int updateByPrimaryKey(TagsEntity record);
}