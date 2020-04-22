package com.xdx.garbage.entity;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "t_bag")
public class TBag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

    @Column(name = "is_del")
    private Integer isDel;

    @Column(name = "bag_code")
    private String bagCode;

    private Integer status;

    /**
     * 环保袋的类别，可回收或不可回收
     */
    @Column(name = "bag_type")
    private String bagType;

    /**
     * 本次垃圾的重量
     */
    private BigDecimal weight;

    /**
     * 本次垃圾的返佣
     */
    @Column(name = "rake_back")
    private BigDecimal rakeBack;

    /**
     * 工作人员的id
     */
    @Column(name = "staff_id")
    private Long staffId;

    /**
     * 工作人员审核的备注
     */
    private String note;

    /**
     * 使用者id
     */
    @Column(name = "user_id")
    private Long userId;

    /**
     * 领取时间
     */
    @Column(name = "receive_time")
    private Date receiveTime;

    /**
     * 回收时间
     */
    @Column(name = "recovery_time")
    private Date recoveryTime;

    private TUser user;

    private TUser staff;

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
     * @return bag_code
     */
    public String getBagCode() {
        return bagCode;
    }

    /**
     * @param bagCode
     */
    public void setBagCode(String bagCode) {
        this.bagCode = bagCode;
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
     * 获取环保袋的类别，可回收或不可回收
     *
     * @return bag_type - 环保袋的类别，可回收或不可回收
     */
    public String getBagType() {
        return bagType;
    }

    /**
     * 设置环保袋的类别，可回收或不可回收
     *
     * @param bagType 环保袋的类别，可回收或不可回收
     */
    public void setBagType(String bagType) {
        this.bagType = bagType;
    }

    /**
     * 获取本次垃圾的重量
     *
     * @return weight - 本次垃圾的重量
     */
    public BigDecimal getWeight() {
        return weight;
    }

    /**
     * 设置本次垃圾的重量
     *
     * @param weight 本次垃圾的重量
     */
    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    /**
     * 获取本次垃圾的返佣
     *
     * @return rake_back - 本次垃圾的返佣
     */
    public BigDecimal getRakeBack() {
        return rakeBack;
    }

    /**
     * 设置本次垃圾的返佣
     *
     * @param rakeBack 本次垃圾的返佣
     */
    public void setRakeBack(BigDecimal rakeBack) {
        this.rakeBack = rakeBack;
    }

    /**
     * 获取工作人员的id
     *
     * @return staff_id - 工作人员的id
     */
    public Long getStaffId() {
        return staffId;
    }

    /**
     * 设置工作人员的id
     *
     * @param staffId 工作人员的id
     */
    public void setStaffId(Long staffId) {
        this.staffId = staffId;
    }

    /**
     * 获取工作人员审核的备注
     *
     * @return note - 工作人员审核的备注
     */
    public String getNote() {
        return note;
    }

    /**
     * 设置工作人员审核的备注
     *
     * @param note 工作人员审核的备注
     */
    public void setNote(String note) {
        this.note = note;
    }

    /**
     * 获取使用者id
     *
     * @return user_id - 使用者id
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 设置使用者id
     *
     * @param userId 使用者id
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 获取领取时间
     *
     * @return receive_time - 领取时间
     */
    public Date getReceiveTime() {
        return receiveTime;
    }

    /**
     * 设置领取时间
     *
     * @param receiveTime 领取时间
     */
    public void setReceiveTime(Date receiveTime) {
        this.receiveTime = receiveTime;
    }

    /**
     * 获取回收时间
     *
     * @return recovery_time - 回收时间
     */
    public Date getRecoveryTime() {
        return recoveryTime;
    }

    /**
     * 设置回收时间
     *
     * @param recoveryTime 回收时间
     */
    public void setRecoveryTime(Date recoveryTime) {
        this.recoveryTime = recoveryTime;
    }

    public TUser getUser() {
        return user;
    }

    public void setUser(TUser user) {
        this.user = user;
    }

    public TUser getStaff() {
        return staff;
    }

    public void setStaff(TUser staff) {
        this.staff = staff;
    }
}