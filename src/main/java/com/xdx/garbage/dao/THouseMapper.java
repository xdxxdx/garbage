package com.xdx.garbage.dao;

import com.xdx.garbage.common.dto.QueryParam;
import com.xdx.garbage.entity.THouse;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface THouseMapper extends Mapper<THouse> {
    List<THouse> selectListWithProvinceCity(QueryParam queryParam);
}