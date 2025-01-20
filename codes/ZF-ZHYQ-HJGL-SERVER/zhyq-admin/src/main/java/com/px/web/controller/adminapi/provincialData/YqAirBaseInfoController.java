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
import com.px.provincialData.domain.YqAirBaseInfo;
import com.px.provincialData.service.IYqAirBaseInfoService;
import com.px.common.utils.poi.ExcelUtil;
import com.px.common.core.page.TableDataInfo;

/**
 * 园区空气质量监测点基本信息Controller
 *
 * @author 品讯科技
 * @date 2024-08
 */
@RestController
@RequestMapping("/admin_api/yqAirBaseInfo")
public class YqAirBaseInfoController extends BaseController
{
    @Autowired
    private IYqAirBaseInfoService yqAirBaseInfoService;

    /**
     * 查询园区空气质量监测点基本信息列表
     */
    @PreAuthorize("@ss.hasPermi('admin_api:yqAirBaseInfo:list')")
    @GetMapping("/list")
    public TableDataInfo list(YqAirBaseInfo yqAirBaseInfo)
    {
        startPage();
        List<YqAirBaseInfo> list = yqAirBaseInfoService.selectYqAirBaseInfoList(yqAirBaseInfo);
        return getDataTable(list);
    }

    /**
     * 导出园区空气质量监测点基本信息列表
     */
    @PreAuthorize("@ss.hasPermi('admin_api:yqAirBaseInfo:export')")
    @Log(title = "园区空气质量监测点基本信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, YqAirBaseInfo yqAirBaseInfo)
    {
        List<YqAirBaseInfo> list = yqAirBaseInfoService.selectYqAirBaseInfoList(yqAirBaseInfo);
        ExcelUtil<YqAirBaseInfo> util = new ExcelUtil<YqAirBaseInfo>(YqAirBaseInfo.class);
        util.exportExcel(response, list, "园区空气质量监测点基本信息数据");
    }

    /**
     * 获取园区空气质量监测点基本信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('admin_api:yqAirBaseInfo:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(yqAirBaseInfoService.selectYqAirBaseInfoById(id));
    }

    /**
     * 新增园区空气质量监测点基本信息
     */
    @PreAuthorize("@ss.hasPermi('admin_api:yqAirBaseInfo:add')")
    @Log(title = "园区空气质量监测点基本信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody YqAirBaseInfo yqAirBaseInfo)
    {
        return toAjax(yqAirBaseInfoService.insertYqAirBaseInfo(yqAirBaseInfo));
    }

    /**
     * 修改园区空气质量监测点基本信息
     */
    @PreAuthorize("@ss.hasPermi('admin_api:yqAirBaseInfo:edit')")
    @Log(title = "园区空气质量监测点基本信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody YqAirBaseInfo yqAirBaseInfo)
    {
        return toAjax(yqAirBaseInfoService.updateYqAirBaseInfo(yqAirBaseInfo));
    }

    /**
     * 删除园区空气质量监测点基本信息
     */
    @PreAuthorize("@ss.hasPermi('admin_api:yqAirBaseInfo:remove')")
    @Log(title = "园区空气质量监测点基本信息", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(yqAirBaseInfoService.deleteYqAirBaseInfoByIds(ids));
    }
}
