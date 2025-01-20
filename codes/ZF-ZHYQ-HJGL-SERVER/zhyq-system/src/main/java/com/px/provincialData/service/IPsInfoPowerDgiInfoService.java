package com.px.provincialData.service;

import java.util.List;

import com.px.provincialData.domain.PsInfoPowerDgiInfo;

/**
 * 数采仪信息Service接口
 *
 * @author 品讯科技
 * @date 2024-08
 */
public interface IPsInfoPowerDgiInfoService
{
    /**
     * 查询数采仪信息
     *
     * @param id 数采仪信息主键
     * @return 数采仪信息
     */
    public PsInfoPowerDgiInfo selectPsInfoPowerDgiInfoById(Long id);

    /**
     * 查询数采仪信息列表
     *
     * @param psInfoPowerDgiInfo 数采仪信息
     * @return 数采仪信息集合
     */
    public List<PsInfoPowerDgiInfo> selectPsInfoPowerDgiInfoList(PsInfoPowerDgiInfo psInfoPowerDgiInfo);

    /**
     * 新增数采仪信息
     *
     * @param psInfoPowerDgiInfo 数采仪信息
     * @return 结果
     */
    public int insertPsInfoPowerDgiInfo(PsInfoPowerDgiInfo psInfoPowerDgiInfo);

    /**
     * 修改数采仪信息
     *
     * @param psInfoPowerDgiInfo 数采仪信息
     * @return 结果
     */
    public int updatePsInfoPowerDgiInfo(PsInfoPowerDgiInfo psInfoPowerDgiInfo);

    /**
     * 批量删除数采仪信息
     *
     * @param ids 需要删除的数采仪信息主键集合
     * @return 结果
     */
    public int deletePsInfoPowerDgiInfoByIds(Long[] ids);

    /**
     * 删除数采仪信息信息
     *
     * @param id 数采仪信息主键
     * @return 结果
     */
    public int deletePsInfoPowerDgiInfoById(Long id);
}

