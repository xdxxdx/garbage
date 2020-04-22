package com.xdx.garbage.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_news")
public class TNews {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

    @Column(name = "is_del")
    private Integer isDel;

    /**
     * 资讯标题
     */
    @Column(name = "news_title")
    private String newsTitle;

    /**
     * 封面图
     */
    @Column(name = "photo_src")
    private String photoSrc;

    private Integer status;

    /**
     * 跳转到公众号的地址
     */
    @Column(name = "jump_url")
    private String jumpUrl;

    /**
     * 文章内容
     */
    @Column(name = "news_content")
    private String newsContent;

    @Column(name = "read_num")
    private String readNum;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return update_time
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * @return is_del
     */
    public Integer getIsDel() {
        return isDel;
    }

    /**
     * @param isDel
     */
    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

    /**
     * 获取资讯标题
     *
     * @return news_title - 资讯标题
     */
    public String getNewsTitle() {
        return newsTitle;
    }

    /**
     * 设置资讯标题
     *
     * @param newsTitle 资讯标题
     */
    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    /**
     * 获取封面图
     *
     * @return photo_src - 封面图
     */
    public String getPhotoSrc() {
        return photoSrc;
    }

    /**
     * 设置封面图
     *
     * @param photoSrc 封面图
     */
    public void setPhotoSrc(String photoSrc) {
        this.photoSrc = photoSrc;
    }

    /**
     * @return status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * @param status
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取跳转到公众号的地址
     *
     * @return jump_url - 跳转到公众号的地址
     */
    public String getJumpUrl() {
        return jumpUrl;
    }

    /**
     * 设置跳转到公众号的地址
     *
     * @param jumpUrl 跳转到公众号的地址
     */
    public void setJumpUrl(String jumpUrl) {
        this.jumpUrl = jumpUrl;
    }

    /**
     * 获取文章内容
     *
     * @return news_content - 文章内容
     */
    public String getNewsContent() {
        return newsContent;
    }

    /**
     * 设置文章内容
     *
     * @param newsContent 文章内容
     */
    public void setNewsContent(String newsContent) {
        this.newsContent = newsContent;
    }

    public String getReadNum() {
        return readNum;
    }

    public void setReadNum(String readNum) {
        this.readNum = readNum;
    }
}