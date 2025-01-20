package com.px.biz.mapper;

import java.util.List;
import com.px.biz.domain.BElectricMetiscSevenDay;

/**
 * 企业用电日7日内实时数据Mapper接口
 *
 * @author 品讯科技
 * @date 2024-08
 */
public interface BElectricMetiscSevenDayMapper
{
    /**
     * 查询企业用电日7日内实时数据
     *
     * @param id 企业用电日7日内实时数据主键
     * @return 企业用电日7日内实时数据
     */
    public BElectricMetiscSevenDay selectBElectricMetiscSevenDayById(Long id);

    /**
     * 查询企业用电日7日内实时数据列表
     *
     * @param bElectricMetiscSevenDay 企业用电日7日内实时数据
     * @return 企业用电日7日内实时数据集合
     */
    public List<BElectricMetiscSevenDay> selectBElectricMetiscSevenDayList(BElectricMetiscSevenDay bElectricMetiscSevenDay);

    /**
     * 新增企业用电日7日内实时数据
     *
     * @param bElectricMetiscSevenDay 企业用电日7日内实时数据
     * @return 结果
     */
    public int insertBElectricMetiscSevenDay(BElectricMetiscSevenDay bElectricMetiscSevenDay);

    /**
     * 修改企业用电日7日内实时数据
     *
     * @param bElectricMetiscSevenDay 企业用电日7日内实时数据
     * @return 结果
     */
    public int updateBElectricMetiscSevenDay(BElectricMetiscSevenDay bElectricMetiscSevenDay);

    /**
     * 删除企业用电日7日内实时数据
     *
     * @param id 企业用电日7日内实时数据主键
     * @return 结果
     */
    public int deleteBElectricMetiscSevenDayById(Long id);

    /**
     * 批量删除企业用电日7日内实时数据
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBElectricMetiscSevenDayByIds(Long[] ids);

    public List<BElectricMetiscSevenDay> selectOneDayList(BElectricMetiscSevenDay bElectricMetiscSevenDay);

}
