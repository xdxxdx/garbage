package com.xdx.garbage.dao;

import com.xdx.garbage.entity.THousePoint;
import tk.mybatis.mapper.common.Mapper;

public interface THousePointMapper extends Mapper<THousePoint> {
    void deleteByHouseId(Long houseId);
}