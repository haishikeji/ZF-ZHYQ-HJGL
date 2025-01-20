package com.px.base.service.impl;

import java.util.List;

import com.px.base.domain.BProcessFileInfo;
import com.px.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.px.base.mapper.BPollutionFacilityProcessMapper;
import com.px.base.domain.BPollutionFacilityProcess;
import com.px.base.service.IBPollutionFacilityProcessService;

/**
 * 污染治理设施建设进程Service业务层处理
 *
 * @author 品讯科技
 * @date 2024-08
 */
@Service
public class BPollutionFacilityProcessServiceImpl implements IBPollutionFacilityProcessService
{
    @Autowired
    private BPollutionFacilityProcessMapper bPollutionFacilityProcessMapper;

    @Autowired
    private BProcessFileInfoServiceImpl bProcessFileInfoService;

    /**
     * 查询污染治理设施建设进程
     *
     * @param id 污染治理设施建设进程主键
     * @return 污染治理设施建设进程
     */
    @Override
    public BPollutionFacilityProcess selectBPollutionFacilityProcessById(Long id)
    {
        BPollutionFacilityProcess bPollutionFacilityProcess = bPollutionFacilityProcessMapper.selectBPollutionFacilityProcessById(id);
        // 通过污染治理设施进程id，查询污染治理设施进程附件列表
        BProcessFileInfo bProcessFileInfo = new BProcessFileInfo();
        bProcessFileInfo.setProcessId(id);
        List<BProcessFileInfo> bProcessFileInfos = bProcessFileInfoService.selectBProcessFileInfoList(bProcessFileInfo);

        if(bPollutionFacilityProcess != null) {
            bPollutionFacilityProcess.setProcessFileInfoList(bProcessFileInfos);
        }
        return bPollutionFacilityProcess;
    }

    /**
     * 查询污染治理设施建设进程列表
     *
     * @param bPollutionFacilityProcess 污染治理设施建设进程
     * @return 污染治理设施建设进程
     */
    @Override
    public List<BPollutionFacilityProcess> selectBPollutionFacilityProcessList(BPollutionFacilityProcess bPollutionFacilityProcess)
    {
        List<BPollutionFacilityProcess> bPollutionFacilityProcesses = bPollutionFacilityProcessMapper.selectBPollutionFacilityProcessList(bPollutionFacilityProcess);
        bPollutionFacilityProcesses.forEach(item -> {
            // 通过污染治理设施进程id，查询污染治理设施进程附件列表
            BProcessFileInfo bProcessFileInfo = new BProcessFileInfo();
            bProcessFileInfo.setProcessId(item.getId());
            List<BProcessFileInfo> bProcessFileInfos = bProcessFileInfoService.selectBProcessFileInfoList(bProcessFileInfo);
            item.setProcessFileInfoList(bProcessFileInfos);
        });
        return bPollutionFacilityProcesses;
    }

    /**
     * 新增污染治理设施建设进程
     *
     * @param bPollutionFacilityProcess 污染治理设施建设进程
     * @return 结果
     */
    @Override
    public int insertBPollutionFacilityProcess(BPollutionFacilityProcess bPollutionFacilityProcess)
    {
        int i = bPollutionFacilityProcessMapper.insertBPollutionFacilityProcess(bPollutionFacilityProcess);
        bPollutionFacilityProcess.setCreateTime(DateUtils.getNowDate());
        bPollutionFacilityProcess.getProcessFileInfoList().forEach(bProcessFileInfo -> {
            bProcessFileInfo.setProcessId(bPollutionFacilityProcess.getId());
            bProcessFileInfoService.insertBProcessFileInfo(bProcessFileInfo);
        });
        return i;
    }

    /**
     * 修改污染治理设施建设进程
     *
     * @param bPollutionFacilityProcess 污染治理设施建设进程
     * @return 结果
     */
    @Override
    public int updateBPollutionFacilityProcess(BPollutionFacilityProcess bPollutionFacilityProcess)
    {
        bPollutionFacilityProcess.setUpdateTime(DateUtils.getNowDate());
        bProcessFileInfoService.deleteBProcessFileInfoByProcessId(bPollutionFacilityProcess.getId());
        bPollutionFacilityProcess.getProcessFileInfoList().forEach(bProcessFileInfo -> {
            bProcessFileInfo.setProcessId(bPollutionFacilityProcess.getId());
            bProcessFileInfoService.insertBProcessFileInfo(bProcessFileInfo);
        });
        return bPollutionFacilityProcessMapper.updateBPollutionFacilityProcess(bPollutionFacilityProcess);
    }

    /**
     * 批量删除污染治理设施建设进程 (逻辑删除)
     *
     * @param ids 需要删除的污染治理设施建设进程主键
     * @return 结果
     */
    @Override
    public int deleteBPollutionFacilityProcessByIds(Long[] ids)
    {
        // 通过污染治理设施进程id删除附件
        bProcessFileInfoService.deleteBProcessFileInfoByProcessIds(ids);
        return bPollutionFacilityProcessMapper.logicallyDeleteByIds(ids);
    }


    /**
     * 批量删除污染治理设施建设进程 (级联逻辑删除)
     *
     * @param facilityIds 污染治理设施的id
     * @return 结果
     */
    @Override
    public int deleteBPollutionFacilityProcessByFacilityIds(Long[] facilityIds)
    {
        // 通过污染治理设施id,删除附件
        bProcessFileInfoService.deleteBProcessFileInfoByFacilityIds(facilityIds);
        // 通过污染治理设施id,删除进程
        return bPollutionFacilityProcessMapper.logicallyDeleteByFacilityIds(facilityIds);
    }
}

