package com.xdx.garbage.service.impl;

import com.xdx.garbage.common.dto.QueryParam;
import com.xdx.garbage.common.service.impl.BaseServiceImpl;
import com.xdx.garbage.dao.TLaunchPointMapper;
import com.xdx.garbage.entity.TAdmin;
import com.xdx.garbage.entity.THouse;
import com.xdx.garbage.entity.TLaunchPoint;
import com.xdx.garbage.service.LaunchPointService;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class LaunchPointServiceImpl extends BaseServiceImpl<TLaunchPointMapper, TLaunchPoint> implements LaunchPointService {
    @Override
    public List<TLaunchPoint> selectListByQueryParam(QueryParam queryParam) {
        List<TLaunchPoint> list = mapper.selectListWithProvinceCity(queryParam);
        return list;
    }

    @Override
    public Long selectCountByQueryParam(QueryParam queryParam) {
        Example example = new Example(TLaunchPoint.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("isDel",0);
        if(queryParam.getCityId()!= null){
            criteria.andEqualTo("cityId", queryParam.getCityId() );
        }
        if(queryParam.getStatus()!= null){
            criteria.andEqualTo("status", queryParam.getStatus() );
        }
        if(queryParam.getPointName()!=null){
            criteria.andLike("pointName",queryParam.getPointName()+"%");
        }
        return Long.valueOf(mapper.selectCountByExample(example));
    }

    @Override
    public int hiddenById(long id) {
        TLaunchPoint launchPoint=new TLaunchPoint();
        launchPoint.setId(id);
        launchPoint.setIsDel(1);
        return mapper.updateByPrimaryKeySelective(launchPoint);
    }

    @Override
    public List<TLaunchPoint> getActivePoints() {
        Example example = new Example(TLaunchPoint.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("isDel",0);
        criteria.andEqualTo("status",1);
        return mapper.selectByExample(example);
    }
}
