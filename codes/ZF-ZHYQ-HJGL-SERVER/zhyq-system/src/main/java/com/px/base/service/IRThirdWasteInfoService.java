package com.px.base.service;

import java.util.List;
import com.px.base.domain.RThirdWasteInfo;

/**
 * 第三方处置与废弃物关系Service接口
 *
 * @author 品讯科技
 * @date 2024-08
 */
public interface IRThirdWasteInfoService
{
    /**
     * 查询第三方处置与废弃物关系
     *
     * @param id 第三方处置与废弃物关系主键
     * @return 第三方处置与废弃物关系
     */
    public RThirdWasteInfo selectRThirdWasteInfoById(Long id);

    /**
     * 查询第三方处置与废弃物关系列表
     *
     * @param rThirdWasteInfo 第三方处置与废弃物关系
     * @return 第三方处置与废弃物关系集合
     */
    public List<RThirdWasteInfo> selectRThirdWasteInfoList(RThirdWasteInfo rThirdWasteInfo);

    /**
     * 新增第三方处置与废弃物关系
     *
     * @param rThirdWasteInfo 第三方处置与废弃物关系
     * @return 结果
     */
    public int insertRThirdWasteInfo(RThirdWasteInfo rThirdWasteInfo);

    /**
     * 修改第三方处置与废弃物关系
     *
     * @param rThirdWasteInfo 第三方处置与废弃物关系
     * @return 结果
     */
    public int updateRThirdWasteInfo(RThirdWasteInfo rThirdWasteInfo);

    /**
     * 批量删除第三方处置与废弃物关系
     *
     * @param ids 需要删除的第三方处置与废弃物关系主键集合
     * @return 结果
     */
    public int deleteRThirdWasteInfoByIds(Long[] ids);

    /**
     * 删除第三方处置与废弃物关系信息
     *
     * @param id 第三方处置与废弃物关系主键
     * @return 结果
     */
    public int deleteRThirdWasteInfoById(Long id);
}

