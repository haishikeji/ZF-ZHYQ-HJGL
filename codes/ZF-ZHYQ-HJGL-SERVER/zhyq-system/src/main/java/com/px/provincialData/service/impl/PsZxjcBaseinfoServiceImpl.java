package com.px.provincialData.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.px.provincialData.mapper.PsZxjcBaseinfoMapper;
import com.px.provincialData.domain.PsZxjcBaseinfo;
import com.px.provincialData.service.IPsZxjcBaseinfoService;

/**
 * 排污单位自行监测基础Service业务层处理
 *
 * @author 品讯科技
 * @date 2024-08
 */
@Service
public class PsZxjcBaseinfoServiceImpl implements IPsZxjcBaseinfoService
{
    @Autowired
    private PsZxjcBaseinfoMapper psZxjcBaseinfoMapper;

    /**
     * 查询排污单位自行监测基础
     *
     * @param id 排污单位自行监测基础主键
     * @return 排污单位自行监测基础
     */
    @Override
    public PsZxjcBaseinfo selectPsZxjcBaseinfoById(Long id)
    {
        return psZxjcBaseinfoMapper.selectPsZxjcBaseinfoById(id);
    }

    /**
     * 查询排污单位自行监测基础列表
     *
     * @param psZxjcBaseinfo 排污单位自行监测基础
     * @return 排污单位自行监测基础
     */
    @Override
    public List<PsZxjcBaseinfo> selectPsZxjcBaseinfoList(PsZxjcBaseinfo psZxjcBaseinfo)
    {
        return psZxjcBaseinfoMapper.selectPsZxjcBaseinfoList(psZxjcBaseinfo);
    }

    /**
     * 新增排污单位自行监测基础
     *
     * @param psZxjcBaseinfo 排污单位自行监测基础
     * @return 结果
     */
    @Override
    public int insertPsZxjcBaseinfo(PsZxjcBaseinfo psZxjcBaseinfo)
    {
        return psZxjcBaseinfoMapper.insertPsZxjcBaseinfo(psZxjcBaseinfo);
    }

    /**
     * 修改排污单位自行监测基础
     *
     * @param psZxjcBaseinfo 排污单位自行监测基础
     * @return 结果
     */
    @Override
    public int updatePsZxjcBaseinfo(PsZxjcBaseinfo psZxjcBaseinfo)
    {
        return psZxjcBaseinfoMapper.updatePsZxjcBaseinfo(psZxjcBaseinfo);
    }

    /**
     * 批量删除排污单位自行监测基础
     *
     * @param ids 需要删除的排污单位自行监测基础主键
     * @return 结果
     */
    @Override
    public int deletePsZxjcBaseinfoByIds(Long[] ids)
    {
        return psZxjcBaseinfoMapper.deletePsZxjcBaseinfoByIds(ids);
    }

    /**
     * 删除排污单位自行监测基础信息
     *
     * @param id 排污单位自行监测基础主键
     * @return 结果
     */
    @Override
    public int deletePsZxjcBaseinfoById(Long id)
    {
        return psZxjcBaseinfoMapper.deletePsZxjcBaseinfoById(id);
    }
}
