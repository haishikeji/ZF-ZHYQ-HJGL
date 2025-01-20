package com.px.biz.service.impl;

import com.px.biz.domain.BSewageOutletMetiscRecords;
import com.px.biz.mapper.BSewageOutletMetiscRecordsMapper;
import com.px.biz.service.IBSewageOutletMetricsRecordsService;
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
public class BSewageOutletMetricsRecordsServiceImpl implements IBSewageOutletMetricsRecordsService
{
    @Autowired
    private BSewageOutletMetiscRecordsMapper bSewageOutletMetiscRecordsMapper;

    /**
     * 查询数据实时明细列表
     *
     * @param bSewageOutletMetiscRecords 数据实时明细
     * @return 数据实时明细
     */
    @Override
    public List<BSewageOutletMetiscRecords> selectBSewageOutletMetricsRecordsList(BSewageOutletMetiscRecords bSewageOutletMetiscRecords)
    {
        return bSewageOutletMetiscRecordsMapper.selectBSewageOutletMetricsRecordsList(bSewageOutletMetiscRecords);
    }
}
