package com.xdx.garbage.dao;

import com.xdx.garbage.common.dto.QueryParam;
import com.xdx.garbage.entity.TCity;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface TCityMapper extends Mapper<TCity> {
    List<TCity>selectListWithProvince(QueryParam queryParam);
}