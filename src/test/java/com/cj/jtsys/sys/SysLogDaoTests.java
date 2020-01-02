package com.cj.jtsys.sys;


import com.cj.jtsys.sys.dao.SysLogDao;
import com.cj.jtsys.sys.dao.SysMenuDao;
import com.cj.jtsys.sys.entity.SysLog;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.Map;

@SpringBootTest
public class SysLogDaoTests {
    @Autowired
    private SysLogDao sysLogDao;
    @Autowired
    SysMenuDao  sysMenuDao;
    @Test
    public void findAll(){
      int rowcount=  sysLogDao.getRowCount("admin");
        System.out.println(rowcount);
    }
    @Test
    public void findPageObjects(){
        List<SysLog> list=sysLogDao.findPageObjects("admin",0,3);
        for(SysLog log:list){
            System.out.println(log);
        }


    }
    @Test
    public void testDeleteObject(){
       int rows= sysLogDao.deleteObjects(100,200,300);
        System.out.println(rows);
    }
    @Test
    public void testFindObject02(){
     Instant start=   Instant.now();
        List<Map<String,Object>> list=sysMenuDao.findAll();
        Instant end=Instant.now();
        System.out.println(Duration.between(start,end));

        for (Map<String, Object> map : list) {
            System.out.println(map);
        }
    }


}
