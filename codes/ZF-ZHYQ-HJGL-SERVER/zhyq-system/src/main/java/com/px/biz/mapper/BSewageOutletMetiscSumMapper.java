package com.px.biz.mapper;

import java.util.List;
import com.px.biz.domain.BSewageOutletMetiscSum;

/**
 * 【请填写功能名称】Mapper接口
 *
 * @author 品讯科技
 * @date 2024-08
 */
public interface BSewageOutletMetiscSumMapper
{
    /**
     * 查询【请填写功能名称】
     *
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public BSewageOutletMetiscSum selectBSewageOutletMetiscSumById(Long id);

    /**
     * 查询【请填写功能名称】列表
     *
     * @param bSewageOutletMetiscSum 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<BSewageOutletMetiscSum> selectBSewageOutletMetiscSumList(BSewageOutletMetiscSum bSewageOutletMetiscSum);

    /**
     * 新增【请填写功能名称】
     *
     * @param bSewageOutletMetiscSum 【请填写功能名称】
     * @return 结果
     */
    public int insertBSewageOutletMetiscSum(BSewageOutletMetiscSum bSewageOutletMetiscSum);

    /**
     * 修改【请填写功能名称】
     *
     * @param bSewageOutletMetiscSum 【请填写功能名称】
     * @return 结果
     */
    public int updateBSewageOutletMetiscSum(BSewageOutletMetiscSum bSewageOutletMetiscSum);

    /**
     * 删除【请填写功能名称】
     *
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteBSewageOutletMetiscSumById(Long id);

    /**
     * 批量删除【请填写功能名称】
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBSewageOutletMetiscSumByIds(Long[] ids);
}
