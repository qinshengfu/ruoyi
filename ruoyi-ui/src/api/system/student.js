import request from '@/utils/request'

// 查询学生信息列表
export function listStudent(query) {
  return request({
    url: '/system/student/list',
    method: 'get',
    params: query
  })
}

// 学生状态修改
export function changeStudentStatus(studentId, studentStatus) {
  const data = {
    studentId,
    studentStatus
  }
  return request({
    url: '/system/student/changeStatus',
    method: 'put',
    data: data
  })
}

// 查询学生信息详细
export function getStudent(studentId) {
  return request({
    url: '/system/student/' + studentId,
    method: 'get'
  })
}

// 新增学生信息
export function addStudent(data) {
  return request({
    url: '/system/student',
    method: 'post',
    data: data
  })
}

// 修改学生信息
export function updateStudent(data) {
  return request({
    url: '/system/student',
    method: 'put',
    data: data
  })
}

// 删除学生信息
export function delStudent(studentId) {
  return request({
    url: '/system/student/' + studentId,
    method: 'delete'
  })
}

// 导出学生信息
export function exportStudent(query) {
  return request({
    url: '/system/student/export',
    method: 'get',
    params: query
  })
}