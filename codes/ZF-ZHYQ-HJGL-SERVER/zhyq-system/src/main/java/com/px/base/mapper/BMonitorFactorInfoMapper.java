package com.px.base.mapper;

import java.util.List;
import com.px.base.domain.BMonitorFactorInfo;import org.apache.ibatis.annotations.Param;


/**
 * 监测因子编码Mapper接口
 *
 * @author 品讯科技
 * @date 2024-08
 */
public interface BMonitorFactorInfoMapper
{
    /**
     * 查询监测因子编码
     *
     * @param id 监测因子编码主键
     * @return 监测因子编码
     */
    public BMonitorFactorInfo selectBMonitorFactorInfoById(Long id);

    /**
     * 查询监测因子编码列表
     *
     * @param bMonitorFactorInfo 监测因子编码
     * @return 监测因子编码集合
     */
    public List<BMonitorFactorInfo> selectBMonitorFactorInfoList(BMonitorFactorInfo bMonitorFactorInfo);

    /**
     * 新增监测因子编码
     *
     * @param bMonitorFactorInfo 监测因子编码
     * @return 结果
     */
    public int insertBMonitorFactorInfo(BMonitorFactorInfo bMonitorFactorInfo);

    /**
     * 修改监测因子编码
     *
     * @param bMonitorFactorInfo 监测因子编码
     * @return 结果
     */
    public int updateBMonitorFactorInfo(BMonitorFactorInfo bMonitorFactorInfo);

    /**
     * 删除监测因子编码
     *
     * @param id 监测因子编码主键
     * @return 结果
     */
    public int deleteBMonitorFactorInfoById(Long id);

    /**
     * 批量删除监测因子编码
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBMonitorFactorInfoByIds(Long[] ids);

    /**
     * 逻辑删除监测因子编码
     * @param id 需要删除的数据主键
     * @return
     */
    public int logicallyDeleteById(Long id);

    /**
     * 逻辑监测因子编码
     * @param ids 需要删除的数据主键集合
     * @return
     */
    public int logicallyDeleteByIds(Long[] ids);
    /**
     * 根据污染因子编码查询污染因子
     * @param uniqueFactorCodes 污染因子编码
     * @return
     */
    List<BMonitorFactorInfo> selectBMonitorFactorInfoPost(@Param("uniqueFactorCodes") List<String> uniqueFactorCodes);
}
