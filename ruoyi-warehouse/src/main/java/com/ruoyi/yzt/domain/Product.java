package com.ruoyi.yzt.domain;

import java.math.BigDecimal;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 产品管理对象 product
 * 
 * @author qsf
 * @date 2021-07-19
 */
@Data
public class Product extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 产品id */
    private Integer productId;

    /** 供应商id */
    private Integer supplierId;

    @Excel(name = "供应商名称")
    private String supplierName;

    /** 产品名称 */
    @Excel(name = "产品名称")
    private String productName;

    /** 仓库编码 */
    @Excel(name = "仓库编码")
    private String warehouseCode;

    /** 规格型号 */
    @Excel(name = "规格型号")
    private String model;

    /** 单位 */
    @Excel(name = "单位")
    private String unit;

    /** 单价 */
    @Excel(name = "单价")
    private BigDecimal price;

    /** 库存数量 */
    @Excel(name = "库存数量")
    private Integer inventory;

    /** 图像 */
//    @Excel(name = "图像")
    private String image;

    /** 使用状态 */
    @Excel(name = "使用状态")
    private String status;

    /** 备注 */
    @Excel(name = "备注")
    private String note;

    private Supplier supplier;

    private InventoryRecord inventoryRecord;

    public InventoryRecord getInventoryRecord() {
        return inventoryRecord;
    }

    public void setInventoryRecord(InventoryRecord inventoryRecord) {
        this.inventoryRecord = inventoryRecord;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public void setProductId(Integer productId)
    {
        this.productId = productId;
    }

    public Integer getProductId() 
    {
        return productId;
    }
    public void setSupplierId(Integer supplierId) 
    {
        this.supplierId = supplierId;
    }

    public Integer getSupplierId() 
    {
        return supplierId;
    }
    public void setProductName(String productName) 
    {
        this.productName = productName;
    }

    public String getProductName() 
    {
        return productName;
    }
    public void setModel(String model) 
    {
        this.model = model;
    }

    public String getModel() 
    {
        return model;
    }
    public void setUnit(String unit) 
    {
        this.unit = unit;
    }

    public String getUnit() 
    {
        return unit;
    }
    public void setPrice(BigDecimal price) 
    {
        this.price = price;
    }

    public BigDecimal getPrice() 
    {
        return price;
    }
    public void setInventory(Integer inventory) 
    {
        this.inventory = inventory;
    }

    public Integer getInventory() 
    {
        return inventory;
    }
    public void setImage(String image) 
    {
        this.image = image;
    }

    public String getImage() 
    {
        return image;
    }
    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getStatus()
    {
        return status;
    }
    public void setNote(String note) 
    {
        this.note = note;
    }

    public String getNote() 
    {
        return note;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("productId", getProductId())
            .append("supplierId", getSupplierId())
            .append("productName", getProductName())
            .append("warehouseCode", getWarehouseCode())
            .append("model", getModel())
            .append("unit", getUnit())
            .append("price", getPrice())
            .append("inventory", getInventory())
            .append("image", getImage())
            .append("status", getStatus())
            .append("note", getNote())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("supplier", getSupplier())
            .append("inventoryRecord", getInventoryRecord())
            .toString();
    }
}
