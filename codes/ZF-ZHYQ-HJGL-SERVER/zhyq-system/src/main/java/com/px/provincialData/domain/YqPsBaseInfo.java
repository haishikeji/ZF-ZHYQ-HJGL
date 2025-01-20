package com.px.provincialData.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.px.common.annotation.Excel;
import com.px.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 园区及企业基本信息对象 yq_ps_baseinfo
 *
 * @author 品讯科技
 * @date 2024-08
 */
public class YqPsBaseInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 园区唯一主键（yq_baseinfo表的id） */
    @Excel(name = "园区唯一主键", readConverterExp = "y=q_baseinfo表的id")
    private Long yqid;

    /** 排污许可证编号 */
    @Excel(name = "排污许可证编号")
    private String pwxkzbh;

    /** 单位名称 */
    @Excel(name = "单位名称")
    private String dwmc;

    /** 统一社会信用代码 */
    @Excel(name = "统一社会信用代码")
    private String tyshxydm;

    /** 组织机构代码 */
    @Excel(name = "组织机构代码")
    private String zzjgdm;

    /** 营业执照号码 */
    @Excel(name = "营业执照号码")
    private String yyzzhm;

    /** 行业类别、使用国民经济行业分类（GB/T 4754-2011）编码
     最小类别 */
    @Excel(name = "行业类别、使用国民经济行业分类", readConverterExp = "G=B/T,4=754-2011")
    private String hylb;

    /** 生产经营场所地址 */
    @Excel(name = "生产经营场所地址")
    private String scjycsdz;

    /** 经度 */
    @Excel(name = "经度")
    private BigDecimal qyjdzb;

    /** 纬度 */
    @Excel(name = "纬度")
    private BigDecimal qywdzb;

    /** 所在省份区划代码(国家统计局颁布的行政区划代码) */
    @Excel(name = "所在省份区划代码(国家统计局颁布的行政区划代码)")
    private String szsfqhdm;

    /** 所在地市区划代码(国家统计局颁布的行政区划代码) */
    @Excel(name = "所在地市区划代码(国家统计局颁布的行政区划代码)")
    private String szdsqhdm;

    /** 所在区县区划代码(国家统计局颁布的行政区划代码) */
    @Excel(name = "所在区县区划代码(国家统计局颁布的行政区划代码)")
    private String szqxqhdm;

    /** 街道乡镇代码 */
    @Excel(name = "街道乡镇代码")
    private String jdxzdm;

    /** 技术负责人 */
    @Excel(name = "技术负责人")
    private String jsfzr;

    /** 固定电话 */
    @Excel(name = "固定电话")
    private String gddh;

    /** 移动电话 */
    @Excel(name = "移动电话")
    private String yddh;

    /** 许可有效期限起 */
    @Excel(name = "许可有效期限起")
    private String xkyxqxq;

    /** 许可有效期限止 */
    @Excel(name = "许可有效期限止")
    private String xkyxqxz;

    /** 投产日期 */
    @Excel(name = "投产日期")
    private String tcrq;

    /** 是否属于重点区域(1.是、0.否) */
    @Excel(name = "是否属于重点区域(1.是、0.否)")
    private Integer sfsyzdqy;

    /** 重点区域类型(使用重点区域类型字典1.所在地属于大气重点控制区、2.所在地属于总磷控制区、3.所在地属于总氮控制区、4.所在地属于重金属污染特别排放限值实施区域) 如果sfsyzdqy为1则必填 */
    @Excel(name = "重点区域类型(使用重点区域类型字典1.所在地属于大气重点控制区、2.所在地属于总磷控制区、3.所在地属于总氮控制区、4.所在地属于重金属污染特别排放限值实施区域) 如果sfsyzdqy为1则必填")
    private String zdqylx;

    /** 主要污染类别，（存在多项内容的，使用半角‘，’隔开） */
    @Excel(name = "主要污染类别，", readConverterExp = "存=在多项内容的，使用半角‘，’隔开")
    private String zywrwlb;

    /** 核发日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "核发日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date hfrq;

    /** 核发环保机关代码 */
    @Excel(name = "核发环保机关代码")
    private String hfhbjgdm;

    /** 核发环保机关名称 */
    @Excel(name = "核发环保机关名称")
    private String hfhbjgmc;

    /** 数据归属（省） */
    @Excel(name = "数据归属", readConverterExp = "省=")
    private String sjgs;

    /** 数据归属（地市） */
    @Excel(name = "数据归属", readConverterExp = "地=市")
    private String dsgs;

    /** 数据归属（区县） */
    @Excel(name = "数据归属", readConverterExp = "区=县")
    private String qxgs;

    /** 申请类型（1.新增、2.补发、3.变更、4.延续转发、5.注销、6.撤销） */
    @Excel(name = "申请类型", readConverterExp = "1=.新增、2.补发、3.变更、4.延续转发、5.注销、6.撤销")
    private Integer sqlx;

    /** 时间戳 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "时间戳", width = 30, dateFormat = "yyyy-MM-dd")
    private Date sjc;

    /** 处理标志0：删除，1正常 */
    @Excel(name = "处理标志0：删除，1正常")
    private String clbz;

    /** 更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "更新时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date updatedTime;

    /** 交换时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "交换时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date exchangeTime;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setYqid(Long yqid)
    {
        this.yqid = yqid;
    }

    public Long getYqid()
    {
        return yqid;
    }
    public void setPwxkzbh(String pwxkzbh)
    {
        this.pwxkzbh = pwxkzbh;
    }

    public String getPwxkzbh()
    {
        return pwxkzbh;
    }
    public void setDwmc(String dwmc)
    {
        this.dwmc = dwmc;
    }

    public String getDwmc()
    {
        return dwmc;
    }
    public void setTyshxydm(String tyshxydm)
    {
        this.tyshxydm = tyshxydm;
    }

    public String getTyshxydm()
    {
        return tyshxydm;
    }
    public void setZzjgdm(String zzjgdm)
    {
        this.zzjgdm = zzjgdm;
    }

    public String getZzjgdm()
    {
        return zzjgdm;
    }
    public void setYyzzhm(String yyzzhm)
    {
        this.yyzzhm = yyzzhm;
    }

    public String getYyzzhm()
    {
        return yyzzhm;
    }
    public void setHylb(String hylb)
    {
        this.hylb = hylb;
    }

    public String getHylb()
    {
        return hylb;
    }
    public void setScjycsdz(String scjycsdz)
    {
        this.scjycsdz = scjycsdz;
    }

    public String getScjycsdz()
    {
        return scjycsdz;
    }
    public void setQyjdzb(BigDecimal qyjdzb)
    {
        this.qyjdzb = qyjdzb;
    }

    public BigDecimal getQyjdzb()
    {
        return qyjdzb;
    }
    public void setQywdzb(BigDecimal qywdzb)
    {
        this.qywdzb = qywdzb;
    }

    public BigDecimal getQywdzb()
    {
        return qywdzb;
    }
    public void setSzsfqhdm(String szsfqhdm)
    {
        this.szsfqhdm = szsfqhdm;
    }

    public String getSzsfqhdm()
    {
        return szsfqhdm;
    }
    public void setSzdsqhdm(String szdsqhdm)
    {
        this.szdsqhdm = szdsqhdm;
    }

    public String getSzdsqhdm()
    {
        return szdsqhdm;
    }
    public void setSzqxqhdm(String szqxqhdm)
    {
        this.szqxqhdm = szqxqhdm;
    }

    public String getSzqxqhdm()
    {
        return szqxqhdm;
    }
    public void setJdxzdm(String jdxzdm)
    {
        this.jdxzdm = jdxzdm;
    }

    public String getJdxzdm()
    {
        return jdxzdm;
    }
    public void setJsfzr(String jsfzr)
    {
        this.jsfzr = jsfzr;
    }

    public String getJsfzr()
    {
        return jsfzr;
    }
    public void setGddh(String gddh)
    {
        this.gddh = gddh;
    }

    public String getGddh()
    {
        return gddh;
    }
    public void setYddh(String yddh)
    {
        this.yddh = yddh;
    }

    public String getYddh()
    {
        return yddh;
    }
    public void setXkyxqxq(String xkyxqxq)
    {
        this.xkyxqxq = xkyxqxq;
    }

    public String getXkyxqxq()
    {
        return xkyxqxq;
    }
    public void setXkyxqxz(String xkyxqxz)
    {
        this.xkyxqxz = xkyxqxz;
    }

    public String getXkyxqxz()
    {
        return xkyxqxz;
    }
    public void setTcrq(String tcrq)
    {
        this.tcrq = tcrq;
    }

    public String getTcrq()
    {
        return tcrq;
    }
    public void setSfsyzdqy(Integer sfsyzdqy)
    {
        this.sfsyzdqy = sfsyzdqy;
    }

    public Integer getSfsyzdqy()
    {
        return sfsyzdqy;
    }
    public void setZdqylx(String zdqylx)
    {
        this.zdqylx = zdqylx;
    }

    public String getZdqylx()
    {
        return zdqylx;
    }
    public void setZywrwlb(String zywrwlb)
    {
        this.zywrwlb = zywrwlb;
    }

    public String getZywrwlb()
    {
        return zywrwlb;
    }
    public void setHfrq(Date hfrq)
    {
        this.hfrq = hfrq;
    }

    public Date getHfrq()
    {
        return hfrq;
    }
    public void setHfhbjgdm(String hfhbjgdm)
    {
        this.hfhbjgdm = hfhbjgdm;
    }

    public String getHfhbjgdm()
    {
        return hfhbjgdm;
    }
    public void setHfhbjgmc(String hfhbjgmc)
    {
        this.hfhbjgmc = hfhbjgmc;
    }

    public String getHfhbjgmc()
    {
        return hfhbjgmc;
    }
    public void setSjgs(String sjgs)
    {
        this.sjgs = sjgs;
    }

    public String getSjgs()
    {
        return sjgs;
    }
    public void setDsgs(String dsgs)
    {
        this.dsgs = dsgs;
    }

    public String getDsgs()
    {
        return dsgs;
    }
    public void setQxgs(String qxgs)
    {
        this.qxgs = qxgs;
    }

    public String getQxgs()
    {
        return qxgs;
    }
    public void setSqlx(Integer sqlx)
    {
        this.sqlx = sqlx;
    }

    public Integer getSqlx()
    {
        return sqlx;
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

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("yqid", getYqid())
                .append("pwxkzbh", getPwxkzbh())
                .append("dwmc", getDwmc())
                .append("tyshxydm", getTyshxydm())
                .append("zzjgdm", getZzjgdm())
                .append("yyzzhm", getYyzzhm())
                .append("hylb", getHylb())
                .append("scjycsdz", getScjycsdz())
                .append("qyjdzb", getQyjdzb())
                .append("qywdzb", getQywdzb())
                .append("szsfqhdm", getSzsfqhdm())
                .append("szdsqhdm", getSzdsqhdm())
                .append("szqxqhdm", getSzqxqhdm())
                .append("jdxzdm", getJdxzdm())
                .append("jsfzr", getJsfzr())
                .append("gddh", getGddh())
                .append("yddh", getYddh())
                .append("xkyxqxq", getXkyxqxq())
                .append("xkyxqxz", getXkyxqxz())
                .append("tcrq", getTcrq())
                .append("sfsyzdqy", getSfsyzdqy())
                .append("zdqylx", getZdqylx())
                .append("zywrwlb", getZywrwlb())
                .append("hfrq", getHfrq())
                .append("hfhbjgdm", getHfhbjgdm())
                .append("hfhbjgmc", getHfhbjgmc())
                .append("sjgs", getSjgs())
                .append("dsgs", getDsgs())
                .append("qxgs", getQxgs())
                .append("sqlx", getSqlx())
                .append("sjc", getSjc())
                .append("clbz", getClbz())
                .append("updatedTime", getUpdatedTime())
                .append("exchangeTime", getExchangeTime())
                .toString();
    }
}
