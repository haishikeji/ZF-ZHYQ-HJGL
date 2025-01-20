package com.px.web.controller.adminapi.provincialData;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.px.common.annotation.Log;
import com.px.common.core.controller.BaseController;
import com.px.common.core.domain.AjaxResult;
import com.px.common.enums.BusinessType;
import com.px.provincialData.domain.PwxkDischargeWaterPortInfoDirect;
import com.px.provincialData.service.IPwxkDischargeWaterPortInfoDirectService;
import com.px.common.utils.poi.ExcelUtil;
import com.px.common.core.page.TableDataInfo;

/**
 * 水污染物排放口信息Controller
 *
 * @author 品讯科技
 * @date 2024-08
 */
@RestController
@RequestMapping("/admin_api/dischargeWaterPortInfoDirect")
public class PwxkDischargeWaterPortInfoDirectController extends BaseController
{
    @Autowired
    private IPwxkDischargeWaterPortInfoDirectService pwxkDischargeWaterPortInfoDirectService;

    /**
     * 查询水污染物排放口信息列表
     */
    @PreAuthorize("@ss.hasPermi('admin_api:dischargeWaterPortInfoDirect:list')")
    @GetMapping("/list")
    public TableDataInfo list(PwxkDischargeWaterPortInfoDirect pwxkDischargeWaterPortInfoDirect)
    {
        startPage();
        List<PwxkDischargeWaterPortInfoDirect> list = pwxkDischargeWaterPortInfoDirectService.selectPwxkDischargeWaterPortInfoDirectList(pwxkDischargeWaterPortInfoDirect);
        return getDataTable(list);
    }

    /**
     * 导出水污染物排放口信息列表
     */
    @PreAuthorize("@ss.hasPermi('admin_api:dischargeWaterPortInfoDirect:export')")
    @Log(title = "水污染物排放口信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PwxkDischargeWaterPortInfoDirect pwxkDischargeWaterPortInfoDirect)
    {
        List<PwxkDischargeWaterPortInfoDirect> list = pwxkDischargeWaterPortInfoDirectService.selectPwxkDischargeWaterPortInfoDirectList(pwxkDischargeWaterPortInfoDirect);
        ExcelUtil<PwxkDischargeWaterPortInfoDirect> util = new ExcelUtil<PwxkDischargeWaterPortInfoDirect>(PwxkDischargeWaterPortInfoDirect.class);
        util.exportExcel(response, list, "水污染物排放口信息数据");
    }

    /**
     * 获取水污染物排放口信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('admin_api:dischargeWaterPortInfoDirect:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(pwxkDischargeWaterPortInfoDirectService.selectPwxkDischargeWaterPortInfoDirectById(id));
    }

    /**
     * 新增水污染物排放口信息
     */
    @PreAuthorize("@ss.hasPermi('admin_api:dischargeWaterPortInfoDirect:add')")
    @Log(title = "水污染物排放口信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PwxkDischargeWaterPortInfoDirect pwxkDischargeWaterPortInfoDirect)
    {
        return toAjax(pwxkDischargeWaterPortInfoDirectService.insertPwxkDischargeWaterPortInfoDirect(pwxkDischargeWaterPortInfoDirect));
    }

    /**
     * 修改水污染物排放口信息
     */
    @PreAuthorize("@ss.hasPermi('admin_api:dischargeWaterPortInfoDirect:edit')")
    @Log(title = "水污染物排放口信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PwxkDischargeWaterPortInfoDirect pwxkDischargeWaterPortInfoDirect)
    {
        return toAjax(pwxkDischargeWaterPortInfoDirectService.updatePwxkDischargeWaterPortInfoDirect(pwxkDischargeWaterPortInfoDirect));
    }

    /**
     * 删除水污染物排放口信息
     */
    @PreAuthorize("@ss.hasPermi('admin_api:dischargeWaterPortInfoDirect:remove')")
    @Log(title = "水污染物排放口信息", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(pwxkDischargeWaterPortInfoDirectService.deletePwxkDischargeWaterPortInfoDirectByIds(ids));
    }
}
