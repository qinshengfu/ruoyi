package com.ruoyi.yzt.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 库存记录对象 inventory_record
 *
 * @author qsf
 * @date 2021-07-19
 */
@Data
public class InventoryRecord extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 库存记录id */
    private Integer inventoryRecordId;

    /** 供应商id */
    private Integer supplierId;

    /** 产品id */
    private Integer productId;

    /** 供应商名称 */
    @Excel(name = "供应商名称")
    private String supplierName;

    /** 产品名称 */
    @Excel(name = "产品名称")
    private String productName;

    /** 记录时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "记录时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date recordTime;

    /** 操作人员 */
    @Excel(name = "操作人员")
    private String operator;

    /** 入/出库数量 */
    @Excel(name = "入/出库数量")
    private Integer changeNumber;

    /** 记录状态 */
    @Excel(name = "记录状态")
    private String recordStatus;

    /** 备注 */
    @Excel(name = "备注")
    private String note;

    /** 领取人 */
    @Excel(name = "领取人")
    private String receivePeople;

    private Supplier supplier;

    private Product product;

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setInventoryRecordId(Integer inventoryRecordId)
    {
        this.inventoryRecordId = inventoryRecordId;
    }

    public Integer getInventoryRecordId()
    {
        return inventoryRecordId;
    }
    public void setSupplierId(Integer supplierId)
    {
        this.supplierId = supplierId;
    }

    public Integer getSupplierId()
    {
        return supplierId;
    }
    public void setProductId(Integer productId)
    {
        this.productId = productId;
    }

    public Integer getProductId()
    {
        return productId;
    }
    public void setRecordTime(Date recordTime)
    {
        this.recordTime = recordTime;
    }

    public Date getRecordTime()
    {
        return recordTime;
    }
    public void setOperator(String operator)
    {
        this.operator = operator;
    }

    public String getOperator()
    {
        return operator;
    }
    public void setChangeNumber(Integer changeNumber)
    {
        this.changeNumber = changeNumber;
    }

    public Integer getChangeNumber()
    {
        return changeNumber;
    }
    public void setRecordStatus(String recordStatus)
    {
        this.recordStatus = recordStatus;
    }

    public String getRecordStatus()
    {
        return recordStatus;
    }
    public void setNote(String note)
    {
        this.note = note;
    }

    public String getNote()
    {
        return note;
    }
    public void setReceivePeople(String receivePeople)
    {
        this.receivePeople = receivePeople;
    }

    public String getReceivePeople()
    {
        return receivePeople;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("inventoryRecordId", getInventoryRecordId())
                .append("supplierId", getSupplierId())
                .append("productId", getProductId())
                .append("recordTime", getRecordTime())
                .append("operator", getOperator())
                .append("changeNumber", getChangeNumber())
                .append("recordStatus", getRecordStatus())
                .append("note", getNote())
                .append("receivePeople", getReceivePeople())
                .append("supplier", getSupplier())
                .append("product", getProduct())
                .toString();
    }
}