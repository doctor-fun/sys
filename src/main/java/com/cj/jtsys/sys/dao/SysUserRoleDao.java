package com.cj.jtsys.sys.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SysUserRoleDao {
    /**
     * 基于用户id查询用户对应角色id;
     * @param id
     * @return
     */
   List<Integer> findRoleIdsByUserId(Integer id);


    int insertObjects(@Param("userId") Integer userId,@Param("roleIds")Integer... roleIds);
    /**
     * 基于角色id删除用户和角色关系数据
     * @param id
     * @return
     */
    @Delete("delete from sys_user_roles where role_id=#{id}")
    int deleteObjectsByRoleId(Integer id);

    /**
     * 基于用户id删除用户和角色关系数据
     * @param id
     * @return
     */
    @Delete("delete from sys_user_roles where user_id=#{id}")
    int deleteObjectsByUserId(Integer id);
}
