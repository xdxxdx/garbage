package com.xdx.garbage.dao;

import com.xdx.garbage.entity.TNews;
import tk.mybatis.mapper.common.Mapper;

public interface TNewsMapper extends Mapper<TNews> {
    int increaseReadNum(TNews news);
}