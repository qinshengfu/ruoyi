import request from '@/utils/request'

// 查询采购管理列表
export function listProcurement(query) {
  return request({
    url: '/yzt/procurement/list',
    method: 'get',
    params: query
  })
}

// 查询采购管理详细
export function getProcurement(procurementId) {
  return request({
    url: '/yzt/procurement/' + procurementId,
    method: 'get'
  })
}

// 新增采购管理
export function addProcurement(data) {
  return request({
    url: '/yzt/procurement',
    method: 'post',
    data: data
  })
}

// 修改采购管理
export function updateProcurement(data) {
  return request({
    url: '/yzt/procurement',
    method: 'put',
    data: data
  })
}

// 修改采购管理
export function warehouseProcurement(data) {
  return request({
    url: '/yzt/procurement/warehouse',
    method: 'put',
    data: data
  })
}


// 删除采购管理
export function delProcurement(procurementId) {
  return request({
    url: '/yzt/procurement/' + procurementId,
    method: 'delete'
  })
}

// 导出采购管理
export function exportProcurement(query) {
  return request({
    url: '/yzt/procurement/export',
    method: 'get',
    params: query
  })
}