package com.px.provincialData.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.px.provincialData.mapper.YqAirBaseInfoMapper;
import com.px.provincialData.domain.YqAirBaseInfo;
import com.px.provincialData.service.IYqAirBaseInfoService;

/**
 * 园区空气质量监测点基本信息Service业务层处理
 *
 * @author 品讯科技
 * @date 2024-08
 */
@Service
public class YqAirBaseInfoServiceImpl implements IYqAirBaseInfoService
{
    @Autowired
    private YqAirBaseInfoMapper yqAirBaseInfoMapper;

    /**
     * 查询园区空气质量监测点基本信息
     *
     * @param id 园区空气质量监测点基本信息主键
     * @return 园区空气质量监测点基本信息
     */
    @Override
    public YqAirBaseInfo selectYqAirBaseInfoById(Long id)
    {
        return yqAirBaseInfoMapper.selectYqAirBaseInfoById(id);
    }

    /**
     * 查询园区空气质量监测点基本信息列表
     *
     * @param yqAirBaseInfo 园区空气质量监测点基本信息
     * @return 园区空气质量监测点基本信息
     */
    @Override
    public List<YqAirBaseInfo> selectYqAirBaseInfoList(YqAirBaseInfo yqAirBaseInfo)
    {
        return yqAirBaseInfoMapper.selectYqAirBaseInfoList(yqAirBaseInfo);
    }

    /**
     * 新增园区空气质量监测点基本信息
     *
     * @param yqAirBaseInfo 园区空气质量监测点基本信息
     * @return 结果
     */
    @Override
    public int insertYqAirBaseInfo(YqAirBaseInfo yqAirBaseInfo)
    {
        return yqAirBaseInfoMapper.insertYqAirBaseInfo(yqAirBaseInfo);
    }

    /**
     * 修改园区空气质量监测点基本信息
     *
     * @param yqAirBaseInfo 园区空气质量监测点基本信息
     * @return 结果
     */
    @Override
    public int updateYqAirBaseInfo(YqAirBaseInfo yqAirBaseInfo)
    {
        return yqAirBaseInfoMapper.updateYqAirBaseInfo(yqAirBaseInfo);
    }

    /**
     * 批量删除园区空气质量监测点基本信息
     *
     * @param ids 需要删除的园区空气质量监测点基本信息主键
     * @return 结果
     */
    @Override
    public int deleteYqAirBaseInfoByIds(Long[] ids)
    {
        return yqAirBaseInfoMapper.deleteYqAirBaseInfoByIds(ids);
    }

    /**
     * 删除园区空气质量监测点基本信息信息
     *
     * @param id 园区空气质量监测点基本信息主键
     * @return 结果
     */
    @Override
    public int deleteYqAirBaseInfoById(Long id)
    {
        return yqAirBaseInfoMapper.deleteYqAirBaseInfoById(id);
    }
}
