package com.px.base.service;

import java.util.List;
import com.px.base.domain.BStopLimitProduct;

/**
 * 停产与限产信息Service接口
 *
 * @author 品讯科技
 * @date 2024-08
 */
public interface IBStopLimitProductService
{
    /**
     * 查询停产与限产信息
     *
     * @param id 停产与限产信息主键
     * @return 停产与限产信息
     */
    public BStopLimitProduct selectBStopLimitProductById(Long id);

    /**
     * 查询停产与限产信息列表
     *
     * @param bStopLimitProduct 停产与限产信息
     * @return 停产与限产信息集合
     */
    public List<BStopLimitProduct> selectBStopLimitProductList(BStopLimitProduct bStopLimitProduct);

    /**
     * 新增停产与限产信息
     *
     * @param bStopLimitProduct 停产与限产信息
     * @return 结果
     */
    public int insertBStopLimitProduct(BStopLimitProduct bStopLimitProduct);

    /**
     * 修改停产与限产信息
     *
     * @param bStopLimitProduct 停产与限产信息
     * @return 结果
     */
    public int updateBStopLimitProduct(BStopLimitProduct bStopLimitProduct);

    /**
     * 批量删除停产与限产信息
     *
     * @param ids 需要删除的停产与限产信息主键集合
     * @return 结果
     */
    public int deleteBStopLimitProductByIds(Long[] ids);

    /**
     * 删除停产与限产信息信息
     *
     * @param id 停产与限产信息主键
     * @return 结果
     */
    public int deleteBStopLimitProductById(Long id);
}

