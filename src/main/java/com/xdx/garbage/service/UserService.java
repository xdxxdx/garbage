package com.xdx.garbage.service;

import com.xdx.garbage.common.service.BaseService;
import com.xdx.garbage.entity.TUser;

public interface UserService extends BaseService<TUser> {
    TUser getUserByOpenId(String openId);
    TUser getUserById(long id);
}
