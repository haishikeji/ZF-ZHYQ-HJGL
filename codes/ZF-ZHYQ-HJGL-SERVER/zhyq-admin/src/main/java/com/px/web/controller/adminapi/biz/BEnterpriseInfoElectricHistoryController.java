package com.px.web.controller.adminapi.biz;

import com.px.biz.domain.BElectricMetiscEnterpriseInfo;
import com.px.biz.domain.BEnterpriseElectricHistory;
import com.px.biz.domain.dto.BElectricMetiscYqInfoRequestDTO;
import com.px.biz.service.IBElectricMetiscEnterpriseInfoService;
import com.px.biz.service.IBEnterpriseElectricHistoryService;
import com.px.common.core.controller.BaseController;
import com.px.common.core.domain.AjaxResult;
import com.px.common.core.page.TableDataInfo;
import com.px.common.utils.poi.ExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: BEnterpriseInfoElectricHistoryController
 * @Description: 企业用电监控日历史记录数据Controller
 */
@RestController
@RequestMapping("/admin_api/enterpriseElectricHistory")
public class BEnterpriseInfoElectricHistoryController extends BaseController {

    @Autowired
    private IBEnterpriseElectricHistoryService ibEnterpriseElectricHistoryService;

    @Autowired
    private IBElectricMetiscEnterpriseInfoService bElectricMetiscEnterpriseInfoService;


    /**
     * 查询企业日用电历史记录
     *
     * @param bEnterpriseElectricHistory 企业用电历史信息
     * @return 返回分页列表数据
     */
    @PreAuthorize("@ss.hasPermi('admin_api:enterpriseElectricHistory:list')")
    @GetMapping("/list")
    public TableDataInfo list(BEnterpriseElectricHistory bEnterpriseElectricHistory) {
        List<BEnterpriseElectricHistory> list = ibEnterpriseElectricHistoryService.selectBEnterpriseElectricHistoryList(bEnterpriseElectricHistory);
        return getDataTable(list);

    }


    // @PreAuthorize("@ss.hasPermi('admin_api:enterpriseElectricHistory:yearlist')")
    // 处理企业年数据查询的POST请求 他可以按照我昨天的要求返回指定月份的数据吗现在
    @PostMapping("/yearlist")
    public AjaxResult yearlist(@RequestBody BElectricMetiscYqInfoRequestDTO bElectricMetiscYqInfoRequestDTO) {
        // 查询并获取企业年电力消耗数据
        List<BEnterpriseElectricHistory> yearList = ibEnterpriseElectricHistoryService.selectAnnualElectricityConsumption(bElectricMetiscYqInfoRequestDTO);
        // 查询并获取企业本年月的每日电力消耗数据
        List<BEnterpriseElectricHistory> dayList = ibEnterpriseElectricHistoryService.selectDailyData(bElectricMetiscYqInfoRequestDTO);
        // 查询并获取企业月电力消耗数据
        List<BEnterpriseElectricHistory> mouthList = ibEnterpriseElectricHistoryService.selectMonthlyData(bElectricMetiscYqInfoRequestDTO);
        // 将查询到的数据列表处理后返回
        return success().put("yearList", yearList).put("dayList", dayList).put("mouthList", mouthList);
    }

    @PreAuthorize("@ss.hasPermi('admin_api:enterpriseElectricHistory:list')")
    // 处理企业年数据查询的POST请求
    public AjaxResult monthlist(@RequestBody BElectricMetiscYqInfoRequestDTO bElectricMetiscYqInfoRequestDTO) {
        // 查询并获取企业月电力消耗数据
        List<BEnterpriseElectricHistory> mouthList = ibEnterpriseElectricHistoryService.selectMonthlyData(bElectricMetiscYqInfoRequestDTO);
        // 将查询到的数据列表处理后返回
        return success().put("mouthList", mouthList);
    }

    //查询企业日用电监测
    @PostMapping("/dayList")
    public AjaxResult selectDayData(@RequestBody Map<String, Object> map) {
        List<BEnterpriseElectricHistory> dayList = ibEnterpriseElectricHistoryService.selectDayData(map);
        return success().put("dayList", dayList);
    }

    // 导出企业用电日数据
    @PreAuthorize("@ss.hasPermi('admin_api:enterpriseElectricHistory:export')")
    @PostMapping("/dailyExport")
    public void dailyExport(HttpServletResponse response, Map<String, Object> map) {
        // 调用服务层方法导出企业日用电信息列表为Excel文件
        List<BEnterpriseElectricHistory> dayList = ibEnterpriseElectricHistoryService.selectDayData(map);
        // 导出Excel文件，并设置文件名
        ExcelUtil<BEnterpriseElectricHistory> util = new ExcelUtil<BEnterpriseElectricHistory>(BEnterpriseElectricHistory.class);
        util.exportExcel(response, dayList, "企业用电日数据");
    }

