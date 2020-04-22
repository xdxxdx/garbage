package com.xdx.garbage.dao;

import com.xdx.garbage.common.dto.QueryParam;
import com.xdx.garbage.entity.TAgency;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface TAgencyMapper extends Mapper<TAgency> {
    List<TAgency> selectListWithProvinceCity(QueryParam queryParam);
}