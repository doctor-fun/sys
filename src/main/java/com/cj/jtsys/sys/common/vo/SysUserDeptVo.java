package com.cj.jtsys.sys.common.vo;

import com.cj.jtsys.sys.entity.SysDept;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class SysUserDeptVo implements Serializable  {


    private static final long serialVersionUID = -3361128248861534771L;
    private Integer id;
    private String username;
    private String password; //加盐
    private String salt;
    private String email;
    private String mobile;
    private Integer valid=1;

    private SysDept sysDept;

    private Date createTime;
    private Date modifiedTime;
    private String createUser;
    private String modifiedUser;
}
