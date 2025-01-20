package com.px.biz.mapper;

import java.util.List;
import com.px.biz.domain.RHeartbeat;

/**
 * 心跳Mapper接口
 * 
 * @author 品讯科技
 * @date 2024-08
 */
public interface RHeartbeatMapper 
{
    /**
     * 查询心跳
     * 
     * @param enterpriseCode 心跳主键
     * @return 心跳
     */
    public RHeartbeat selectRHeartbeatByEnterpriseCode(String enterpriseCode);

    /**
     * 查询心跳列表
     * 
     * @param rHeartbeat 心跳
     * @return 心跳集合
     */
    public List<RHeartbeat> selectRHeartbeatList(RHeartbeat rHeartbeat);

    /**
     * 新增心跳
     * 
     * @param rHeartbeat 心跳
     * @return 结果
     */
    public int insertRHeartbeat(RHeartbeat rHeartbeat);

    /**
     * 修改心跳
     * 
     * @param rHeartbeat 心跳
     * @return 结果
     */
    public int updateRHeartbeat(RHeartbeat rHeartbeat);

    /**
     * 删除心跳
     * 
     * @param enterpriseCode 心跳主键
     * @return 结果
     */
    public int deleteRHeartbeatByEnterpriseCode(String enterpriseCode);

    /**
     * 批量删除心跳
     * 
     * @param enterpriseCodes 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteRHeartbeatByEnterpriseCodes(String[] enterpriseCodes);
}
