package com.cj.jtsys.sys.service.impl;

import com.cj.jtsys.sys.common.vo.PageObject;
import com.cj.jtsys.sys.common.vo.SysUserDeptVo;
import com.cj.jtsys.sys.config.PageProperties;
import com.cj.jtsys.sys.dao.SysUserDao;
import com.cj.jtsys.sys.dao.SysUserRoleDao;
import com.cj.jtsys.sys.entity.SysUser;
import com.cj.jtsys.sys.exception.ServiceException;
import com.cj.jtsys.sys.pageUtils.Assert;
import com.cj.jtsys.sys.service.SysUserService;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.jvm.hotspot.debugger.Page;
import sun.security.krb5.internal.PAData;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class SysUserServiceImpl implements SysUserService {
@Autowired
private PageProperties pageProperties;

    @Autowired
    private SysUserDao sysUserDao;

    @Autowired
    private SysUserRoleDao sysUserRoleDao;
    @Override
    public PageObject<SysUserDeptVo> findPageObjects(String username, Integer pageCurrent) {

        //参数校验
        Assert.isValid(pageCurrent!=null&&pageCurrent>0,"当前页码不正确");
        //查询总记录数并校验
        int rowCount = sysUserDao.getRowCount(username);
        if(rowCount==0)
            throw new ServiceException("没有对应记录");
        //查询当前页记录
        int pageSize = pageProperties.getPageSize();
        int startIndex=(pageCurrent-1)*pageSize;
        List<SysUserDeptVo> records = sysUserDao.findPageObjects(username, startIndex, pageSize);

        //封装查询结果
        return new PageObject<>(records,rowCount,pageCurrent,pageSize);
    }

    @Override
    public int validById(Integer id, Integer valid, String modifiedUser) {
        //参数校验
        Assert.isValid(id!=null&&id>0,"id值无效");
        Assert.isValid(valid!=null&&(valid==1||valid==0),"状态无效");
        //修改状态
        int rows = sysUserDao.validById(id, valid, modifiedUser);
        if(rows==0)
            throw new ServiceException("记录可能不存在");
        //返回结果
        return rows;
    }

    @Override
    public int saveObject(SysUser sysUser, Integer[] roleIds) {
       //参数校验
        Assert.isNull(sysUser,"保存对象不能为空");
        Assert.isEmpty(sysUser.getUsername(),"用户名不能为空");
        Assert.isEmpty(sysUser.getPassword(),"密码不能为空");
        Assert.isEmpty(roleIds,"必须为用户分配角色");
        //2.保存用户自身数据
        //2.1pwd加密
        String salt = UUID.randomUUID().toString();
        SimpleHash sh = new SimpleHash("MD5", sysUser.getPassword(), salt, 1);
        //algorithmName算法名称,md5算法
        //source未加密的密码
        //salt//盐值
        //hashIteration//加密次数
        String newPassword=sh.toHex();//原来的十进制太长，换成16进制进行保存
        //2.2存储到实体对象中
        sysUser.setSalt(salt);
        sysUser.setPassword(newPassword);

        //2.3持久化用户信息
        int rows = sysUserDao.insertObject(sysUser);
        //保存关系数据
        sysUserRoleDao.insertObjects(sysUser.getId(),roleIds);
        return rows;
    }

    @Override
    public Map<String, Object> findObjectById(Integer id) {
        //参数校验
        Assert.isValid(id!=null&&id>0,"id值无效");


        //查询用户以及用户对应的部门信息
        SysUserDeptVo user = sysUserDao.findObjectById(id);
        Assert.isNull(user,"对象不存在");
        if(user==null)
            throw new ServiceException("用户不存在");

        //查询用户对应的角色信息
        List<Integer> roleIds = sysUserRoleDao.findRoleIdsByUserId(id);
        //封装结果并返回
        Map<String,Object> map=new HashMap<>();
        map.put("user",user);
        map.put("roleIds",user);
        return map;
    }
    @Override
    public int updateObject(SysUser sysUser, Integer[] roleIds) {
        //参数校验
        Assert.isNull(sysUser,"保存对象不能为空");
        Assert.isEmpty(sysUser.getUsername(),"用户名不能为空");
        Assert.isEmpty(roleIds,"必须为用户分配角色");
        //保存用户自身信息
        int rows = sysUserDao.updateObject(sysUser);
        //保存关系数据和角色关系数据
        //先删后改
        sysUserRoleDao.deleteObjectsByUserId(sysUser.getId());
        sysUserRoleDao.insertObjects(sysUser.getId(),roleIds);
        return rows;
    }



}
