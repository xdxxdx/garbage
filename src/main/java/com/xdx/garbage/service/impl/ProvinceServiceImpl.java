package com.xdx.garbage.service.impl;

import com.xdx.garbage.common.dto.QueryParam;
import com.xdx.garbage.common.service.impl.BaseServiceImpl;
import com.xdx.garbage.dao.TProvinceMapper;
import com.xdx.garbage.entity.TAdmin;
import com.xdx.garbage.entity.TCity;
import com.xdx.garbage.entity.TProvince;
import com.xdx.garbage.service.ProvinceService;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProvinceServiceImpl extends BaseServiceImpl<TProvinceMapper, TProvince> implements ProvinceService {
    @Override
    public List<TProvince> selectListByQueryParam(QueryParam queryParam) {
        Example example = new Example(TProvince.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("isDel",0);
        if(queryParam.getProvinceName()!= null){
            criteria.andLike("provinceName", queryParam.getProvinceName() + "%");
        }
        example.setOrderByClause(queryParam.getSort()+" "+ queryParam.getSortOrder());
        List<TProvince> list = mapper.selectByExample(example);
        return list;
    }

    @Override
    public Long selectCountByQueryParam(QueryParam queryParam) {
        Example example = new Example(TProvince.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("isDel",0);
        if(queryParam.getProvinceName()!= null){
            criteria.andLike("provinceName", queryParam.getProvinceName() + "%");
        }
        return Long.valueOf(mapper.selectCountByExample(example));
    }

    @Override
    public int hiddenById(long id) {
        TProvince province=new TProvince();
        province.setId(id);
        province.setIsDel(1);
        return mapper.updateByPrimaryKeySelective(province);
    }

    @Override
    public List<Map<String,Object>> selectListWithCities(QueryParam queryParam) {
        List<TProvince>provinceList=mapper.selectListWithCities(queryParam);
        List<Map<String,Object>>list=new ArrayList<>();
        for (TProvince province : provinceList) {
            Map<String, Object> map = new HashMap<>();
            map.put("value", province.getId());
            map.put("label", province.getProvinceName());
            List<Map<String,Object>>children=new ArrayList<>();
            for (TCity city : province.getCities()) {
                Map<String, Object> childMap = new HashMap<>();
                childMap.put("value", city.getId());
                childMap.put("label", city.getCityName());
                children.add(childMap);
            }
            map.put("children", children);
            list.add(map);
        }
        return list;
    }
}
