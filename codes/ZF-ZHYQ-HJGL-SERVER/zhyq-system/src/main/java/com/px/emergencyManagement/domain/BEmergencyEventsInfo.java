package com.px.emergencyManagement.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.px.common.annotation.Excel;
import com.px.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 应急事件信息对象 b_emergency_events_info
 *
 * @author 品讯科技
 * @date 2024-08
 */
public class BEmergencyEventsInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键id */
    private Long id;

    /** 企业编码 */
    private String enterpriseCode;

    /** 企业名称 */
    @Excel(name = "企业名称")
    private String enterpriseName;

    /** 事件类型 */
    @Excel(name = "事件类型", dictType = "emergency_events_type")
    private String eventsType;

    /** 描述 */
    @Excel(name = "描述")
    private String description;

    /** 发生时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Excel(name = "发生时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date occurrenceTime;

    /** 发生位置 */
    @Excel(name = "发生位置")
    private String address;

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
    public void setEnterpriseCode(String enterpriseCode)
    {
        this.enterpriseCode = enterpriseCode;
    }

    public String getEnterpriseCode()
    {
        return enterpriseCode;
    }
    public void setEventsType(String eventsType)
    {
        this.eventsType = eventsType;
    }

    public String getEventsType()
    {
        return eventsType;
    }
    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getDescription()
    {
        return description;
    }
    public void setOccurrenceTime(Date occurrenceTime)
    {
        this.occurrenceTime = occurrenceTime;
    }

    public Date getOccurrenceTime()
    {
        return occurrenceTime;
    }
    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getAddress()
    {
        return address;
    }
    public void setDelFlag(String delFlag)
    {
        this.delFlag = delFlag;
    }

    public String getDelFlag()
    {
        return delFlag;
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
                .append("eventsType", getEventsType())
                .append("description", getDescription())
                .append("occurrenceTime", getOccurrenceTime())
                .append("address", getAddress())
                .append("delFlag", getDelFlag())
                .append("createTime", getCreateTime())
                .append("createBy", getCreateBy())
                .append("updateTime", getUpdateTime())
                .append("updateBy", getUpdateBy())
                .toString();
    }
}
