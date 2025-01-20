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
import com.px.base.domain.BThirdDisposalInfo;
import com.px.base.service.IBThirdDisposalInfoService;
import com.px.common.utils.poi.ExcelUtil;
import com.px.common.core.page.TableDataInfo;

/**
 * 固废与危废第三方处置信息Controller
 *
 * @author 品讯科技
 * @date 2024-08
 */
@RestController
@RequestMapping("/admin_api/third_disposal")
public class BThirdDisposalInfoController extends BaseController
{
    @Autowired
    private IBThirdDisposalInfoService bThirdDisposalInfoService;

    /**
     * 查询固废与危废第三方处置信息列表
     */
    @PreAuthorize("@ss.hasPermi('admin_api:third_disposal:list')")
    @GetMapping("/list")
    public TableDataInfo list(BThirdDisposalInfo bThirdDisposalInfo)
    {
        startPage();
        List<BThirdDisposalInfo> list = bThirdDisposalInfoService.selectBThirdDisposalInfoList(bThirdDisposalInfo);
        return getDataTable(list);
    }

    /**
     * 导出固废与危废第三方处置信息列表
     */
    @PreAuthorize("@ss.hasPermi('admin_api:third_disposal:export')")
    @Log(title = "固废与危废第三方处置信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BThirdDisposalInfo bThirdDisposalInfo)
    {
        List<BThirdDisposalInfo> list = bThirdDisposalInfoService.selectBThirdDisposalInfoList(bThirdDisposalInfo);
        ExcelUtil<BThirdDisposalInfo> util = new ExcelUtil<BThirdDisposalInfo>(BThirdDisposalInfo.class);
        util.exportExcel(response, list, "固废与危废第三方处置信息数据");
    }

    /**
     * 获取固废与危废第三方处置信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('admin_api:third_disposal:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(bThirdDisposalInfoService.selectBThirdDisposalInfoById(id));
    }

    /**
     * 新增固废与危废第三方处置信息
     */
    @PreAuthorize("@ss.hasPermi('admin_api:third_disposal:add')")
    @Log(title = "固废与危废第三方处置信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BThirdDisposalInfo bThirdDisposalInfo)
    {
        return toAjax(bThirdDisposalInfoService.insertBThirdDisposalInfo(bThirdDisposalInfo));
    }

    /**
     * 修改固废与危废第三方处置信息
     */
    @PreAuthorize("@ss.hasPermi('admin_api:third_disposal:edit')")
    @Log(title = "固废与危废第三方处置信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BThirdDisposalInfo bThirdDisposalInfo)
    {
        return toAjax(bThirdDisposalInfoService.updateBThirdDisposalInfo(bThirdDisposalInfo));
    }

    /**
     * 删除固废与危废第三方处置信息
     */
    @PreAuthorize("@ss.hasPermi('admin_api:third_disposal:remove')")
    @Log(title = "固废与危废第三方处置信息", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(bThirdDisposalInfoService.deleteBThirdDisposalInfoByIds(ids));
    }
}

