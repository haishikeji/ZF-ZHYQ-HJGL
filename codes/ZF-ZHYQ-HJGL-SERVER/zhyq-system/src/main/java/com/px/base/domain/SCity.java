package com.px.base.domain;

import com.px.common.annotation.Excel;
import com.px.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.math.BigDecimal;

/**
 * 城市信息对象 s_city
 *
 * @author 品讯科技
 * @date 2024-08
 */
public class SCity extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private Long regionId;

    /** 父类 */
    @Excel(name = "父类")
    private BigDecimal parentId;

    /** 名称 */
    @Excel(name = "名称")
    private String regionName;

    /** 类型 */
    @Excel(name = "类型")
    private BigDecimal regionType;

    public void setRegionId(Long regionId)
    {
        this.regionId = regionId;
    }

    public Long getRegionId()
    {
        return regionId;
    }
    public void setParentId(BigDecimal parentId)
    {
        this.parentId = parentId;
    }

    public BigDecimal getParentId()
    {
        return parentId;
    }
    public void setRegionName(String regionName)
    {
        this.regionName = regionName;
    }

    public String getRegionName()
    {
        return regionName;
    }
    public void setRegionType(BigDecimal regionType)
    {
        this.regionType = regionType;
    }

    public BigDecimal getRegionType()
    {
        return regionType;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("regionId", getRegionId())
            .append("parentId", getParentId())
            .append("regionName", getRegionName())
            .append("regionType", getRegionType())
            .toString();
    }
}
