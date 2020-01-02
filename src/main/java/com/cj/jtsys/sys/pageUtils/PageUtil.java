package com.cj.jtsys.sys.pageUtils;
//省代码用的
public class PageUtil {
    public static void isVailid(Integer pageCurrent){
        if(pageCurrent==null||pageCurrent<1)
               throw new IllegalArgumentException("当前页码不正确");
        }
 }
