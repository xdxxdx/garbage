package com.xdx.garbage.service.impl;

import com.xdx.garbage.common.dto.BaseResponse;
import com.xdx.garbage.common.dto.QueryParam;
import com.xdx.garbage.common.service.impl.BaseServiceImpl;
import com.xdx.garbage.dao.THouseMapper;
import com.xdx.garbage.entity.TCity;
import com.xdx.garbage.entity.THouse;
import com.xdx.garbage.entity.THousePoint;
import com.xdx.garbage.service.HousePointService;
import com.xdx.garbage.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Example;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class HouseServiceImpl extends BaseServiceImpl<THouseMapper, THouse> implements HouseService {
    @Autowired
    private HousePointService housePointService;
    @Override
    public List<THouse> selectListByQueryParam(QueryParam queryParam) {
        List<THouse> list = mapper.selectListWithProvinceCity(queryParam);
        return list;
    }

    @Override
    public Long selectCountByQueryParam(QueryParam queryParam) {
        Example example = new Example(THouse.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("isDel",0);
        if(queryParam.getCityId()!= null){
            criteria.andEqualTo("cityId", queryParam.getCityId() );
        }
        if(queryParam.getHouseName()!=null){
            criteria.andLike("houseName",queryParam.getHouseName()+"%");
        }
        return Long.valueOf(mapper.selectCountByExample(example));
    }

    @Override
    public int hiddenById(long id) {
        THouse house=new THouse();
        house.setId(id);
        house.setIsDel(1);
        return mapper.updateByPrimaryKeySelective(house);
    }

    @Override
    @Transactional
    public boolean addHouse(THouse house){
        mapper.insertSelective(house);
        if(house.getPoints()!=null&&house.getPoints().size()>0){
            for (Long point : house.getPoints()) {
                THousePoint housePoint=new THousePoint();
                housePoint.setHouseId(house.getId());
                housePoint.setPointId(point);
                housePointService.insertSelective(housePoint);
            }
        }
        return true;
    }

    @Override
    @Transactional
    public boolean updateHouse(THouse house) {
        mapper.updateByPrimaryKeySelective(house);
        housePointService.deleteByHouseId(house.getId());
        if(house.getPoints()!=null&&house.getPoints().size()>0){
            for (Long point : house.getPoints()) {
                THousePoint housePoint=new THousePoint();
                housePoint.setHouseId(house.getId());
                housePoint.setPointId(point);
                housePointService.insertSelective(housePoint);
            }
        }
        return true;
    }

}
