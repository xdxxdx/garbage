package com.xdx.garbage.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_house_point")
public class THousePoint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

    @Column(name = "is_del")
    private Integer isDel;

    @Column(name = "house_id")
    private Long houseId;

    @Column(name = "point_id")
    private Long pointId;

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
     * @return house_id
     */
    public Long getHouseId() {
        return houseId;
    }

    /**
     * @param houseId
     */
    public void setHouseId(Long houseId) {
        this.houseId = houseId;
    }

    /**
     * @return point_id
     */
    public Long getPointId() {
        return pointId;
    }

    /**
     * @param pointId
     */
    public void setPointId(Long pointId) {
        this.pointId = pointId;
    }
}