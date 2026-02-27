package com.ruoyi.business.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 动态ua对象 cloud_ua
 * 
 * @author sirena
 * @date 2026-02-27
 */
public class CloudUa extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private Long id;

    /** ua信息 */
    @Excel(name = "ua信息")
    private String ua;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }

    public void setUa(String ua) 
    {
        this.ua = ua;
    }

    public String getUa() 
    {
        return ua;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("ua", getUa())
            .append("createTime", getCreateTime())
            .toString();
    }
}
