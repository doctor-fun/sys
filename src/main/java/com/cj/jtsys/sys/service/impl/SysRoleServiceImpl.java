package com.cj.jtsys.sys.service.impl;

import com.cj.jtsys.sys.common.vo.CheckBox;
import com.cj.jtsys.sys.service.SysRoleService;
import com.cj.jtsys.sys.common.vo.PageObject;
import com.cj.jtsys.sys.config.PageProperties;
import com.cj.jtsys.sys.dao.SysRoleDao;
import com.cj.jtsys.sys.dao.SysRoleMenuDao;
import com.cj.jtsys.sys.dao.SysUserRoleDao;
import com.cj.jtsys.sys.entity.SysRole;
import com.cj.jtsys.sys.exception.ServiceException;
import com.cj.jtsys.sys.pageUtils.Assert;
import com.cj.jtsys.sys.vo.SysRoleMenuVo;
import com.sun.tools.javac.comp.Check;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SysRoleServiceImpl implements SysRoleService {

    @Autowired
    private PageProperties pageProperties;
    @Autowired
    private SysRoleMenuDao sysRoleMenuDao;
    @Autowired
    private SysUserRoleDao sysUserRoleDao;
    @Autowired
    private SysRoleDao sysRoleDao;

    @Override
    public PageObject<SysRole> findPageObject(String name, Integer pageCurrent) {
        //验证参数有效性
        Assert.isValid(pageCurrent!=null&&pageCurrent>0,"页码值无效");
        //查询总记录数并校验
        int rowCount = sysRoleDao.getRowCount(name);
        if(rowCount==0)
            throw new ServiceException("记录不存在");
        //查询当前页要呈现的记录

        int pageSize=pageProperties.getPageSize();
        int startIndex=(pageCurrent-1)*pageSize;//前面页数乘以每页大小就是当前页的起始值
        //返回结果
        List<SysRole> records = sysRoleDao.findPageObjects(name, startIndex, pageSize);

        return new PageObject<>(records,rowCount,pageCurrent,pageSize);
    }

    @Override
    public int deleteObject(Integer id) {
        //校验数据
        Assert.isValid(id!=null&&id>0,"id值无效");
        //删除关系数据
        sysRoleMenuDao.deleteObjectsByRoleId(id);
        sysUserRoleDao.deleteObjectsByRoleId(id);
        //删除自身信息
        int rows = sysRoleDao.deleteObject(id);

        //校验并返回结果
        if(rows==0)
            throw new ServiceException("记录可能已经不存在");
        return  rows;
    }

    @Override
    public int saveObject(SysRole sysRole, Integer[] menuIds) {
        //参数校验
        Assert.isNull(sysRole,"保存对象不能为空");
        Assert.isEmpty(sysRole.getName(),"角色名不能为空");
        Assert.isEmpty(menuIds,"必须为角色授权");
        //保存角色自身信息
        int rows=sysRoleDao.insertObject(sysRole);
        //保存角色菜单关系数据
//        角色菜单每条数据形如(sysRole.getID()
        sysRoleMenuDao.insertObjects(sysRole.getId(),menuIds);
        return rows;
    }

    @Override
    public SysRoleMenuVo findObjectById(Integer id) {
        //参数校验
        Assert.isValid(id!=null&&id>0,"id不能为空");
        //2基于id查询角色

        SysRoleMenuVo rm = sysRoleDao.findObjectById(id);
        if(rm==null)
            throw new ServiceException("记录不存在");

        return rm;

    }

    @Override
    public int updateObject(SysRole sysRole, Integer[] menuIds) {
        //参数校验
        Assert.isNull(sysRole,"保存对象不能为空");
        Assert.isEmpty(sysRole.getName(),"角色名不能为空");
        Assert.isEmpty(menuIds,"必须为角色授权");
        //保存角色自身信息
        int rows=sysRoleDao.insertObject(sysRole);
    //删除原有的角色-菜单关系数据
        sysRoleMenuDao.deleteObjectsByRoleId(sysRole.getId());
        //保存角色菜单关系数据s
//        角色菜单每条数据形如(sysRole.getID()
        sysRoleMenuDao.insertObjects(sysRole.getId(),menuIds);
        return rows;
    }

    @Override
    public List<CheckBox> findObjects() {
        return sysRoleDao.findObjects();
    }
}
