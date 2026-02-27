import request from '@/utils/request'

// 查询游戏接口列表
export function listApi(query) {
  return request({
    url: '/business/api/list',
    method: 'get',
    params: query
  })
}

// 查询游戏接口详细
export function getApi(id) {
  return request({
    url: '/business/api/' + id,
    method: 'get'
  })
}

// 新增游戏接口
export function addApi(data) {
  return request({
    url: '/business/api',
    method: 'post',
    data: data
  })
}

// 修改游戏接口
export function updateApi(data) {
  return request({
    url: '/business/api',
    method: 'put',
    data: data
  })
}

// 删除游戏接口
export function delApi(id) {
  return request({
    url: '/business/api/' + id,
    method: 'delete'
  })
}
