package com.px.biz.service;

import com.px.biz.domain.BElectricMetiscYqInfo;
import com.px.biz.domain.dto.BElectricMetiscYqInfoRequestDTO;

import java.util.List;

/**
 * 园区用电点监测Service接口
 */
public interface IBElectricMetiscYqInfoService {
    /**
     * 查看园区用电年数据
     */
    public List<BElectricMetiscYqInfo> selectAnnualData(BElectricMetiscYqInfo bElectricMetiscYqInfo);
    /**
     * 查看园区用电月数据
     */
    public List<BElectricMetiscYqInfo> selectMonthlyData(BElectricMetiscYqInfo bElectricMetiscYqInfo);
    /**
     * 查询园区用电实时数据
     * @param bElectricMetiscYqInfo 园区用电信息
     * @return 园区用电信息集合
     */
    List<BElectricMetiscYqInfo> selectBElectricMetiscYqInfoList(BElectricMetiscYqInfo bElectricMetiscYqInfo);

    /**
     * 根据时间区间查询不同时间下园区用电数据
     * @param bElectricMetiscYqInfoRequestDTO 园区用电基本信息
     * @return 不同时间区间用电数据
     */
    List<BElectricMetiscYqInfo> selectBElectricMetiscYqInfoListByTimeDimension(BElectricMetiscYqInfoRequestDTO bElectricMetiscYqInfoRequestDTO);

    public int insertBElectricMetiscYQ(BElectricMetiscYqInfo bElectricMetiscYqInfo);
}
