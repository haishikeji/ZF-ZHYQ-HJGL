package com.px.base.mapper;

import java.util.List;
import com.px.base.domain.RHazardousWasteWarehouse;

/**
 * 危废仓库与危废关系Mapper接口
 *
 * @author 品讯科技
 * @date 2024-08
 */
public interface RHazardousWasteWarehouseMapper
{
    /**
     * 查询危废仓库与危废关系
     *
     * @param id 危废仓库与危废关系主键
     * @return 危废仓库与危废关系
     */
    public RHazardousWasteWarehouse selectRHazardousWasteWarehouseById(Long id);

    /**
     * 查询危废仓库与危废关系列表
     *
     * @param rHazardousWasteWarehouse 危废仓库与危废关系
     * @return 危废仓库与危废关系集合
     */
    public List<RHazardousWasteWarehouse> selectRHazardousWasteWarehouseList(RHazardousWasteWarehouse rHazardousWasteWarehouse);

    /**
     * 新增危废仓库与危废关系
     *
     * @param rHazardousWasteWarehouse 危废仓库与危废关系
     * @return 结果
     */
    public int insertRHazardousWasteWarehouse(RHazardousWasteWarehouse rHazardousWasteWarehouse);

    /**
     * 修改危废仓库与危废关系
     *
     * @param rHazardousWasteWarehouse 危废仓库与危废关系
     * @return 结果
     */
    public int updateRHazardousWasteWarehouse(RHazardousWasteWarehouse rHazardousWasteWarehouse);

    /**
     * 删除危废仓库与危废关系
     *
     * @param id 危废仓库与危废关系主键
     * @return 结果
     */
    public int deleteRHazardousWasteWarehouseById(Long id);

    /**
     * 批量删除危废仓库与危废关系
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteRHazardousWasteWarehouseByIds(Long[] ids);

    /**
     * 逻辑删除危废仓库与危废关系
     * @param id 危废仓库与危废关系信息主键
     * @return
     */
    public int logicallyDeleteById(Long id);

    /**
     * 逻辑删除危废仓库与危废关系
     * @param ids 需要删除的数据主键集合
     * @return
     */
    public int logicallyDeleteByIds(Long[] ids);
}
