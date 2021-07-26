import request from '@/utils/request'

// 查询产品管理列表
export function listProduct(query) {
  return request({
    url: '/yzt/product/list',
    method: 'get',
    params: query
  })
}

export function productList(supplierName) {
  const data = {
    supplierName
  }
  return request({
    url: '/yzt/product/getProductList',
    method: 'get',
    params: data
  })
}

// 查询产品管理详细
export function getProduct(productId) {
  return request({
    url: '/yzt/product/' + productId,
    method: 'get'
  })
}

// 新增产品管理
export function addProduct(data) {
  return request({
    url: '/yzt/product',
    method: 'post',
    data: data
  })
}

// 修改产品管理
export function updateProduct(data) {
  return request({
    url: '/yzt/product',
    method: 'put',
    data: data
  })
}

//入库
export function wareHouseProduct(data) {
  return request({
    url: '/yzt/product/warehouse',
    method: 'put',
    data: data
  })
}

//出库
export function deliveryProduct(data) {
  return request({
    url: '/yzt/product/delivery',
    method: 'put',
    data: data
  })
}

// 删除产品管理
export function delProduct(productId) {
  return request({
    url: '/yzt/product/' + productId,
    method: 'delete'
  })
}

// 导出产品管理
export function exportProduct(query) {
  return request({
    url: '/yzt/product/export',
    method: 'get',
    params: query
  })
}

// 供应商状态修改
export function changeStatus(productId, status) {
  const data = {
    productId,
    status
  }
  return request({
    url: '/yzt/product/changeStatus',
    method: 'put',
    data: data
  })
}
