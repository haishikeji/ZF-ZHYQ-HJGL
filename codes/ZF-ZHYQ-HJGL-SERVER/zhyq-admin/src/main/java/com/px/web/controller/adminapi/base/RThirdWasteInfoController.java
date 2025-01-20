package com.px.web.controller.adminapi.base;

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
import com.px.base.domain.RThirdWasteInfo;
import com.px.base.service.IRThirdWasteInfoService;
import com.px.common.utils.poi.ExcelUtil;
import com.px.common.core.page.TableDataInfo;

/**
 * 第三方处置与废弃物关系Controller
 *
 * @author 品讯科技
 * @date 2024-08
 */
@RestController
@RequestMapping("/admin_api/third_waste")
public class RThirdWasteInfoController extends BaseController
{
    @Autowired
    private IRThirdWasteInfoService rThirdWasteInfoService;

    /**
     * 查询第三方处置与废弃物关系列表
     */
    @PreAuthorize("@ss.hasPermi('admin_api:third_waste:list')")
    @GetMapping("/list")
    public TableDataInfo list(RThirdWasteInfo rThirdWasteInfo)
    {
        startPage();
        List<RThirdWasteInfo> list = rThirdWasteInfoService.selectRThirdWasteInfoList(rThirdWasteInfo);
        return getDataTable(list);
    }

    /**
     * 导出第三方处置与废弃物关系列表
     */
    @PreAuthorize("@ss.hasPermi('admin_api:third_waste:export')")
    @Log(title = "第三方处置与废弃物关系", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, RThirdWasteInfo rThirdWasteInfo)
    {
        List<RThirdWasteInfo> list = rThirdWasteInfoService.selectRThirdWasteInfoList(rThirdWasteInfo);
        ExcelUtil<RThirdWasteInfo> util = new ExcelUtil<RThirdWasteInfo>(RThirdWasteInfo.class);
        util.exportExcel(response, list, "第三方处置与废弃物关系数据");
    }

    /**
     * 获取第三方处置与废弃物关系详细信息
     */
    @PreAuthorize("@ss.hasPermi('admin_api:third_waste:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(rThirdWasteInfoService.selectRThirdWasteInfoById(id));
    }

    /**
     * 新增第三方处置与废弃物关系
     */
    @PreAuthorize("@ss.hasPermi('admin_api:third_waste:add')")
    @Log(title = "第三方处置与废弃物关系", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody RThirdWasteInfo rThirdWasteInfo)
    {
        return toAjax(rThirdWasteInfoService.insertRThirdWasteInfo(rThirdWasteInfo));
    }

    /**
     * 修改第三方处置与废弃物关系
     */
    @PreAuthorize("@ss.hasPermi('admin_api:third_waste:edit')")
    @Log(title = "第三方处置与废弃物关系", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody RThirdWasteInfo rThirdWasteInfo)
    {
        return toAjax(rThirdWasteInfoService.updateRThirdWasteInfo(rThirdWasteInfo));
    }

    /**
     * 删除第三方处置与废弃物关系
     */
    @PreAuthorize("@ss.hasPermi('admin_api:third_waste:remove')")
    @Log(title = "第三方处置与废弃物关系", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(rThirdWasteInfoService.deleteRThirdWasteInfoByIds(ids));
    }
}
