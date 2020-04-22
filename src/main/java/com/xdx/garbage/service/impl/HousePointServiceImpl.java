package com.xdx.garbage.service.impl;

import com.xdx.garbage.common.dto.QueryParam;
import com.xdx.garbage.common.service.impl.BaseServiceImpl;
import com.xdx.garbage.dao.THousePointMapper;
import com.xdx.garbage.entity.THousePoint;
import com.xdx.garbage.service.HousePointService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HousePointServiceImpl extends BaseServiceImpl<THousePointMapper, THousePoint> implements HousePointService {
    @Override
    public List<THousePoint> selectListByQueryParam(QueryParam queryParam) {
        return null;
    }

    @Override
    public Long selectCountByQueryParam(QueryParam queryParam) {
        return null;
    }

    @Override
    public int hiddenById(long id) {
        return 0;
    }

    @Override
    public void deleteByHouseId(Long houseId) {
        mapper.deleteByHouseId(houseId);
    }
}
