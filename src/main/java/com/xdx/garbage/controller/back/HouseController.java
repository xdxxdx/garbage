package com.xdx.garbage.controller.back;

import com.xdx.garbage.common.controller.BaseController;
import com.xdx.garbage.common.dto.BaseResponse;
import com.xdx.garbage.entity.THouse;
import com.xdx.garbage.service.HouseService;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/ele/house")
public class HouseController extends BaseController<HouseService, THouse> {
    /**
     * 新增操作
     * @param house
     * @return
     */
    @PostMapping("/add")
    public BaseResponse add(@RequestBody THouse house){
        if(service.addHouse(house)){
            return BaseResponse.success4element(null);
        }else{
            return BaseResponse.fail(-1);
        }
    }

    /**
     * 更新操作
     * 注意body中需要包含主键
     * @param house
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/{id}",method = RequestMethod.POST)
    public BaseResponse<?> modify(HttpServletRequest request, @RequestBody THouse house, @PathVariable("id")String id){
        if(service.updateHouse(house)){
            return BaseResponse.success4element(null);
        }else{
            return BaseResponse.fail(-1);
        }
    }
}
