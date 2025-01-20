package com.px.biz.mapper;

import com.px.biz.domain.BWxUserInfo;

import java.util.List;

/**
 * 微信用户信息Mapper接口
 *
 * @author 品讯科技
 * @date 2024-08
 */
public interface BWxUserInfoMapper
{
    /**
     * 查询微信用户信息
     *
     * @param id 微信用户信息主键
     * @return 微信用户信息
     */
    public BWxUserInfo selectBWxUserInfoById(Long id);

    /**
     * 查询微信用户信息列表
     *
     * @param bWxUserInfo 微信用户信息
     * @return 微信用户信息集合
     */
    public List<BWxUserInfo> selectBWxUserInfoList(BWxUserInfo bWxUserInfo);

    /**
     * 新增微信用户信息
     *
     * @param bWxUserInfo 微信用户信息
     * @return 结果
     */
    public int insertBWxUserInfo(BWxUserInfo bWxUserInfo);

    /**
     * 修改微信用户信息
     *
     * @param bWxUserInfo 微信用户信息
     * @return 结果
     */
    public int updateBWxUserInfo(BWxUserInfo bWxUserInfo);

    /**
     * 删除微信用户信息
     *
     * @param id 微信用户信息主键
     * @return 结果
     */
    public int deleteBWxUserInfoById(Long id);

    /**
     * 批量删除微信用户信息
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBWxUserInfoByIds(Long[] ids);

    public BWxUserInfo queryByWxUserCode(String wxUserId);

    public BWxUserInfo queryByUserName(String userName);

    public int deleteWxUserInfo(Long[] ids);
}
