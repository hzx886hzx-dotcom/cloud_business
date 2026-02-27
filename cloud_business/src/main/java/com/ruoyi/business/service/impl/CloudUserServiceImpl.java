package com.ruoyi.business.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.business.mapper.CloudUserMapper;
import com.ruoyi.business.domain.CloudUser;
import com.ruoyi.business.service.ICloudUserService;

/**
 * 用户Service业务层处理
 * 
 * @author sirena
 * @date 2026-02-27
 */
@Service
public class CloudUserServiceImpl implements ICloudUserService 
{
    @Autowired
    private CloudUserMapper cloudUserMapper;

    /**
     * 查询用户
     * 
     * @param id 用户主键
     * @return 用户
     */
    @Override
    public CloudUser selectCloudUserById(Long id)
    {
        return cloudUserMapper.selectCloudUserById(id);
    }

    /**
     * 查询用户列表
     * 
     * @param cloudUser 用户
     * @return 用户
     */
    @Override
    public List<CloudUser> selectCloudUserList(CloudUser cloudUser)
    {
        return cloudUserMapper.selectCloudUserList(cloudUser);
    }

    /**
     * 新增用户
     * 
     * @param cloudUser 用户
     * @return 结果
     */
    @Override
    public int insertCloudUser(CloudUser cloudUser)
    {
        cloudUser.setCreateTime(DateUtils.getNowDate());
        return cloudUserMapper.insertCloudUser(cloudUser);
    }

    /**
     * 修改用户
     * 
     * @param cloudUser 用户
     * @return 结果
     */
    @Override
    public int updateCloudUser(CloudUser cloudUser)
    {
        return cloudUserMapper.updateCloudUser(cloudUser);
    }

    /**
     * 批量删除用户
     * 
     * @param ids 需要删除的用户主键
     * @return 结果
     */
    @Override
    public int deleteCloudUserByIds(Long[] ids)
    {
        return cloudUserMapper.deleteCloudUserByIds(ids);
    }

    /**
     * 删除用户信息
     * 
     * @param id 用户主键
     * @return 结果
     */
    @Override
    public int deleteCloudUserById(Long id)
    {
        return cloudUserMapper.deleteCloudUserById(id);
    }
}
