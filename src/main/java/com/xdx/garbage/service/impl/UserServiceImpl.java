package com.xdx.garbage.service.impl;

import com.xdx.garbage.common.dto.QueryParam;
import com.xdx.garbage.common.service.impl.BaseServiceImpl;
import com.xdx.garbage.dao.TUserMapper;
import com.xdx.garbage.entity.TUser;
import com.xdx.garbage.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl extends BaseServiceImpl<TUserMapper, TUser> implements UserService {
    @Override
    public List<TUser> selectListByQueryParam(QueryParam queryParam) {
        return null;
    }

    @Override
    public Long selectCountByQueryParam(QueryParam queryParam) {
        return null;
    }

    @Override
    public int hiddenById(long id) {
        return 0;
    }

    @Override
    public TUser getUserByOpenId(String openId) {
        TUser user=new TUser();
        user.setOpenId(openId);
        return mapper.selectOne(user);
    }

    @Override
    public TUser getUserById(long id) {
        TUser user=new TUser();
        user.setId(id);
        return mapper.selectOne(user);
    }

}
