package com.xdx.garbage.entity;

import java.util.Date;
import java.util.List;
import javax.persistence.*;

@Table(name = "t_house")
public class THouse {
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
     * 小区名称
     */
    @Column(name = "house_name")
    private String houseName;

    @Column(name = "province_id")
    private Long provinceId;

    @Column(name = "city_id")
    private Long cityId;

    private TProvince province;

    private TCity city;

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
     * 获取小区名称
     *
     * @return house_name - 小区名称
     */
    public String getHouseName() {
        return houseName;
    }

    /**
     * 设置小区名称
     *
     * @param houseName 小区名称
     */
    public void setHouseName(String houseName) {
        this.houseName = houseName;
    }

    public Long getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Long provinceId) {
        this.provinceId = provinceId;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }
    private List<Long>points;

    public TProvince getProvince() {
        return province;
    }

    public void setProvince(TProvince province) {
        this.province = province;
    }

    public TCity getCity() {
        return city;
    }

    public void setCity(TCity city) {
        this.city = city;
    }

    public List<Long> getPoints() {
        return points;
    }

    public void setPoints(List<Long> points) {
        this.points = points;
    }
}