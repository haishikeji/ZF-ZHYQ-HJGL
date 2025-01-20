package com.px.base.service;

import java.util.List;
import com.px.base.domain.BThirdDisposalInfo;

/**
 * 固废与危废第三方处置信息Service接口
 *
 * @author 品讯科技
 * @date 2024-08
 */
public interface IBThirdDisposalInfoService
{
    /**
     * 查询固废与危废第三方处置信息
     *
     * @param id 固废与危废第三方处置信息主键
     * @return 固废与危废第三方处置信息
     */
    public BThirdDisposalInfo selectBThirdDisposalInfoById(Long id);

    /**
     * 查询固废与危废第三方处置信息列表
     *
     * @param bThirdDisposalInfo 固废与危废第三方处置信息
     * @return 固废与危废第三方处置信息集合
     */
    public List<BThirdDisposalInfo> selectBThirdDisposalInfoList(BThirdDisposalInfo bThirdDisposalInfo);

    /**
     * 新增固废与危废第三方处置信息
     *
     * @param bThirdDisposalInfo 固废与危废第三方处置信息
     * @return 结果
     */
    public int insertBThirdDisposalInfo(BThirdDisposalInfo bThirdDisposalInfo);

    /**
     * 修改固废与危废第三方处置信息
     *
     * @param bThirdDisposalInfo 固废与危废第三方处置信息
     * @return 结果
     */
    public int updateBThirdDisposalInfo(BThirdDisposalInfo bThirdDisposalInfo);

    /**
     * 批量删除固废与危废第三方处置信息
     *
     * @param ids 需要删除的固废与危废第三方处置信息主键集合
     * @return 结果
     */
    public int deleteBThirdDisposalInfoByIds(Long[] ids);

    /**
     * 删除固废与危废第三方处置信息信息
     *
     * @param id 固废与危废第三方处置信息主键
     * @return 结果
     */
    public int deleteBThirdDisposalInfoById(Long id);
}
