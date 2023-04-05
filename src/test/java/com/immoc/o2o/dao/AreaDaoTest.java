package com.immoc.o2o.dao;

import com.immoc.o2o.BaseTest;
import com.immoc.o2o.entity.Area;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

public class AreaDaoTest extends BaseTest {

    @Autowired
    private AreaDao areaDao;

    @Test
    public void testQueryArea() {
        List<Area> areaList = areaDao.queryArea();
        assertEquals(2, areaList.size());
    }

    @Test
    public void insertArea() {
    }

    @Test
    public void updateArea() {
    }

    @Test
    public void deleteArea() {
    }

    @Test
    public void batchDeleteArea() {
    }
}