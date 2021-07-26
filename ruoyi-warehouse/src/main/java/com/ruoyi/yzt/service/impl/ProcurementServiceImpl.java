package com.ruoyi.yzt.service.impl;

import java.math.BigDecimal;
import java.util.List;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.yzt.domain.InventoryRecord;
import com.ruoyi.yzt.domain.Product;
import com.ruoyi.yzt.dto.ProcurementDto;
import com.ruoyi.yzt.mapper.InventoryRecordMapper;
import com.ruoyi.yzt.mapper.ProductMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.yzt.mapper.ProcurementMapper;
import com.ruoyi.yzt.domain.Procurement;
import com.ruoyi.yzt.service.IProcurementService;
import org.springframework.transaction.annotation.Transactional;

/**
 * 采购管理Service业务层处理
 *
 * @author qsf
 * @date 2021-07-23
 */
@Service
public class ProcurementServiceImpl implements IProcurementService {
    @Autowired
    private ProcurementMapper procurementMapper;

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private InventoryRecordMapper inventoryRecordMapper;

    /**
     * 查询采购管理
     *
     * @param procurementId 采购管理ID
     * @return 采购管理
     */
    @Override
    public Procurement selectProcurementById(Integer procurementId) {
        return procurementMapper.selectProcurementById(procurementId);
    }

    /**
     * 查询采购管理列表
     *
     * @param procurement 采购管理
     * @return 采购管理
     */
    @Override
    public List<Procurement> selectProcurementList(Procurement procurement) {
        return procurementMapper.selectProcurementList(procurement);
    }

    /**
     * 新增采购管理
     *
     * @param procurement 采购管理
     * @return 结果
     */
    @Override
    public int insertProcurement(Procurement procurement) {
        Integer productId = procurement.getProductId();
        Product product = productMapper.selectProductById(productId);
        procurement.setPrice(product.getPrice());
        procurement.setTotalPrice(product.getPrice().multiply(new BigDecimal(procurement.getNumber())));
        return procurementMapper.insertProcurement(procurement);
    }

    /**
     * 修改采购管理
     *
     * @param procurement 采购管理
     * @return 结果
     */
    @Override
    public int updateProcurement(Procurement procurement) {
        return procurementMapper.updateProcurement(procurement);
    }

    /**
     * 入库管理
     *
     * @param procurementDto
     * @return
     */
    @Transactional
    @Override
    public int warehouse(ProcurementDto procurementDto) {
        Procurement procurement = new Procurement();
        InventoryRecord inventoryRecord = new InventoryRecord();
        BeanUtils.copyProperties(procurementDto, procurement);
        BeanUtils.copyProperties(procurementDto, inventoryRecord);
        //入库量
        procurement.setReceipt(procurement.getReceipt()+procurementDto.getNumber());
        //设置采购数量为空
        procurement.setNumber(null);
        //采购记录状态(0,下单，1入库，2，退货）
        procurement.setStatus("1");

        //入库时间
        inventoryRecord.setRecordTime(DateUtils.getNowDate());
        //入库记录状态（0，入库，1，出库，2，退货）
        inventoryRecord.setRecordStatus("0");
        //入库量
        inventoryRecord.setChangeNumber(procurementDto.getNumber());
        Product product = productMapper.selectProductById(procurementDto.getProductId());
        //商品入库
        product.setInventory(product.getInventory() + procurementDto.getNumber());

//        inventoryRecord.setNote(procurementDto.getNote());
        int i = procurementMapper.updateProcurement(procurement);
        int i2 = productMapper.updateProduct(product);
        int i1 = inventoryRecordMapper.insertInventoryRecord(inventoryRecord);
        if (i < 0 || i1 < 0 || i2 < 0) {
            return 0;
        }
        return 1;
    }

    /**
     * 批量删除采购管理
     *
     * @param procurementIds 需要删除的采购管理ID
     * @return 结果
     */
    @Override
    public int deleteProcurementByIds(Integer[] procurementIds) {
        return procurementMapper.deleteProcurementByIds(procurementIds);
    }

    /**
     * 删除采购管理信息
     *
     * @param procurementId 采购管理ID
     * @return 结果
     */
    @Override
    public int deleteProcurementById(Integer procurementId) {
        return procurementMapper.deleteProcurementById(procurementId);
    }
}
