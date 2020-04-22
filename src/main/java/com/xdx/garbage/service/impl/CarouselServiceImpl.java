package com.xdx.garbage.service.impl;

import com.xdx.garbage.common.dto.QueryParam;
import com.xdx.garbage.common.service.impl.BaseServiceImpl;
import com.xdx.garbage.dao.TCarouselMapper;
import com.xdx.garbage.entity.TAdmin;
import com.xdx.garbage.entity.TCarousel;
import com.xdx.garbage.service.CarouselService;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class CarouselServiceImpl extends BaseServiceImpl<TCarouselMapper, TCarousel> implements CarouselService {
    @Override
    public List<TCarousel> selectListByQueryParam(QueryParam queryParam) {
        Example example = new Example(TCarousel.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("isDel",0);
        if(queryParam.getUserName() != null){
            criteria.andLike("carouselName", queryParam.getCarouselName() + "%");
        }
        example.setOrderByClause(queryParam.getSort()+" "+ queryParam.getSortOrder());
        List<TCarousel> list = mapper.selectByExample(example);
        return list;
    }

    @Override
    public Long selectCountByQueryParam(QueryParam queryParam) {
        Example example = new Example(TCarousel.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("isDel",0);
        if(queryParam.getUserName() != null){
            criteria.andLike("carouselName", queryParam.getCarouselName() + "%");
        }
        return Long.valueOf(mapper.selectCountByExample(example));
    }

    @Override
    public int hiddenById(long id) {
        TCarousel carousel=new TCarousel();
        carousel.setId(id);
        carousel.setIsDel(1);
        return super.updateSelectiveById(carousel);
    }

}
