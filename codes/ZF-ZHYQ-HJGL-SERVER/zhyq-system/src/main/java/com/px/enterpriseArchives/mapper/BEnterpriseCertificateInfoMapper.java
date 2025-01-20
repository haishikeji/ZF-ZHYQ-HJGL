package com.px.enterpriseArchives.mapper;

import java.util.List;
import com.px.enterpriseArchives.domain.BEnterpriseCertificateInfo;

/**
 * 企业证件信息Mapper接口
 *
 * @author 品讯科技
 * @date 2024-08
 */
public interface BEnterpriseCertificateInfoMapper
{
    /**
     * 查询企业证件信息
     *
     * @param id 企业证件信息主键
     * @return 企业证件信息
     */
    public BEnterpriseCertificateInfo selectBEnterpriseCertificateInfoById(Long id);

    /**
     * 查询企业证件信息列表
     *
     * @param bEnterpriseCertificateInfo 企业证件信息
     * @return 企业证件信息集合
     */
    public List<BEnterpriseCertificateInfo> selectBEnterpriseCertificateInfoList(BEnterpriseCertificateInfo bEnterpriseCertificateInfo);

    /**
     * 新增企业证件信息
     *
     * @param bEnterpriseCertificateInfo 企业证件信息
     * @return 结果
     */
    public int insertBEnterpriseCertificateInfo(BEnterpriseCertificateInfo bEnterpriseCertificateInfo);

    /**
     * 修改企业证件信息
     *
     * @param bEnterpriseCertificateInfo 企业证件信息
     * @return 结果
     */
    public int updateBEnterpriseCertificateInfo(BEnterpriseCertificateInfo bEnterpriseCertificateInfo);

    /**
     * 删除企业证件信息
     *
     * @param id 企业证件信息主键
     * @return 结果
     */
    public int deleteBEnterpriseCertificateInfoById(Long id);

    /**
     * 批量删除企业证件信息
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBEnterpriseCertificateInfoByIds(Long[] ids);

    public int deleteBEnterpriseCertificateInfo(BEnterpriseCertificateInfo bEnterpriseCertificateInfo);

    public int insertBEnterpriseCertificateInfoList(List<BEnterpriseCertificateInfo> certificateInfo);
}
