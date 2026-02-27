import request from '@/utils/request'

// 查询动态ua列表
export function listUa(query) {
  return request({
    url: '/business/ua/list',
    method: 'get',
    params: query
  })
}

// 查询动态ua详细
export function getUa(id) {
  return request({
    url: '/business/ua/' + id,
    method: 'get'
  })
}

// 新增动态ua
export function addUa(data) {
  return request({
    url: '/business/ua',
    method: 'post',
    data: data
  })
}

// 修改动态ua
export function updateUa(data) {
  return request({
    url: '/business/ua',
    method: 'put',
    data: data
  })
}

// 删除动态ua
export function delUa(id) {
  return request({
    url: '/business/ua/' + id,
    method: 'delete'
  })
}
