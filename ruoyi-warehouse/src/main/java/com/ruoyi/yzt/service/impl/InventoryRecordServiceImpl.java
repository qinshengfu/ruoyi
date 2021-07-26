package com.ruoyi.yzt.service.impl;

import java.util.List;

import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.yzt.mapper.InventoryRecordMapper;
import com.ruoyi.yzt.domain.InventoryRecord;
import com.ruoyi.yzt.service.IInventoryRecordService;

/**
 * 库存记录Service业务层处理
 *
 * @author qsf
 * @date 2021-07-19
 */
@Service
public class InventoryRecordServiceImpl implements IInventoryRecordService
{
    @Autowired
    private InventoryRecordMapper inventoryRecordMapper;

    /**
     * 查询库存记录
     *
     * @param inventoryRecordId 库存记录ID
     * @return 库存记录
     */
    @Override
    public InventoryRecord selectInventoryRecordById(Integer inventoryRecordId)
    {
        return inventoryRecordMapper.selectInventoryRecordById(inventoryRecordId);
    }

    /**
     * 查询库存记录列表
     *
     * @param inventoryRecord 库存记录
     * @return 库存记录
     */
    @Override
    public List<InventoryRecord> selectInventoryRecordList(InventoryRecord inventoryRecord)
    {
        return inventoryRecordMapper.selectInventoryRecordList(inventoryRecord);
    }

    /**
     * 新增库存记录
     *
     * @param inventoryRecord 库存记录
     * @return 结果
     */
    @Override
    public int insertInventoryRecord(InventoryRecord inventoryRecord)
    {
        inventoryRecord.setRecordTime(DateUtils.getNowDate());
        return inventoryRecordMapper.insertInventoryRecord(inventoryRecord);
    }

    /**
     * 修改库存记录
     *
     * @param inventoryRecord 库存记录
     * @return 结果
     */
    @Override
    public int updateInventoryRecord(InventoryRecord inventoryRecord)
    {
        return inventoryRecordMapper.updateInventoryRecord(inventoryRecord);
    }

    /**
     * 批量删除库存记录
     *
     * @param inventoryRecordIds 需要删除的库存记录ID
     * @return 结果
     */
    @Override
    public int deleteInventoryRecordByIds(Integer[] inventoryRecordIds)
    {
        return inventoryRecordMapper.deleteInventoryRecordByIds(inventoryRecordIds);
    }

    /**
     * 删除库存记录信息
     *
     * @param inventoryRecordId 库存记录ID
     * @return 结果
     */
    @Override
    public int deleteInventoryRecordById(Integer inventoryRecordId)
    {
        return inventoryRecordMapper.deleteInventoryRecordById(inventoryRecordId);
    }
}