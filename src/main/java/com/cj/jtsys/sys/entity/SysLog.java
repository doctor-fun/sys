package com.cj.jtsys.sys.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
//这是个持久层PO,属性与数据库行11对应，需要实现序列化，用于存储对象的数据都要有序列化ID
//把对象转化为字节称为序列化
//因为在构建过程中java类字节码对象会动态变化，需要一个id方便与其对象绑定，这个id初始时是根据属性结构生成的，所以必须刚开始就指定
public class SysLog  implements Serializable {

    private static final long serialVersionUID = -1050504365111644352L;
    private Integer id;
    //用户名
    private String username;
    //用户操作
    private String operation;
    //请求方法
    private String method;
    //请求参数
    private String params;
    //执行时长(毫秒)
    private Long time;
    //IP地址
    private String ip;
    //创建时间
    private Date createdTime;


}
