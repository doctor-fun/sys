package com.cj.jtsys.sys.Controller;

import com.cj.jtsys.sys.common.vo.JsonResult;
import com.cj.jtsys.sys.entity.SysUser;
import com.cj.jtsys.sys.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user/")
public class SysUserController {
    @Autowired
    private SysUserService sysUserService;

    @RequestMapping("doFindObjectById")
    public JsonResult doFindObjectById(Integer id){
        return new JsonResult(sysUserService.findObjectById(id));
    }

    @RequestMapping("doFindPageObjects")
    public JsonResult doFindPageObjects(String username,Integer pageCurrent){
        return new JsonResult(sysUserService.findPageObjects(username,pageCurrent));
    }

    @RequestMapping("doValidById")
    public JsonResult doValidById(Integer id,Integer valid){
        sysUserService.validById(id,valid,"admin");
        return new JsonResult("update ok");
    }
    @RequestMapping("doSaveObject")
    public JsonResult doSaveObject(SysUser sysUser,Integer[] roleIds){
    sysUserService.saveObject(sysUser, roleIds);
        return new JsonResult("save ok" );
    }

    @RequestMapping("doUpdateObject")
    public JsonResult doUpdateObject(SysUser sysUser,Integer[] roleIds){
        sysUserService.updateObject(sysUser, roleIds);
        return new JsonResult("update ok" );
    }

}
