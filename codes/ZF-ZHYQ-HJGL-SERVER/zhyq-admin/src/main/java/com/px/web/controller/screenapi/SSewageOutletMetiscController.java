package com.px.web.controller.screenapi;

import com.px.base.domain.RMicrostationFactorInfo;
import com.px.biz.domain.BSewageOutletMetiscRecords;
import com.px.biz.service.IBSewageOutletMetricsRecordsService;
import com.px.common.core.controller.BaseController;
import com.px.common.core.domain.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 空气微站信息Controller
 *
 * @author 品讯科技
 * @date 2024-08
 */
@RestController
@RequestMapping("/screen_api/sewage_outlet")
public class SSewageOutletMetiscController extends BaseController
{

    @Autowired
    private IBSewageOutletMetricsRecordsService ibSewageOutletMetricsRecordsService;


    /**
     * 查询空气微站实时检测信息列表
     */
    @GetMapping("/runInfo")
    public AjaxResult airMicrostationList(RMicrostationFactorInfo rMicrostationFactorInfo){
        // 查询空气微站列表
        List<BSewageOutletMetiscRecords> recordsList = ibSewageOutletMetricsRecordsService.selectBSewageOutletMetricsRecordsList(null);

        //返回实时数据和污染因子信息
        return AjaxResult.success().put("recordsList",recordsList);
    }

}
