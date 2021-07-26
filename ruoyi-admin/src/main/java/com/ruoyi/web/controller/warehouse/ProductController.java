package com.ruoyi.web.controller.warehouse;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.service.TokenService;
import com.ruoyi.yzt.domain.InventoryRecord;
import com.ruoyi.yzt.domain.Product;
import com.ruoyi.yzt.domain.Supplier;
import com.ruoyi.yzt.dto.ProductDto;
import com.ruoyi.yzt.enums.StatusEnum;
import com.ruoyi.yzt.service.IInventoryRecordService;
import com.ruoyi.yzt.service.IProductService;
import com.ruoyi.yzt.service.ISupplierService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * 产品管理Controller
 *
 * @author qsf
 * @date 2021-07-19
 */
@RestController
@RequestMapping("/yzt/product")
public class ProductController extends BaseController {
    @Autowired
    private IProductService productService;
    @Autowired
    private ISupplierService supplierService;
    @Autowired
    private IInventoryRecordService inventoryRecordService;
    @Autowired
    private TokenService tokenService;

    /**
     * 查询产品管理列表
     */
    @PreAuthorize("@ss.hasPermi('yzt:product:list')")
    @GetMapping("/list")
    public TableDataInfo list(ProductDto productDto) {
        Product product = new Product();
        Supplier supplier = new Supplier();
        BeanUtils.copyProperties(productDto,product);
        supplier.setSupplierName(productDto.getSupplierName());
        product.setSupplier(supplier);
        startPage();
        List<Product> list = productService.selectProductList(product);
       /* List<Integer> supplierIdList = list.stream().map(e -> e.getSupplierId()).collect(Collectors.toList());
        List<Supplier> supplierList = supplierService.selectSupplierByIds(supplierIdList);*/

        return getDataTable(list);
    }

    /**
     * 获取产品
     * @param
     * @return
     */
    @GetMapping("/getProductList")
    public AjaxResult getProductList(ProductDto productDto){
        Product product = new Product();
        Supplier supplier = new Supplier();
        BeanUtils.copyProperties(productDto,product);
        product.setStatus("0");
        supplier.setSupplierName(productDto.getSupplierName());
        product.setSupplier(supplier);
        List<Product> list = productService.selectProductList(product);
        return AjaxResult.success(list);
    }

    /**
     * 导出产品管理列表
     */
    @PreAuthorize("@ss.hasPermi('yzt:product:export')")
    @Log(title = "产品管理", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(ProductDto productDto) {
        Product product = new Product();
        Supplier supplier = new Supplier();
        supplier.setSupplierId(productDto.getSupplierId());
        supplier.setSupplierName(productDto.getSupplierName());
        product.setSupplier(supplier);
        BeanUtils.copyProperties(productDto,product);
        List<Product> list = productService.selectProductList(product);
        ArrayList<Product> productList = new ArrayList<>();
        for (Product product1: list){
            product1.setSupplierName(product1.getSupplier().getSupplierName());
            if (product1.getStatus().equals(StatusEnum.NORMAL.getCode())){
                product1.setStatus(StatusEnum.NORMAL.getMsg());
            }else if (product1.getStatus().equals(StatusEnum.DISABLE.getCode())){
                product1.setStatus(StatusEnum.DISABLE.getMsg());
            }
            productList.add(product1);
        }
        ExcelUtil<Product> util = new ExcelUtil<Product>(Product.class);
        return util.exportExcel(productList, "product");
    }

    /**
     * 获取产品管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('yzt:product:query')")
    @GetMapping(value = "/{productId}")
    public AjaxResult getInfo(@PathVariable("productId") Integer productId) {
        return AjaxResult.success(productService.selectProductById(productId));
    }

    /**
     * 新增产品管理
     */
    @PreAuthorize("@ss.hasPermi('yzt:product:add')")
    @Log(title = "产品管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Product product) {
        return toAjax(productService.insertProduct(product));
    }

    /**
     * 修改产品管理
     */
    @PreAuthorize("@ss.hasPermi('yzt:product:edit')")
    @Log(title = "产品管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Product product) {
        return toAjax(productService.updateProduct(product));
    }

    /**
     * 状态修改
     */
    @PreAuthorize("@ss.hasPermi('yzt:product:edit')")
    @Log(title = "商品管理", businessType = BusinessType.UPDATE)
    @PutMapping("/changeStatus")
    public AjaxResult changeStatus(@RequestBody Product product)
    {
        return toAjax(productService.updateProduct(product));
    }

    /**
     * 入库
     *
     * @param productDto
     * @return
     */
    @PreAuthorize("@ss.hasPermi('yzt:product:warehouse')")
    @Log(title = "入库", businessType = BusinessType.UPDATE)
    @PutMapping("/warehouse")
    public AjaxResult wareHouseProduct(@RequestBody ProductDto productDto,HttpServletRequest request) {
        LoginUser loginUser = tokenService.getLoginUser(request);
        Product product = new Product();
        product.setProductId(productDto.getProductId());
        Product selectProductById = productService.selectProductById(productDto.getProductId());
        int number = selectProductById.getInventory() + productDto.getChangeNumber();
        product.setInventory(number);
        int updateProduct = productService.updateProduct(product);
        InventoryRecord inventoryRecord = new InventoryRecord();
        BeanUtils.copyProperties(productDto, inventoryRecord);
        inventoryRecord.setNote(productDto.getReceiveNote());
        inventoryRecord.setRecordStatus("0");
        inventoryRecord.setOperator(loginUser.getUsername());
        inventoryRecord.setReceivePeople(loginUser.getUsername());
        int insertInventoryRecord = inventoryRecordService.insertInventoryRecord(inventoryRecord);
        if (updateProduct > 0 && insertInventoryRecord > 0) {
            return AjaxResult.success();
        }else {
            return AjaxResult.error();
        }
    }

    @PreAuthorize("@ss.hasPermi('yzt:product:delivery')")
    @Log(title = "出库", businessType = BusinessType.UPDATE)
    @PutMapping("/delivery")
    public AjaxResult deliveryProduct(@RequestBody ProductDto productDto, HttpServletRequest request) {
        LoginUser loginUser = tokenService.getLoginUser(request);
        if (StringUtils.isNotNull(loginUser)) {
            String userName = loginUser.getUsername();
        }
        Product product = new Product();
        product.setProductId(productDto.getProductId());
        Product selectProductById = productService.selectProductById(productDto.getProductId());
        int number = selectProductById.getInventory() - productDto.getChangeNumber();
        if (number<0){
            return AjaxResult.error(-9999,"库存不足");
        }
        product.setInventory(number);
        int updateProduct = productService.updateProduct(product);
        InventoryRecord inventoryRecord = new InventoryRecord();
        BeanUtils.copyProperties(productDto, inventoryRecord);
        inventoryRecord.setNote(productDto.getReceiveNote());
//        inventoryRecord.setRecordStatus("1");
        inventoryRecord.setOperator(loginUser.getUsername());
        int insertInventoryRecord = inventoryRecordService.insertInventoryRecord(inventoryRecord);
        if (updateProduct > 0 && insertInventoryRecord > 0) {
            return AjaxResult.success();
        }else {
            return AjaxResult.error();
        }
    }

    /**
     * 删除产品管理
     */
    @PreAuthorize("@ss.hasPermi('yzt:product:remove')")
    @Log(title = "产品管理", businessType = BusinessType.DELETE)
    @DeleteMapping("/{productIds}")
    public AjaxResult remove(@PathVariable Integer[] productIds) {
        return toAjax(productService.deleteProductByIds(productIds));
    }
}
