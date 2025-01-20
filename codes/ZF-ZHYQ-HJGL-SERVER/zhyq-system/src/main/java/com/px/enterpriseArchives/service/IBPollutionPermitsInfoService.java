package com.px.enterpriseArchives.service;

import java.util.List;
import com.px.enterpriseArchives.domain.BPollutionPermitsInfo;

/**
 * 排污许可证Service接口
 *
 * @author 品讯科技
 * @date 2024-08
 */
public interface IBPollutionPermitsInfoService
{
    /**
     * 查询排污许可证
     *
     * @param id 排污许可证主键
     * @return 排污许可证
     */
    public BPollutionPermitsInfo selectBPollutionPermitsInfoById(Long id);

    /**
     * 查询排污许可证列表
     *
     * @param bPollutionPermitsInfo 排污许可证
     * @return 排污许可证集合
     */
    public List<BPollutionPermitsInfo> selectBPollutionPermitsInfoList(BPollutionPermitsInfo bPollutionPermitsInfo);

    /**
     * 新增排污许可证
     *
     * @param bPollutionPermitsInfo 排污许可证
     * @return 结果
     */
    public int insertBPollutionPermitsInfo(BPollutionPermitsInfo bPollutionPermitsInfo);

    /**
     * 修改排污许可证
     *
     * @param bPollutionPermitsInfo 排污许可证
     * @return 结果
     */
    public int updateBPollutionPermitsInfo(BPollutionPermitsInfo bPollutionPermitsInfo);

    /**
     * 批量删除排污许可证
     *
     * @param ids 需要删除的排污许可证主键集合
     * @return 结果
     */
    public int deleteBPollutionPermitsInfoByIds(Long[] ids);

    /**
     * 删除排污许可证信息
     *
     * @param id 排污许可证主键
     * @return 结果
     */
    public int deleteBPollutionPermitsInfoById(Long id);
}
