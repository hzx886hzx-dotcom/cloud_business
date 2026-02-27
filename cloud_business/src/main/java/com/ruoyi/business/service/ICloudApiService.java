package com.ruoyi.business.service;

import java.util.List;
import com.ruoyi.business.domain.CloudApi;

/**
 * 游戏接口Service接口
 * 
 * @author sirena
 * @date 2026-02-27
 */
public interface ICloudApiService 
{
    /**
     * 查询游戏接口
     * 
     * @param id 游戏接口主键
     * @return 游戏接口
     */
    public CloudApi selectCloudApiById(Long id);

    /**
     * 查询游戏接口列表
     * 
     * @param cloudApi 游戏接口
     * @return 游戏接口集合
     */
    public List<CloudApi> selectCloudApiList(CloudApi cloudApi);

    /**
     * 新增游戏接口
     * 
     * @param cloudApi 游戏接口
     * @return 结果
     */
    public int insertCloudApi(CloudApi cloudApi);

    /**
     * 修改游戏接口
     * 
     * @param cloudApi 游戏接口
     * @return 结果
     */
    public int updateCloudApi(CloudApi cloudApi);

    /**
     * 批量删除游戏接口
     * 
     * @param ids 需要删除的游戏接口主键集合
     * @return 结果
     */
    public int deleteCloudApiByIds(Long[] ids);

    /**
     * 删除游戏接口信息
     * 
     * @param id 游戏接口主键
     * @return 结果
     */
    public int deleteCloudApiById(Long id);
}
