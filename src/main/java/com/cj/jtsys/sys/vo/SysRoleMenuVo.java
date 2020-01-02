package com.cj.jtsys.sys.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

//vo对象，用于封装角色id和角色和菜单关系数据
@Data
public class SysRoleMenuVo implements Serializable {
    private static final long serialVersionUID = -7261235381786788547L;
    //角色id
    private Integer id;
    private String name;
    private String note;
    private List<Integer> menuIds;
}
