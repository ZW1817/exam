package com.kaifamiao.controller;

import com.kaifamiao.model.*;
import com.kaifamiao.service.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.TestConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
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
    private StudentService studentService;
    @Autowired
    private BanjiService banjiService;

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

//  显示当前老师下所有试卷即对应学生的信息
    @RequestMapping("/findALL")
    @CrossOrigin
    public List<Map<String, Object>> findALL() {
        return paperstateService.selectStudent();
    }

    @RequestMapping("/zujuan")
    @CrossOrigin("*")
//            @RequestBody List<Zujuan> zujuans
    public Integer zujuan(@RequestBody ShijuanList shijuanLists) {
        System.out.println(shijuanLists);
        ShijuanModel shijuanModel = new ShijuanModel();
        ShijuanitemModel shijuanitemModel = new ShijuanitemModel();
        shijuanModel.setKmid(9);
        shijuanModel.setTitle(shijuanLists.getShijuanname());
        shijuanModel.setTno(shijuanLists.getTno());
        shijuanModel.setZongfen(shijuanLists.getTotal());
//        String time = LocalDate.now() +" "+LocalTime.now();
        shijuanModel.setStarttime(shijuanLists.getDate().get(0));
        shijuanModel.setEndtime(shijuanLists.getDate().get(1));

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

        PaperstateModel paperstate = new PaperstateModel();
        BanjiModel banjiModel = new BanjiModel();
        banjiModel.setTno(shijuanLists.getTno());
//      找到当前老师下所有的班级，将这张试卷内容添加到 shijuanitem paperstate shijuan三张表中
        List<BanjiModel> banjiModels = banjiService.selectAll(banjiModel);
        for (int i = 0 ;i < banjiModels.size(); i++){

            StudentModel studentModel = new StudentModel();
            studentModel.setClassid(banjiModels.get(i).getId());
            List<StudentModel> studentModels = studentService.findAll(studentModel);
//          当前班级下所有学生
            for(int j = 0; j < studentModels.size(); j ++ ){
                paperstate.setShijuanid(shijuanId);
                paperstate.setDstate(0);
                paperstate.setYstate(0);
                paperstate.setStno(shijuanLists.getTno());
                paperstate.setStno(studentModels.get(j).getStno());
                paperstateService.insert(paperstate);
            }

        }

        return 1;
    }

    @Test
    public void sss(){
        String time = LocalDate.now() +" "+LocalTime.now();
        System.out.println(time.substring(0,time.lastIndexOf(".")));
    }
}
