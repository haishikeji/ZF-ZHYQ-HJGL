package com.px.enterpriseArchives.mapper;

import java.util.List;
import com.px.enterpriseArchives.domain.BEnterprisePicInfo;

/**
 * 企业图片信息Mapper接口
 *
 * @author 品讯科技
 * @date 2024-08
 */
public interface BEnterprisePicInfoMapper
{
    /**
     * 查询企业图片信息
     *
     * @param id 企业图片信息主键
     * @return 企业图片信息
     */
    public BEnterprisePicInfo selectBEnterprisePicInfoById(Long id);

    /**
     * 查询企业图片信息列表
     *
     * @param bEnterprisePicInfo 企业图片信息
     * @return 企业图片信息集合
     */
    public List<BEnterprisePicInfo> selectBEnterprisePicInfoList(BEnterprisePicInfo bEnterprisePicInfo);

    /**
     * 新增企业图片信息
     *
     * @param bEnterprisePicInfo 企业图片信息
     * @return 结果
     */
    public int insertBEnterprisePicInfo(BEnterprisePicInfo bEnterprisePicInfo);

    /**
     * 修改企业图片信息
     *
     * @param bEnterprisePicInfo 企业图片信息
     * @return 结果
     */
    public int updateBEnterprisePicInfo(BEnterprisePicInfo bEnterprisePicInfo);

    /**
     * 删除企业图片信息
     *
     * @param id 企业图片信息主键
     * @return 结果
     */
    public int deleteBEnterprisePicInfoById(Long id);

    /**
     * 批量删除企业图片信息
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBEnterprisePicInfoByIds(Long[] ids);

    public int deleteBEnterprisePicInfo(BEnterprisePicInfo bEnterprisePicInfo);

    public int insertBEnterprisePicInfoList(List<BEnterprisePicInfo> enterprisePicInfoList);
}
