package com.ruoyi.business.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.business.domain.CloudUser;
import com.ruoyi.business.service.ICloudUserService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 用户Controller
 * 
 * @author sirena
 * @date 2026-02-27
 */
@RestController
@RequestMapping("/business/user")
public class CloudUserController extends BaseController
{
    @Autowired
    private ICloudUserService cloudUserService;

    /**
     * 查询用户列表
     */
    @PreAuthorize("@ss.hasPermi('business:user:list')")
    @GetMapping("/list")
    public TableDataInfo list(CloudUser cloudUser)
    {
        startPage();
        List<CloudUser> list = cloudUserService.selectCloudUserList(cloudUser);
        return getDataTable(list);
    }

    /**
     * 导出用户列表
     */
    @PreAuthorize("@ss.hasPermi('business:user:export')")
    @Log(title = "用户", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CloudUser cloudUser)
    {
        List<CloudUser> list = cloudUserService.selectCloudUserList(cloudUser);
        ExcelUtil<CloudUser> util = new ExcelUtil<CloudUser>(CloudUser.class);
        util.exportExcel(response, list, "用户数据");
    }

    /**
     * 获取用户详细信息
     */
    @PreAuthorize("@ss.hasPermi('business:user:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(cloudUserService.selectCloudUserById(id));
    }

    /**
     * 新增用户
     */
    @PreAuthorize("@ss.hasPermi('business:user:add')")
    @Log(title = "用户", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CloudUser cloudUser)
    {
        return toAjax(cloudUserService.insertCloudUser(cloudUser));
    }

    /**
     * 修改用户
     */
    @PreAuthorize("@ss.hasPermi('business:user:edit')")
    @Log(title = "用户", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CloudUser cloudUser)
    {
        return toAjax(cloudUserService.updateCloudUser(cloudUser));
    }

    /**
     * 删除用户
     */
    @PreAuthorize("@ss.hasPermi('business:user:remove')")
    @Log(title = "用户", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(cloudUserService.deleteCloudUserByIds(ids));
    }
}
