package com.cj.jtsys.sys.service.impl;

import com.cj.jtsys.sys.service.SysLogService;
import com.cj.jtsys.sys.common.vo.PageObject;
import com.cj.jtsys.sys.config.PageProperties;
import com.cj.jtsys.sys.dao.SysLogDao;
import com.cj.jtsys.sys.entity.SysLog;

import com.cj.jtsys.sys.exception.ServiceException;
import com.cj.jtsys.sys.pageUtils.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@Service
//command+ i是重写方法
public class SysLogServiceImpl implements SysLogService {

    @Autowired
   private SysLogDao sysLogDao;
    @Autowired
    private   PageProperties pageProperties;

    @Override
    public int deleteObjects(Integer... ids) {
        //1.验证参数合法性
     Assert.isTrue(ids!=null&&ids.length>0,"请先选择要删除哪些条目");
    int rows= sysLogDao.deleteObjects(ids);
     if(rows==0){
         throw new ServiceException("记录可能已经不存在了");

     }
        return rows;
    }

    @Override
    public PageObject<SysLog> findPageObject(String username, Integer pageCurrent) {

            //1.验证参数合法性
            //1.1验证pageCurrent的合法性，
            //不合法抛出IllegalArgumentException异常
//        Assert.isTrue(pageCurrent!=null&&pageCurrent>=1, "页码值无效");
        PageUtil.isVailid(pageCurrent);
            //2.基于条件查询总记录数
            //2.1) 执行查询,所有行
            int rowCount=sysLogDao.getRowCount(username);
            //2.2) 验证查询结果，假如结果为0不再执行如下操作
            if(rowCount==0)
                throw new ServiceException("系统没有查到对应记录");
            //3.基于条件查询当前页记录(pageSize定义为2)
            //3.1)定义pageSize

            int pageSize=pageProperties.getPageSize();
            //3.2)计算startIndex
            int startIndex=(pageCurrent-1)*pageSize;
            //3.3)执行当前数据的查询操作
            List<SysLog> records=
                    sysLogDao.findPageObjects(username, startIndex, pageSize);
            //4.对分页信息以及当前页记录进行封装
            //4.1)构建PageObject对象
            PageObject<SysLog> pageObject=new PageObject<>();
            //4.2)封装数据
            pageObject.setPageCurrent(pageCurrent);
            pageObject.setPageSize(pageSize);
            pageObject.setRowCount(rowCount);
            pageObject.setRecords(records);
            pageObject.setPageCount((rowCount-1)/pageSize+1);
            //5.返回封装结果。
            return pageObject;
        }



}
