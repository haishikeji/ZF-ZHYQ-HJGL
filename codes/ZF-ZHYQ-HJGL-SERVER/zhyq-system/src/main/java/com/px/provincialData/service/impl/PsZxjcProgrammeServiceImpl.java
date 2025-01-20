package com.px.provincialData.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.px.provincialData.mapper.PsZxjcProgrammeMapper;
import com.px.provincialData.domain.PsZxjcProgramme;
import com.px.provincialData.service.IPsZxjcProgrammeService;

/**
 * 排污单位自行监测方案Service业务层处理
 *
 * @author 品讯科技
 * @date 2024-08
 */
@Service
public class PsZxjcProgrammeServiceImpl implements IPsZxjcProgrammeService
{
    @Autowired
    private PsZxjcProgrammeMapper psZxjcProgrammeMapper;

    /**
     * 查询排污单位自行监测方案
     *
     * @param id 排污单位自行监测方案主键
     * @return 排污单位自行监测方案
     */
    @Override
    public PsZxjcProgramme selectPsZxjcProgrammeById(Long id)
    {
        return psZxjcProgrammeMapper.selectPsZxjcProgrammeById(id);
    }

    /**
     * 查询排污单位自行监测方案列表
     *
     * @param psZxjcProgramme 排污单位自行监测方案
     * @return 排污单位自行监测方案
     */
    @Override
    public List<PsZxjcProgramme> selectPsZxjcProgrammeList(PsZxjcProgramme psZxjcProgramme)
    {
        return psZxjcProgrammeMapper.selectPsZxjcProgrammeList(psZxjcProgramme);
    }

    /**
     * 新增排污单位自行监测方案
     *
     * @param psZxjcProgramme 排污单位自行监测方案
     * @return 结果
     */
    @Override
    public int insertPsZxjcProgramme(PsZxjcProgramme psZxjcProgramme)
    {
        return psZxjcProgrammeMapper.insertPsZxjcProgramme(psZxjcProgramme);
    }

    /**
     * 修改排污单位自行监测方案
     *
     * @param psZxjcProgramme 排污单位自行监测方案
     * @return 结果
     */
    @Override
    public int updatePsZxjcProgramme(PsZxjcProgramme psZxjcProgramme)
    {
        return psZxjcProgrammeMapper.updatePsZxjcProgramme(psZxjcProgramme);
    }

    /**
     * 批量删除排污单位自行监测方案
     *
     * @param ids 需要删除的排污单位自行监测方案主键
     * @return 结果
     */
    @Override
    public int deletePsZxjcProgrammeByIds(Long[] ids)
    {
        return psZxjcProgrammeMapper.deletePsZxjcProgrammeByIds(ids);
    }

    /**
     * 删除排污单位自行监测方案信息
     *
     * @param id 排污单位自行监测方案主键
     * @return 结果
     */
    @Override
    public int deletePsZxjcProgrammeById(Long id)
    {
        return psZxjcProgrammeMapper.deletePsZxjcProgrammeById(id);
    }
}
