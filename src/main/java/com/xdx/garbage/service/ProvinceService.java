package com.xdx.garbage.service;

import com.xdx.garbage.common.dto.QueryParam;
import com.xdx.garbage.common.service.BaseService;
import com.xdx.garbage.entity.TProvince;

import java.util.List;
import java.util.Map;

public interface ProvinceService extends BaseService<TProvince> {

    List<Map<String,Object>> selectListWithCities(QueryParam queryParam);
}
