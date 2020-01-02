package com.cj.jtsys.sys.Controller;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.atomic.AtomicLong;

@Controller
@RequestMapping("/")
//用于统一处理页面显示
public class PageController {
    private AtomicLong al=new AtomicLong();
    @RequestMapping("/doIndexUI")
    public String doIndexUI(){
       String tname= Thread.currentThread().getName();
        System.out.println(tname);
        System.out.println( al.incrementAndGet());
        return "starter";//starter页面里会执行js函数，请求其他页面（load是异步的）
    }

    @RequestMapping("/log/log_list")
    public String doLogUI(){
        return "sys/log_list";//view
    }



    @RequestMapping("doPageUI")
    public String doPageUI(){
        return "common/page";
    }

    @RequestMapping("menu/menu_list")
    public String doMenuUI()  {
        return "sys/menu_list";
    }


    @RequestMapping("{module}/{moduleUI}")
    public String doModuleUI(@PathVariable String moduleUI){
        return "sys/"+moduleUI;
    }



//    @RequestMapping("/log/doDeleteObjects")
//    public String doDeleteObject(@Param("ids") Integer... ids){
//
//
//    }
}
