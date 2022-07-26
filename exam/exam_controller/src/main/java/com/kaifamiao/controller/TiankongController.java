package com.kaifamiao.controller;

import com.kaifamiao.model.PanduanModel;
import com.kaifamiao.model.TiankongModel;
import com.kaifamiao.model.XuanzeModel;
import com.kaifamiao.service.PanduanService;
import com.kaifamiao.service.TiankongService;
import com.kaifamiao.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tiankong")
@CrossOrigin
public class TiankongController {

    @Autowired
    private TiankongService tiankongService;

    @RequestMapping("/insert")
    public int insert(TiankongModel tiankongModel){
        return tiankongService.insert(tiankongModel);
    }

    @RequestMapping("/delete")
    @CrossOrigin
    public ResponseUtil delete(TiankongModel tiankongModel){
        if(tiankongService.delete(tiankongModel) > 0 ) return ResponseUtil.ok("删除成功",1);
        return ResponseUtil.error("删除失败");
    }

    @RequestMapping("/update")
    @CrossOrigin
    public int update(TiankongModel tiankongModel){
        return tiankongService.update(tiankongModel);
    }

    @RequestMapping("/findAll")
    @CrossOrigin
    public List<TiankongModel> findAll(){
        return tiankongService.findAll(null);
    }

}
