package com.cj.jtsys.sys.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SysRoleMenuDao {
    /**
     * 基于角色id查询菜单对应的ids
     * @param id
     * @return
     */
    int findMenuIdsByRoleId(Integer id);



    /**
     * 基于角色id和角色对应的菜单ids，保存数据
     * @param roleId
     * @param menuIds
     * @return
     */
    int insertObjects(@Param("roleId") Integer roleId,@Param("menuIds")Integer[] menuIds);
    /**
     * 基于角色id删除角色，菜单关系菜单数据
     * @param id
     * @return
     */
    @Delete("delete from sys_role_menus where role_id=#{id}")
    int deleteObjectsByRoleId(Integer id);
    /**
     * 基于菜单id删除角色和菜单关系数据
     * @param id
     * @return
     */
    @Delete("delete from sys_role_menus where menu_id=#{id}")
    int deleteObjectsByMenuId(Integer id);
}
