package com.px.emergencyManagement.service.impl;

import java.util.List;
import com.px.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.px.emergencyManagement.mapper.BEmergencySuppliesInfoMapper;
import com.px.emergencyManagement.domain.BEmergencySuppliesInfo;
import com.px.emergencyManagement.service.IBEmergencySuppliesInfoService;

/**
 * 应急物资信息Service业务层处理
 *
 * @author 品讯科技
 * @date 2024-08
 */
@Service
public class BEmergencySuppliesInfoServiceImpl implements IBEmergencySuppliesInfoService
{
    @Autowired
    private BEmergencySuppliesInfoMapper bEmergencySuppliesInfoMapper;

    /**
     * 查询应急物资信息
     *
     * @param id 应急物资信息主键
     * @return 应急物资信息
     */
    @Override
    public BEmergencySuppliesInfo selectBEmergencySuppliesInfoById(Long id)
    {
        return bEmergencySuppliesInfoMapper.selectBEmergencySuppliesInfoById(id);
    }

    /**
     * 查询应急物资信息列表
     *
     * @param bEmergencySuppliesInfo 应急物资信息
     * @return 应急物资信息
     */
    @Override
    public List<BEmergencySuppliesInfo> selectBEmergencySuppliesInfoList(BEmergencySuppliesInfo bEmergencySuppliesInfo)
    {
        return bEmergencySuppliesInfoMapper.selectBEmergencySuppliesInfoList(bEmergencySuppliesInfo);
    }

    /**
     * 新增应急物资信息
     *
     * @param bEmergencySuppliesInfo 应急物资信息
     * @return 结果
     */
    @Override
    public int insertBEmergencySuppliesInfo(BEmergencySuppliesInfo bEmergencySuppliesInfo)
    {
        bEmergencySuppliesInfo.setCreateTime(DateUtils.getNowDate());
        return bEmergencySuppliesInfoMapper.insertBEmergencySuppliesInfo(bEmergencySuppliesInfo);
    }

    /**
     * 修改应急物资信息
     *
     * @param bEmergencySuppliesInfo 应急物资信息
     * @return 结果
     */
    @Override
    public int updateBEmergencySuppliesInfo(BEmergencySuppliesInfo bEmergencySuppliesInfo)
    {
        bEmergencySuppliesInfo.setUpdateTime(DateUtils.getNowDate());
        return bEmergencySuppliesInfoMapper.updateBEmergencySuppliesInfo(bEmergencySuppliesInfo);
    }

    /**
     * 批量删除应急物资信息
     *
     * @param ids 需要删除的应急物资信息主键
     * @return 结果
     */
    @Override
    public int deleteBEmergencySuppliesInfoByIds(Long[] ids)
    {
        return bEmergencySuppliesInfoMapper.deleteBEmergencySuppliesInfoByIds(ids);
    }

    /**
     * 删除应急物资信息信息
     *
     * @param id 应急物资信息主键
     * @return 结果
     */
    @Override
    public int deleteBEmergencySuppliesInfoById(Long id)
    {
        return bEmergencySuppliesInfoMapper.deleteBEmergencySuppliesInfoById(id);
    }

    @Override
    public int logicDelBEmergencySuppliesInfoByIds(Long[] ids) {
        return bEmergencySuppliesInfoMapper.logicDelBEmergencySuppliesInfoByIds(ids);
    }

    @Override
    public List<BEmergencySuppliesInfo> selectBEmergencySuppliesInfoExport(BEmergencySuppliesInfo bEmergencySuppliesInfo) {
        return bEmergencySuppliesInfoMapper.selectBEmergencySuppliesInfoExport(bEmergencySuppliesInfo);
    }
}
