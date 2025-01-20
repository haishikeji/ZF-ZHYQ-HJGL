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
import com.px.base.domain.BHazardousWarehouseInfo;
import com.px.base.service.IBHazardousWarehouseInfoService;
import com.px.common.utils.poi.ExcelUtil;
import com.px.common.core.page.TableDataInfo;

/**
 * 危废仓库信息 Controller
 *
 * @author 品讯科技
 * @date 2024-08
 */
@RestController
@RequestMapping("/admin_api/hazardous_warehouse")
public class BHazardousWarehouseInfoController extends BaseController
{
    @Autowired
    private IBHazardousWarehouseInfoService bHazardousWarehouseInfoService;

    /**
     * 查询危废仓库信息 列表
     */
    @PreAuthorize("@ss.hasPermi('admin_api:hazardous_warehouse:list')")
    @GetMapping("/list")
    public TableDataInfo list(BHazardousWarehouseInfo bHazardousWarehouseInfo)
    {
        startPage();
        List<BHazardousWarehouseInfo> list = bHazardousWarehouseInfoService.selectBHazardousWarehouseInfoList(bHazardousWarehouseInfo);
        return getDataTable(list);
    }

    /**
     * 导出危废仓库信息 列表
     */
    @PreAuthorize("@ss.hasPermi('admin_api:hazardous_warehouse:export')")
    @Log(title = "危废仓库信息 ", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BHazardousWarehouseInfo bHazardousWarehouseInfo)
    {
        List<BHazardousWarehouseInfo> list = bHazardousWarehouseInfoService.selectBHazardousWarehouseInfoList(bHazardousWarehouseInfo);
        ExcelUtil<BHazardousWarehouseInfo> util = new ExcelUtil<BHazardousWarehouseInfo>(BHazardousWarehouseInfo.class);
        util.exportExcel(response, list, "危废仓库信息 数据");
    }

    /**
     * 获取危废仓库信息 详细信息
     */
    @PreAuthorize("@ss.hasPermi('admin_api:hazardous_warehouse:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(bHazardousWarehouseInfoService.selectBHazardousWarehouseInfoById(id));
    }

    /**
     * 新增危废仓库信息
     */
    @PreAuthorize("@ss.hasPermi('admin_api:hazardous_warehouse:add')")
    @Log(title = "危废仓库信息 ", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BHazardousWarehouseInfo bHazardousWarehouseInfo)
    {
        return toAjax(bHazardousWarehouseInfoService.insertBHazardousWarehouseInfo(bHazardousWarehouseInfo));
    }

    /**
     * 修改危废仓库信息
     */
    @PreAuthorize("@ss.hasPermi('admin_api:hazardous_warehouse:edit')")
    @Log(title = "危废仓库信息 ", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BHazardousWarehouseInfo bHazardousWarehouseInfo)
    {
        return toAjax(bHazardousWarehouseInfoService.updateBHazardousWarehouseInfo(bHazardousWarehouseInfo));
    }

    /**
     * 删除危废仓库信息
     */
    @PreAuthorize("@ss.hasPermi('admin_api:hazardous_warehouse:remove')")
    @Log(title = "危废仓库信息 ", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(bHazardousWarehouseInfoService.deleteBHazardousWarehouseInfoByIds(ids));
    }

    /**
    * 查询危废仓库不分页
    */
    @PreAuthorize("@ss.hasPermi('admin_api:hazardous_warehouse:list')")
    @PostMapping("/listNotPage")
    public AjaxResult listNotPage(BHazardousWarehouseInfo bHazardousWarehouseInfo)
    {
        return success(bHazardousWarehouseInfoService.selectBHazardousWarehouseInfoList(bHazardousWarehouseInfo));
    }
}

