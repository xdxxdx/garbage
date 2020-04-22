package com.xdx.garbage.controller.back;

import com.xdx.garbage.common.controller.BaseController;
import com.xdx.garbage.common.dto.BaseResponse;
import com.xdx.garbage.common.dto.QueryParam;
import com.xdx.garbage.entity.TProvince;
import com.xdx.garbage.service.ProvinceService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("ele/province")
public class ProvinceController extends BaseController<ProvinceService, TProvince> {

    @RequestMapping("/listWithCities")
    public BaseResponse provinceWithCities(QueryParam queryParam){
        List<Map<String,Object>> provinceList = service.selectListWithCities(queryParam);
        return  BaseResponse.success4element(provinceList);
    }
}
