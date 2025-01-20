package com.px.web.controller.screenapi;

/**
 * 大屏统计空气质量记录Controller
 *
 * @author 品讯科技
 * @date 2024-08
 */

import com.px.base.domain.BAirQualityRecord;
import com.px.base.domain.vo.ParkYearAirQualityVO;
import com.px.base.service.IBAirQualityRecordService;
import com.px.common.core.domain.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/screen_api/airQualityRecord")
public class SAirQualityRecordController {

    @Autowired
    IBAirQualityRecordService bAirQualityRecordService;

    /**
     * 大屏总驾驶仓统计园区空气质量接口
     */
    @PostMapping("/parkAirQuality")
    public AjaxResult parkAirQuality(@RequestBody Map<String, Object> data) {
        Map<String, Object> map = new HashMap<>();
        // 获取全年统计数据
        map.put("startTime", data.get("yearStartTime"));
        map.put("endTime", data.get("yearEndTime"));
        List<ParkYearAirQualityVO> parkYearAirQualityList = bAirQualityRecordService.parkYearAirQuality(map);

        // 获取天数据
        map.put("startTime", data.get("dayStartTime"));
        map.put("endTime", data.get("dayEndTime"));
        List<BAirQualityRecord> bAirQualityRecordList = bAirQualityRecordService.selectBAirQualityRecordByTime(map);

        return AjaxResult.success()
                .put("parkYearAirQualityList", parkYearAirQualityList)
                .put("bAirQualityRecordList", bAirQualityRecordList);
    }
}
