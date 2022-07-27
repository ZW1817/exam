package com.kaifamiao.controller;

import com.kaifamiao.model.JiandaModel;
import com.kaifamiao.model.PanduanModel;
import com.kaifamiao.service.JiandaService;
import com.kaifamiao.service.PanduanService;
import com.kaifamiao.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/jianda")
@CrossOrigin
public class JiandaController {

    @Autowired
    private JiandaService jiandaService;

    @RequestMapping("/insert")
    public int insert(JiandaModel jiandaModel){
        return jiandaService.insert(jiandaModel);
    }

    @RequestMapping("/delete")
    @CrossOrigin
    public ResponseUtil delete(JiandaModel jiandaModel){
        if(jiandaService.delete(jiandaModel) > 0 ) return ResponseUtil.ok("删除成功",1);
        return ResponseUtil.error("删除失败");
    }

    @RequestMapping("/update")
    @CrossOrigin
    public ResponseUtil update(JiandaModel jiandaModel){
        if( jiandaService.update(jiandaModel) > 0) return ResponseUtil.ok("修改成功",1) ;
        return ResponseUtil.error("修改失败");
    }

    @RequestMapping("/findAll")
    @CrossOrigin
    public List<JiandaModel> findAll(){
        return jiandaService.findAll(null);
    }

}
