package com.ruoyi.business.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.business.mapper.CloudApiMapper;
import com.ruoyi.business.domain.CloudApi;
import com.ruoyi.business.service.ICloudApiService;

/**
 * 游戏接口Service业务层处理
 * 
 * @author sirena
 * @date 2026-02-27
 */
@Service
public class CloudApiServiceImpl implements ICloudApiService 
{
    @Autowired
    private CloudApiMapper cloudApiMapper;

    /**
     * 查询游戏接口
     * 
     * @param id 游戏接口主键
     * @return 游戏接口
     */
    @Override
    public CloudApi selectCloudApiById(Long id)
    {
        return cloudApiMapper.selectCloudApiById(id);
    }

    /**
     * 查询游戏接口列表
     * 
     * @param cloudApi 游戏接口
     * @return 游戏接口
     */
    @Override
    public List<CloudApi> selectCloudApiList(CloudApi cloudApi)
    {
        return cloudApiMapper.selectCloudApiList(cloudApi);
    }

    /**
     * 新增游戏接口
     * 
     * @param cloudApi 游戏接口
     * @return 结果
     */
    @Override
    public int insertCloudApi(CloudApi cloudApi)
    {
        cloudApi.setCreateTime(DateUtils.getNowDate());
        return cloudApiMapper.insertCloudApi(cloudApi);
    }

    /**
     * 修改游戏接口
     * 
     * @param cloudApi 游戏接口
     * @return 结果
     */
    @Override
    public int updateCloudApi(CloudApi cloudApi)
    {
        cloudApi.setUpdateTime(DateUtils.getNowDate());
        return cloudApiMapper.updateCloudApi(cloudApi);
    }

    /**
     * 批量删除游戏接口
     * 
     * @param ids 需要删除的游戏接口主键
     * @return 结果
     */
    @Override
    public int deleteCloudApiByIds(Long[] ids)
    {
        return cloudApiMapper.deleteCloudApiByIds(ids);
    }

    /**
     * 删除游戏接口信息
     * 
     * @param id 游戏接口主键
     * @return 结果
     */
    @Override
    public int deleteCloudApiById(Long id)
    {
        return cloudApiMapper.deleteCloudApiById(id);
    }
}
