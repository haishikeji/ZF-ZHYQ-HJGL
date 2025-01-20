package com.px.biz.service.impl;

import com.px.biz.domain.BMicrostationMetricsRecords;
import com.px.biz.mapper.BMicrostationMetricsRecordsMapper;
import com.px.biz.service.IBMicrostationMetricsRecordsService;
import com.px.common.annotation.DataSource;
import com.px.common.enums.DataSourceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 数据实时明细Service业务层处理
 *
 * @author 品讯科技
 * @date 2024-08
 */
@Service
@DataSource(value = DataSourceType.SLAVE)
public class BMicrostationMetricsRecordsServiceImpl implements IBMicrostationMetricsRecordsService
{
    @Autowired
    private BMicrostationMetricsRecordsMapper bMicrostationMetricsRecordsMapper;

    /**
     * 查询数据实时明细列表
     *
     * @param bMicrostationMetricsRecords 数据实时明细
     * @return 数据实时明细
     */
    @Override
    public List<BMicrostationMetricsRecords> selectBMicrostationMetricsRecordsList(BMicrostationMetricsRecords bMicrostationMetricsRecords)
    {
        return bMicrostationMetricsRecordsMapper.selectBMicrostationMetricsRecordsList(bMicrostationMetricsRecords);
    }
}
