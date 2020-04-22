package com.xdx.garbage.service.impl;

import com.xdx.garbage.common.constant.Constant;
import com.xdx.garbage.common.dto.QueryParam;
import com.xdx.garbage.common.service.impl.BaseServiceImpl;
import com.xdx.garbage.common.util.EncryptionUtil;
import com.xdx.garbage.dao.TAgencyMapper;
import com.xdx.garbage.entity.TAdmin;
import com.xdx.garbage.entity.TAgency;
import com.xdx.garbage.service.AdminService;
import com.xdx.garbage.service.AgencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class AgencyServiceImpl extends BaseServiceImpl<TAgencyMapper, TAgency> implements AgencyService {
    @Autowired
    private AdminService adminService;
    @Override
    public List<TAgency> selectListByQueryParam(QueryParam queryParam) {
        List<TAgency> list = mapper.selectListWithProvinceCity(queryParam);
        return list;
    }

    @Override
    public Long selectCountByQueryParam(QueryParam queryParam) {
        Example example = new Example(TAgency.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("isDel",0);
        if(queryParam.getStatus()!=null){
            criteria.andEqualTo("status", queryParam.getStatus());
        }
        if(queryParam.getAgentName() != null){
            criteria.andLike("agentName", queryParam.getAgentName() + "%");
        }
        return Long.valueOf(mapper.selectCountByExample(example));
    }

    @Override
    public int hiddenById(long id) {
        TAgency agency = new TAgency();
        agency.setId(id);
        agency.setIsDel(1);
        return mapper.updateByPrimaryKeySelective(agency);
    }

    @Override
    public boolean addAgent(TAgency agency) {
        mapper.insertSelective(agency);
        TAdmin admin=new TAdmin();
        admin.setUserName(agency.getAgentAccount());
        admin.setPwd(EncryptionUtil.encrypt(Constant.defaultPwd));
        admin.setRole("'agent'");
        adminService.insertSelective(admin);
        return true;
    }
}
