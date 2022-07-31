package com.kaifamiao.controller;

import com.kaifamiao.model.TiankongModel;
import com.kaifamiao.model.XuanzeModel;
import com.kaifamiao.service.XuanzeService;
import com.kaifamiao.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/xuanze")
@CrossOrigin
public class XuanzeController {

    @Autowired
    private XuanzeService xuanzeService;

    @RequestMapping("/insert")
    public int insert(XuanzeModel xuanzeModel){
        return xuanzeService.insert(xuanzeModel);
    }

    @RequestMapping("/delete")
    @CrossOrigin
    public ResponseUtil delete(XuanzeModel xuanzeModel){
         if(xuanzeService.delete(xuanzeModel) > 0 ) return ResponseUtil.ok("删除成功",1);
         return ResponseUtil.error("删除失败");
    }

    @RequestMapping("/update")
    @CrossOrigin
    public ResponseUtil update(XuanzeModel xuanzeModel){
        if( xuanzeService.update(xuanzeModel) > 0) return ResponseUtil.ok("修改成功",1) ;
        return ResponseUtil.error("修改失败");
    }
    @RequestMapping("/findAll")
    @CrossOrigin
    public List<XuanzeModel> findAll(){
        return xuanzeService.findAll(null);
    }

}
