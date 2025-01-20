package com.px.base.mapper;

import com.px.base.domain.BMicrostationMetiscInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @@author 品讯科技
 * @ClassName: BMicrostationMetiscMapper
 * @CreateDate: 2024年08月02日 14:06
 * @Description: 空气微站因子实时数据Mapper层
 */
@Mapper
public interface BMicrostationMetiscMapper {
    /**
     * 查询空气微站因子实时数据
     *
     * @param map 参数
     * @return 空气微站因子实时数据
     */
    public List<BMicrostationMetiscInfo> selectBMicrostationMetiscInfoList(Map<String, Object> map);

    /**
     * 查看空气微站因子小时数据
     * @param map
     * @return
     */

    public List<BMicrostationMetiscInfo> selectBMicrostationMetiscInfoListHourlydata(Map<String, Object> map);

    /**
     * 查看空气微站日数据
     * @param map
     * @return
     */
    public List<BMicrostationMetiscInfo> selectBMicrostationMetiscInfoListDailydata(Map<String, Object> map);

    /**
     * 查看空气微站平均值
     * @param map
     * @return
     */
    List<BMicrostationMetiscInfo> selectBMicrostationInfoListAvgData(Map<String, Object> map);
}
