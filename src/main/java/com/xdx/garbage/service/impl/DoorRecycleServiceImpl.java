package com.xdx.garbage.service.impl;

import com.xdx.garbage.common.dto.QueryParam;
import com.xdx.garbage.common.service.impl.BaseServiceImpl;
import com.xdx.garbage.dao.TDoorRecycleMapper;
import com.xdx.garbage.entity.TAdmin;
import com.xdx.garbage.entity.TDoorRecycle;
import com.xdx.garbage.service.DoorRecycleService;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class DoorRecycleServiceImpl extends BaseServiceImpl<TDoorRecycleMapper, TDoorRecycle> implements DoorRecycleService {

    @Override
    public List<TDoorRecycle> selectListByQueryParam(QueryParam queryParam) {
        Example example = new Example(TDoorRecycle.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("isDel",0);
        if(queryParam.getUserId() != null){
            criteria.andEqualTo("userId",queryParam.getUserId());
        }
        if(queryParam.getStatus()!=null){
            criteria.andEqualTo("status",queryParam.getStatus());
        }
        example.setOrderByClause(queryParam.getSort()+" "+ queryParam.getSortOrder());
        List<TDoorRecycle> list = mapper.selectByExample(example);
        return list;
    }

    @Override
    public Long selectCountByQueryParam(QueryParam queryParam) {
        Example example = new Example(TDoorRecycle.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("isDel",0);
        if(queryParam.getUserId() != null){
            criteria.andEqualTo("userId",queryParam.getUserId());
        }
        if(queryParam.getStatus()!=null){
            criteria.andEqualTo("status",queryParam.getStatus());
        }
        return Long.valueOf(mapper.selectCountByExample(example));
    }

    @Override
    public int hiddenById(long id) {
        return 0;
    }
}
