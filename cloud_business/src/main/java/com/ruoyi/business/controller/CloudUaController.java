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
import com.ruoyi.business.domain.CloudUa;
import com.ruoyi.business.service.ICloudUaService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 动态uaController
 * 
 * @author sirena
 * @date 2026-02-27
 */
@RestController
@RequestMapping("/business/ua")
public class CloudUaController extends BaseController
{
    @Autowired
    private ICloudUaService cloudUaService;

    /**
     * 查询动态ua列表
     */
    @PreAuthorize("@ss.hasPermi('business:ua:list')")
    @GetMapping("/list")
    public TableDataInfo list(CloudUa cloudUa)
    {
        startPage();
        List<CloudUa> list = cloudUaService.selectCloudUaList(cloudUa);
        return getDataTable(list);
    }

    /**
     * 导出动态ua列表
     */
    @PreAuthorize("@ss.hasPermi('business:ua:export')")
    @Log(title = "动态ua", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CloudUa cloudUa)
    {
        List<CloudUa> list = cloudUaService.selectCloudUaList(cloudUa);
        ExcelUtil<CloudUa> util = new ExcelUtil<CloudUa>(CloudUa.class);
        util.exportExcel(response, list, "动态ua数据");
    }

    /**
     * 获取动态ua详细信息
     */
    @PreAuthorize("@ss.hasPermi('business:ua:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(cloudUaService.selectCloudUaById(id));
    }

    /**
     * 新增动态ua
     */
    @PreAuthorize("@ss.hasPermi('business:ua:add')")
    @Log(title = "动态ua", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CloudUa cloudUa)
    {
        return toAjax(cloudUaService.insertCloudUa(cloudUa));
    }

    /**
     * 修改动态ua
     */
    @PreAuthorize("@ss.hasPermi('business:ua:edit')")
    @Log(title = "动态ua", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CloudUa cloudUa)
    {
        return toAjax(cloudUaService.updateCloudUa(cloudUa));
    }

    /**
     * 删除动态ua
     */
    @PreAuthorize("@ss.hasPermi('business:ua:remove')")
    @Log(title = "动态ua", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(cloudUaService.deleteCloudUaByIds(ids));
    }
}
