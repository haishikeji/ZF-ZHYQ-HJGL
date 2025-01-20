package com.px.provincialData.domain;

import com.px.common.annotation.Excel;
import com.px.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 排放口排放标准信息对象 b_outlet_standard_info
 *
 * @author 品讯科技
 * @date 2024-08
 */
public class BOutletStandardInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 执行标准编码 */
    @Excel(name = "执行标准编码")
    private String standardCode;

    /** 执行标准名称 */
    @Excel(name = "执行标准名称")
    private String standardName;

    /** 执行标准内容 */
    @Excel(name = "执行标准内容")
    private String standardText;

    /** 删除字段(0未删除，1已删除) */
    private String delFlag;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setStandardCode(String standardCode)
    {
        this.standardCode = standardCode;
    }

    public String getStandardCode()
    {
        return standardCode;
    }
    public void setStandardName(String standardName)
    {
        this.standardName = standardName;
    }

    public String getStandardName()
    {
        return standardName;
    }
    public void setStandardText(String standardText)
    {
        this.standardText = standardText;
    }

    public String getStandardText()
    {
        return standardText;
    }
    public void setDelFlag(String delFlag)
    {
        this.delFlag = delFlag;
    }

    public String getDelFlag()
    {
        return delFlag;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("standardCode", getStandardCode())
                .append("standardName", getStandardName())
                .append("standardText", getStandardText())
                .append("delFlag", getDelFlag())
                .append("createTime", getCreateTime())
                .append("createBy", getCreateBy())
                .append("updateTime", getUpdateTime())
                .append("updateBy", getUpdateBy())
                .toString();
    }
}
