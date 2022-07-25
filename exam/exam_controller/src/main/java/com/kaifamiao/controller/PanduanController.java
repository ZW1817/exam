package com.kaifamiao.controller;

import com.kaifamiao.model.PanduanModel;
import com.kaifamiao.model.XuanzeModel;
import com.kaifamiao.service.PanduanService;
import com.kaifamiao.service.XuanzeService;
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
    public int delete(PanduanModel panduanModel){
        return panduanService.delete(panduanModel);
    }

    @RequestMapping("/update")
    @CrossOrigin
    public int update(PanduanModel panduanModel){
        return panduanService.update(panduanModel);
    }

    @RequestMapping("/findAll")
    @CrossOrigin
    public List<PanduanModel> findAll(){
        return panduanService.findAll(null);
    }

}
