package com.px.provincialData.service;

import java.util.List;

import com.px.common.core.domain.AjaxResult;
import com.px.provincialData.domain.BAirOutletInfo;
import com.px.provincialData.domain.dto.BAirOutLetInfoDto;

/**
 * 大气污染物排放口信息Service接口
 *
 * @author 品讯科技
 * @date 2024-08
 */
public interface IBAirOutletInfoService
{
    /**
     * 查询大气污染物排放口信息
     *
     * @param id 大气污染物排放口信息主键
     * @return 大气污染物排放口信息
     */
    public BAirOutletInfo selectBAirOutletInfoById(Long id);

    /**
     * 查询大气污染物排放口信息列表
     *
     * @param bAirOutletInfo 大气污染物排放口信息
     * @return 大气污染物排放口信息集合
     */
    public List<BAirOutletInfo> selectBAirOutletInfoList(BAirOutletInfo bAirOutletInfo);

    /**
     * 新增大气污染物排放口信息
     *
     * @param bAirOutletInfo 大气污染物排放口信息
     * @return 结果
     */
    public int insertBAirOutletInfo(BAirOutletInfo bAirOutletInfo);

    /**
     * 修改大气污染物排放口信息
     *
     * @param bAirOutletInfo 大气污染物排放口信息
     * @return 结果
     */
    public int updateBAirOutletInfo(BAirOutletInfo bAirOutletInfo);

    /**
     * 批量删除大气污染物排放口信息
     *
     * @param ids 需要删除的大气污染物排放口信息主键集合
     * @return 结果
     */
    public int deleteBAirOutletInfoByIds(Long[] ids);

    /**
     * 删除大气污染物排放口信息信息
     *
     * @param id 大气污染物排放口信息主键
     * @return 结果
     */
    public int deleteBAirOutletInfoById(Long id);

    public BAirOutletInfo selectBAirOutletJoinOutletFactorById(Long id);

    public AjaxResult selectBAirOutletInfo(BAirOutLetInfoDto bAirOutLetInfoDto);
}
