package com.xdx.garbage.service.impl;


import com.xdx.garbage.common.dto.QueryParam;
import com.xdx.garbage.common.service.impl.BaseServiceImpl;
import com.xdx.garbage.common.util.EncryptionUtil;
import com.xdx.garbage.dao.TAdminMapper;
import com.xdx.garbage.entity.TAdmin;
import com.xdx.garbage.entity.TCarousel;
import com.xdx.garbage.entity.TUser;
import com.xdx.garbage.service.AdminService;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class AdminServiceImpl extends BaseServiceImpl<TAdminMapper, TAdmin> implements AdminService {
    @Override
    public boolean checkAdminLogin(String userName, String pwd) {
        TAdmin admin=new TAdmin();
        admin.setUserName(userName);
        admin=selectOne(admin);
        if(admin!=null){
            if(admin.getPwd().equals(EncryptionUtil.encrypt(pwd))){
                return true;
            }
        }
        return false;
    }

    @Override
    public List<TAdmin> selectListByQueryParam(QueryParam queryParam) {
        Example example = new Example(TAdmin.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("isDel",0);
        if(queryParam.getUserName() != null){
            criteria.andLike("userName", queryParam.getUserName() + "%");
        }
        example.setOrderByClause(queryParam.getSort()+" "+ queryParam.getSortOrder());
        List<TAdmin> list = mapper.selectByExample(example);
        return list;
    }

    @Override
    public Long selectCountByQueryParam(QueryParam queryParam) {
        Example example = new Example(TAdmin.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("isDel",0);
        if(queryParam.getUserName() != null){
            criteria.andLike("userName", queryParam.getUserName() + "%");
        }
        return Long.valueOf(mapper.selectCountByExample(example));
    }

    @Override
    public int hiddenById(long id) {
        return 0;
    }

}
