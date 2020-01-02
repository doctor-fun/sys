package com.cj.jtsys.sys.Controller;

import com.cj.jtsys.sys.service.SysMenuService;
import com.cj.jtsys.sys.common.vo.JsonResult;
import com.cj.jtsys.sys.entity.SysMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/menu/")
public class SysMenuController {



    @Autowired
    private SysMenuService sysMenuService;
    @RequestMapping("/doFindObjects")
    public JsonResult doFindObjects(){
        return new JsonResult(sysMenuService.findAll());
    }


    @RequestMapping("doDeleteObject")
    public  JsonResult doDeleteObject(Integer id)
    {
        sysMenuService.deleteObject(id);
        return  new JsonResult("delete Ok");
    }

    @RequestMapping("doFindZtreeMenuNodes")
    public JsonResult doFindZtreeMenuNodes(){
        return new JsonResult(sysMenuService.findZtreeMenuNode());
    }

    @RequestMapping("doSaveObject")
    //springmvc会自动将页面控件元素的name值放到sysMenu的同名属性内
    public JsonResult doSaveObject(SysMenu sysMenu){
        sysMenuService.saveObject(sysMenu);
        return new JsonResult("saveOk");
    }
    @RequestMapping("doUpdateObject")
    //springmvc会自动将页面控件元素的name值放到sysMenu的同名属性内
    public JsonResult doUpdateObject(SysMenu sysMenu){
        sysMenuService.updateObject(sysMenu);
        return new JsonResult("update Ok");
    }



}
