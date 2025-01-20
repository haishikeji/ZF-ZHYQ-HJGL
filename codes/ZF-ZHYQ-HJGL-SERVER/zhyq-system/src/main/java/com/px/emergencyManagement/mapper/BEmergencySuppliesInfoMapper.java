package com.px.emergencyManagement.mapper;

import java.util.List;
import com.px.emergencyManagement.domain.BEmergencySuppliesInfo;

/**
 * 应急物资信息Mapper接口
 *
 * @author 品讯科技
 * @date 2024-08
 */
public interface BEmergencySuppliesInfoMapper
{
    /**
     * 查询应急物资信息
     *
     * @param id 应急物资信息主键
     * @return 应急物资信息
     */
    public BEmergencySuppliesInfo selectBEmergencySuppliesInfoById(Long id);

    /**
     * 查询应急物资信息列表
     *
     * @param bEmergencySuppliesInfo 应急物资信息
     * @return 应急物资信息集合
     */
    public List<BEmergencySuppliesInfo> selectBEmergencySuppliesInfoList(BEmergencySuppliesInfo bEmergencySuppliesInfo);

    /**
     * 新增应急物资信息
     *
     * @param bEmergencySuppliesInfo 应急物资信息
     * @return 结果
     */
    public int insertBEmergencySuppliesInfo(BEmergencySuppliesInfo bEmergencySuppliesInfo);

    /**
     * 修改应急物资信息
     *
     * @param bEmergencySuppliesInfo 应急物资信息
     * @return 结果
     */
    public int updateBEmergencySuppliesInfo(BEmergencySuppliesInfo bEmergencySuppliesInfo);

    /**
     * 删除应急物资信息
     *
     * @param id 应急物资信息主键
     * @return 结果
     */
    public int deleteBEmergencySuppliesInfoById(Long id);

    /**
     * 批量删除应急物资信息
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBEmergencySuppliesInfoByIds(Long[] ids);

    public int logicDelBEmergencySuppliesInfoByIds(Long[] ids);

    public List<BEmergencySuppliesInfo> selectBEmergencySuppliesInfoExport(BEmergencySuppliesInfo bEmergencySuppliesInfo);
}
