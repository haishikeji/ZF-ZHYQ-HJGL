package com.px.emergencyManagement.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.px.common.annotation.Excel;
import com.px.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 应急预案信息对象 b_plan_info
 *
 * @author 品讯科技
 * @date 2024-08
 */
public class BPlanInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键id */
    private Long id;

    /** 企业编码 */
    private String enterpriseCode;

    @Excel(name = "企业名称")
    private String enterpriseName;

    /** 预案 */
    @Excel(name = "预案")
    private String planName;

    /** 备案信息 */
    @Excel(name = "备案信息")
    private String filingInfo;

    /** 预案类型 */
    @Excel(name = "预案类型", dictType = "emergency_plan_type")
    private String planType;

    /** 删除字段(0未删除，1已删除) */
    private String delFlag;

    /** 版本 */
    @Excel(name = "版本")
    private String version;

    /** 编制日期 */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @Excel(name = "编制日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date compilationDate;

    /** 生效日期 */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @Excel(name = "生效日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date effectiveDate;

    /** 有效期 */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @Excel(name = "有效期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date validity;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setEnterpriseCode(String enterpriseCode)
    {
        this.enterpriseCode = enterpriseCode;
    }

    public String getEnterpriseCode()
    {
        return enterpriseCode;
    }
    public void setPlanName(String planName)
    {
        this.planName = planName;
    }

    public String getPlanName()
    {
        return planName;
    }
    public void setValidity(Date validity)
    {
        this.validity = validity;
    }

    public Date getValidity()
    {
        return validity;
    }
    public void setFilingInfo(String filingInfo)
    {
        this.filingInfo = filingInfo;
    }

    public String getFilingInfo()
    {
        return filingInfo;
    }
    public void setPlanType(String planType)
    {
        this.planType = planType;
    }

    public String getPlanType()
    {
        return planType;
    }
    public void setDelFlag(String delFlag)
    {
        this.delFlag = delFlag;
    }

    public String getDelFlag()
    {
        return delFlag;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Date getCompilationDate() {
        return compilationDate;
    }

    public void setCompilationDate(Date compilationDate) {
        this.compilationDate = compilationDate;
    }

    public Date getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(Date effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("enterpriseCode", getEnterpriseCode())
                .append("planName", getPlanName())
                .append("validity", getValidity())
                .append("filingInfo", getFilingInfo())
                .append("planType", getPlanType())
                .append("delFlag", getDelFlag())
                .append("createTime", getCreateTime())
                .append("createBy", getCreateBy())
                .append("updateTime", getUpdateTime())
                .append("updateBy", getUpdateBy())
                .append("version", getVersion())
                .append("compilationDate", getCompilationDate())
                .append("effectiveDate", getEffectiveDate())
                .toString();
    }
}
