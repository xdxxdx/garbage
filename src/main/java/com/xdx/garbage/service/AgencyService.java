package com.xdx.garbage.service;

import com.xdx.garbage.common.service.BaseService;
import com.xdx.garbage.entity.TAgency;

public interface AgencyService extends BaseService<TAgency> {

    boolean addAgent(TAgency agency);
}
