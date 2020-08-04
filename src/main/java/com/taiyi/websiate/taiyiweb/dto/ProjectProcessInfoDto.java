package com.taiyi.websiate.taiyiweb.dto;

/**
 * @Despriction:
 * @Author: syoung
 * @Date:Created in
 * @Modity By:
 */
public class ProjectProcessInfoDto {
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
     * 进度图片集
     */
    private String imgs;

    /**
     * 进度项名称
     */
    private String itemName;
    /**
     * 进度项icon
     */
    private String itemIcon;

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
        this.content = content;
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

    public String getImgs() {
        return imgs;
    }

    public void setImgs(String imgs) {
        this.imgs = imgs;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemIcon() {
        return itemIcon;
    }

    public void setItemIcon(String itemIcon) {
        this.itemIcon = itemIcon;
    }
}
