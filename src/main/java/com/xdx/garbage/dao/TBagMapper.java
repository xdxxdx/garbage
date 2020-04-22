package com.xdx.garbage.dao;

import com.xdx.garbage.common.dto.QueryParam;
import com.xdx.garbage.entity.TBag;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface TBagMapper extends Mapper<TBag> {
    List<TBag> selectExtendList(QueryParam queryParam);

    int bindBag(TBag bag);
}
