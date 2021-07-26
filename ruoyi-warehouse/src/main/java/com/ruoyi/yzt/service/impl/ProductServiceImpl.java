package com.ruoyi.yzt.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.yzt.mapper.ProductMapper;
import com.ruoyi.yzt.domain.Product;
import com.ruoyi.yzt.service.IProductService;

/**
 * 产品管理Service业务层处理
 * 
 * @author qsf
 * @date 2021-07-19
 */
@Service
public class ProductServiceImpl implements IProductService 
{
    @Autowired
    private ProductMapper productMapper;

    /**
     * 查询产品管理
     * 
     * @param productId 产品管理ID
     * @return 产品管理
     */
    @Override
    public Product selectProductById(Integer productId)
    {
        return productMapper.selectProductById(productId);
    }

    /**
     * 查询产品管理列表
     * 
     * @param product 产品管理
     * @return 产品管理
     */
    @Override
    public List<Product> selectProductList(Product product)
    {
        return productMapper.selectProductList(product);
    }

    /**
     * 新增产品管理
     * 
     * @param product 产品管理
     * @return 结果
     */
    @Override
    public int insertProduct(Product product)
    {
        product.setCreateTime(DateUtils.getNowDate());
        return productMapper.insertProduct(product);
    }

    /**
     * 修改产品管理
     * 
     * @param product 产品管理
     * @return 结果
     */
    @Override
    public int updateProduct(Product product)
    {
        product.setUpdateTime(DateUtils.getNowDate());
        return productMapper.updateProduct(product);
    }

    /**
     * 批量删除产品管理
     * 
     * @param productIds 需要删除的产品管理ID
     * @return 结果
     */
    @Override
    public int deleteProductByIds(Integer[] productIds)
    {
        return productMapper.deleteProductByIds(productIds);
    }

    /**
     * 删除产品管理信息
     * 
     * @param productId 产品管理ID
     * @return 结果
     */
    @Override
    public int deleteProductById(Integer productId)
    {
        return productMapper.deleteProductById(productId);
    }
}
