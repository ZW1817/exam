package com.kaifamiao.controller;

import com.kaifamiao.model.PanduanModel;
import com.kaifamiao.model.TiankongModel;
import com.kaifamiao.service.PanduanService;
import com.kaifamiao.service.TiankongService;
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
    public int delete(TiankongModel tiankongModel){
        return tiankongService.delete(tiankongModel);
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
