package com.cj.jtsys.sys.service;

import com.cj.jtsys.sys.common.vo.CheckBox;
import com.cj.jtsys.sys.common.vo.PageObject;
import com.cj.jtsys.sys.entity.SysRole;
import com.cj.jtsys.sys.vo.SysRoleMenuVo;
import com.sun.tools.javac.comp.Check;

import java.util.List;


public interface SysRoleService {
    /**
     * 查询所有的角色信息
     * @return
     */
    List<CheckBox> findObjects();
    /**
     * 通过角色id查询角色信息，并查询角色菜单id，封装到sysRoleMenuVo这个vo对象中
     * @param id
     * @return
     */

    SysRoleMenuVo findObjectById(Integer id);

    /**
     * 更新角色以及角色对应的菜单关系数据
     * @param sysRole
     * @param ids
     * @return
     */
    int updateObject(SysRole sysRole,Integer[] ids);


    /**
     * 保存角色以及角色对应的关系数据
     * @param sysRole
     * @param ids
     * @return
     */
    int saveObject(SysRole sysRole,Integer[] ids);
    /**
     * 基于id删除角色以及对应的用户关系
     * @param id
     * @return
     */
    int deleteObject(Integer id);
    /**
     * 分页查询角色信息
     * @param name
     * @param pageCurrent
     * @return
     */
    PageObject <SysRole> findPageObject(String name,Integer pageCurrent);

}
