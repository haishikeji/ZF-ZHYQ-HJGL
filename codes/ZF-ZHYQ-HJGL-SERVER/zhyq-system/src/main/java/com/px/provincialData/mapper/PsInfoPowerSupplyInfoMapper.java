package com.px.provincialData.mapper;

import java.util.List;
import com.px.provincialData.domain.PsInfoPowerSupplyInfo;

/**
 * 供电线路信息Mapper接口
 *
 * @author 品讯科技
 * @date 2024-08
 */
public interface PsInfoPowerSupplyInfoMapper
{
    /**
     * 查询供电线路信息
     *
     * @param id 供电线路信息主键
     * @return 供电线路信息
     */
    public PsInfoPowerSupplyInfo selectPsInfoPowerSupplyInfoById(Long id);

    /**
     * 查询供电线路信息列表
     *
     * @param psInfoPowerSupplyInfo 供电线路信息
     * @return 供电线路信息集合
     */
    public List<PsInfoPowerSupplyInfo> selectPsInfoPowerSupplyInfoList(PsInfoPowerSupplyInfo psInfoPowerSupplyInfo);

    /**
     * 新增供电线路信息
     *
     * @param psInfoPowerSupplyInfo 供电线路信息
     * @return 结果
     */
    public int insertPsInfoPowerSupplyInfo(PsInfoPowerSupplyInfo psInfoPowerSupplyInfo);

    /**
     * 修改供电线路信息
     *
     * @param psInfoPowerSupplyInfo 供电线路信息
     * @return 结果
     */
    public int updatePsInfoPowerSupplyInfo(PsInfoPowerSupplyInfo psInfoPowerSupplyInfo);

    /**
     * 删除供电线路信息
     *
     * @param id 供电线路信息主键
     * @return 结果
     */
    public int deletePsInfoPowerSupplyInfoById(Long id);

    /**
     * 批量删除供电线路信息
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePsInfoPowerSupplyInfoByIds(Long[] ids);
}
