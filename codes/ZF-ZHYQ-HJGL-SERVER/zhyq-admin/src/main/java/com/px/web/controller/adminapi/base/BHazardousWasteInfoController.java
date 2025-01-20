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
import com.px.base.domain.BHazardousWasteInfo;
import com.px.base.service.IBHazardousWasteInfoService;
import com.px.common.utils.poi.ExcelUtil;
import com.px.common.core.page.TableDataInfo;

/**
 * 危废信息Controller
 *
 * @author 品讯科技
 * @date 2024-08
 */
@RestController
@RequestMapping("/admin_api/hazardous_waste")
public class BHazardousWasteInfoController extends BaseController
{
    @Autowired
    private IBHazardousWasteInfoService bHazardousWasteInfoService;

    /**
     * 查询危废信息列表
     */
    @PreAuthorize("@ss.hasPermi('admin_api:hazardous_waste:list')")
    @GetMapping("/list")
    public TableDataInfo list(BHazardousWasteInfo bHazardousWasteInfo)
    {
        startPage();
        List<BHazardousWasteInfo> list = bHazardousWasteInfoService.selectBHazardousWasteInfoList(bHazardousWasteInfo);
        return getDataTable(list);
    }

    /** 查询危废信息不分页 */
    @PostMapping("/listNotPage")
    public AjaxResult listNotPage(@RequestBody BHazardousWasteInfo bHazardousWasteInfo)
    {
        List<BHazardousWasteInfo> list = bHazardousWasteInfoService.selectBHazardousWasteInfoList(bHazardousWasteInfo);
        return success(list);
    }

    /**
     * 导出危废信息列表
     */
    @PreAuthorize("@ss.hasPermi('admin_api:hazardous_waste:export')")
    @Log(title = "危废信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BHazardousWasteInfo bHazardousWasteInfo)
    {
        List<BHazardousWasteInfo> list = bHazardousWasteInfoService.selectBHazardousWasteInfoExport(bHazardousWasteInfo);
        ExcelUtil<BHazardousWasteInfo> util = new ExcelUtil<BHazardousWasteInfo>(BHazardousWasteInfo.class);
        util.exportExcel(response, list, "危废信息数据");
    }

    /**
     * 获取危废信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('admin_api:hazardous_waste:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(bHazardousWasteInfoService.selectBHazardousWasteInfoById(id));
    }

    /**
     * 新增危废信息
     */
    @PreAuthorize("@ss.hasPermi('admin_api:hazardous_waste:add')")
    @Log(title = "危废信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BHazardousWasteInfo bHazardousWasteInfo)
    {
        return toAjax(bHazardousWasteInfoService.insertBHazardousWasteInfo(bHazardousWasteInfo));
    }

    /**
     * 修改危废信息
     */
    @PreAuthorize("@ss.hasPermi('admin_api:hazardous_waste:edit')")
    @Log(title = "危废信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BHazardousWasteInfo bHazardousWasteInfo)
    {
        return toAjax(bHazardousWasteInfoService.updateBHazardousWasteInfo(bHazardousWasteInfo));
    }

    /**
     * 删除危废信息
     */
    @PreAuthorize("@ss.hasPermi('admin_api:hazardous_waste:remove')")
    @Log(title = "危废信息", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(bHazardousWasteInfoService.deleteBHazardousWasteInfoByIds(ids));
    }
}

