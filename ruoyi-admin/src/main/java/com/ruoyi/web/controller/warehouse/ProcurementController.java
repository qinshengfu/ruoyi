package com.ruoyi.web.controller.warehouse;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.service.TokenService;
import com.ruoyi.yzt.domain.Procurement;
import com.ruoyi.yzt.domain.Product;
import com.ruoyi.yzt.domain.Supplier;
import com.ruoyi.yzt.dto.ProcurementDto;
import com.ruoyi.yzt.enums.ProcurementStatusEnum;
import com.ruoyi.yzt.service.IProcurementService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * 采购管理Controller
 * 
 * @author qsf
 * @date 2021-07-23
 */
@RestController
@RequestMapping("/yzt/procurement")
public class ProcurementController extends BaseController
{
    @Autowired
    private IProcurementService procurementService;

    @Autowired
    private TokenService tokenService;

    /**
     * 查询采购管理列表
     */
    @PreAuthorize("@ss.hasPermi('yzt:procurement:list')")
    @GetMapping("/list")
    public TableDataInfo list(ProcurementDto procurementDto)
    {
        Procurement procurement = new Procurement();
        BeanUtils.copyProperties(procurementDto,procurement);
        Supplier supplier = new Supplier();
        Product product = new Product();
        supplier.setSupplierName(procurementDto.getSupplierName());
        product.setProductName(procurementDto.getProductName());
        procurement.setSupplier(supplier);
        procurement.setProduct(product);
        startPage();
        List<Procurement> list = procurementService.selectProcurementList(procurement);
        return getDataTable(list);
    }

    /**
     * 导出采购管理列表
     */
    @PreAuthorize("@ss.hasPermi('yzt:procurement:export')")
    @Log(title = "采购管理", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(ProcurementDto procurementDto)
    {
        Procurement procurement = new Procurement();
        Supplier supplier = new Supplier();
        Product product = new Product();
        BeanUtils.copyProperties(procurementDto,procurement);
        procurement.setSupplier(supplier);
        procurement.setProduct(product);

        List<Procurement> list = procurementService.selectProcurementList(procurement);
        ArrayList<Procurement> procurementList = new ArrayList<>();
        for (Procurement procurement1 : list){
            procurement1.setSupplierName(procurement1.getSupplier().getSupplierName());
            procurement1.setProductName(procurement1.getProduct().getProductName());
            if (procurement1.getStatus().equals(ProcurementStatusEnum.ORDER.getCode())){
                procurement1.setStatus(ProcurementStatusEnum.ORDER.getMsg());
            }else if (procurement1.getStatus().equals(ProcurementStatusEnum.WAREHOUSE.getCode())){
                procurement1.setStatus(ProcurementStatusEnum.WAREHOUSE.getMsg());
            }else if (procurement1.getStatus().equals(ProcurementStatusEnum.RETURN_GOODS.getCode())){
                procurement1.setStatus(ProcurementStatusEnum.RETURN_GOODS.getMsg());
            }
            procurementList.add(procurement1);
        }
        ExcelUtil<Procurement> util = new ExcelUtil<Procurement>(Procurement.class);
        return util.exportExcel(procurementList, "procurement");
    }

    /**
     * 获取采购管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('yzt:procurement:query')")
    @GetMapping(value = "/{procurementId}")
    public AjaxResult getInfo(@PathVariable("procurementId") Integer procurementId)
    {
        return AjaxResult.success(procurementService.selectProcurementById(procurementId));
    }

    /**
     * 新增采购管理
     */
    @PreAuthorize("@ss.hasPermi('yzt:procurement:add')")
    @Log(title = "采购管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Procurement procurement)
    {
        return toAjax(procurementService.insertProcurement(procurement));
    }

    /**
     * 修改采购管理
     */
    @PreAuthorize("@ss.hasPermi('yzt:procurement:edit')")
    @Log(title = "采购管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Procurement procurement)
    {
        return toAjax(procurementService.updateProcurement(procurement));
    }

    /**
     * 入库管理
     * @param procurementDto
     * @return
     */
    @PreAuthorize("@ss.hasPermi('yzt:procurement:warehouse')")
    @Log(title = "采购管理", businessType = BusinessType.UPDATE)
    @PutMapping("/warehouse")
    public AjaxResult warehouse(@RequestBody ProcurementDto procurementDto, HttpServletRequest request)
    {
        LoginUser loginUser = tokenService.getLoginUser(request);
        procurementDto.setRecordStatus("1");
        procurementDto.setReceivePeople(loginUser.getUsername());
        procurementDto.setOperator(loginUser.getUsername());
        return toAjax(procurementService.warehouse(procurementDto));
    }

    /**
     * 删除采购管理
     */
    @PreAuthorize("@ss.hasPermi('yzt:procurement:remove')")
    @Log(title = "采购管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{procurementIds}")
    public AjaxResult remove(@PathVariable Integer[] procurementIds)
    {
        return toAjax(procurementService.deleteProcurementByIds(procurementIds));
    }
}
