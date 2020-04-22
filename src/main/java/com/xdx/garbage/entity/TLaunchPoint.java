package com.xdx.garbage.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_launch_point")
public class TLaunchPoint {
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
     * 投放点名称
     */
    @Column(name = "point_name")
    private String pointName;


    @Column(name = "province_id")
    private Long provinceId;

    @Column(name = "city_id")
    private Long cityId;

    private TProvince province;

    private TCity city;

    @Column(name = "agent_id")
    private Long AgentId;

    /**
     * 经度
     */
    private String longitude;

    /**
     * 纬度
     */
    private String latitude;

    @Column(name = "status")
    private Integer status;

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
     * 获取投放点名称
     *
     * @return point_name - 投放点名称
     */
    public String getPointName() {
        return pointName;
    }

    /**
     * 设置投放点名称
     *
     * @param pointName 投放点名称
     */
    public void setPointName(String pointName) {
        this.pointName = pointName;
    }

    /**
     * 获取经度
     *
     * @return longitude - 经度
     */
    public String getLongitude() {
        return longitude;
    }

    /**
     * 设置经度
     *
     * @param longitude 经度
     */
    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    /**
     * 获取纬度
     *
     * @return latitude - 纬度
     */
    public String getLatitude() {
        return latitude;
    }

    /**
     * 设置纬度
     *
     * @param latitude 纬度
     */
    public void setLatitude(String latitude) {
        this.latitude = latitude;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getAgentId() {
        return AgentId;
    }

    public void setAgentId(Long agentId) {
        AgentId = agentId;
    }
}