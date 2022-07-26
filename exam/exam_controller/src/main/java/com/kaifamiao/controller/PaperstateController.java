package com.kaifamiao.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kaifamiao.mapper.ShijuanitemMapper;
import com.kaifamiao.model.*;
import com.kaifamiao.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/paperstate")
@CrossOrigin
public class PaperstateController {
    @Autowired
    private PaperstateService paperstateService;

    @Autowired
    private PanduanService panduanService;

    @Autowired
    private XuanzeService xuanzeService;

    @Autowired
    private TiankongService tiankongService;

    @Autowired
    private JiandaService jiandaService;

    @Autowired
    private ShijuanitemService shijuanitemService;

    @RequestMapping("/findALL")
    @CrossOrigin
    public List<Map<String, Object>> findALL() {
        return paperstateService.selectStdudent();
    }

    @RequestMapping("/zujuan")
    @CrossOrigin("*")
//            @RequestBody List<Zujuan> zujuans
    public Integer zujuan(@RequestBody shijuanList shijuanLists) {
        System.out.println(shijuanLists);
        ShijuanModel shijuanModel = new ShijuanModel();
        ShijuanitemModel shijuanitemModel = new ShijuanitemModel();
        shijuanModel.setKmid(9);
        shijuanModel.setTitle(shijuanLists.getShijuanname());
        shijuanModel.setTno(shijuanLists.getTno());
        shijuanModel.setZongfen(shijuanLists.getTotal());
        shijuanModel.setStarttime(new Date());
        Integer shijuanId = paperstateService.createShijuan(shijuanModel);
        for (int i = 0; i < shijuanLists.getZujuans().size(); i++) {
            if (shijuanLists.getZujuans().get(i).getQtype() == 0) {
                if (shijuanLists.getZujuans().get(i).getTnum() > 0) {
                    List<XuanzeModel> list = xuanzeService.selectRandNum(shijuanLists.getZujuans().get(i).getTnum());
                    for (int j = 0; j < shijuanLists.getZujuans().get(i).getTnum(); j++) {
                        shijuanitemModel.setShijuanid(shijuanId);
                        shijuanitemModel.setQtype(shijuanLists.getZujuans().get(i).getQtype());
                        shijuanitemModel.setFenshu(shijuanLists.getZujuans().get(i).getScore());
                        shijuanitemModel.setTihao(list.get(j).getId());
                        shijuanitemService.insert(shijuanitemModel);
                    }
                }
            }
            if (shijuanLists.getZujuans().get(i).getQtype() == 1) {
                if (shijuanLists.getZujuans().get(i).getTnum() > 0) {
                    List<PanduanModel> list = panduanService.selectRandNum(shijuanLists.getZujuans().get(i).getTnum());
                    for (int j = 0; j < shijuanLists.getZujuans().get(i).getTnum(); j++) {
                        shijuanitemModel.setShijuanid(shijuanId);
                        shijuanitemModel.setQtype(shijuanLists.getZujuans().get(i).getQtype());
                        shijuanitemModel.setFenshu(shijuanLists.getZujuans().get(i).getScore());
                        shijuanitemModel.setTihao(list.get(j).getId());
                        shijuanitemService.insert(shijuanitemModel);
                    }
                }
            }
            if (shijuanLists.getZujuans().get(i).getQtype() == 2) {
                if (shijuanLists.getZujuans().get(i).getTnum() > 0) {
                    List<TiankongModel> list = tiankongService.selectRandNum(shijuanLists.getZujuans().get(i).getTnum());
                    for (int j = 0; j < shijuanLists.getZujuans().get(i).getTnum(); j++) {
                        shijuanitemModel.setShijuanid(shijuanId);
                        shijuanitemModel.setQtype(shijuanLists.getZujuans().get(i).getQtype());
                        shijuanitemModel.setFenshu(shijuanLists.getZujuans().get(i).getScore());
                        shijuanitemModel.setTihao(list.get(j).getId());
                        shijuanitemService.insert(shijuanitemModel);
                    }
                }
            }
            if (shijuanLists.getZujuans().get(i).getQtype() == 3) {
                if (shijuanLists.getZujuans().get(i).getTnum() > 0) {
                    List<JiandaModel> list = jiandaService.selectRandNum(shijuanLists.getZujuans().get(i).getTnum());
                    for (int j = 0; j < shijuanLists.getZujuans().get(i).getTnum(); j++) {
                        shijuanitemModel.setShijuanid(shijuanId);
                        shijuanitemModel.setQtype(shijuanLists.getZujuans().get(i).getQtype());
                        shijuanitemModel.setFenshu(shijuanLists.getZujuans().get(i).getScore());
                        shijuanitemModel.setTihao(list.get(j).getId());
                        shijuanitemService.insert(shijuanitemModel);
                    }
                }
            }
        }
        Paperstate paperstate = new Paperstate();
        paperstate.setShijuanid(shijuanId);
        paperstate.setDstate(false);
        paperstate.setYstate(false);
        paperstate.setStno(shijuanLists.getTno());
        return 1;
    }

}
