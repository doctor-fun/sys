package com.cj.jtsys.sys.web;


import com.cj.jtsys.sys.common.vo.JsonResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 定义全局异常处理方法
 */
@ControllerAdvice//全局的异常处理类
//参数异常也是运行时异常
//有局部的异常就先执行局部异常处理类
public class GlobalExceptionHandler {
    /**
     * 异常处理方法
     * @param e
     * @return
     */
    @ResponseBody
    @ExceptionHandler(RuntimeException.class)//可以处理的异常类型
    public JsonResult doHandlerRuntimeException(RuntimeException e){
        e.printStackTrace();
        System.out.println("==Global==");
        return new JsonResult(e);
    }
}