    //查询企业月用电监测
    @PostMapping("/querymouthList")
    public AjaxResult selectMonthlyData(@RequestBody BElectricMetiscYqInfoRequestDTO bElectricMetiscYqInfoRequestDTO) {
        List<BEnterpriseElectricHistory> querymouthList = ibEnterpriseElectricHistoryService.selectMonthlyData(bElectricMetiscYqInfoRequestDTO);
        return success().put("querymouthList", querymouthList);
    }

    // 导出企业用电量月数据
    @PreAuthorize("@ss.hasPermi('admin_api:enterpriseElectricHistory:export')")
    @PostMapping("/monthlyExport")
    public void monthlyExport(HttpServletResponse response, BElectricMetiscYqInfoRequestDTO bElectricMetiscYqInfoRequestDTO) {
        // 调用服务层方法导出企业月用电信息列表为Excel文件
        List<BEnterpriseElectricHistory> querymouthList = ibEnterpriseElectricHistoryService.selectMonthlyData(bElectricMetiscYqInfoRequestDTO);
        // 导出Excel文件，并设置文件名
        ExcelUtil<BEnterpriseElectricHistory> util = new ExcelUtil<BEnterpriseElectricHistory>(BEnterpriseElectricHistory.class);
        util.exportExcel(response, querymouthList, "企业用电月数据");
    }

    //查询企业小时的用电监测
    @PostMapping("/hourlyData")
    public AjaxResult getHourlyData(@RequestBody BElectricMetiscYqInfoRequestDTO bElectricMetiscYqInfoRequestDTO) {
        String code = bElectricMetiscYqInfoRequestDTO.getEnterpriseCode();
        String tableName = "b_electric_recodes_" + bElectricMetiscYqInfoRequestDTO.getEnterpriseCode().substring(code.length() - 7);
        // 数据表是否在数据库中存在
        if (!bElectricMetiscEnterpriseInfoService.isTableExist(tableName)) {
            return AjaxResult.warn("企业未接入用电数据");
        }
        List<BElectricMetiscEnterpriseInfo> hourlyData = ibEnterpriseElectricHistoryService.getHourlyElectricityData(bElectricMetiscYqInfoRequestDTO, tableName);
        return success().put("hourlyData", hourlyData);
    }

    // 导出企业用电小时记录数据
    @PreAuthorize("@ss.hasPermi('admin_api:enterpriseElectricHistory:export')")
    @PostMapping("/hourlyExport")
    public void export(HttpServletResponse response, BElectricMetiscYqInfoRequestDTO bElectricMetiscYqInfoRequestDTO) {
        String code = bElectricMetiscYqInfoRequestDTO.getEnterpriseCode();
        String tableName = "b_electric_recodes_" + bElectricMetiscYqInfoRequestDTO.getEnterpriseCode().substring(code.length() - 7);
        ExcelUtil<BElectricMetiscEnterpriseInfo> util = new ExcelUtil<BElectricMetiscEnterpriseInfo>(BElectricMetiscEnterpriseInfo.class);
        // 数据表是否在数据库中存在
        if (!bElectricMetiscEnterpriseInfoService.isTableExist(tableName)) {
            util.exportExcel(response, null, "未接入用电数据");
        }
        List<BElectricMetiscEnterpriseInfo> list = ibEnterpriseElectricHistoryService.getHourlyElectricityData(bElectricMetiscYqInfoRequestDTO, tableName);
        util.exportExcel(response, list, "企业用电小时数据");
    }

    //查询企业年用电监测
    @PostMapping("/yearlyData")
    public AjaxResult queryYearlyData(@RequestBody BElectricMetiscYqInfoRequestDTO bElectricMetiscYqInfoRequestDTO) {
        List<BEnterpriseElectricHistory> yearlyList = ibEnterpriseElectricHistoryService.selectAnnualElectricityConsumption(bElectricMetiscYqInfoRequestDTO);
        return success().put("yearlyList", yearlyList);
    }

    // 导出企业用电量年数据
    @PreAuthorize("@ss.hasPermi('admin_api:enterpriseElectricHistory:export')")
    @PostMapping("/yearlyExport")
    public void yearlyExport(HttpServletResponse response, BElectricMetiscYqInfoRequestDTO bElectricMetiscYqInfoRequestDTO) {
        List<BEnterpriseElectricHistory> yearlyList = ibEnterpriseElectricHistoryService.selectAnnualElectricityConsumption(bElectricMetiscYqInfoRequestDTO);
        // 导出Excel文件，并设置文件名
        ExcelUtil<BEnterpriseElectricHistory> util = new ExcelUtil<BEnterpriseElectricHistory>(BEnterpriseElectricHistory.class);
        util.exportExcel(response, yearlyList, "企业用电年数据");
    }

}

