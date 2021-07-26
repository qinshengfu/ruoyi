package com.ruoyi.yzt.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 采购管理对象 procurement
 * 
 * @author qsf
 * @date 2021-07-23
 */
@Data
public class Procurement extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 采购id */
    private Integer procurementId;

    /** 供应商id */
    private Integer supplierId;

    //导出用
    @Excel(name = "供应商名称")
    private String supplierName;

    /** 商品id */
    private Integer productId;

    //导出用
    @Excel(name = "商品名称")
    private String productName;

    /** 采购数量 */
    @Excel(name = "采购数量")
    private Integer number;

    /** 单价 */
    @Excel(name = "单价")
    private BigDecimal price;

    /** 总价 */
    @Excel(name = "总价")
    private BigDecimal totalPrice;

    /** 送货单号 */
    @Excel(name = "送货单号")
    private String oddNumbers;

    /** 入库量 */
    @Excel(name = "入库量")
    private Integer receipt;

    /** 送货日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "送货日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date deliveryTime;

    /** 备注 */
    @Excel(name = "备注")
    private String procurementNote;

    /** 采购状态 */
    @Excel(name = "采购状态")
    private String status;

    private Product product;

    private Supplier supplier;

    public void setProcurementId(Integer procurementId) 
    {
        this.procurementId = procurementId;
    }

    public Integer getProcurementId() 
    {
        return procurementId;
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
    public void setNumber(Integer number) 
    {
        this.number = number;
    }

    public Integer getNumber() 
    {
        return number;
    }
    public void setPrice(BigDecimal price) 
    {
        this.price = price;
    }

    public BigDecimal getPrice() 
    {
        return price;
    }
    public void setTotalPrice(BigDecimal totalPrice) 
    {
        this.totalPrice = totalPrice;
    }

    public BigDecimal getTotalPrice() 
    {
        return totalPrice;
    }
    public void setOddNumbers(String oddNumbers) 
    {
        this.oddNumbers = oddNumbers;
    }

    public String getOddNumbers() 
    {
        return oddNumbers;
    }
    public void setReceipt(Integer receipt) 
    {
        this.receipt = receipt;
    }

    public Integer getReceipt() 
    {
        return receipt;
    }
    public void setDeliveryTime(Date deliveryTime) 
    {
        this.deliveryTime = deliveryTime;
    }

    public Date getDeliveryTime() 
    {
        return deliveryTime;
    }
    public void setProcurementNote(String procurementNote) 
    {
        this.procurementNote = procurementNote;
    }

    public String getProcurementNote() 
    {
        return procurementNote;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("procurementId", getProcurementId())
            .append("supplierId", getSupplierId())
            .append("productId", getProductId())
            .append("number", getNumber())
            .append("price", getPrice())
            .append("totalPrice", getTotalPrice())
            .append("oddNumbers", getOddNumbers())
            .append("receipt", getReceipt())
            .append("status", getStatus())
            .append("deliveryTime", getDeliveryTime())
            .append("procurementNote", getProcurementNote())
            .toString();
    }
}
