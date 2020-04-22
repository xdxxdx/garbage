package com.xdx.garbage.dao;

import com.xdx.garbage.common.dto.QueryParam;
import com.xdx.garbage.entity.TLaunchPoint;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface TLaunchPointMapper extends Mapper<TLaunchPoint> {
    List<TLaunchPoint> selectListWithProvinceCity(QueryParam queryParam);
}