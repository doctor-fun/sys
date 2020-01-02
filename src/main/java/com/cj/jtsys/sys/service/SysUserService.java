package com.cj.jtsys.sys.service;

import com.cj.jtsys.sys.common.vo.PageObject;
import com.cj.jtsys.sys.common.vo.SysUserDeptVo;
import com.cj.jtsys.sys.entity.SysUser;

import java.util.Map;

public interface SysUserService {

    /**
     *基于用户id获取用户以及用户对应的角色信息
     * @param id
     * @return
     */
    Map<String,Object> findObjectById(Integer id  );

    /**
     * 更新用户信息及关系数据
     * @param sysUser
     * @param roleIds
     * @return
     */
    int updateObject(SysUser sysUser,Integer[] roleIds);




    /**
     * 保存用户信息及关系数据
     * @param sysUser
     * @param roleIds
     * @return
     */
    int saveObject(SysUser sysUser,Integer[] roleIds);


    int validById(Integer id,Integer valid,String modifiedUser);

    PageObject<SysUserDeptVo> findPageObjects(
            String username,Integer pageCurrent
    );
}
