package com.charging.controller;

import com.charging.dto.UnitDto;
import com.charging.excel.ExcelUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping(value="deal")
public class DealController {

    /**
     * 读取excel中的内容，并计算出计算价格
     * 生成excel
     * @param file
     */
    @PostMapping(value="import")
    public void importPreview(@RequestParam("file") MultipartFile file,HttpServletResponse httpServletResponse) {
        List<UnitDto> unitDtos = ExcelUtil.importExcel(file, 1, 1, UnitDto.class);
        for(UnitDto unitDto : unitDtos){
            String distance = unitDto.getDistance();
            if(distance.indexOf("R")>-1){
                String unitPrice = unitDto.getUnitPrice().trim();
                String oilRisen = unitDto.getOilRisen().trim();

                if(StringUtils.isBlank(unitPrice) && StringUtils.isBlank(oilRisen)){
                    unitDto.setUnitAccount(String.valueOf(Double.parseDouble(unitPrice) + Double.parseDouble(oilRisen)));
                }
            }else{
                unitDto.setUnitAccount("结算价格");
            }
        }

        ExcelUtil.exportExcel(unitDtos,"123","",UnitDto.class,"结算单价.xlsx",httpServletResponse);
    }
}
