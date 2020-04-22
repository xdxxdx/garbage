package com.xdx.garbage.controller.back;

import com.xdx.garbage.common.controller.BaseController;
import com.xdx.garbage.entity.TLaunchPoint;
import com.xdx.garbage.service.LaunchPointService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

@RequestMapping("ele/point")
public class LaunchPointController extends BaseController<LaunchPointService, TLaunchPoint> {
}
