package com.px.emergencyManagement.service.impl;

import java.util.List;
import com.px.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.px.emergencyManagement.mapper.BRiskSourceInfoMapper;
import com.px.emergencyManagement.domain.BRiskSourceInfo;
import com.px.emergencyManagement.service.IBRiskSourceInfoService;

/**
 * 环境风险源信息Service业务层处理
 *
 * @author 品讯科技
 * @date 2024-08
 */
@Service
public class BRiskSourceInfoServiceImpl implements IBRiskSourceInfoService
{
    @Autowired
    private BRiskSourceInfoMapper bRiskSourceInfoMapper;

    /**
     * 查询环境风险源信息
     *
     * @param id 环境风险源信息主键
     * @return 环境风险源信息
     */
    @Override
    public BRiskSourceInfo selectBRiskSourceInfoById(Long id)
    {
        return bRiskSourceInfoMapper.selectBRiskSourceInfoById(id);
    }

    /**
     * 查询环境风险源信息列表
     *
     * @param bRiskSourceInfo 环境风险源信息
     * @return 环境风险源信息
     */
    @Override
    public List<BRiskSourceInfo> selectBRiskSourceInfoList(BRiskSourceInfo bRiskSourceInfo)
    {
        return bRiskSourceInfoMapper.selectBRiskSourceInfoList(bRiskSourceInfo);
    }

    /**
     * 新增环境风险源信息
     *
     * @param bRiskSourceInfo 环境风险源信息
     * @return 结果
     */
    @Override
    public int insertBRiskSourceInfo(BRiskSourceInfo bRiskSourceInfo)
    {
        bRiskSourceInfo.setCreateTime(DateUtils.getNowDate());
        return bRiskSourceInfoMapper.insertBRiskSourceInfo(bRiskSourceInfo);
    }

    /**
     * 修改环境风险源信息
     *
     * @param bRiskSourceInfo 环境风险源信息
     * @return 结果
     */
    @Override
    public int updateBRiskSourceInfo(BRiskSourceInfo bRiskSourceInfo)
    {
        bRiskSourceInfo.setUpdateTime(DateUtils.getNowDate());
        return bRiskSourceInfoMapper.updateBRiskSourceInfo(bRiskSourceInfo);
    }

    /**
     * 批量删除环境风险源信息
     *
     * @param ids 需要删除的环境风险源信息主键
     * @return 结果
     */
    @Override
    public int deleteBRiskSourceInfoByIds(Long[] ids)
    {
        return bRiskSourceInfoMapper.deleteBRiskSourceInfoByIds(ids);
    }

    /**
     * 删除环境风险源信息信息
     *
     * @param id 环境风险源信息主键
     * @return 结果
     */
    @Override
    public int deleteBRiskSourceInfoById(Long id)
    {
        return bRiskSourceInfoMapper.deleteBRiskSourceInfoById(id);
    }

    @Override
    public int logicDelBRiskSourceInfoByIds(Long[] ids) {
        return bRiskSourceInfoMapper.logicDelBRiskSourceInfoByIds(ids);
    }

    @Override
    public List<BRiskSourceInfo> selectBRiskSourceInfoJoinEnterpriseList(BRiskSourceInfo bRiskSourceInfo) {
        return bRiskSourceInfoMapper.selectBRiskSourceInfoJoinEnterpriseList(bRiskSourceInfo);
    }
}
