package com.px.web.controller.screenapi;

import com.px.base.service.IBWasteStorageOptionService;
import com.px.biz.domain.BSewageOutletSumRecord;
import com.px.biz.service.IBSewageOutletSumRecordService;
import com.px.common.core.controller.BaseController;
import com.px.common.core.domain.AjaxResult;
import com.px.common.core.page.TableDataInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/screen_api/sewageOutletSumRecord")
public class BSewageOutletSumRecordController extends BaseController {
    @Autowired
    private IBSewageOutletSumRecordService bSewageOutletSumRecordService;
    @Autowired
    private IBWasteStorageOptionService bWasteStorageOptionService;

    @GetMapping("/list")
    public TableDataInfo list(BSewageOutletSumRecord bSewageOutletSumRecord) {
        startPage();
        List<BSewageOutletSumRecord> list = bSewageOutletSumRecordService.selectBSewageOutletSumRecordList(bSewageOutletSumRecord);
        return getDataTable(list);
    }

    //获取污水总量
    @GetMapping("listAll")
    public AjaxResult listAll() {
        // 获取污水总量
        Double sewage = bSewageOutletSumRecordService.selectSewageOutletSumRecordAll();
        // 获取固废总量
        Double fixed = bWasteStorageOptionService.selectWasteStorageFixedORDanger("1");
        // 获取危废总量
        Double danger = bWasteStorageOptionService.selectWasteStorageFixedORDanger("2");
        // 初始化 long 数组
        long[] results = new long[3];

        // 将 Double 转换为 long，并处理可能的 null 值
        results[0] = sewage != null ? sewage.longValue() : 0; // 或者您可以选择其他默认值
        results[1] = fixed != null ? fixed.longValue() : 0; // 或者您可以选择其他默认值
        results[2] = danger != null ? danger.longValue() : 0; // 或者您可以选择其他默认值

        return success(results);
    }
}

