package com.cj.jtsys.sys.dao;

import com.cj.jtsys.sys.common.vo.SysUserDeptVo;
import com.cj.jtsys.sys.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface SysUserDao {
    /**
     * 更新用户信息
     * @param sysUser
     * @return
     */
    int updateObject(SysUser sysUser);


    /**
     *
     * 查询用户以及用户对应的部门信息
     * @param id
     * @return
     */
    SysUserDeptVo findObjectById(Integer id);

    /**
     * 保存用户信息
     * @param sysUser
     * @return
     */
    int insertObject(SysUser sysUser);
    /**
     * 用户禁用，启用操作实现
     * @param id
     * @param valid
     * @param modifiedUser
     * @return
     */
    @Update("update sys_users set valid=#{valid},modifiedUser=#{modifiedUser},modifiedTime=now() where id=#{id}")
    int validById(
            @Param("id") Integer id,
            @Param("valid") Integer valid,
            @Param("modifiedUser") String modifiedUser);

    /**
     * 查询总记录数
     * @param username
     * @return
     */
    int getRowCount(@Param("username") String username);

    /**
     * 基于当前页查询总记录数
     * @param username
     * @param startIndex
     * @param pageSize
     * @return
     */
    List<SysUserDeptVo> findPageObjects(
            @Param("username")String username,
            @Param("startIndex") Integer startIndex,
            @Param("pageSize") Integer pageSize);
}
