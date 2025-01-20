package com.px.biz.mapper;

import java.util.List;
import com.px.biz.domain.BGardenProvinceInfo;

/**
 * 园区基础信息Mapper接口
 *
 * @author 品讯科技
 * @date 2024-08
 */
public interface BGardenProvinceInfoMapper
{
    /**
     * 查询园区基础信息
     *
     * @param id 园区基础信息主键
     * @return 园区基础信息
     */
    public BGardenProvinceInfo selectBGardenProvinceInfoById(Long id);

    /**
     * 查询园区基础信息列表
     *
     * @param bGardenProvinceInfo 园区基础信息
     * @return 园区基础信息集合
     */
    public List<BGardenProvinceInfo> selectBGardenProvinceInfoList(BGardenProvinceInfo bGardenProvinceInfo);

    /**
     * 新增园区基础信息
     *
     * @param bGardenProvinceInfo 园区基础信息
     * @return 结果
     */
    public int insertBGardenProvinceInfo(BGardenProvinceInfo bGardenProvinceInfo);

    /**
     * 修改园区基础信息
     *
     * @param bGardenProvinceInfo 园区基础信息
     * @return 结果
     */
    public int updateBGardenProvinceInfo(BGardenProvinceInfo bGardenProvinceInfo);

    /**
     * 删除园区基础信息
     *
     * @param id 园区基础信息主键
     * @return 结果
     */
    public int deleteBGardenProvinceInfoById(Long id);

    /**
     * 批量删除园区基础信息
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBGardenProvinceInfoByIds(Long[] ids);
}
