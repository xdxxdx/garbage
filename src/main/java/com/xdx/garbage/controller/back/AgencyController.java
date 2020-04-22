package com.xdx.garbage.controller.back;

import com.xdx.garbage.common.constant.Constant;
import com.xdx.garbage.common.controller.BaseController;
import com.xdx.garbage.common.dto.BaseResponse;
import com.xdx.garbage.common.util.EncryptionUtil;
import com.xdx.garbage.entity.TAgency;
import com.xdx.garbage.service.AgencyService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("ele/agency")
public class AgencyController extends BaseController<AgencyService, TAgency> {

    @Override
    @PostMapping("/add")
    public BaseResponse add(@RequestBody TAgency agent){
        if(service.addAgent(agent)){
            return BaseResponse.success4element(null);
        }else{
            return BaseResponse.fail(-1);
        }
    }
}
