package com.xdx.garbage.entity;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "t_door_recycle")
public class TDoorRecycle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

    @Column(name = "is_del")
    private Integer isDel;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "recycle_time")
    private String recycleTime;

    @Column(name = "recycle_type")
    private String recycleType;

    private String note;

    private BigDecimal fee;

    @Column(name = "staff_id")
    private Long staffId;

    @Column(name = "confirm_time")
    private Date confirmTime;

    /**
     * 预约状态
     */
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * @return recycle_time
     */
    public String getRecycleTime() {
        return recycleTime;
    }

    /**
     * @param recycleTime
     */
    public void setRecycleTime(String recycleTime) {
        this.recycleTime = recycleTime;
    }

    /**
     * @return recycle_type
     */
    public String getRecycleType() {
        return recycleType;
    }

    /**
     * @param recycleType
     */
    public void setRecycleType(String recycleType) {
        this.recycleType = recycleType;
    }

    /**
     * @return note
     */
    public String getNote() {
        return note;
    }

    /**
     * @param note
     */
    public void setNote(String note) {
        this.note = note;
    }

    /**
     * @return fee
     */
    public BigDecimal getFee() {
        return fee;
    }

    /**
     * @param fee
     */
    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    /**
     * @return staff_id
     */
    public Long getStaffId() {
        return staffId;
    }

    /**
     * @param staffId
     */
    public void setStaffId(Long staffId) {
        this.staffId = staffId;
    }

    /**
     * @return confirm_time
     */
    public Date getConfirmTime() {
        return confirmTime;
    }

    /**
     * @param confirmTime
     */
    public void setConfirmTime(Date confirmTime) {
        this.confirmTime = confirmTime;
    }

    /**
     * 获取预约状态
     *
     * @return status - 预约状态
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置预约状态
     *
     * @param status 预约状态
     */
    public void setStatus(Integer status) {
        this.status = status;
    }
}