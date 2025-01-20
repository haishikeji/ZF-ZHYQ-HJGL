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
import com.px.base.domain.BMonitorFactorInfo;
import com.px.base.service.IBMonitorFactorInfoService;
import com.px.common.utils.poi.ExcelUtil;
import com.px.common.core.page.TableDataInfo;

/**
 * 监测因子编码Controller
 *
 * @author 品讯科技
 * @date 2024-08
 */
@RestController
@RequestMapping("/admin_api/monitor_factor")
public class BMonitorFactorInfoController extends BaseController
{
    @Autowired
    private IBMonitorFactorInfoService bMonitorFactorInfoService;

    /**
     * 查询监测因子编码列表
     */
    @PreAuthorize("@ss.hasPermi('admin_api:monitor_factor:list')")
    @GetMapping("/list")
    public TableDataInfo list(BMonitorFactorInfo bMonitorFactorInfo)
    {
        startPage();
        List<BMonitorFactorInfo> list = bMonitorFactorInfoService.selectBMonitorFactorInfoList(bMonitorFactorInfo);
        return getDataTable(list);
    }

    /**
     * 查询监测因子编码列表不分页
     */
    @PostMapping("/listNotPage")
    public AjaxResult listNotPage(@RequestBody BMonitorFactorInfo bMonitorFactorInfo)
    {
        List<BMonitorFactorInfo> list = bMonitorFactorInfoService.selectBMonitorFactorInfoList(bMonitorFactorInfo);
        return AjaxResult.success(list);
    }

    /**
     * 导出监测因子编码列表
     */
    @PreAuthorize("@ss.hasPermi('admin_api:monitor_factor:export')")
    @Log(title = "监测因子编码", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BMonitorFactorInfo bMonitorFactorInfo)
    {
        List<BMonitorFactorInfo> list = bMonitorFactorInfoService.selectBMonitorFactorInfoList(bMonitorFactorInfo);
        ExcelUtil<BMonitorFactorInfo> util = new ExcelUtil<BMonitorFactorInfo>(BMonitorFactorInfo.class);
        util.exportExcel(response, list, "监测因子编码数据");
    }

    /**
     * 获取监测因子编码详细信息
     */
    @PreAuthorize("@ss.hasPermi('admin_api:monitor_factor:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(bMonitorFactorInfoService.selectBMonitorFactorInfoById(id));
    }

    /**
     * 新增监测因子编码
     */
    @PreAuthorize("@ss.hasPermi('admin_api:monitor_factor:add')")
    @Log(title = "监测因子编码", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BMonitorFactorInfo bMonitorFactorInfo)
    {
        return toAjax(bMonitorFactorInfoService.insertBMonitorFactorInfo(bMonitorFactorInfo));
    }

    /**
     * 修改监测因子编码
     */
    @PreAuthorize("@ss.hasPermi('admin_api:monitor_factor:edit')")
    @Log(title = "监测因子编码", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BMonitorFactorInfo bMonitorFactorInfo)
    {
        return toAjax(bMonitorFactorInfoService.updateBMonitorFactorInfo(bMonitorFactorInfo));
    }

    /**
     * 删除监测因子编码
     */
    @PreAuthorize("@ss.hasPermi('admin_api:monitor_factor:remove')")
    @Log(title = "监测因子编码", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(bMonitorFactorInfoService.deleteBMonitorFactorInfoByIds(ids));
    }
}
