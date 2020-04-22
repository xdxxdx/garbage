package com.xdx.garbage.service;

import com.xdx.garbage.common.service.BaseService;
import com.xdx.garbage.entity.TAdmin;

public interface AdminService extends BaseService<TAdmin> {
    boolean checkAdminLogin(String userName, String pwd);

}
