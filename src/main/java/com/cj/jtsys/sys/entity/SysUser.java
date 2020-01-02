package com.cj.jtsys.sys.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class SysUser implements Serializable {

    private static final long serialVersionUID = -5785520088339110279L;
    private Integer id;
    private String username;
    private String password;
    private String salt;
    private String email;
    private String mobile;
    private Integer valid=1;
    private Integer deptId;
    private Date createTime;
    private Date modifiedTime;
    private String createdUser;
    private String modifiedUser;


}
