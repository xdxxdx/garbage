package com.xdx.garbage.service.impl;

import com.xdx.garbage.common.dto.QueryParam;
import com.xdx.garbage.common.service.impl.BaseServiceImpl;
import com.xdx.garbage.common.util.RandomUtil;
import com.xdx.garbage.dao.TBagMapper;
import com.xdx.garbage.entity.TAdmin;
import com.xdx.garbage.entity.TBag;
import com.xdx.garbage.service.BagService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Slf4j
@Service
public class BagServiceImpl extends BaseServiceImpl<TBagMapper, TBag> implements BagService {
    @Override
    public List<TBag> selectListByQueryParam(QueryParam queryParam) {
        List<TBag> list = mapper.selectExtendList(queryParam);
        return list;
    }

    @Override
    public Long selectCountByQueryParam(QueryParam queryParam) {
        Example example = new Example(TBag.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("isDel",0);
        if(queryParam.getStatus() != null){
            criteria.andEqualTo("status", queryParam.getStatus());
        }
        if(queryParam.getStartTime()!=null){
            criteria.andGreaterThanOrEqualTo("createTime",queryParam.getStartTime());
        }
        if(queryParam.getEndTime()!=null){
            criteria.andLessThanOrEqualTo("createTime", queryParam.getEndTime());
        }

        return Long.valueOf(mapper.selectCountByExample(example));
    }

    @Override
    public int hiddenById(long id) {
        return 0;
    }

    @Override
    @Async
    public void batchAdd(int num) {
        for(int i=0;i<num;i++){
            log.info("current thread "+Thread.currentThread().getName());
            TBag bag=new TBag();
            bag.setBagCode(System.currentTimeMillis()+""+ RandomUtil.getRandNum(10000,99999));
            mapper.insertSelective(bag);
        }
    }

    @Override
    public int bindBag(TBag bag) {
        return mapper.bindBag(bag);
    }
}
