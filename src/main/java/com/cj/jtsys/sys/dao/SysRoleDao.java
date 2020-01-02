package com.cj.jtsys.sys.dao;

import com.cj.jtsys.sys.common.vo.CheckBox;
import com.cj.jtsys.sys.entity.SysRole;
import com.cj.jtsys.sys.vo.SysRoleMenuVo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface SysRoleDao {
    /**
     * 查询所有的角色的Id，name
     * @return
     */
    @Select("select id,name from sys_roles")
    List<CheckBox> findObjects();

    /**
     *基于角色id查询角色以及角色对应的菜单信息
     * @param id
     * @return
     */

    SysRoleMenuVo findObjectById(Integer id);
    /**
     * 写入角色自身信息
     * @param sysRole
     * @return
     */
    int insertObject(SysRole sysRole);
    /**
     * 基于角色id删除角色和用户关系数据
     * @param id
     * @return
     */
    @Delete("delete from sys_roles where id=#{id}")
    int deleteObject(Integer id);
    /**
     * 基于条件（模糊查询）统计角色总数
     * @param name
     * @return
     */
    int getRowCount(@Param("name") String name);

    /**
     * 基于条件查询当前页要呈现的记录
     * @param name
     * @param startIndex
     * @param pageSize
     * @return
     */
    List<SysRole> findPageObjects(@Param("name") String name ,
                              @Param("startIndex")  Integer startIndex,
                              @Param("pageSize")  Integer pageSize);
}
