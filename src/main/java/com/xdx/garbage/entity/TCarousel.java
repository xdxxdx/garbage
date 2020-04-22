package com.xdx.garbage.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_carousel")
public class TCarousel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

    @Column(name = "is_del")
    private Integer isDel;

    private Integer status;

    @Column(name = "photo_src")
    private String photoSrc;

    @Column(name = "jump_url")
    private String jumpUrl;

    @Column(name = "show_place")
    private String showPlace;

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
     * @return photo_src
     */
    public String getPhotoSrc() {
        return photoSrc;
    }

    /**
     * @param photoSrc
     */
    public void setPhotoSrc(String photoSrc) {
        this.photoSrc = photoSrc;
    }

    /**
     * @return jump_url
     */
    public String getJumpUrl() {
        return jumpUrl;
    }

    /**
     * @param jumpUrl
     */
    public void setJumpUrl(String jumpUrl) {
        this.jumpUrl = jumpUrl;
    }

    /**
     * @return show_place
     */
    public String getShowPlace() {
        return showPlace;
    }

    /**
     * @param showPlace
     */
    public void setShowPlace(String showPlace) {
        this.showPlace = showPlace;
    }
}