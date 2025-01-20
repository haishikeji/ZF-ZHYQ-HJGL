package com.px.base.service;

import java.util.List;
import com.px.base.domain.BNoiseFacilityInfo;

/**
 * 在线噪声设施信息Service接口
 *
 * @author 品讯科技
 * @date 2024-08
 */
public interface IBNoiseFacilityInfoService
{
    /**
     * 查询在线噪声设施信息
     *
     * @param id 在线噪声设施信息主键
     * @return 在线噪声设施信息
     */
    public BNoiseFacilityInfo selectBNoiseFacilityInfoById(Long id);

    /**
     * 查询在线噪声设施信息列表
     *
     * @param bNoiseFacilityInfo 在线噪声设施信息
     * @return 在线噪声设施信息集合
     */
    public List<BNoiseFacilityInfo> selectBNoiseFacilityInfoList(BNoiseFacilityInfo bNoiseFacilityInfo);

    /**
     * 新增在线噪声设施信息
     *
     * @param bNoiseFacilityInfo 在线噪声设施信息
     * @return 结果
     */
    public int insertBNoiseFacilityInfo(BNoiseFacilityInfo bNoiseFacilityInfo);

    /**
     * 修改在线噪声设施信息
     *
     * @param bNoiseFacilityInfo 在线噪声设施信息
     * @return 结果
     */
    public int updateBNoiseFacilityInfo(BNoiseFacilityInfo bNoiseFacilityInfo);

    /**
     * 批量删除在线噪声设施信息
     *
     * @param ids 需要删除的在线噪声设施信息主键集合
     * @return 结果
     */
    public int deleteBNoiseFacilityInfoByIds(Long[] ids);

    /**
     * 删除在线噪声设施信息信息
     *
     * @param id 在线噪声设施信息主键
     * @return 结果
     */
    public int deleteBNoiseFacilityInfoById(Long id);

    public List<BNoiseFacilityInfo> selectBNoiseFacilityInfoExport(BNoiseFacilityInfo bNoiseFacilityInfo);
}
