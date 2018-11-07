package com.charging.dto;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

@Data
public class UnitDto {

    @Excel(name = "里程范围", orderNum = "1")
    private String distance;

    @Excel(name = "车长", orderNum = "2")
    private String carLength;

    @Excel(name = "单价", orderNum = "3")
    private String unitPrice;

    @Excel(name = "油价调整", orderNum = "4")
    private String oilRisen;

    @Excel(name = "结算价格", orderNum = "5")
    private String unitAccount;
}
