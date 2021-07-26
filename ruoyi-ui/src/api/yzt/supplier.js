import request from '@/utils/request'

// 查询供应商管理列表
export function listSupplier(query) {
  return request({
    url: '/yzt/supplier/list',
    method: 'get',
    params: query
  })
}

export function supplierList() {
  return request({
    url: '/yzt/supplier/getSupplierList',
    method: 'get'
  })
}

// 查询供应商管理详细
export function getSupplier(supplierId) {
  return request({
    url: '/yzt/supplier/' + supplierId,
    method: 'get'
  })
}

// 新增供应商管理
export function addSupplier(data) {
  return request({
    url: '/yzt/supplier',
    method: 'post',
    data: data
  })
}

// 修改供应商管理
export function updateSupplier(data) {
  return request({
    url: '/yzt/supplier',
    method: 'put',
    data: data
  })
}

// 删除供应商管理
export function delSupplier(supplierId) {
  return request({
    url: '/yzt/supplier/' + supplierId,
    method: 'delete'
  })
}

// 导出供应商管理
export function exportSupplier(query) {
  return request({
    url: '/yzt/supplier/export',
    method: 'get',
    params: query
  })
}

// 供应商状态修改
export function changeStatus(supplierId, status) {
  const data = {
    supplierId,
    status
  }
  return request({
    url: '/yzt/supplier/changeStatus',
    method: 'put',
    data: data
  })
}
