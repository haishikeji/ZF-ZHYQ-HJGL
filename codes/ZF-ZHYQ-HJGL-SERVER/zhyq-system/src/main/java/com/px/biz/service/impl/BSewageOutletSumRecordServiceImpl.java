package com.px.biz.service.impl;

import java.util.List;

import com.px.biz.domain.BSewageOutletMetiscEnterpriseInfo;
import com.px.common.annotation.DataSource;
import com.px.common.enums.DataSourceType;
import com.px.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.px.biz.mapper.BSewageOutletSumRecordMapper;
import com.px.biz.domain.BSewageOutletSumRecord;
import com.px.biz.service.IBSewageOutletSumRecordService;

/**
 * 所有排口累积日统计记录Service业务层处理
 *
 * @author 品讯科技
 * @date 2024-08
 */
@Service
@DataSource(value = DataSourceType.SLAVE)
public class BSewageOutletSumRecordServiceImpl implements IBSewageOutletSumRecordService
{
    @Autowired
    private BSewageOutletSumRecordMapper bSewageOutletSumRecordMapper;

    /**
     * 查询所有排口累积日统计记录
     *
     * @param id 所有排口累积日统计记录主键
     * @return 所有排口累积日统计记录
     */
    @Override
    public BSewageOutletSumRecord selectBSewageOutletSumRecordById(Long id)
    {
        return bSewageOutletSumRecordMapper.selectBSewageOutletSumRecordById(id);
    }

    /**
     * 查询所有排口累积日统计记录列表
     *
     * @param bSewageOutletSumRecord 所有排口累积日统计记录
     * @return 所有排口累积日统计记录
     */
    @Override
    public List<BSewageOutletSumRecord> selectBSewageOutletSumRecordList(BSewageOutletSumRecord bSewageOutletSumRecord)
    {
        return bSewageOutletSumRecordMapper.selectBSewageOutletSumRecordList(bSewageOutletSumRecord);
    }

    /**
     * 新增所有排口累积日统计记录
     *
     * @param bSewageOutletSumRecord 所有排口累积日统计记录
     * @return 结果
     */
    @Override
    public int insertBSewageOutletSumRecord(BSewageOutletSumRecord bSewageOutletSumRecord)
    {
        bSewageOutletSumRecord.setCreateTime(DateUtils.getNowDate());
        return bSewageOutletSumRecordMapper.insertBSewageOutletSumRecord(bSewageOutletSumRecord);
    }

    /**
     * 修改所有排口累积日统计记录
     *
     * @param bSewageOutletSumRecord 所有排口累积日统计记录
     * @return 结果
     */
    @Override
    public int updateBSewageOutletSumRecord(BSewageOutletSumRecord bSewageOutletSumRecord)
    {
        return bSewageOutletSumRecordMapper.updateBSewageOutletSumRecord(bSewageOutletSumRecord);
    }

    /**
     * 批量删除所有排口累积日统计记录
     *
     * @param ids 需要删除的所有排口累积日统计记录主键
     * @return 结果
     */
    @Override
    public int deleteBSewageOutletSumRecordByIds(Long[] ids)
    {
        return bSewageOutletSumRecordMapper.deleteBSewageOutletSumRecordByIds(ids);
    }

    /**
     * 删除所有排口累积日统计记录信息
     *
     * @param id 所有排口累积日统计记录主键
     * @return 结果
     */
    @Override
    public int deleteBSewageOutletSumRecordById(Long id)
    {
        return bSewageOutletSumRecordMapper.deleteBSewageOutletSumRecordById(id);
    }

    /**
     * 获取企业排污口实时数据
     * @param bWaterOutletInfo
     * @return
     */
    @Override
    public List<BSewageOutletMetiscEnterpriseInfo> selectBSewageOutletMetiscList(BSewageOutletMetiscEnterpriseInfo bWaterOutletInfo,String recordedAt) {
        return bSewageOutletSumRecordMapper.selectBSewageOutletMetiscList(bWaterOutletInfo,recordedAt);
    }

    /**
     * 数据表是否在数据库中存在
     * @param tableName
     * @return
     */
    @Override
    public boolean isTableExist(String tableName) {
        return bSewageOutletSumRecordMapper.isTableExist(tableName);
    }

    /**
     * 获取污水总量
     * @return
     */
    @Override
    public Double selectSewageOutletSumRecordAll() {
        //TODO 没数据会报错，有数据可以解开 return (double)Math.round(bSewageOutletSumRecordMapper.selectSewageOutletSumRecordAll());
        return new Double(0);
    }
}
