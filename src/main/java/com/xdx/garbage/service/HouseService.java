package com.xdx.garbage.service;

import com.xdx.garbage.common.service.BaseService;
import com.xdx.garbage.entity.THouse;

public interface HouseService extends BaseService<THouse> {
     boolean addHouse(THouse house);

    boolean updateHouse(THouse house);
}
