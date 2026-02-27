package com.ruoyi.business.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 游戏接口对象 cloud_api
 * 
 * @author sirena
 * @date 2026-02-27
 */
public class CloudApi extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键ID */
    private Long id;

    /** 分类 0=游戏 1=用户 */
    @Excel(name = "分类 0=游戏 1=用户")
    private Long category;

    /** 平台 0=石头岛 1=鲸鱼 */
    @Excel(name = "平台 0=石头岛 1=鲸鱼")
    private Long platform;

    /** 接口名称 */
    @Excel(name = "接口名称")
    private String name;

    /** 接口URL */
    @Excel(name = "接口URL")
    private String api;

    /** 请求方式 */
    @Excel(name = "请求方式")
    private String method;

    /** 内容类型 */
    private String contentType;

    /** 请求头(JSON) */
    private String headers;

    /** 查询参数(JSON) */
    private String params;

    /** 代理 */
    private String proxy;

    /** 超时时间(秒) */
    private Long timeout;

    /** 重试次数 */
    private Long retryTimes;

    /** 重试间隔(秒) */
    private Long retryInterval;

    /** 下次执行间隔(秒) */
    private Long nextExecuteInterval;

    /** 响应格式 */
    private String respFormat;

    /** 期望响应码(多个用逗号分隔) */
    private String expectCode;

    /** 状态 0:禁用 1:启用 */
    @Excel(name = "状态 0:禁用 1:启用")
    private Integer status;

    /** 排序 */
    private Long sort;

    /** 接口描述 */
    private String description;

    /** 创建人 */
    private String creator;

    /** 版本号 */
    private Long version;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }

    public void setCategory(Long category) 
    {
        this.category = category;
    }

    public Long getCategory() 
    {
        return category;
    }

    public void setPlatform(Long platform) 
    {
        this.platform = platform;
    }

    public Long getPlatform() 
    {
        return platform;
    }

    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }

    public void setApi(String api) 
    {
        this.api = api;
    }

    public String getApi() 
    {
        return api;
    }

    public void setMethod(String method) 
    {
        this.method = method;
    }

    public String getMethod() 
    {
        return method;
    }

    public void setContentType(String contentType) 
    {
        this.contentType = contentType;
    }

    public String getContentType() 
    {
        return contentType;
    }

    public void setHeaders(String headers) 
    {
        this.headers = headers;
    }

    public String getHeaders() 
    {
        return headers;
    }

    public void setBody(String params)
    {
        this.params = params;
    }

    public String setBody()
    {
        return params;
    }

    public void setProxy(String proxy) 
    {
        this.proxy = proxy;
    }

    public String getProxy() 
    {
        return proxy;
    }

    public void setTimeout(Long timeout) 
    {
        this.timeout = timeout;
    }

    public Long getTimeout() 
    {
        return timeout;
    }

    public void setRetryTimes(Long retryTimes) 
    {
        this.retryTimes = retryTimes;
    }

    public Long getRetryTimes() 
    {
        return retryTimes;
    }

    public void setRetryInterval(Long retryInterval) 
    {
        this.retryInterval = retryInterval;
    }

    public Long getRetryInterval() 
    {
        return retryInterval;
    }

    public void setNextExecuteInterval(Long nextExecuteInterval) 
    {
        this.nextExecuteInterval = nextExecuteInterval;
    }

    public Long getNextExecuteInterval() 
    {
        return nextExecuteInterval;
    }

    public void setRespFormat(String respFormat) 
    {
        this.respFormat = respFormat;
    }

    public String getRespFormat() 
    {
        return respFormat;
    }

    public void setExpectCode(String expectCode) 
    {
        this.expectCode = expectCode;
    }

    public String getExpectCode() 
    {
        return expectCode;
    }

    public void setStatus(Integer status) 
    {
        this.status = status;
    }

    public Integer getStatus() 
    {
        return status;
    }

    public void setSort(Long sort) 
    {
        this.sort = sort;
    }

    public Long getSort() 
    {
        return sort;
    }

    public void setDescription(String description) 
    {
        this.description = description;
    }

    public String getDescription() 
    {
        return description;
    }

    public void setCreator(String creator) 
    {
        this.creator = creator;
    }

    public String getCreator() 
    {
        return creator;
    }

    public void setVersion(Long version) 
    {
        this.version = version;
    }

    public Long getVersion() 
    {
        return version;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("category", getCategory())
            .append("platform", getPlatform())
            .append("name", getName())
            .append("api", getApi())
            .append("method", getMethod())
            .append("contentType", getContentType())
            .append("headers", getHeaders())
            .append("params", getParams())
            .append("proxy", getProxy())
            .append("timeout", getTimeout())
            .append("retryTimes", getRetryTimes())
            .append("retryInterval", getRetryInterval())
            .append("nextExecuteInterval", getNextExecuteInterval())
            .append("respFormat", getRespFormat())
            .append("expectCode", getExpectCode())
            .append("status", getStatus())
            .append("sort", getSort())
            .append("description", getDescription())
            .append("creator", getCreator())
            .append("createBy", getCreateBy())
            .append("version", getVersion())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
