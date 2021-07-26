package com.ruoyi.yzt.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 供应商管理对象 supplier
 *
 * @author qsf
 * @date 2021-07-19
 */
public class Supplier extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 供应商id */
    private Integer supplierId;

    /** 供应商名称 */
    @Excel(name = "供应商名称")
    private String supplierName;

    /** 供应商地址 */
    @Excel(name = "供应商地址")
    private String supplierAddress;

    /** 电话 */
    @Excel(name = "电话")
    private String tenPhone;

    /** 联系人 */
    @Excel(name = "联系人")
    private String contactPeople;

    /** 联系人电话 */
    @Excel(name = "联系人电话")
    private String contactPhone;

    /** 邮件 */
    @Excel(name = "邮件")
    private String email;

    /** 传真 */
    @Excel(name = "传真")
    private String fax;

    /** 可用状态 */
    @Excel(name = "可用状态")
    private String status;

    public void setSupplierId(Integer supplierId)
    {
        this.supplierId = supplierId;
    }

    public Integer getSupplierId()
    {
        return supplierId;
    }
    public void setSupplierName(String supplierName)
    {
        this.supplierName = supplierName;
    }

    public String getSupplierName()
    {
        return supplierName;
    }
    public void setSupplierAddress(String supplierAddress)
    {
        this.supplierAddress = supplierAddress;
    }

    public String getSupplierAddress()
    {
        return supplierAddress;
    }
    public void setTenPhone(String tenPhone)
    {
        this.tenPhone = tenPhone;
    }

    public String getTenPhone()
    {
        return tenPhone;
    }
    public void setContactPeople(String contactPeople)
    {
        this.contactPeople = contactPeople;
    }

    public String getContactPeople()
    {
        return contactPeople;
    }
    public void setContactPhone(String contactPhone)
    {
        this.contactPhone = contactPhone;
    }

    public String getContactPhone()
    {
        return contactPhone;
    }
    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getEmail()
    {
        return email;
    }
    public void setFax(String fax)
    {
        this.fax = fax;
    }

    public String getFax()
    {
        return fax;
    }
    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getStatus()
    {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("supplierId", getSupplierId())
                .append("supplierName", getSupplierName())
                .append("supplierAddress", getSupplierAddress())
                .append("tenPhone", getTenPhone())
                .append("contactPeople", getContactPeople())
                .append("contactPhone", getContactPhone())
                .append("email", getEmail())
                .append("fax", getFax())
                .append("status", getStatus())
                .append("createTime", getCreateTime())
                .append("updateTime", getUpdateTime())
                .toString();
    }
}