package com.xdx.garbage.service;

import com.xdx.garbage.common.service.BaseService;
import com.xdx.garbage.entity.TLaunchPoint;

import java.util.List;

public interface LaunchPointService extends BaseService<TLaunchPoint> {
    List<TLaunchPoint>getActivePoints();
}
