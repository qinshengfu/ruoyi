import request from '@/utils/request'

// 查询库存记录列表
export function listRecord(query) {
  return request({
    url: '/yzt/record/list',
    method: 'get',
    params: query
  })
}

// 查询库存记录详细
export function getRecord(inventoryRecordId) {
  return request({
    url: '/yzt/record/' + inventoryRecordId,
    method: 'get'
  })
}

// 新增库存记录
export function addRecord(data) {
  return request({
    url: '/yzt/record',
    method: 'post',
    data: data
  })
}

// 修改库存记录
export function updateRecord(data) {
  return request({
    url: '/yzt/record',
    method: 'put',
    data: data
  })
}

// 删除库存记录
export function delRecord(inventoryRecordId) {
  return request({
    url: '/yzt/record/' + inventoryRecordId,
    method: 'delete'
  })
}

// 导出库存记录
export function exportRecord(query) {
  return request({
    url: '/yzt/record/export',
    method: 'get',
    params: query
  })
}