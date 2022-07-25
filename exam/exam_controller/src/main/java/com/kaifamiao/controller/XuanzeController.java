package com.kaifamiao.controller;

import com.kaifamiao.model.XuanzeModel;
import com.kaifamiao.service.XuanzeService;
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
    public int delete(XuanzeModel xuanzeModel){
        return xuanzeService.delete(xuanzeModel);
    }

    @RequestMapping("/update")
    @CrossOrigin
    public int update(XuanzeModel xuanzeModel){
        return xuanzeService.update(xuanzeModel);
    }

    @RequestMapping("/findAll")
    @CrossOrigin
    public List<XuanzeModel> findAll(){
        return xuanzeService.findAll(null);
    }

}
