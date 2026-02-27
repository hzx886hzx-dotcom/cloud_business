package com.ruoyi.business.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.business.mapper.CloudUaMapper;
import com.ruoyi.business.domain.CloudUa;
import com.ruoyi.business.service.ICloudUaService;

/**
 * 动态uaService业务层处理
 * 
 * @author sirena
 * @date 2026-02-27
 */
@Service
public class CloudUaServiceImpl implements ICloudUaService 
{
    @Autowired
    private CloudUaMapper cloudUaMapper;

    /**
     * 查询动态ua
     * 
     * @param id 动态ua主键
     * @return 动态ua
     */
    @Override
    public CloudUa selectCloudUaById(Long id)
    {
        return cloudUaMapper.selectCloudUaById(id);
    }

    /**
     * 查询动态ua列表
     * 
     * @param cloudUa 动态ua
     * @return 动态ua
     */
    @Override
    public List<CloudUa> selectCloudUaList(CloudUa cloudUa)
    {
        return cloudUaMapper.selectCloudUaList(cloudUa);
    }

    /**
     * 新增动态ua
     * 
     * @param cloudUa 动态ua
     * @return 结果
     */
    @Override
    public int insertCloudUa(CloudUa cloudUa)
    {
        cloudUa.setCreateTime(DateUtils.getNowDate());
        return cloudUaMapper.insertCloudUa(cloudUa);
    }

    /**
     * 修改动态ua
     * 
     * @param cloudUa 动态ua
     * @return 结果
     */
    @Override
    public int updateCloudUa(CloudUa cloudUa)
    {
        return cloudUaMapper.updateCloudUa(cloudUa);
    }

    /**
     * 批量删除动态ua
     * 
     * @param ids 需要删除的动态ua主键
     * @return 结果
     */
    @Override
    public int deleteCloudUaByIds(Long[] ids)
    {
        return cloudUaMapper.deleteCloudUaByIds(ids);
    }

    /**
     * 删除动态ua信息
     * 
     * @param id 动态ua主键
     * @return 结果
     */
    @Override
    public int deleteCloudUaById(Long id)
    {
        return cloudUaMapper.deleteCloudUaById(id);
    }
}
