package com.immoc.o2o.service;

import com.immoc.o2o.BaseTest;
import com.immoc.o2o.entity.Area;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

public class AreaServiceTest extends BaseTest {

    @Autowired
    private AreaService areaService;

    @Test
    public void getAreaListTest() {

        List<Area> areaList = areaService.getAreaList();
        assertEquals("瑶海区", areaList.get(0).getAreaName());


    }
}