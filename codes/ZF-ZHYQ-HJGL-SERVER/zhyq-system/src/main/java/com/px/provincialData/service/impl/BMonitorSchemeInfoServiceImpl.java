package com.px.provincialData.service.impl;

import java.util.List;
import com.px.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.px.provincialData.mapper.BMonitorSchemeInfoMapper;
import com.px.provincialData.domain.BMonitorSchemeInfo;
import com.px.provincialData.service.IBMonitorSchemeInfoService;

/**
 * 排污单位自行监测方案Service业务层处理
 *
 * @author 品讯科技
 * @date 2024-08
 */
@Service
public class BMonitorSchemeInfoServiceImpl implements IBMonitorSchemeInfoService
{
    @Autowired
    private BMonitorSchemeInfoMapper bMonitorSchemeInfoMapper;

    /**
     * 查询排污单位自行监测方案
     *
     * @param id 排污单位自行监测方案主键
     * @return 排污单位自行监测方案
     */
    @Override
    public BMonitorSchemeInfo selectBMonitorSchemeInfoById(Long id)
    {
        return bMonitorSchemeInfoMapper.selectBMonitorSchemeInfoById(id);
    }

    /**
     * 查询排污单位自行监测方案列表
     *
     * @param bMonitorSchemeInfo 排污单位自行监测方案
     * @return 排污单位自行监测方案
     */
    @Override
    public List<BMonitorSchemeInfo> selectBMonitorSchemeInfoList(BMonitorSchemeInfo bMonitorSchemeInfo)
    {
        return bMonitorSchemeInfoMapper.selectBMonitorSchemeInfoList(bMonitorSchemeInfo);
    }

    /**
     * 新增排污单位自行监测方案
     *
     * @param bMonitorSchemeInfo 排污单位自行监测方案
     * @return 结果
     */
    @Override
    public int insertBMonitorSchemeInfo(BMonitorSchemeInfo bMonitorSchemeInfo)
    {
        bMonitorSchemeInfo.setCreateTime(DateUtils.getNowDate());
        return bMonitorSchemeInfoMapper.insertBMonitorSchemeInfo(bMonitorSchemeInfo);
    }

    /**
     * 修改排污单位自行监测方案
     *
     * @param bMonitorSchemeInfo 排污单位自行监测方案
     * @return 结果
     */
    @Override
    public int updateBMonitorSchemeInfo(BMonitorSchemeInfo bMonitorSchemeInfo)
    {
        bMonitorSchemeInfo.setUpdateTime(DateUtils.getNowDate());
        return bMonitorSchemeInfoMapper.updateBMonitorSchemeInfo(bMonitorSchemeInfo);
    }

    /**
     * 批量删除排污单位自行监测方案
     *
     * @param ids 需要删除的排污单位自行监测方案主键
     * @return 结果
     */
    @Override
    public int deleteBMonitorSchemeInfoByIds(Long[] ids)
    {
        return bMonitorSchemeInfoMapper.deleteBMonitorSchemeInfoByIds(ids);
    }

    /**
     * 删除排污单位自行监测方案信息
     *
     * @param id 排污单位自行监测方案主键
     * @return 结果
     */
    @Override
    public int deleteBMonitorSchemeInfoById(Long id)
    {
        return bMonitorSchemeInfoMapper.deleteBMonitorSchemeInfoById(id);
    }
}
