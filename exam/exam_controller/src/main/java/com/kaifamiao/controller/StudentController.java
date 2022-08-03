package com.kaifamiao.controller;

import com.kaifamiao.model.*;
import com.kaifamiao.service.DajuanitemService;
import com.kaifamiao.service.PaperstateService;
import com.kaifamiao.service.ShijuanitemService;
import com.kaifamiao.service.StudentService;
import com.kaifamiao.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/student")
@CrossOrigin("*")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private ShijuanitemService shijuanitemService;

    @Autowired
    private DajuanitemService dajuanitemService;

    @Autowired
    private PaperstateService paperstateService;

    @RequestMapping("/update")
    public ResponseUtil update(StudentModel studentModel){
        if(studentService.update(studentModel) > 0){
            return ResponseUtil.ok(1,"修改成功",studentModel);
        }
        return ResponseUtil.error("修改失败");
    }
//  老师功能 查询自己管理下全部学生
    @RequestMapping("/findALL")
    @CrossOrigin
    public List<StudentModel> findALL(){
        return studentService.findAll();
    }

//  学生开始考试
    @RequestMapping("/findAllTi")
    public List<ShijuanitemModel> findAllTi(ShijuanitemModel shijuanitemModel){
        List<ShijuanitemModel> list = new ArrayList<>();
        shijuanitemModel.setShijuanid(shijuanitemModel.getShijuanid());
        shijuanitemModel.setQtype(0);
        list.addAll(shijuanitemService.selectAllXuanze(shijuanitemModel));
        shijuanitemModel.setQtype(1);
        list.addAll(shijuanitemService.selectAllPanduan(shijuanitemModel));
        shijuanitemModel.setQtype(2);
        list.addAll(shijuanitemService.selectAllTiankong(shijuanitemModel));
        shijuanitemModel.setQtype(3);
        list.addAll(shijuanitemService.selectAllJianda(shijuanitemModel));
        return list;
    }


//    提交考试
    @RequestMapping("/submitTi")
    @CrossOrigin("*")
    public ResponseUtil submitTi(@RequestBody Submitshijuan paper){
            int i = 1;
    //  添加答卷
        DajuanitemModel dajuanitemModel = new DajuanitemModel();
        dajuanitemModel.setStno(paper.getStno());
        dajuanitemModel.setShijuanid(paper.getPapers().get(0).getShijuanid());
        String time = LocalDate.now() + " " + LocalTime.now();

        for (ShijuanitemModel shijuanitemModel: paper.getPapers()) {
            dajuanitemModel.setQtype(shijuanitemModel.getQtype());
            dajuanitemModel.setTihao(shijuanitemModel.getTihao());
            dajuanitemModel.setFenshu(shijuanitemModel.getFenshu());
            if(shijuanitemModel.getQtype() == 0) {//选择
                dajuanitemModel.setDaan(shijuanitemModel.getChoice());
                dajuanitemModel.setDefen(shijuanitemModel.getChoice() == shijuanitemModel.getDaan() ? shijuanitemModel.getFenshu() : 0);
            }
            if(shijuanitemModel.getQtype() == 1) { //判断
                dajuanitemModel.setDaan(shijuanitemModel.getPanduan());
                dajuanitemModel.setDefen(shijuanitemModel.getPanduan() == shijuanitemModel.getDaan() ? shijuanitemModel.getFenshu() : 0);
            }
            if(shijuanitemModel.getQtype() == 2) dajuanitemModel.setDaan(shijuanitemModel.getTiankong());
            if(shijuanitemModel.getQtype() == 3) dajuanitemModel.setDaan(shijuanitemModel.getJianda());
           i = dajuanitemService.insert(dajuanitemModel);
           if(i == 0) return ResponseUtil.error("提交失败",0);
        }
    //  修改状态
        PaperstateModel paperstateModel = new PaperstateModel();
        paperstateModel.setStno(paper.getStno());
        paperstateModel.setDstate(1);
        paperstateModel.setShijuanid(paper.getPapers().get(0).getShijuanid());
        paperstateModel.setSubmittime(time.substring(0,time.lastIndexOf(".")));
        i = paperstateService.update(paperstateModel);
        if(i == 0) return ResponseUtil.error("提交失败",0);
        return ResponseUtil.ok("提交成功",1);
    }

    /**
     * 查看试卷
     * @param stno
     * @param shijuanid
     * @return
     */
    @RequestMapping("/view")
    public ResponseUtil view(@RequestParam("stno")String stno,@RequestParam("shijuanid") int shijuanid){
        DajuanitemModel dajuanitemModel = new DajuanitemModel();
        dajuanitemModel.setShijuanid(shijuanid);
        dajuanitemModel.setStno(stno);

        List<DajuanitemModel> list  = new ArrayList<>();

        dajuanitemModel.setQtype(0);
        list.addAll(dajuanitemService.selectAllXuanze(dajuanitemModel));
        dajuanitemModel.setQtype(1);
        list.addAll(dajuanitemService.selectAllPanduan(dajuanitemModel));
        dajuanitemModel.setQtype(2);
        list.addAll(dajuanitemService.selectAllTiankong(dajuanitemModel));
        dajuanitemModel.setQtype(3);
        list.addAll(dajuanitemService.selectAllJianda(dajuanitemModel));

        return ResponseUtil.ok("查找成功",list);
    }

}
