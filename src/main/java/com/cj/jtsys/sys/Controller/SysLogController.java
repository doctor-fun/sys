package com.cj.jtsys.sys.Controller;

import com.cj.jtsys.sys.service.SysLogService;
import com.cj.jtsys.sys.common.vo.JsonResult;
import com.cj.jtsys.sys.common.vo.PageObject;
import com.cj.jtsys.sys.entity.SysLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/log/")
public class SysLogController {
    @Autowired
    private SysLogService sysLogService;
    @ResponseBody
    @RequestMapping("doFindPageObjects")
    public JsonResult doFindPageObjets(
        String username,Integer pageCurrent){
        //找到目标用户特定页码下的页面数据
        PageObject<SysLog> pageObject=sysLogService.findPageObject(username,pageCurrent);
        return new JsonResult(pageObject);

    }



    @ResponseBody
    @RequestMapping("doDeleteObjects")
    public JsonResult doDeleteObjects(Integer... ids){
        sysLogService.deleteObjects(ids);
        return new JsonResult("delete OK");

    }
}
