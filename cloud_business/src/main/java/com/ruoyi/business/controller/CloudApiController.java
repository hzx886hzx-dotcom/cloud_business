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
import com.ruoyi.business.domain.CloudApi;
import com.ruoyi.business.service.ICloudApiService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 游戏接口Controller
 * 
 * @author sirena
 * @date 2026-02-27
 */
@RestController
@RequestMapping("/business/api")
public class CloudApiController extends BaseController
{
    @Autowired
    private ICloudApiService cloudApiService;

    /**
     * 查询游戏接口列表
     */
    @PreAuthorize("@ss.hasPermi('business:api:list')")
    @GetMapping("/list")
    public TableDataInfo list(CloudApi cloudApi)
    {
        startPage();
        List<CloudApi> list = cloudApiService.selectCloudApiList(cloudApi);
        return getDataTable(list);
    }

    /**
     * 导出游戏接口列表
     */
    @PreAuthorize("@ss.hasPermi('business:api:export')")
    @Log(title = "游戏接口", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CloudApi cloudApi)
    {
        List<CloudApi> list = cloudApiService.selectCloudApiList(cloudApi);
        ExcelUtil<CloudApi> util = new ExcelUtil<CloudApi>(CloudApi.class);
        util.exportExcel(response, list, "游戏接口数据");
    }

    /**
     * 获取游戏接口详细信息
     */
    @PreAuthorize("@ss.hasPermi('business:api:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(cloudApiService.selectCloudApiById(id));
    }

    /**
     * 新增游戏接口
     */
    @PreAuthorize("@ss.hasPermi('business:api:add')")
    @Log(title = "游戏接口", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CloudApi cloudApi)
    {
        return toAjax(cloudApiService.insertCloudApi(cloudApi));
    }

    /**
     * 修改游戏接口
     */
    @PreAuthorize("@ss.hasPermi('business:api:edit')")
    @Log(title = "游戏接口", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CloudApi cloudApi)
    {
        return toAjax(cloudApiService.updateCloudApi(cloudApi));
    }

    /**
     * 删除游戏接口
     */
    @PreAuthorize("@ss.hasPermi('business:api:remove')")
    @Log(title = "游戏接口", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(cloudApiService.deleteCloudApiByIds(ids));
    }
}
