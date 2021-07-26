package com.ruoyi.yzt.mapper;

import java.util.List;
import com.ruoyi.yzt.domain.Supplier;

/**
 * 供应商管理Mapper接口
 *
 * @author qsf
 * @date 2021-07-19
 */
public interface SupplierMapper
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
     * 删除供应商管理
     *
     * @param supplierId 供应商管理ID
     * @return 结果
     */
    public int deleteSupplierById(Integer supplierId);

    /**
     * 批量删除供应商管理
     *
     * @param supplierIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteSupplierByIds(Integer[] supplierIds);

    /**
     *
     * @param supplierIdList
     * @return
     */
    public List<Supplier> selectSupplierByIds(List<Integer> supplierIdList);
}