package com.px.biz.mapper;

import java.util.List;
import com.px.biz.domain.BGardenPicInfo;

/**
 * 园区图片信息Mapper接口
 *
 * @author 品讯科技
 * @date 2024-08
 */
public interface BGardenPicInfoMapper
{
    /**
     * 查询园区图片信息
     *
     * @param id 园区图片信息主键
     * @return 园区图片信息
     */
    public BGardenPicInfo selectBGardenPicInfoById(Long id);

    /**
     * 查询园区图片信息列表
     *
     * @param bGardenPicInfo 园区图片信息
     * @return 园区图片信息集合
     */
    public List<BGardenPicInfo> selectBGardenPicInfoList(BGardenPicInfo bGardenPicInfo);

    /**
     * 新增园区图片信息
     *
     * @param bGardenPicInfo 园区图片信息
     * @return 结果
     */
    public int insertBGardenPicInfo(BGardenPicInfo bGardenPicInfo);

    /**
     * 修改园区图片信息
     *
     * @param bGardenPicInfo 园区图片信息
     * @return 结果
     */
    public int updateBGardenPicInfo(BGardenPicInfo bGardenPicInfo);

    /**
     * 删除园区图片信息
     *
     * @param id 园区图片信息主键
     * @return 结果
     */
    public int deleteBGardenPicInfoById(Long id);

    /**
     * 批量删除园区图片信息
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBGardenPicInfoByIds(Long[] ids);

    public int deleteBGardenPicInfoByGardenCode(String gardenCode);
}
