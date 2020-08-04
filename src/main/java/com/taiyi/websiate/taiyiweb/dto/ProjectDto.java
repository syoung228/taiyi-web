package com.taiyi.websiate.taiyiweb.dto;

import com.taiyi.websiate.taiyiweb.entity.ProjectProcessInfoEntity;

import java.util.List;

/**
 * @Despriction:
 * @Author: syoung
 * @Date:Created in
 * @Modity By:
 */
public class ProjectDto {
    /**
     *
     */
    private Integer id;

    /**
     * 标题
     */
    private String title;

    /**
     * 地址
     */
    private String address;

    /**
     * 0：进行中  1：已完成
     */
    private Integer status;

    /**
     * 描述
     */
    private String des;

    /**
     * 图片地址
     */
    private String imgUrl;

    /**
     * 项目时间
     */
    private Long createTime;
    /**
     * 进度详情
     */
    private List<ProjectProcessInfoEntity> projectProcessInfoEntity;
}
