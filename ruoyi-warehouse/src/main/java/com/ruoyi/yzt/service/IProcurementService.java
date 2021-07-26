package com.ruoyi.yzt.service;

import java.util.List;
import com.ruoyi.yzt.domain.Procurement;
import com.ruoyi.yzt.dto.ProcurementDto;

/**
 * 采购管理Service接口
 * 
 * @author qsf
 * @date 2021-07-23
 */
public interface IProcurementService 
{
    /**
     * 查询采购管理
     * 
     * @param procurementId 采购管理ID
     * @return 采购管理
     */
    public Procurement selectProcurementById(Integer procurementId);

    /**
     * 查询采购管理列表
     * 
     * @param procurement 采购管理
     * @return 采购管理集合
     */
    public List<Procurement> selectProcurementList(Procurement procurement);

    /**
     * 新增采购管理
     * 
     * @param procurement 采购管理
     * @return 结果
     */
    public int insertProcurement(Procurement procurement);

    /**
     * 修改采购管理
     * 
     * @param procurement 采购管理
     * @return 结果
     */
    public int updateProcurement(Procurement procurement);

    /**
     * 入库管理
     * @param procurementDto
     * @return
     */
    public int warehouse(ProcurementDto procurementDto);

    /**
     * 批量删除采购管理
     * 
     * @param procurementIds 需要删除的采购管理ID
     * @return 结果
     */
    public int deleteProcurementByIds(Integer[] procurementIds);

    /**
     * 删除采购管理信息
     * 
     * @param procurementId 采购管理ID
     * @return 结果
     */
    public int deleteProcurementById(Integer procurementId);
}
