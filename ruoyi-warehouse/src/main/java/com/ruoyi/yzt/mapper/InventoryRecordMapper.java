package com.ruoyi.yzt.mapper;

import java.util.List;
import com.ruoyi.yzt.domain.InventoryRecord;

/**
 * 库存记录Mapper接口
 *
 * @author qsf
 * @date 2021-07-19
 */
public interface InventoryRecordMapper
{
    /**
     * 查询库存记录
     *
     * @param inventoryRecordId 库存记录ID
     * @return 库存记录
     */
    public InventoryRecord selectInventoryRecordById(Integer inventoryRecordId);

    /**
     * 查询库存记录列表
     *
     * @param inventoryRecord 库存记录
     * @return 库存记录集合
     */
    public List<InventoryRecord> selectInventoryRecordList(InventoryRecord inventoryRecord);

    /**
     * 新增库存记录
     *
     * @param inventoryRecord 库存记录
     * @return 结果
     */
    public int insertInventoryRecord(InventoryRecord inventoryRecord);

    /**
     * 修改库存记录
     *
     * @param inventoryRecord 库存记录
     * @return 结果
     */
    public int updateInventoryRecord(InventoryRecord inventoryRecord);

    /**
     * 删除库存记录
     *
     * @param inventoryRecordId 库存记录ID
     * @return 结果
     */
    public int deleteInventoryRecordById(Integer inventoryRecordId);

    /**
     * 批量删除库存记录
     *
     * @param inventoryRecordIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteInventoryRecordByIds(Integer[] inventoryRecordIds);
}