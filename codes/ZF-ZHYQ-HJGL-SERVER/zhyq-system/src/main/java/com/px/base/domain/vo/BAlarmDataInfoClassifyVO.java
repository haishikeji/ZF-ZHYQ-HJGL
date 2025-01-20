package com.px.base.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @@author 品讯科技
 * @ClassName: BAlarmDataInfoClassifyVO
 * @CreateDate: 2024年08月07日
 * @Description: 预警数量VO
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BAlarmDataInfoClassifyVO {
    private Integer alarmCount;
    private String month;
    private Integer dayOfMonth;
    private String workType;

    private Integer waterCount; // 污染源预警
    private Integer airCount; // 环境质量预警
    private Integer electricCount; // 用电预警

    private Integer totaLwaterCount; // 总共污染源预警
    private Integer totaLairCount; // 总共环境质量预警
    private Integer totaLelectricCount; // 总共用电预警
    private Integer totalCount; // 总共多少条
    private Date recordDate;  // 日期

   

}
