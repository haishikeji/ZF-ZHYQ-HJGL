package com.px.base.service.impl;

import java.util.List;
import com.px.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.px.base.mapper.BThirdDisposalInfoMapper;
import com.px.base.domain.BThirdDisposalInfo;
import com.px.base.service.IBThirdDisposalInfoService;

/**
 * 固废与危废第三方处置信息Service业务层处理
 *
 * @author 品讯科技
 * @date 2024-08
 */
@Service
public class BThirdDisposalInfoServiceImpl implements IBThirdDisposalInfoService
{
    @Autowired
    private BThirdDisposalInfoMapper bThirdDisposalInfoMapper;

    /**
     * 查询固废与危废第三方处置信息
     *
     * @param id 固废与危废第三方处置信息主键
     * @return 固废与危废第三方处置信息
     */
    @Override
    public BThirdDisposalInfo selectBThirdDisposalInfoById(Long id)
    {
        return bThirdDisposalInfoMapper.selectBThirdDisposalInfoById(id);
    }

    /**
     * 查询固废与危废第三方处置信息列表
     *
     * @param bThirdDisposalInfo 固废与危废第三方处置信息
     * @return 固废与危废第三方处置信息
     */
    @Override
    public List<BThirdDisposalInfo> selectBThirdDisposalInfoList(BThirdDisposalInfo bThirdDisposalInfo)
    {
        return bThirdDisposalInfoMapper.selectBThirdDisposalInfoList(bThirdDisposalInfo);
    }

    /**
     * 新增固废与危废第三方处置信息
     *
     * @param bThirdDisposalInfo 固废与危废第三方处置信息
     * @return 结果
     */
    @Override
    public int insertBThirdDisposalInfo(BThirdDisposalInfo bThirdDisposalInfo)
    {
        bThirdDisposalInfo.setCreateTime(DateUtils.getNowDate());
        return bThirdDisposalInfoMapper.insertBThirdDisposalInfo(bThirdDisposalInfo);
    }

    /**
     * 修改固废与危废第三方处置信息
     *
     * @param bThirdDisposalInfo 固废与危废第三方处置信息
     * @return 结果
     */
    @Override
    public int updateBThirdDisposalInfo(BThirdDisposalInfo bThirdDisposalInfo)
    {
        bThirdDisposalInfo.setUpdateTime(DateUtils.getNowDate());
        return bThirdDisposalInfoMapper.updateBThirdDisposalInfo(bThirdDisposalInfo);
    }

    /**
     * 批量删除固废与危废第三方处置信息
     *
     * @param ids 需要删除的固废与危废第三方处置信息主键
     * @return 结果
     */
    @Override
    public int deleteBThirdDisposalInfoByIds(Long[] ids)
    {
        return bThirdDisposalInfoMapper.logicallyDeleteByIds(ids);
    }

    /**
     * 删除固废与危废第三方处置信息信息
     *
     * @param id 固废与危废第三方处置信息主键
     * @return 结果
     */
    @Override
    public int deleteBThirdDisposalInfoById(Long id)
    {
        return bThirdDisposalInfoMapper.logicallyDeleteById(id);
    }
}
