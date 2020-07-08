import request from '@/utils/request'

/**
 * 测试实体实体的根 url
 * @type {string}
 */
const baseUrl = '/demo/demoEntity'
/**
 * 获得测试实体的数据字典
 */
export function getDemoEntityDict() {
  return request({
    url: `${baseUrl}/dict`,
    method: 'get'
  })
}

/**
 * 新增测试实体
 * @param model 需要保存的数据
 */
export function insertDemoEntity(model) {
  return request({
    url: `${baseUrl}`,
    method: 'post',
    data: model
  })
}

/**
 * 删除测试实体
 * @param id 要删除的测试实体id
 */
export function deleteDemoEntity(id) {
  return request({
    url: `${baseUrl}/${id}`,
    method: 'delete'
  })
}

/**
* 根据id查询测试实体
* @param id 要查询的测试实体id
*/
export function getDemoEntityById(id) {
  return request({
    url: `${baseUrl}/${id}`,
    method: 'get'
  })
}

/**
 * 更新测试实体
 * @param id 要更新的测试实体id
 * @param model 需要更新的数据
 */
export function updateDemoEntity(id, model) {
  return request({
    url: `${baseUrl}/${id}`,
    method: 'put',
    data: model
  })
}

/**
 * 查询测试实体,返回数组
 * @param model 查询条件
 */
export function getDemoEntityList(model) {
  return request({
    url: `${baseUrl}`,
    method: 'get',
    params: model
  })
}

/**
 * 分页查询测试实体,返回数组
 * @param page 第几页
 * @param size 没有多少条数据
 * @param model 查询条件
 */
export function getDemoEntityPage(page, size, model) {
  return request({
    url: `${baseUrl}/${page}/${size}`,
    method: 'get',
    params: model
  })
}

/**
 * 批量操作测试实体
 * @param model
 */
export function batchOperation(model) {
  return request({
    url: `${baseUrl}/batch`,
    method: 'post',
    data: model
  })
}
