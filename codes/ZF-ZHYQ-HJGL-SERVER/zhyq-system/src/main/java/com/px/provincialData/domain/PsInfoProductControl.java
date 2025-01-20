package com.px.provincialData.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.px.common.annotation.Excel;
import com.px.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 生产设施管控对象 psinfo_product_control
 *
 * @author 品讯科技
 * @date 2024-08
 */
public class PsInfoProductControl extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 排污许可证编号 */
    @Excel(name = "排污许可证编号")
    private String pwxkzbh;

    /** 生产单元id(“生产单元信息”表中id) */
    @Excel(name = "生产单元id(“生产单元信息”表中id)")
    private String productId;

    /** 监管类型（1:停产
     2:限产） */
    @Excel(name = "监管类型", readConverterExp = "1=:停产 2:限产")
    private String superviseType;

    /** 限产百分比 */
    @Excel(name = "限产百分比")
    private String limitproductRate;

    /** 管控开始时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "管控开始时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date controlStartTime;

    /** 管控结束时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "管控结束时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date controlEndTime;

    /** 时间戳 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "时间戳", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date sjc;

    /** 处理标志（0：删除
     1：正常） */
    @Excel(name = "处理标志", readConverterExp = "0=：删除 1：正常")
    private String clbz;

    /** 更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "更新时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date updatedTime;

    /** 交换时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "交换时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date exchangeTime;

    /** 生产单元信息 */
    private PsInfoProductInfo psInfoProductInfo;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setPwxkzbh(String pwxkzbh)
    {
        this.pwxkzbh = pwxkzbh;
    }

    public String getPwxkzbh()
    {
        return pwxkzbh;
    }
    public void setProductId(String productId)
    {
        this.productId = productId;
    }

    public String getProductId()
    {
        return productId;
    }
    public void setSuperviseType(String superviseType)
    {
        this.superviseType = superviseType;
    }

    public String getSuperviseType()
    {
        return superviseType;
    }
    public void setLimitproductRate(String limitproductRate)
    {
        this.limitproductRate = limitproductRate;
    }

    public String getLimitproductRate()
    {
        return limitproductRate;
    }
    public void setControlStartTime(Date controlStartTime)
    {
        this.controlStartTime = controlStartTime;
    }

    public Date getControlStartTime()
    {
        return controlStartTime;
    }
    public void setControlEndTime(Date controlEndTime)
    {
        this.controlEndTime = controlEndTime;
    }

    public Date getControlEndTime()
    {
        return controlEndTime;
    }
    public void setSjc(Date sjc)
    {
        this.sjc = sjc;
    }

    public Date getSjc()
    {
        return sjc;
    }
    public void setClbz(String clbz)
    {
        this.clbz = clbz;
    }

    public String getClbz()
    {
        return clbz;
    }
    public void setUpdatedTime(Date updatedTime)
    {
        this.updatedTime = updatedTime;
    }

    public Date getUpdatedTime()
    {
        return updatedTime;
    }
    public void setExchangeTime(Date exchangeTime)
    {
        this.exchangeTime = exchangeTime;
    }

    public Date getExchangeTime()
    {
        return exchangeTime;
    }

    public PsInfoProductInfo getPsInfoProductInfo() {
        return psInfoProductInfo;
    }

    public void setPsInfoProductInfo(PsInfoProductInfo psInfoProductInfo) {
        this.psInfoProductInfo = psInfoProductInfo;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("pwxkzbh", getPwxkzbh())
                .append("productId", getProductId())
                .append("superviseType", getSuperviseType())
                .append("limitproductRate", getLimitproductRate())
                .append("controlStartTime", getControlStartTime())
                .append("controlEndTime", getControlEndTime())
                .append("sjc", getSjc())
                .append("clbz", getClbz())
                .append("updatedTime", getUpdatedTime())
                .append("exchangeTime", getExchangeTime())
                .toString();
    }
}
