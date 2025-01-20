package com.px.provincialData.domain;

import com.px.base.domain.ROutletFactorInfo;
import com.px.common.annotation.Excel;
import com.px.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.List;

/**
 * 水污染物排放口信息对象 b_water_outlet_info
 *
 * @author 品讯科技
 * @date 2024-08
 */
public class BWaterOutletInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 企业编码 */
    @Excel(name = "企业编码")
    private String enterpriseCode;

    /** 排污许可证编号 */
    @Excel(name = "排污许可证编号")
    private String licenseCode;

    /** 排放口编码 */
    @Excel(name = "排放口编码")
    private String outletCode;

    /** 排放口名称 */
    @Excel(name = "排放口名称")
    private String outletName;

    /** 排放口类型 */
    @Excel(name = "排放口类型")
    private String outletType;

    /** 排口种类;3进水口 4工业进水口 5排口 */
    @Excel(name = "排放口种类", readConverterExp = "3=进水口,4=工业进水口,5=排口")
    private String outletIlk;

    /** 排放方式 */
    @Excel(name = "排放方式")
    private String outletMethod;

    /** 排放去向 */
    @Excel(name = "排放去向")
    private String outletDirection;

    /** 经度 */
    @Excel(name = "经度")
    private String outletLng;

    /** 纬度 */
    @Excel(name = "纬度")
    private String outletLat;

    /** 执行标准 */
    private String standardsType;

    /** 删除字段(0未删除，1已删除) */
    private String delFlag;

    private List<ROutletFactorInfo> rOutletFactorInfoList;

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
    public void setLicenseCode(String licenseCode)
    {
        this.licenseCode = licenseCode;
    }

    public String getLicenseCode()
    {
        return licenseCode;
    }
    public void setOutletCode(String outletCode)
    {
        this.outletCode = outletCode;
    }

    public String getOutletCode()
    {
        return outletCode;
    }
    public void setOutletName(String outletName)
    {
        this.outletName = outletName;
    }

    public String getOutletName()
    {
        return outletName;
    }
    public void setOutletType(String outletType)
    {
        this.outletType = outletType;
    }

    public String getOutletType()
    {
        return outletType;
    }
    public String getOutletIlk() {
        return outletIlk;
    }

    public void setOutletIlk(String outletIlk) {
        this.outletIlk = outletIlk;
    }
    public void setOutletMethod(String outletMethod)
    {
        this.outletMethod = outletMethod;
    }

    public String getOutletMethod()
    {
        return outletMethod;
    }
    public void setOutletDirection(String outletDirection)
    {
        this.outletDirection = outletDirection;
    }

    public String getOutletDirection()
    {
        return outletDirection;
    }
    public void setOutletLng(String outletLng)
    {
        this.outletLng = outletLng;
    }

    public String getOutletLng()
    {
        return outletLng;
    }
    public void setOutletLat(String outletLat)
    {
        this.outletLat = outletLat;
    }

    public String getOutletLat()
    {
        return outletLat;
    }
    public void setDelFlag(String delFlag)
    {
        this.delFlag = delFlag;
    }

    public String getDelFlag()
    {
        return delFlag;
    }

    public List<ROutletFactorInfo> getrOutletFactorInfoList() {
        return rOutletFactorInfoList;
    }

    public void setROutletFactorInfoList(List<ROutletFactorInfo> rOutletFactorInfoList) {
        this.rOutletFactorInfoList = rOutletFactorInfoList;
    }

    public String getStandardsType() {
        return standardsType;
    }

    public void setStandardsType(String standardsType) {
        this.standardsType = standardsType;
    }

    public void setrOutletFactorInfoList(List<ROutletFactorInfo> rOutletFactorInfoList) {
        this.rOutletFactorInfoList = rOutletFactorInfoList;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("enterpriseCode", getEnterpriseCode())
                .append("licenseCode", getLicenseCode())
                .append("outletCode", getOutletCode())
                .append("outletName", getOutletName())
                .append("outletType", getOutletType())
                .append("outletMethod", getOutletMethod())
                .append("outletDirection", getOutletDirection())
                .append("outletLng", getOutletLng())
                .append("outletLat", getOutletLat())
                .append("delFlag", getDelFlag())
                .append("createTime", getCreateTime())
                .append("createBy", getCreateBy())
                .append("updateTime", getUpdateTime())
                .append("updateBy", getUpdateBy())
                .append("ROutletFactorInfoList", getrOutletFactorInfoList())
                .append("standardsType", getStandardsType())
                .toString();
    }
}
