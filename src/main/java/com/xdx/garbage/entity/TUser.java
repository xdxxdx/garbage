package com.xdx.garbage.entity;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "t_user")
public class TUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

    @Column(name = "is_del")
    private Integer isDel;

    @Column(name = "open_id")
    private String openId;

    @Column(name = "nick_name")
    private String nickName;

    /**
     * 小区Id
     */
    @Column(name = "house_id")
    private Integer houseId;

    @Column(name = "house_detail")
    private String houseDetail;

    private BigDecimal balance;

    private String phone;

    /**
     * 用户类型，有用户和管理人员
     */
    @Column(name = "user_role")
    private String userRole;

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
     * @return open_id
     */
    public String getOpenId() {
        return openId;
    }

    /**
     * @param openId
     */
    public void setOpenId(String openId) {
        this.openId = openId;
    }

    /**
     * @return nick_name
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * @param nickName
     */
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    /**
     * 获取小区Id
     *
     * @return house_id - 小区Id
     */
    public Integer getHouseId() {
        return houseId;
    }

    /**
     * 设置小区Id
     *
     * @param houseId 小区Id
     */
    public void setHouseId(Integer houseId) {
        this.houseId = houseId;
    }

    /**
     * @return house_detail
     */
    public String getHouseDetail() {
        return houseDetail;
    }

    /**
     * @param houseDetail
     */
    public void setHouseDetail(String houseDetail) {
        this.houseDetail = houseDetail;
    }

    /**
     * @return balance
     */
    public BigDecimal getBalance() {
        return balance;
    }

    /**
     * @param balance
     */
    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    /**
     * @return phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 获取用户类型，有用户和管理人员
     *
     * @return user_role - 用户类型，有用户和管理人员
     */
    public String getUserRole() {
        return userRole;
    }

    /**
     * 设置用户类型，有用户和管理人员
     *
     * @param userRole 用户类型，有用户和管理人员
     */
    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }
}