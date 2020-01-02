package com.cj.jtsys.sys.common.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 基于此对象封装控制层对象的响应结果
 * 在此对象中应该包含返回到客户端的数据以及一个状态码和状态信息
 */
@Data
@NoArgsConstructor
public class JsonResult  implements Serializable {
    private static final long serialVersionUID = 2849128529592269805L;
    //状态码
    private  int state=1;//初始状态码为1，表示正常
    //状态码对应的信息
    private String message="ok";
    private Object data;//用于保存结果数据实体
    public JsonResult(String message){
        this.message=message;
    }
    public JsonResult(Object data){
        this.data=data;
    }
//如果入口参数是个e（异常类），调用这个构造函数，并执行
    public JsonResult(Throwable e){
        this.state=0;
        this.message=e.getMessage();
    }





}
