package com.immoc.o2o.service.impl;

import com.immoc.o2o.dao.AreaDao;
import com.immoc.o2o.entity.Area;
import com.immoc.o2o.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AreaServiceImpl implements AreaService {


    //service层是依赖于dao层的
    @Autowired
    private AreaDao areaDao;

    @Override
    public List<Area> getAreaList() {
        return areaDao.queryArea();
    }
}
