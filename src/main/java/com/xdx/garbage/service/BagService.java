package com.xdx.garbage.service;

import com.xdx.garbage.common.service.BaseService;
import com.xdx.garbage.entity.TBag;

public interface BagService extends BaseService<TBag> {
    void batchAdd(int num);

    int bindBag(TBag bag);
}
