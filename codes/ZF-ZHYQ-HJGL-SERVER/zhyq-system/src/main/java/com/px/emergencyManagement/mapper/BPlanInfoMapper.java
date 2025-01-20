package com.px.emergencyManagement.mapper;

import java.util.List;
import com.px.emergencyManagement.domain.BPlanInfo;
import org.apache.ibatis.annotations.Options;

/**
 * 应急预案信息Mapper接口
 *
 * @author 品讯科技
 * @date 2024-08
 */
public interface BPlanInfoMapper
{
    /**
     * 查询应急预案信息
     *
     * @param id 应急预案信息主键
     * @return 应急预案信息
     */
    public BPlanInfo selectBPlanInfoById(Long id);

    /**
     * 查询应急预案信息列表
     *
     * @param bPlanInfo 应急预案信息
     * @return 应急预案信息集合
     */
    public List<BPlanInfo> selectBPlanInfoList(BPlanInfo bPlanInfo);

    /**
     * 新增应急预案信息
     *
     * @param bPlanInfo 应急预案信息
     * @return 结果
     */
    @Options(useGeneratedKeys = true, keyProperty = "id")  // 获取生成的主键
    public void insertBPlanInfo(BPlanInfo bPlanInfo);

    /**
     * 修改应急预案信息
     *
     * @param bPlanInfo 应急预案信息
     * @return 结果
     */
    public int updateBPlanInfo(BPlanInfo bPlanInfo);

    /**
     * 删除应急预案信息
     *
     * @param id 应急预案信息主键
     * @return 结果
     */
    public int deleteBPlanInfoById(Long id);

    /**
     * 批量删除应急预案信息
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBPlanInfoByIds(Long[] ids);

    public int logicDeleteBPlanInfoByIds(Long[] ids);

    public List<BPlanInfo> selectBPlanInfoExport(BPlanInfo bPlanInfo);
}
