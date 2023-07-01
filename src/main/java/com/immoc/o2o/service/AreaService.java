package com.immoc.o2o.service;

import com.immoc.o2o.entity.Area;

import java.util.List;

public interface AreaService {

    /**
     * 获取区域列表，优先从缓存获取
     *
     * @return
     */
    List<Area> getAreaList();

}
