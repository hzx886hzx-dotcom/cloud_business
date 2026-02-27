package com.ruoyi.business.service;

import java.util.List;
import com.ruoyi.business.domain.CloudUa;

/**
 * 动态uaService接口
 * 
 * @author sirena
 * @date 2026-02-27
 */
public interface ICloudUaService 
{
    /**
     * 查询动态ua
     * 
     * @param id 动态ua主键
     * @return 动态ua
     */
    public CloudUa selectCloudUaById(Long id);

    /**
     * 查询动态ua列表
     * 
     * @param cloudUa 动态ua
     * @return 动态ua集合
     */
    public List<CloudUa> selectCloudUaList(CloudUa cloudUa);

    /**
     * 新增动态ua
     * 
     * @param cloudUa 动态ua
     * @return 结果
     */
    public int insertCloudUa(CloudUa cloudUa);

    /**
     * 修改动态ua
     * 
     * @param cloudUa 动态ua
     * @return 结果
     */
    public int updateCloudUa(CloudUa cloudUa);

    /**
     * 批量删除动态ua
     * 
     * @param ids 需要删除的动态ua主键集合
     * @return 结果
     */
    public int deleteCloudUaByIds(Long[] ids);

    /**
     * 删除动态ua信息
     * 
     * @param id 动态ua主键
     * @return 结果
     */
    public int deleteCloudUaById(Long id);
}
