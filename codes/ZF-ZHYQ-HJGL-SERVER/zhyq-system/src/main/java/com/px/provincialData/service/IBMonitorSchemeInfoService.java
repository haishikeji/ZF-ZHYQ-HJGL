package com.px.provincialData.service;

import java.util.List;
import com.px.provincialData.domain.BMonitorSchemeInfo;

/**
 * 排污单位自行监测方案Service接口
 *
 * @author 品讯科技
 * @date 2024-08
 */
public interface IBMonitorSchemeInfoService
{
    /**
     * 查询排污单位自行监测方案
     *
     * @param id 排污单位自行监测方案主键
     * @return 排污单位自行监测方案
     */
    public BMonitorSchemeInfo selectBMonitorSchemeInfoById(Long id);

    /**
     * 查询排污单位自行监测方案列表
     *
     * @param bMonitorSchemeInfo 排污单位自行监测方案
     * @return 排污单位自行监测方案集合
     */
    public List<BMonitorSchemeInfo> selectBMonitorSchemeInfoList(BMonitorSchemeInfo bMonitorSchemeInfo);

    /**
     * 新增排污单位自行监测方案
     *
     * @param bMonitorSchemeInfo 排污单位自行监测方案
     * @return 结果
     */
    public int insertBMonitorSchemeInfo(BMonitorSchemeInfo bMonitorSchemeInfo);

    /**
     * 修改排污单位自行监测方案
     *
     * @param bMonitorSchemeInfo 排污单位自行监测方案
     * @return 结果
     */
    public int updateBMonitorSchemeInfo(BMonitorSchemeInfo bMonitorSchemeInfo);

    /**
     * 批量删除排污单位自行监测方案
     *
     * @param ids 需要删除的排污单位自行监测方案主键集合
     * @return 结果
     */
    public int deleteBMonitorSchemeInfoByIds(Long[] ids);

    /**
     * 删除排污单位自行监测方案信息
     *
     * @param id 排污单位自行监测方案主键
     * @return 结果
     */
    public int deleteBMonitorSchemeInfoById(Long id);
}
