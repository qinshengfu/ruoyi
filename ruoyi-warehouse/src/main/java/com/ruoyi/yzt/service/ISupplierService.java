package com.ruoyi.yzt.service;

import java.util.List;
import com.ruoyi.yzt.domain.Supplier;

/**
 * 供应商管理Service接口
 *
 * @author qsf
 * @date 2021-07-19
 */
public interface ISupplierService
{
    /**
     * 查询供应商管理
     *
     * @param supplierId 供应商管理ID
     * @return 供应商管理
     */
    public Supplier selectSupplierById(Integer supplierId);

    /**
     * 查询供应商管理列表
     *
     * @param supplier 供应商管理
     * @return 供应商管理集合
     */
    public List<Supplier> selectSupplierList(Supplier supplier);

    /**
     * 新增供应商管理
     *
     * @param supplier 供应商管理
     * @return 结果
     */
    public int insertSupplier(Supplier supplier);

    /**
     * 修改供应商管理
     *
     * @param supplier 供应商管理
     * @return 结果
     */
    public int updateSupplier(Supplier supplier);

    /**
     * 批量删除供应商管理
     *
     * @param supplierIds 需要删除的供应商管理ID
     * @return 结果
     */
    public int deleteSupplierByIds(Integer[] supplierIds);

    /**
     * 删除供应商管理信息
     *
     * @param supplierId 供应商管理ID
     * @return 结果
     */
    public int deleteSupplierById(Integer supplierId);

    /**
     * 通过id批量查找
     * @param supplierIdList
     * @return
     */
    public List<Supplier> selectSupplierByIds(List<Integer> supplierIdList);
}