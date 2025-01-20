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
import com.px.base.domain.RMicrostationFactorInfo;
import com.px.base.service.IRMicrostationFactorInfoService;
import com.px.common.utils.poi.ExcelUtil;
import com.px.common.core.page.TableDataInfo;

/**
 * 空气微站与污染因子的关系Controller
 *
 * @author 品讯科技
 * @date 2024-08
 */
@RestController
@RequestMapping("/admin_api/r_microstation_factor")
public class RMicrostationFactorInfoController extends BaseController
{
    @Autowired
    private IRMicrostationFactorInfoService rMicrostationFactorInfoService;
    /**
     * 查询空气微站与污染因子的关系列表
     */
    @PreAuthorize("@ss.hasPermi('admin_api:r_microstation_factor:list')")
    @GetMapping("/list")
    public TableDataInfo list(RMicrostationFactorInfo rMicrostationFactorInfo)
    {
        startPage();
        List<RMicrostationFactorInfo> list = rMicrostationFactorInfoService.selectRMicrostationFactorInfoList(rMicrostationFactorInfo);
        return getDataTable(list);
    }

    /**
     * 导出空气微站与污染因子的关系列表
     */
    @PreAuthorize("@ss.hasPermi('admin_api:r_microstation_factor:export')")
    @Log(title = "空气微站与污染因子的关系", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, RMicrostationFactorInfo rMicrostationFactorInfo)
    {
        List<RMicrostationFactorInfo> list = rMicrostationFactorInfoService.selectRMicrostationFactorInfoList(rMicrostationFactorInfo);
        ExcelUtil<RMicrostationFactorInfo> util = new ExcelUtil<RMicrostationFactorInfo>(RMicrostationFactorInfo.class);
        util.exportExcel(response, list, "空气微站与污染因子的关系数据");
    }

    /**
     * 获取空气微站与污染因子的关系详细信息
     */
    @PreAuthorize("@ss.hasPermi('admin_api:r_microstation_factor:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(rMicrostationFactorInfoService.selectRMicrostationFactorInfoById(id));
    }

    /**
     * 新增空气微站与污染因子的关系
     */
    @PreAuthorize("@ss.hasPermi('admin_api:r_microstation_factor:add')")
    @Log(title = "空气微站与污染因子的关系", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody RMicrostationFactorInfo rMicrostationFactorInfo)
    {
        return toAjax(rMicrostationFactorInfoService.insertRMicrostationFactorInfo(rMicrostationFactorInfo));
    }

    /**
     * 修改空气微站与污染因子的关系
     */
    @PreAuthorize("@ss.hasPermi('admin_api:r_microstation_factor:edit')")
    @Log(title = "空气微站与污染因子的关系", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody RMicrostationFactorInfo rMicrostationFactorInfo)
    {
        return toAjax(rMicrostationFactorInfoService.updateRMicrostationFactorInfo(rMicrostationFactorInfo));
    }

    /**
     * 删除空气微站与污染因子的关系
     */
    @PreAuthorize("@ss.hasPermi('admin_api:r_microstation_factor:remove')")
    @Log(title = "空气微站与污染因子的关系", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(rMicrostationFactorInfoService.deleteRMicrostationFactorInfoByIds(ids));
    }
}

