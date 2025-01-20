package com.px.enterpriseArchives.service.impl;

import java.util.List;
import com.px.common.utils.DateUtils;
import com.px.common.utils.StringUtils;
import com.px.enterpriseArchives.domain.BEnterpriseCertificateInfo;
import com.px.enterpriseArchives.domain.dto.ScreenEnterpriseDto;
import com.px.enterpriseArchives.mapper.BEnterpriseCertificateInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.px.enterpriseArchives.mapper.BEnterpriseBaseInfoMapper;
import com.px.enterpriseArchives.domain.BEnterpriseBaseInfo;
import com.px.enterpriseArchives.service.IBEnterpriseBaseInfoService;

/**
 * 企业基本信息Service业务层处理
 *
 * @author 品讯科技
 * @date 2024-08
 */
@Service
public class BEnterpriseBaseInfoServiceImpl implements IBEnterpriseBaseInfoService
{
    @Autowired
    private BEnterpriseBaseInfoMapper bEnterpriseBaseInfoMapper;

    @Autowired
    BEnterpriseCertificateInfoMapper bEnterpriseCertificateInfoMapper;

    /**
     * 查询企业基本信息
     *
     * @param id 企业基本信息主键
     * @return 企业基本信息
     */
    @Override
    public BEnterpriseBaseInfo selectBEnterpriseBaseInfoById(Long id)
    {
        return bEnterpriseBaseInfoMapper.selectBEnterpriseBaseInfoById(id);
    }

    /**
     * 查询企业基本信息列表
     *
     * @param bEnterpriseBaseInfo 企业基本信息
     * @return 企业基本信息
     */
    @Override
    public List<BEnterpriseBaseInfo> selectBEnterpriseBaseInfoList(BEnterpriseBaseInfo bEnterpriseBaseInfo)
    {
        return bEnterpriseBaseInfoMapper.selectBEnterpriseBaseInfoList(bEnterpriseBaseInfo);
    }

    /**
     * 新增企业基本信息
     *
     * @param bEnterpriseBaseInfo 企业基本信息
     * @return 结果
     */
    @Override
    public int insertBEnterpriseBaseInfo(BEnterpriseBaseInfo bEnterpriseBaseInfo)
    {
        bEnterpriseBaseInfo.setCreateTime(DateUtils.getNowDate());
        return bEnterpriseBaseInfoMapper.insertBEnterpriseBaseInfo(bEnterpriseBaseInfo);
    }

    /**
     * 修改企业基本信息
     *
     * @param bEnterpriseBaseInfo 企业基本信息
     * @return 结果
     */
    @Override
    public int updateBEnterpriseBaseInfo(BEnterpriseBaseInfo bEnterpriseBaseInfo)
    {
        bEnterpriseBaseInfo.setUpdateTime(DateUtils.getNowDate());
        return bEnterpriseBaseInfoMapper.updateBEnterpriseBaseInfo(bEnterpriseBaseInfo);
    }

    /**
     * 批量删除企业基本信息
     *
     * @param ids 需要删除的企业基本信息主键
     * @return 结果
     */
    @Override
    public int deleteBEnterpriseBaseInfoByIds(Long[] ids)
    {
        return bEnterpriseBaseInfoMapper.logicallyDeleteByIds(ids);
    }

    /**
     * 删除企业基本信息信息
     *
     * @param id 企业基本信息主键
     * @return 结果
     */
    @Override
    public int deleteBEnterpriseBaseInfoById(Long id)
    {
        return bEnterpriseBaseInfoMapper.deleteBEnterpriseBaseInfoById(id);
    }

    @Override
    public List<BEnterpriseBaseInfo> screenSelectBEnterpriseBaseInfo(ScreenEnterpriseDto screenEnterpriseDto) {
        return bEnterpriseBaseInfoMapper.screenSelectBEnterpriseBaseInfo(screenEnterpriseDto);
    }

    @Override
    public BEnterpriseBaseInfo getEnterpriseInfoByCode(String enterpriseCode) {
        BEnterpriseCertificateInfo bEnterpriseCertificateInfo = new BEnterpriseCertificateInfo();
        bEnterpriseCertificateInfo.setEnterpriseCode(enterpriseCode);
        bEnterpriseCertificateInfoMapper.selectBEnterpriseCertificateInfoList(bEnterpriseCertificateInfo);
        BEnterpriseBaseInfo enterpriseInfoByCode = bEnterpriseBaseInfoMapper.getEnterpriseInfoByCode(enterpriseCode);
        if(enterpriseInfoByCode != null){
            enterpriseInfoByCode.setCertificateInfoList(bEnterpriseCertificateInfoMapper.selectBEnterpriseCertificateInfoList(bEnterpriseCertificateInfo));
        }
        return enterpriseInfoByCode;
    }

    @Override
    public Integer selectOnlineNum(ScreenEnterpriseDto screenEnterpriseDto) {
        if (StringUtils.isEmpty(screenEnterpriseDto.getOnlineMonitoringFacility())) {
            screenEnterpriseDto.setOnlineMonitoringFacility("1");
        }
        return bEnterpriseBaseInfoMapper.selectOnlineNum(screenEnterpriseDto);
    }

    @Override
    public List<BEnterpriseBaseInfo> selectBEnterpriseBaseInfoBWaterOutletInfo(BEnterpriseBaseInfo bEnterpriseBaseInfo) {
        return bEnterpriseBaseInfoMapper.selectBEnterpriseBaseInfoBWaterOutletInfo(bEnterpriseBaseInfo);
    }

    @Override
    public List<BEnterpriseBaseInfo> selectBEnterpriseBaseInfoBBoxInfo(BEnterpriseBaseInfo bEnterpriseBaseInfo,List<String> enterpriseCodes) {
        String enterpriseName=bEnterpriseBaseInfo.getEnterpriseName();
        return bEnterpriseBaseInfoMapper.selectBEnterpriseBaseInfoBBoxInfo(enterpriseCodes,enterpriseName);
    }
}
