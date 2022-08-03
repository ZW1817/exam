package com.kaifamiao.controller;

import com.kaifamiao.model.JiandaModel;
import com.kaifamiao.model.PanduanModel;
import com.kaifamiao.model.TiankongModel;
import com.kaifamiao.model.XuanzeModel;
import com.kaifamiao.service.PanduanService;
import com.kaifamiao.service.XuanzeService;
import com.kaifamiao.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/panduan")
@CrossOrigin
public class PanduanController {

    @Autowired
    private PanduanService panduanService;

    @RequestMapping("/insert")
    public int insert(PanduanModel panduanModel){
        return panduanService.insert(panduanModel);
    }

    @RequestMapping("/delete")
    @CrossOrigin
    public ResponseUtil delete(PanduanModel panduanModel){
        if(panduanService.delete(panduanModel) > 0 ) return ResponseUtil.ok("删除成功",1);
        return ResponseUtil.error("删除失败");
    }

    @RequestMapping("/update")
    @CrossOrigin
    public ResponseUtil update(PanduanModel panduanModel){
        if( panduanService.update(panduanModel) > 0) return ResponseUtil.ok("修改成功",1) ;
        return ResponseUtil.error("修改失败");
    }
    @RequestMapping("/findAll")
    @CrossOrigin
    public List<PanduanModel> findAll(){
        return panduanService.findAll(null);
    }

}
