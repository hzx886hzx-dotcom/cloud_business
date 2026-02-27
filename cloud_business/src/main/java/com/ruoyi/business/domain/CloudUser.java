package com.ruoyi.business.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 用户对象 cloud_user
 * 
 * @author sirena
 * @date 2026-02-27
 */
public class CloudUser extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private Long id;

    /** 用户名 */
    @Excel(name = "用户名")
    private String username;

    /** 密码 */
    private String password;

    /** 代理 */
    private String proxy;

    /** 金额 */
    @Excel(name = "金额")
    private BigDecimal amount;

    /** 访问令牌 */
    private String accessToken;

    /** 平台 0=石头岛 1=鲸鱼 */
    @Excel(name = "平台 0=石头岛 1=鲸鱼")
    private Integer platform;

    /** ua_id */
    @Excel(name = "ua_id")
    private Long uaId;

    /** 创建人 */
    @Excel(name = "创建人")
    private String creator;

    /** 版本号 */
    @Excel(name = "版本号")
    private Integer version;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }

    public void setUsername(String username) 
    {
        this.username = username;
    }

    public String getUsername() 
    {
        return username;
    }

    public void setPassword(String password) 
    {
        this.password = password;
    }

    public String getPassword() 
    {
        return password;
    }

    public void setProxy(String proxy) 
    {
        this.proxy = proxy;
    }

    public String getProxy() 
    {
        return proxy;
    }

    public void setAmount(BigDecimal amount) 
    {
        this.amount = amount;
    }

    public BigDecimal getAmount() 
    {
        return amount;
    }

    public void setAccessToken(String accessToken) 
    {
        this.accessToken = accessToken;
    }

    public String getAccessToken() 
    {
        return accessToken;
    }

    public void setPlatform(Integer platform) 
    {
        this.platform = platform;
    }

    public Integer getPlatform() 
    {
        return platform;
    }

    public void setUaId(Long uaId) 
    {
        this.uaId = uaId;
    }

    public Long getUaId() 
    {
        return uaId;
    }

    public void setCreator(String creator) 
    {
        this.creator = creator;
    }

    public String getCreator() 
    {
        return creator;
    }

    public void setVersion(Integer version) 
    {
        this.version = version;
    }

    public Integer getVersion() 
    {
        return version;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("username", getUsername())
            .append("password", getPassword())
            .append("proxy", getProxy())
            .append("amount", getAmount())
            .append("accessToken", getAccessToken())
            .append("platform", getPlatform())
            .append("uaId", getUaId())
            .append("createTime", getCreateTime())
            .append("creator", getCreator())
            .append("createBy", getCreateBy())
            .append("version", getVersion())
            .toString();
    }
}
