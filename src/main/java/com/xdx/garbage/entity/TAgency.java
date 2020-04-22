package com.xdx.garbage.entity;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "t_agency")
public class TAgency {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

    @Column(name = "is_del")
    private Integer isDel;

    @Column(name = "agent_name")
    private String agentName;

    @Column(name = "province_id")
    private Long provinceId;

    @Column(name = "city_id")
    private Long cityId;

    @Column(name = "agent_account")
    private String agentAccount;

    @Column(name = "agent_pwd")
    private String agentPwd;

    private Integer status;

    private String note;

    private String role;

    private String tel;

    private BigDecimal balance;

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
     * @return agent_name
     */
    public String getAgentName() {
        return agentName;
    }

    /**
     * @param agentName
     */
    public void setAgentName(String agentName) {
        this.agentName = agentName;
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
     * @return city_id
     */
    public Long getCityId() {
        return cityId;
    }

    /**
     * @param cityId
     */
    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    /**
     * @return agent_account
     */
    public String getAgentAccount() {
        return agentAccount;
    }

    /**
     * @param agentAccount
     */
    public void setAgentAccount(String agentAccount) {
        this.agentAccount = agentAccount;
    }

    /**
     * @return agent_pwd
     */
    public String getAgentPwd() {
        return agentPwd;
    }

    /**
     * @param agentPwd
     */
    public void setAgentPwd(String agentPwd) {
        this.agentPwd = agentPwd;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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
     * @return role
     */
    public String getRole() {
        return role;
    }

    /**
     * @param role
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * @return tel
     */
    public String getTel() {
        return tel;
    }

    /**
     * @param tel
     */
    public void setTel(String tel) {
        this.tel = tel;
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
}