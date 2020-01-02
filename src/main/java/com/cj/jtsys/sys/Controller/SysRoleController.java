package com.cj.jtsys.sys.Controller;

import com.cj.jtsys.sys.service.SysRoleService;
import com.cj.jtsys.sys.common.vo.JsonResult;
import com.cj.jtsys.sys.entity.SysRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RequestMapping("/role/")
@RestController
public class SysRoleController {
    @Autowired
    private SysRoleService sysRoleService;

    @RequestMapping("doFindPageObjects")
    public JsonResult doFindPageObjects(String name,Integer pageCurrent){
        return new JsonResult(sysRoleService.findPageObject(name,pageCurrent));
    }

    @RequestMapping("doDeleteObject")
    public JsonResult doDeleteObject(Integer id){
        sysRoleService.deleteObject(id);
        return  new JsonResult("delete ok");
    }


    @RequestMapping("doUpdateObject")
    public JsonResult doUpdateObject(SysRole sysRole,Integer[] menuIds)
    {
        sysRoleService.updateObject(sysRole,menuIds);
        return new JsonResult("update ok");
    }
    @RequestMapping("doSaveObject")
    public JsonResult doSaveObject(SysRole sysRole,Integer[] menuIds)
    {
        sysRoleService.saveObject(sysRole,menuIds);
        return new JsonResult("save ok");
    }
    @RequestMapping("doFindObjectById")
    public JsonResult doFindObjectById(Integer id){
        return new JsonResult(sysRoleService.findObjectById(id));
    }


    @RequestMapping("doFindRoles")
    public JsonResult doFindRoles(){
        return new JsonResult(sysRoleService.findObjects());
    }
}
