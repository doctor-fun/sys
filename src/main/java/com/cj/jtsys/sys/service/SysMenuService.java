package com.cj.jtsys.sys.service;

import com.cj.jtsys.sys.common.vo.Node;
import com.cj.jtsys.sys.entity.SysMenu;

import java.util.List;
import java.util.Map;

public interface SysMenuService {

    List<Node> findZtreeMenuNode();
    int deleteObject(Integer id);
    List<Map<String,Object>> findAll();
    int saveObject(SysMenu sysMenu);
    int updateObject(SysMenu sysMenu);

 }
