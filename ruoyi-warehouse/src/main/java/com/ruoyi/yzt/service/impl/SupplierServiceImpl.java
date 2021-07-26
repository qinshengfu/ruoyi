package com.ruoyi.yzt.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.yzt.mapper.SupplierMapper;
import com.ruoyi.yzt.domain.Supplier;
import com.ruoyi.yzt.service.ISupplierService;

/**
 * 供应商管理Service业务层处理
 *
 * @author qsf
 * @date 2021-07-19
 */
@Service
public class SupplierServiceImpl implements ISupplierService
{
    @Autowired
    private SupplierMapper supplierMapper;

    /**
     * 查询供应商管理
     *
     * @param supplierId 供应商管理ID
     * @return 供应商管理
     */
    @Override
    public Supplier selectSupplierById(Integer supplierId)
    {
        return supplierMapper.selectSupplierById(supplierId);
    }

    /**
     * 查询供应商管理列表
     *
     * @param supplier 供应商管理
     * @return 供应商管理
     */
    @Override
    public List<Supplier> selectSupplierList(Supplier supplier)
    {
        return supplierMapper.selectSupplierList(supplier);
    }

    /**
     * 新增供应商管理
     *
     * @param supplier 供应商管理
     * @return 结果
     */
    @Override
    public int insertSupplier(Supplier supplier)
    {
        supplier.setCreateTime(DateUtils.getNowDate());
        return supplierMapper.insertSupplier(supplier);
    }

    /**
     * 修改供应商管理
     *
     * @param supplier 供应商管理
     * @return 结果
     */
    @Override
    public int updateSupplier(Supplier supplier)
    {
        supplier.setUpdateTime(DateUtils.getNowDate());
        return supplierMapper.updateSupplier(supplier);
    }

    /**
     * 批量删除供应商管理
     *
     * @param supplierIds 需要删除的供应商管理ID
     * @return 结果
     */
    @Override
    public int deleteSupplierByIds(Integer[] supplierIds)
    {
        return supplierMapper.deleteSupplierByIds(supplierIds);
    }

    /**
     * 删除供应商管理信息
     *
     * @param supplierId 供应商管理ID
     * @return 结果
     */
    @Override
    public int deleteSupplierById(Integer supplierId)
    {
        return supplierMapper.deleteSupplierById(supplierId);
    }

    @Override
    public List<Supplier> selectSupplierByIds(List<Integer> supplierIdList) {
        return supplierMapper.selectSupplierByIds(supplierIdList);

    }
}