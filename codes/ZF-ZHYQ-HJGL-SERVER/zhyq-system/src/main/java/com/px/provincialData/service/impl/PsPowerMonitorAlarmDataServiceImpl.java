package com.px.provincialData.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.px.provincialData.mapper.PsPowerMonitorAlarmDataMapper;
import com.px.provincialData.domain.PsPowerMonitorAlarmData;
import com.px.provincialData.service.IPsPowerMonitorAlarmDataService;

/**
 * 企业用电监测报警Service业务层处理
 *
 * @author 品讯科技
 * @date 2024-08
 */
@Service
public class PsPowerMonitorAlarmDataServiceImpl implements IPsPowerMonitorAlarmDataService
{
    @Autowired
    private PsPowerMonitorAlarmDataMapper psPowerMonitorAlarmDataMapper;

    /**
     * 查询企业用电监测报警
     *
     * @param id 企业用电监测报警主键
     * @return 企业用电监测报警
     */
    @Override
    public PsPowerMonitorAlarmData selectPsPowerMonitorAlarmDataById(Long id)
    {
        return psPowerMonitorAlarmDataMapper.selectPsPowerMonitorAlarmDataById(id);
    }

    /**
     * 查询企业用电监测报警列表
     *
     * @param psPowerMonitorAlarmData 企业用电监测报警
     * @return 企业用电监测报警
     */
    @Override
    public List<PsPowerMonitorAlarmData> selectPsPowerMonitorAlarmDataList(PsPowerMonitorAlarmData psPowerMonitorAlarmData)
    {
        return psPowerMonitorAlarmDataMapper.selectPsPowerMonitorAlarmDataList(psPowerMonitorAlarmData);
    }

    /**
     * 新增企业用电监测报警
     *
     * @param psPowerMonitorAlarmData 企业用电监测报警
     * @return 结果
     */
    @Override
    public int insertPsPowerMonitorAlarmData(PsPowerMonitorAlarmData psPowerMonitorAlarmData)
    {
        return psPowerMonitorAlarmDataMapper.insertPsPowerMonitorAlarmData(psPowerMonitorAlarmData);
    }

    /**
     * 修改企业用电监测报警
     *
     * @param psPowerMonitorAlarmData 企业用电监测报警
     * @return 结果
     */
    @Override
    public int updatePsPowerMonitorAlarmData(PsPowerMonitorAlarmData psPowerMonitorAlarmData)
    {
        return psPowerMonitorAlarmDataMapper.updatePsPowerMonitorAlarmData(psPowerMonitorAlarmData);
    }

    /**
     * 批量删除企业用电监测报警
     *
     * @param ids 需要删除的企业用电监测报警主键
     * @return 结果
     */
    @Override
    public int deletePsPowerMonitorAlarmDataByIds(Long[] ids)
    {
        return psPowerMonitorAlarmDataMapper.deletePsPowerMonitorAlarmDataByIds(ids);
    }

    /**
     * 删除企业用电监测报警信息
     *
     * @param id 企业用电监测报警主键
     * @return 结果
     */
    @Override
    public int deletePsPowerMonitorAlarmDataById(Long id)
    {
        return psPowerMonitorAlarmDataMapper.deletePsPowerMonitorAlarmDataById(id);
    }
}
