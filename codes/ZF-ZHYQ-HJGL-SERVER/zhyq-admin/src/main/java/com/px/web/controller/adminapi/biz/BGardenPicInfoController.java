package com.px.web.controller.adminapi.biz;

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
import com.px.biz.domain.BGardenPicInfo;
import com.px.biz.service.IBGardenPicInfoService;
import com.px.common.utils.poi.ExcelUtil;
import com.px.common.core.page.TableDataInfo;

/**
 * 园区图片信息Controller
 *
 * @author 品讯科技
 * @date 2024-08
 */
@RestController
@RequestMapping("/admin_api/garden_pic_info")
public class BGardenPicInfoController extends BaseController
{
    @Autowired
    private IBGardenPicInfoService bGardenPicInfoService;

    /**
     * 查询园区图片信息列表
     */
    @PreAuthorize("@ss.hasPermi('admin_api:garden_pic_info:list')")
    @GetMapping("/list")
    public TableDataInfo list(BGardenPicInfo bGardenPicInfo)
    {
        startPage();
        List<BGardenPicInfo> list = bGardenPicInfoService.selectBGardenPicInfoList(bGardenPicInfo);
        return getDataTable(list);
    }

    /**
     * 导出园区图片信息列表
     */
    @PreAuthorize("@ss.hasPermi('admin_api:garden_pic_info:export')")
    @Log(title = "园区图片信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BGardenPicInfo bGardenPicInfo)
    {
        List<BGardenPicInfo> list = bGardenPicInfoService.selectBGardenPicInfoList(bGardenPicInfo);
        ExcelUtil<BGardenPicInfo> util = new ExcelUtil<BGardenPicInfo>(BGardenPicInfo.class);
        util.exportExcel(response, list, "园区图片信息数据");
    }

    /**
     * 获取园区图片信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('admin_api:garden_pic_info:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(bGardenPicInfoService.selectBGardenPicInfoById(id));
    }

    /**
     * 新增园区图片信息
     */
    @PreAuthorize("@ss.hasPermi('admin_api:garden_pic_info:add')")
    @Log(title = "园区图片信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BGardenPicInfo bGardenPicInfo)
    {
        return toAjax(bGardenPicInfoService.insertBGardenPicInfo(bGardenPicInfo));
    }

    /**
     * 修改园区图片信息
     */
    @PreAuthorize("@ss.hasPermi('admin_api:garden_pic_info:edit')")
    @Log(title = "园区图片信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BGardenPicInfo bGardenPicInfo)
    {
        return toAjax(bGardenPicInfoService.updateBGardenPicInfo(bGardenPicInfo));
    }

    /**
     * 删除园区图片信息
     */
    @PreAuthorize("@ss.hasPermi('admin_api:garden_pic_info:remove')")
    @Log(title = "园区图片信息", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(bGardenPicInfoService.deleteBGardenPicInfoByIds(ids));
    }
}
