package com.px.enterpriseArchives.service.impl;

import java.util.List;
import com.px.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.px.enterpriseArchives.mapper.BEnterpriseCertificateInfoMapper;
import com.px.enterpriseArchives.domain.BEnterpriseCertificateInfo;
import com.px.enterpriseArchives.service.IBEnterpriseCertificateInfoService;

/**
 * 企业证件信息Service业务层处理
 *
 * @author 品讯科技
 * @date 2024-08
 */
@Service
public class BEnterpriseCertificateInfoServiceImpl implements IBEnterpriseCertificateInfoService
{
    @Autowired
    private BEnterpriseCertificateInfoMapper bEnterpriseCertificateInfoMapper;

    /**
     * 查询企业证件信息
     *
     * @param id 企业证件信息主键
     * @return 企业证件信息
     */
    @Override
    public BEnterpriseCertificateInfo selectBEnterpriseCertificateInfoById(Long id)
    {
        return bEnterpriseCertificateInfoMapper.selectBEnterpriseCertificateInfoById(id);
    }

    /**
     * 查询企业证件信息列表
     *
     * @param bEnterpriseCertificateInfo 企业证件信息
     * @return 企业证件信息
     */
    @Override
    public List<BEnterpriseCertificateInfo> selectBEnterpriseCertificateInfoList(BEnterpriseCertificateInfo bEnterpriseCertificateInfo)
    {
        return bEnterpriseCertificateInfoMapper.selectBEnterpriseCertificateInfoList(bEnterpriseCertificateInfo);
    }

    /**
     * 新增企业证件信息
     *
     * @param bEnterpriseCertificateInfo 企业证件信息
     * @return 结果
     */
    @Override
    public int insertBEnterpriseCertificateInfo(BEnterpriseCertificateInfo bEnterpriseCertificateInfo)
    {
        bEnterpriseCertificateInfo.setCreateTime(DateUtils.getNowDate());
        return bEnterpriseCertificateInfoMapper.insertBEnterpriseCertificateInfo(bEnterpriseCertificateInfo);
    }

    /**
     * 修改企业证件信息
     *
     * @param bEnterpriseCertificateInfo 企业证件信息
     * @return 结果
     */
    @Override
    public int updateBEnterpriseCertificateInfo(BEnterpriseCertificateInfo bEnterpriseCertificateInfo)
    {
        bEnterpriseCertificateInfo.setUpdateTime(DateUtils.getNowDate());
        return bEnterpriseCertificateInfoMapper.updateBEnterpriseCertificateInfo(bEnterpriseCertificateInfo);
    }

    /**
     * 批量删除企业证件信息
     *
     * @param ids 需要删除的企业证件信息主键
     * @return 结果
     */
    @Override
    public int deleteBEnterpriseCertificateInfoByIds(Long[] ids)
    {
        return bEnterpriseCertificateInfoMapper.deleteBEnterpriseCertificateInfoByIds(ids);
    }

    /**
     * 删除企业证件信息信息
     *
     * @param id 企业证件信息主键
     * @return 结果
     */
    @Override
    public int deleteBEnterpriseCertificateInfoById(Long id)
    {
        return bEnterpriseCertificateInfoMapper.deleteBEnterpriseCertificateInfoById(id);
    }

    @Override
    public int deleteBEnterpriseCertificateInfo(BEnterpriseCertificateInfo bEnterpriseCertificateInfo) {
        return bEnterpriseCertificateInfoMapper.deleteBEnterpriseCertificateInfo(bEnterpriseCertificateInfo);
    }

    @Override
    public int insertBEnterpriseCertificateInfoList(List<BEnterpriseCertificateInfo> certificateInfo) {
        if (certificateInfo != null && certificateInfo.size() != 0) {
            return bEnterpriseCertificateInfoMapper.insertBEnterpriseCertificateInfoList(certificateInfo);
        }
        return 0;
    }
}
