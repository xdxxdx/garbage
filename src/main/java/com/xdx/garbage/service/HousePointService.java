package com.xdx.garbage.service;

import com.xdx.garbage.common.service.BaseService;
import com.xdx.garbage.entity.THousePoint;

public interface HousePointService extends BaseService<THousePoint> {
    void deleteByHouseId(Long houseId);
}
