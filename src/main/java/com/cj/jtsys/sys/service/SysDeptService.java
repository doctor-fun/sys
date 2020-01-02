package com.cj.jtsys.sys.service;

import java.util.List;
import java.util.Map;

import com.cj.jtsys.sys.common.vo.Node;
import com.cj.jtsys.sys.entity.SysDept;

public interface SysDeptService {
	 List<Map<String,Object>> findObjects();
	 List<Node> findZTreeNodes();
	 int saveObject(SysDept entity);
	 int updateObject(SysDept entity);
	 int deleteObject(Integer id);
}
