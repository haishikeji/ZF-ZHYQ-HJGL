package com.px.base.mapper;

import java.util.List;
import com.px.base.domain.BGardenSpatialInfo;

/**
 * 片区空间分布Mapper接口
 *
 * @author 品讯科技
 * @date 2024-08
 */
public interface BGardenSpatialInfoMapper
{
    /**
     * 查询片区空间分布
     *
     * @param id 片区空间分布主键
     * @return 片区空间分布
     */
    public BGardenSpatialInfo selectBGardenSpatialInfoById(Long id);

    /**
     * 查询片区空间分布列表
     *
     * @param bGardenSpatialInfo 片区空间分布
     * @return 片区空间分布集合
     */
    public List<BGardenSpatialInfo> selectBGardenSpatialInfoList(BGardenSpatialInfo bGardenSpatialInfo);

    /**
     * 新增片区空间分布
     *
     * @param bGardenSpatialInfo 片区空间分布
     * @return 结果
     */
    public int insertBGardenSpatialInfo(BGardenSpatialInfo bGardenSpatialInfo);

    /**
     * 修改片区空间分布
     *
     * @param bGardenSpatialInfo 片区空间分布
     * @return 结果
     */
    public int updateBGardenSpatialInfo(BGardenSpatialInfo bGardenSpatialInfo);

    /**
     * 删除片区空间分布
     *
     * @param id 片区空间分布主键
     * @return 结果
     */
    public int deleteBGardenSpatialInfoById(Long id);

    /**
     * 批量删除片区空间分布
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBGardenSpatialInfoByIds(Long[] ids);

    public List<BGardenSpatialInfo> selectBGardenSpatialInfoExport(BGardenSpatialInfo bGardenSpatialInfo);
}
