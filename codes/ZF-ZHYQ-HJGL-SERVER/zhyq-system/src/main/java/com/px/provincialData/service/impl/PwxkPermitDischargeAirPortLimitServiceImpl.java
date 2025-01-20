package com.px.provincialData.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.px.provincialData.mapper.PwxkPermitDischargeAirPortLimitMapper;
import com.px.provincialData.domain.PwxkPermitDischargeAirPortLimit;
import com.px.provincialData.service.IPwxkPermitDischargeAirPortLimitService;

/**
 * 废气污染物许可限值Service业务层处理
 *
 * @author 品讯科技
 * @date 2024-08
 */
@Service
public class PwxkPermitDischargeAirPortLimitServiceImpl implements IPwxkPermitDischargeAirPortLimitService
{
    @Autowired
    private PwxkPermitDischargeAirPortLimitMapper pwxkPermitDischargeAirPortLimitMapper;

    /**
     * 查询废气污染物许可限值
     *
     * @param id 废气污染物许可限值主键
     * @return 废气污染物许可限值
     */
    @Override
    public PwxkPermitDischargeAirPortLimit selectPwxkPermitDischargeAirPortLimitById(Long id)
    {
        return pwxkPermitDischargeAirPortLimitMapper.selectPwxkPermitDischargeAirPortLimitById(id);
    }

    /**
     * 查询废气污染物许可限值列表
     *
     * @param pwxkPermitDischargeAirPortLimit 废气污染物许可限值
     * @return 废气污染物许可限值
     */
    @Override
    public List<PwxkPermitDischargeAirPortLimit> selectPwxkPermitDischargeAirPortLimitList(PwxkPermitDischargeAirPortLimit pwxkPermitDischargeAirPortLimit)
    {
        return pwxkPermitDischargeAirPortLimitMapper.selectPwxkPermitDischargeAirPortLimitList(pwxkPermitDischargeAirPortLimit);
    }

    /**
     * 新增废气污染物许可限值
     *
     * @param pwxkPermitDischargeAirPortLimit 废气污染物许可限值
     * @return 结果
     */
    @Override
    public int insertPwxkPermitDischargeAirPortLimit(PwxkPermitDischargeAirPortLimit pwxkPermitDischargeAirPortLimit)
    {
        return pwxkPermitDischargeAirPortLimitMapper.insertPwxkPermitDischargeAirPortLimit(pwxkPermitDischargeAirPortLimit);
    }

    /**
     * 修改废气污染物许可限值
     *
     * @param pwxkPermitDischargeAirPortLimit 废气污染物许可限值
     * @return 结果
     */
    @Override
    public int updatePwxkPermitDischargeAirPortLimit(PwxkPermitDischargeAirPortLimit pwxkPermitDischargeAirPortLimit)
    {
        return pwxkPermitDischargeAirPortLimitMapper.updatePwxkPermitDischargeAirPortLimit(pwxkPermitDischargeAirPortLimit);
    }

    /**
     * 批量删除废气污染物许可限值
     *
     * @param ids 需要删除的废气污染物许可限值主键
     * @return 结果
     */
    @Override
    public int deletePwxkPermitDischargeAirPortLimitByIds(Long[] ids)
    {
        return pwxkPermitDischargeAirPortLimitMapper.deletePwxkPermitDischargeAirPortLimitByIds(ids);
    }

    /**
     * 删除废气污染物许可限值信息
     *
     * @param id 废气污染物许可限值主键
     * @return 结果
     */
    @Override
    public int deletePwxkPermitDischargeAirPortLimitById(Long id)
    {
        return pwxkPermitDischargeAirPortLimitMapper.deletePwxkPermitDischargeAirPortLimitById(id);
    }
}
