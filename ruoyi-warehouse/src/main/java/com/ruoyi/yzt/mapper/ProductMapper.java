package com.ruoyi.yzt.mapper;

import java.util.List;
import com.ruoyi.yzt.domain.Product;

/**
 * 产品管理Mapper接口
 * 
 * @author qsf
 * @date 2021-07-19
 */
public interface ProductMapper 
{
    /**
     * 查询产品管理
     * 
     * @param productId 产品管理ID
     * @return 产品管理
     */
    public Product selectProductById(Integer productId);

    /**
     * 查询产品管理列表
     * 
     * @param product 产品管理
     * @return 产品管理集合
     */
    public List<Product> selectProductList(Product product);

    /**
     * 新增产品管理
     * 
     * @param product 产品管理
     * @return 结果
     */
    public int insertProduct(Product product);

    /**
     * 修改产品管理
     * 
     * @param product 产品管理
     * @return 结果
     */
    public int updateProduct(Product product);

    /**
     * 删除产品管理
     * 
     * @param productId 产品管理ID
     * @return 结果
     */
    public int deleteProductById(Integer productId);

    /**
     * 批量删除产品管理
     * 
     * @param productIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteProductByIds(Integer[] productIds);
}
