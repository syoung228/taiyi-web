package com.taiyi.websiate.taiyiweb.mapper;

import com.taiyi.websiate.taiyiweb.entity.CompanyInfoEntity;
import com.taiyi.websiate.taiyiweb.entity.CompanyInfoEntityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CompanyInfoEntityMapper {
    long countByExample(CompanyInfoEntityExample example);

    int deleteByExample(CompanyInfoEntityExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CompanyInfoEntity record);

    int insertSelective(CompanyInfoEntity record);

    /** QuerySignleResultMethodPlugin 生成 by plugn */
    CompanyInfoEntity singleResultByExample(CompanyInfoEntityExample example);

    /** QueryMethodPlugin 生成 by plugn */
    List query(CompanyInfoEntity example);

    List<CompanyInfoEntity> selectByExample(CompanyInfoEntityExample example);

    CompanyInfoEntity selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CompanyInfoEntity record, @Param("example") CompanyInfoEntityExample example);

    int updateByExample(@Param("record") CompanyInfoEntity record, @Param("example") CompanyInfoEntityExample example);

    int updateByPrimaryKeySelective(CompanyInfoEntity record);

    int updateByPrimaryKey(CompanyInfoEntity record);
}