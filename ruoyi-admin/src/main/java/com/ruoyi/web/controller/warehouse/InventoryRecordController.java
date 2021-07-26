package com.ruoyi.web.controller.warehouse;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.service.TokenService;

import com.ruoyi.yzt.domain.InventoryRecord;
import com.ruoyi.yzt.domain.Product;
import com.ruoyi.yzt.domain.Supplier;
import com.ruoyi.yzt.dto.InventoryRecordDto;
import com.ruoyi.yzt.enums.RecordStatusEnum;
import com.ruoyi.yzt.service.IInventoryRecordService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 库存记录Controller
 *
 * @author qsf
 * @date 2021-07-19
 */
@RestController
@RequestMapping("/yzt/record")
public class InventoryRecordController extends BaseController
{
    @Autowired
    private IInventoryRecordService inventoryRecordService;

    @Autowired
    private TokenService tokenService;

    /**
     * 查询库存记录列表
     */
    @PreAuthorize("@ss.hasPermi('yzt:record:list')")
    @GetMapping("/list")
    public TableDataInfo list(InventoryRecordDto inventoryRecordDto)
    {
        InventoryRecord inventoryRecord = new InventoryRecord();
        Supplier supplier = new Supplier();
        Product product = new Product();
        supplier.setSupplierName(inventoryRecordDto.getSupplierName());
        product.setProductName(inventoryRecordDto.getProductName());
        BeanUtils.copyProperties(inventoryRecordDto,inventoryRecord);
        inventoryRecord.setSupplier(supplier);
        inventoryRecord.setProduct(product);
        startPage();
        List<InventoryRecord> list = inventoryRecordService.selectInventoryRecordList(inventoryRecord);
        return getDataTable(list);
    }

    /**
     * 导出库存记录列表
     */
    @PreAuthorize("@ss.hasPermi('yzt:record:export')")
    @Log(title = "库存记录", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(InventoryRecordDto inventoryRecordDto)
    {
        InventoryRecord inventoryRecord = new InventoryRecord();
        Product product = new Product();
        Supplier supplier = new Supplier();
        BeanUtils.copyProperties(inventoryRecordDto,inventoryRecord);
        product.setProductId(inventoryRecordDto.getProductId());
        supplier.setSupplierId(inventoryRecordDto.getSupplierId());
        inventoryRecord.setProduct(product);
        inventoryRecord.setSupplier(supplier);
        List<InventoryRecord> list = inventoryRecordService.selectInventoryRecordList(inventoryRecord);
        ArrayList<InventoryRecord> inventoryRecordList = new ArrayList<>();
        for (InventoryRecord inventoryRecord1: list){
            inventoryRecord1.setSupplierName(inventoryRecord1.getSupplier().getSupplierName());
            inventoryRecord1.setProductName(inventoryRecord1.getProduct().getProductName());
            if (inventoryRecord1.getRecordStatus().equals(RecordStatusEnum.WAREHOUSE.getCode())){
                inventoryRecord1.setRecordStatus(RecordStatusEnum.WAREHOUSE.getMsg());
            }else if (inventoryRecord1.getRecordStatus().equals(RecordStatusEnum.DELIVERY.getCode())){
                inventoryRecord1.setRecordStatus(RecordStatusEnum.DELIVERY.getMsg());
            }else if (inventoryRecord1.getRecordStatus().equals(RecordStatusEnum.RETURN_GOODS.getCode())){
                inventoryRecord1.setRecordStatus(RecordStatusEnum.RETURN_GOODS.getMsg());
            }
            inventoryRecordList.add(inventoryRecord1);
        }
        ExcelUtil<InventoryRecord> util = new ExcelUtil<InventoryRecord>(InventoryRecord.class);
        return util.exportExcel(inventoryRecordList, "record");
    }

    /**
     * 获取库存记录详细信息
     */
    @PreAuthorize("@ss.hasPermi('yzt:record:query')")
    @GetMapping(value = "/{inventoryRecordId}")
    public AjaxResult getInfo(@PathVariable("inventoryRecordId") Integer inventoryRecordId)
    {
        return AjaxResult.success(inventoryRecordService.selectInventoryRecordById(inventoryRecordId));
    }

    /**
     * 新增库存记录
     */
    @PreAuthorize("@ss.hasPermi('yzt:record:add')")
    @Log(title = "库存记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody InventoryRecord inventoryRecord)
    {
        return toAjax(inventoryRecordService.insertInventoryRecord(inventoryRecord));
    }

    /**
     * 修改库存记录
     */
    @PreAuthorize("@ss.hasPermi('yzt:record:edit')")
    @Log(title = "库存记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody InventoryRecord inventoryRecord)
    {
        return toAjax(inventoryRecordService.updateInventoryRecord(inventoryRecord));
    }

    /**
     * 删除库存记录
     */
    @PreAuthorize("@ss.hasPermi('yzt:record:remove')")
    @Log(title = "库存记录", businessType = BusinessType.DELETE)
    @DeleteMapping("/{inventoryRecordIds}")
    public AjaxResult remove(@PathVariable Integer[] inventoryRecordIds)
    {
        return toAjax(inventoryRecordService.deleteInventoryRecordByIds(inventoryRecordIds));
    }
}