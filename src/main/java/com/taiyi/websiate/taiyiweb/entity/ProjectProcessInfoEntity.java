package com.taiyi.websiate.taiyiweb.entity;

/**
 * 表名称：project_process_info
 * 表注释：
 * 
 * @author mybites-generater
 * @createtime 2020-08-03 17:12:12
 * 
 */
public class ProjectProcessInfoEntity {
    /**
     * 
     */
    private Integer id;

    /**
     * 进度描述
     */
    private String content;

    /**
     * 关联进度
     */
    private Integer itemId;

    /**
     * 关联项目工程
     */
    private Integer projectId;

    /**
     * 是否删除
     */
    private Integer isDelete;

    /**
     * 进度图片集
     */
    private String imgs;

    /**
     * 进度项名称
     */
    private String itemName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public String getImgs() {
        return imgs;
    }

    public void setImgs(String imgs) {
        this.imgs = imgs == null ? null : imgs.trim();
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName == null ? null : itemName.trim();
    }
}