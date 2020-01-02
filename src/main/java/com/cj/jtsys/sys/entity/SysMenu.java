package com.cj.jtsys.sys.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class SysMenu implements Serializable {
    private static final long serialVersionUID = 1651850392170707023L;
    private  int id;
    private String name;
    private String url;
    private  int type;
    private int sort;
    private String note;
    private int parentId;
    private  String permission;
    private String createdUser;
    private String modifiedUser;
    private Date createdTime;
    private Date modifiedTime;

}
