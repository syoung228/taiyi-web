package com.taiyi.websiate.taiyiweb.mapper;

import com.taiyi.websiate.taiyiweb.entity.ContactEntity;
import com.taiyi.websiate.taiyiweb.entity.ContactEntityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ContactEntityMapper {
    long countByExample(ContactEntityExample example);

    int deleteByExample(ContactEntityExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ContactEntity record);

    int insertSelective(ContactEntity record);

    /** QuerySignleResultMethodPlugin 生成 by plugn */
    ContactEntity singleResultByExample(ContactEntityExample example);

    /** QueryMethodPlugin 生成 by plugn */
    List query(ContactEntity example);

    List<ContactEntity> selectByExample(ContactEntityExample example);

    ContactEntity selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ContactEntity record, @Param("example") ContactEntityExample example);

    int updateByExample(@Param("record") ContactEntity record, @Param("example") ContactEntityExample example);

    int updateByPrimaryKeySelective(ContactEntity record);

    int updateByPrimaryKey(ContactEntity record);
}