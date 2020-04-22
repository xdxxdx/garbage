package com.xdx.garbage.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_city")
public class TCity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

    @Column(name = "is_del")
    private Integer isDel;

    @Column(name = "province_id")
    private Long provinceId;

    @Column(name = "city_name")
    private String cityName;

    private TProvince province;

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
     * @return province_id
     */
    public Long getProvinceId() {
        return provinceId;
    }

    /**
     * @param provinceId
     */
    public void setProvinceId(Long provinceId) {
        this.provinceId = provinceId;
    }

    /**
     * @return city_name
     */
    public String getCityName() {
        return cityName;
    }

    /**
     * @param cityName
     */
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public TProvince getProvince() {
        return province;
    }

    public void setProvince(TProvince province) {
        this.province = province;
    }
}