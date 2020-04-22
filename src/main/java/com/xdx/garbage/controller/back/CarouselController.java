package com.xdx.garbage.controller.back;

import com.xdx.garbage.common.controller.BaseController;
import com.xdx.garbage.common.dto.BaseResponse;
import com.xdx.garbage.entity.TCarousel;
import com.xdx.garbage.service.CarouselService;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("ele/carousel")
public class CarouselController extends BaseController<CarouselService, TCarousel> {

    @ResponseBody
    @RequestMapping(value="/status",method = RequestMethod.POST)
    public BaseResponse<?> modify(HttpServletRequest request, @RequestBody TCarousel entity){
        service.updateSelectiveById(entity);
        return BaseResponse.success4element(entity);
    }
}
