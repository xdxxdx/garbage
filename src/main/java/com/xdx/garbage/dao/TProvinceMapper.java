package com.xdx.garbage.dao;

import com.xdx.garbage.common.dto.QueryParam;
import com.xdx.garbage.entity.TProvince;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface TProvinceMapper extends Mapper<TProvince> {
    List<TProvince>selectListWithCities(QueryParam queryParam);
}