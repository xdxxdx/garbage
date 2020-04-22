package com.xdx.garbage.service.impl;

import com.xdx.garbage.common.dto.QueryParam;
import com.xdx.garbage.common.service.impl.BaseServiceImpl;
import com.xdx.garbage.dao.TNewsMapper;
import com.xdx.garbage.entity.TNews;
import com.xdx.garbage.service.NewsService;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class NewsServiceImpl extends BaseServiceImpl<TNewsMapper, TNews> implements NewsService {
    @Override
    public List<TNews> selectListByQueryParam(QueryParam queryParam) {
        Example example = new Example(TNews.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("isDel",0);
        if(queryParam.getNewsTitle() != null){
            criteria.andLike("newsTitle", queryParam.getNewsTitle() + "%");
        }
        example.setOrderByClause(queryParam.getSort()+" "+ queryParam.getSortOrder());
        List<TNews> list = mapper.selectByExample(example);
        return list;
    }

    @Override
    public Long selectCountByQueryParam(QueryParam queryParam) {
        Example example = new Example(TNews.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("isDel",0);
        if(queryParam.getNewsTitle() != null){
            criteria.andLike("newsTitle", queryParam.getNewsTitle() + "%");
        }
        return Long.valueOf(mapper.selectCountByExample(example));
    }

    @Override
    public int hiddenById(long id) {
        TNews news=new TNews();
        news.setId(id);
        news.setIsDel(1);
        return mapper.updateByPrimaryKeySelective(news);
    }

    @Override
    public int increaseReadNum(TNews news) {
        return mapper.increaseReadNum(news);
    }
}
