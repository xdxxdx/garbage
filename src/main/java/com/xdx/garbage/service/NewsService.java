package com.xdx.garbage.service;

import com.xdx.garbage.common.service.BaseService;
import com.xdx.garbage.entity.TNews;

public interface NewsService extends BaseService<TNews> {
    int increaseReadNum(TNews news);
}
