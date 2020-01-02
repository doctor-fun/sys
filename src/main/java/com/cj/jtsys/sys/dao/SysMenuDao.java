package com.cj.jtsys.sys.dao;

import com.cj.jtsys.sys.common.vo.Node;
import com.cj.jtsys.sys.entity.SysMenu;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;


import java.util.List;
import java.util.Map;

@Mapper
public interface SysMenuDao {
    /**
     * 数据的持久化
     * @param sysMenu 被持久化的对象
     * @return 更新的行数
     */


    int updateObject(SysMenu sysMenu);

    /**
     * 查询菜单节点信息（id,name,parentId）
     * @return
     */
    //ztree是JS插件，用于显示JS树结构，这个方法就是找到数结构上的点
    @Select("select id,name,parentId from sys_menus")
    List<Node> findZtreeMenuNode();


    //查询所有菜单以及对应的上级菜单名称，一行记录映射为一个Map
    //map的string是数据库列名，Object是值
    List<Map<String,Object>> findAll();


    /**
     * 统计当前菜单中子菜单的数量
     * @param id
     * @return
     */
    @Select("select count(*) from sys_menus where parentId=#{id}")
    int getChildCount(Integer id);

    /**
     * 基于id删除当前菜单
     * @param id
     * @return
     */
    @Delete("delete from sys_menu where id=#{id}")
    int deleteObject(Integer id);

    /**
     * 数据的持久化
     * @param entity 被持久化的对象
     * @return 更新的行数
     */
    int insertObject(SysMenu entity);

}
