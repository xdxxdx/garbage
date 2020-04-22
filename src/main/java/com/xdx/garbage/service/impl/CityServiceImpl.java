package com.xdx.garbage.service.impl;

import com.xdx.garbage.common.dto.QueryParam;
import com.xdx.garbage.common.service.impl.BaseServiceImpl;
import com.xdx.garbage.dao.TCityMapper;
import com.xdx.garbage.entity.TCity;
import com.xdx.garbage.entity.TProvince;
import com.xdx.garbage.service.CityService;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class CityServiceImpl extends BaseServiceImpl<TCityMapper, TCity> implements CityService {
    @Override
    public List<TCity> selectListByQueryParam(QueryParam queryParam) {
        List<TCity> list = mapper.selectListWithProvince(queryParam);
        return list;
    }

    @Override
    public Long selectCountByQueryParam(QueryParam queryParam) {
        Example example = new Example(TCity.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("isDel",0);
        if(queryParam.getProvinceId()!= null){
            criteria.andEqualTo("provinceId", queryParam.getProvinceId() );
        }
        return Long.valueOf(mapper.selectCountByExample(example));
    }

    @Override
    public int hiddenById(long id) {
        TCity city=new TCity();
        city.setId(id);
        city.setIsDel(1);
        return mapper.updateByPrimaryKeySelective(city);
    }
}
