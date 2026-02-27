package com.ruoyi.business.service;

import java.util.List;
import com.ruoyi.business.domain.CloudUser;

/**
 * 用户Service接口
 * 
 * @author sirena
 * @date 2026-02-27
 */
public interface ICloudUserService 
{
    /**
     * 查询用户
     * 
     * @param id 用户主键
     * @return 用户
     */
    public CloudUser selectCloudUserById(Long id);

    /**
     * 查询用户列表
     * 
     * @param cloudUser 用户
     * @return 用户集合
     */
    public List<CloudUser> selectCloudUserList(CloudUser cloudUser);

    /**
     * 新增用户
     * 
     * @param cloudUser 用户
     * @return 结果
     */
    public int insertCloudUser(CloudUser cloudUser);

    /**
     * 修改用户
     * 
     * @param cloudUser 用户
     * @return 结果
     */
    public int updateCloudUser(CloudUser cloudUser);

    /**
     * 批量删除用户
     * 
     * @param ids 需要删除的用户主键集合
     * @return 结果
     */
    public int deleteCloudUserByIds(Long[] ids);

    /**
     * 删除用户信息
     * 
     * @param id 用户主键
     * @return 结果
     */
    public int deleteCloudUserById(Long id);
}
