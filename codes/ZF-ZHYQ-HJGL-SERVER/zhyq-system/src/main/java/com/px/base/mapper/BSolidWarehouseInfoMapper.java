package com.px.base.mapper;

import java.util.List;
import com.px.base.domain.BSolidWarehouseInfo;

/**
 * 固废仓库信息Mapper接口
 *
 * @author 品讯科技
 * @date 2024-08
 */
public interface BSolidWarehouseInfoMapper
{
    /**
     * 查询固废仓库信息
     *
     * @param id 固废仓库信息主键
     * @return 固废仓库信息
     */
    public BSolidWarehouseInfo selectBSolidWarehouseInfoById(Long id);

    /**
     * 查询固废仓库信息列表
     *
     * @param bSolidWarehouseInfo 固废仓库信息
     * @return 固废仓库信息集合
     */
    public List<BSolidWarehouseInfo> selectBSolidWarehouseInfoList(BSolidWarehouseInfo bSolidWarehouseInfo);

    /**
     * 新增固废仓库信息
     *
     * @param bSolidWarehouseInfo 固废仓库信息
     * @return 结果
     */
    public int insertBSolidWarehouseInfo(BSolidWarehouseInfo bSolidWarehouseInfo);

    /**
     * 修改固废仓库信息
     *
     * @param bSolidWarehouseInfo 固废仓库信息
     * @return 结果
     */
    public int updateBSolidWarehouseInfo(BSolidWarehouseInfo bSolidWarehouseInfo);

    /**
     * 删除固废仓库信息
     *
     * @param id 固废仓库信息主键
     * @return 结果
     */
    public int deleteBSolidWarehouseInfoById(Long id);

    /**
     * 批量删除固废仓库信息
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBSolidWarehouseInfoByIds(Long[] ids);


    /**
     * 逻辑删除固废仓库信息
     * @param id 空气微站信息主键
     * @return
     */
    public int logicallyDeleteById(Long id);

    /**
     * 逻辑删除固废仓库信息
     * @param ids 需要删除的数据主键集合
     * @return
     */
    public int logicallyDeleteByIds(Long[] ids);
}
