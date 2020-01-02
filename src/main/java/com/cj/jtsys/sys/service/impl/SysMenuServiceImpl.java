package com.cj.jtsys.sys.service.impl;

import com.cj.jtsys.sys.service.SysMenuService;
import com.cj.jtsys.sys.common.vo.Node;
import com.cj.jtsys.sys.dao.SysMenuDao;
import com.cj.jtsys.sys.dao.SysRoleMenuDao;
import com.cj.jtsys.sys.entity.SysMenu;
import com.cj.jtsys.sys.exception.ServiceException;
import com.cj.jtsys.sys.pageUtils.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import java.util.List;
import java.util.Map;
@Service
public class SysMenuServiceImpl implements SysMenuService {
    @Autowired
    private SysMenuDao sysMenuDao;
    @Autowired
    private SysRoleMenuDao sysRoleMenuDao;
    @Override
    public List<Map<String, Object>> findAll() {
        return sysMenuDao.findAll();
    }

    @Override
    public List<Node> findZtreeMenuNode() {
        return sysMenuDao.findZtreeMenuNode();
    }

    @Override
    public int updateObject(SysMenu sysMenu) {
        Assert.isNull(sysMenu,"保存对象不为空");
        Assert.isEmpty(sysMenu.getName(),"菜单名称不为空");
        int rows = sysMenuDao.updateObject(sysMenu);
        return rows;
    }

    @Override
    public int saveObject(SysMenu sysMenu) {
        //合法验证
        if(sysMenu==null){
            throw  new ServiceException("保存对象为空");
        }
        if(StringUtils.isEmpty(sysMenu.getName())){
            throw new ServiceException("菜单名不为空");
        }
        int rows;
        try{
            rows=sysMenuDao.insertObject(sysMenu);
        }catch(Exception e){
            e.printStackTrace();
            throw new ServiceException("保存失败");
        }

        return rows;
    }

    @Override
    //后面需要加一些事务控制
    public int deleteObject(Integer id) {
        //判断参数有效性
        Assert.isTrue(id!=null&&id>1,"id值无效");//false就抛出
        //查询当前菜单是否有子菜单，并进行校验
        int childCount = sysMenuDao.getChildCount(id);
        if(childCount>0){
            throw new ServiceException("请先删除子菜单");
        }
        //删除角色菜单关系数据
        sysRoleMenuDao.deleteObjectsByMenuId(id);
        //删除菜单自身属性
        int rows = sysMenuDao.deleteObject(id);
        if(rows==0){
            throw new ServiceException("记录已经不存在了");
        }
        //返回结果
        return rows;
    }
}
