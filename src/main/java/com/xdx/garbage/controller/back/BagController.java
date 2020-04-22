package com.xdx.garbage.controller.back;

import com.xdx.garbage.common.controller.BaseController;
import com.xdx.garbage.common.dto.BaseResponse;
import com.xdx.garbage.entity.TBag;
import com.xdx.garbage.service.BagService;
import com.xdx.garbage.service.impl.BagServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ele/bag")
public class BagController extends BaseController<BagService, TBag> {
    /**
     * 批量新增
     * @param num
     * @return
     */
    @PostMapping("/add/{num}")
    public BaseResponse batchAdd(@PathVariable(value = "num") int num){
        service.batchAdd(num);
        return BaseResponse.success4element(null);
    }
}
