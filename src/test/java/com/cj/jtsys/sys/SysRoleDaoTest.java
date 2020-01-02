package com.cj.jtsys.sys;

import com.cj.jtsys.sys.dao.SysRoleDao;
import com.cj.jtsys.sys.entity.SysRole;
import com.cj.jtsys.sys.vo.SysRoleMenuVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.List;

@Slf4j
@SpringBootTest
public class SysRoleDaoTest {
    @Autowired
    private SysRoleDao sysRoleDao;
    @Test
    public void testFindObjectById(){
        SysRoleMenuVo rm = sysRoleDao.findObjectById(1);
        System.out.println(rm );
    }

    @Test
    public void getRowCount(){
        int rowCount = sysRoleDao.getRowCount("运维");
        log.info("查询到{}条记录",rowCount);


    }
    @Test
    public void findPageObjects(){
        List<SysRole> list = sysRoleDao.findPageObjects("运维", 0, 3);
        for (SysRole sysRole : list) {
            System.out.println(sysRole);
        }

    }

}
