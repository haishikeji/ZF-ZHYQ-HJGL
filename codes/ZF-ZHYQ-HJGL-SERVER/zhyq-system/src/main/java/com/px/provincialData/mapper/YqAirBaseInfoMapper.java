package com.px.provincialData.mapper;

import java.util.List;
import com.px.provincialData.domain.YqAirBaseInfo;

/**
 * 园区空气质量监测点基本信息Mapper接口
 *
 * @author 品讯科技
 * @date 2024-08
 */
public interface YqAirBaseInfoMapper
{
    /**
     * 查询园区空气质量监测点基本信息
     *
     * @param id 园区空气质量监测点基本信息主键
     * @return 园区空气质量监测点基本信息
     */
    public YqAirBaseInfo selectYqAirBaseInfoById(Long id);

    /**
     * 查询园区空气质量监测点基本信息列表
     *
     * @param yqAirBaseInfo 园区空气质量监测点基本信息
     * @return 园区空气质量监测点基本信息集合
     */
    public List<YqAirBaseInfo> selectYqAirBaseInfoList(YqAirBaseInfo yqAirBaseInfo);

    /**
     * 新增园区空气质量监测点基本信息
     *
     * @param yqAirBaseInfo 园区空气质量监测点基本信息
     * @return 结果
     */
    public int insertYqAirBaseInfo(YqAirBaseInfo yqAirBaseInfo);

    /**
     * 修改园区空气质量监测点基本信息
     *
     * @param yqAirBaseInfo 园区空气质量监测点基本信息
     * @return 结果
     */
    public int updateYqAirBaseInfo(YqAirBaseInfo yqAirBaseInfo);

    /**
     * 删除园区空气质量监测点基本信息
     *
     * @param id 园区空气质量监测点基本信息主键
     * @return 结果
     */
    public int deleteYqAirBaseInfoById(Long id);

    /**
     * 批量删除园区空气质量监测点基本信息
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteYqAirBaseInfoByIds(Long[] ids);
}
