package com.taiyi.websiate.taiyiweb.entity;

/**
 * 表名称：mdiy_post_feedback
 * 表注释：意见反馈
 * 
 * @author mybites-generater
 * @createtime 2020-08-03 10:37:50
 * 
 */
public class mdiyPostFeedbackEntity {
    /**
     * 
     */
    private Integer id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 手机
     */
    private String phone;

    /**
     * 留言
     */
    private String words;

    /**
     * 创建时间
     */
    private Long createTime;

    /**
     * 留言状态  0 未受理 1 已受理
     */
    private Integer status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getWords() {
        return words;
    }

    public void setWords(String words) {
        this.words = words == null ? null : words.trim();
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}