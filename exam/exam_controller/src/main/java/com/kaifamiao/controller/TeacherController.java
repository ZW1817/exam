package com.kaifamiao.controller;

import com.kaifamiao.model.DajuanitemModel;
import com.kaifamiao.model.PaperstateModel;
import com.kaifamiao.model.TeacherModel;
import com.kaifamiao.service.DajuanitemService;
import com.kaifamiao.service.PaperstateService;
import com.kaifamiao.service.TeacherService;
import com.kaifamiao.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/teacher")
@CrossOrigin
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private DajuanitemService dajuanitemService;

    @Autowired
    private PaperstateService paperstateService;

    @RequestMapping("/update")
    @CrossOrigin
    public ResponseUtil update(TeacherModel teacherModel){
        if(teacherService.update(teacherModel) > 0) return ResponseUtil.ok("修改成功",1);
        return ResponseUtil.error("修改失败");
    }

    /**
     * 查询当前老师所要查询学生的答卷
     * @param stno
     * @param shijuanid
     * @return
     */
    @RequestMapping("/yue")
    public ResponseUtil yue(
            @RequestParam("stno") String stno,
            @RequestParam("shijuanid") Integer shijuanid
    ){
        DajuanitemModel dajuanitemModel = new DajuanitemModel();
        dajuanitemModel.setShijuanid(shijuanid);
        dajuanitemModel.setStno(stno);

        List<DajuanitemModel> list = new ArrayList<>();
        dajuanitemModel.setQtype(0);
        list.addAll(dajuanitemService.selectAllXuanze(dajuanitemModel));
        dajuanitemModel.setQtype(1);
        list.addAll(dajuanitemService.selectAllPanduan(dajuanitemModel));
        dajuanitemModel.setQtype(2);
        list.addAll(dajuanitemService.selectAllTiankong(dajuanitemModel));
        dajuanitemModel.setQtype(3);
        list.addAll(dajuanitemService.selectAllJianda(dajuanitemModel));

        return ResponseUtil.ok(1,"查询成功",list);
    }

    /**
     * 老师阅卷后分别对dajuanitem和paperstate两张表进行修改
     * @param dajuanitemModel
     * @return
     */
    @RequestMapping("/yuejuan")
    public ResponseUtil yuejuan(@RequestBody DajuanitemModel dajuanitemModel){
        List<DajuanitemModel> list = dajuanitemModel.getPapers();

        int i = 0;
        double score = 0;
        for (DajuanitemModel d:list) {
            score += d.getDefen();
            if(d.getQtype() == 2) i = dajuanitemService.update(d);
            if(d.getQtype() == 3) i = dajuanitemService.update(d);
//            if(i == 0) return ResponseUtil.error("提交失败");
        }

        PaperstateModel paperstateModel = new PaperstateModel();
        paperstateModel.setStno(list.get(0).getStno());
        paperstateModel.setShijuanid(list.get(0).getShijuanid());

        paperstateModel.setYstate(1);
        paperstateModel.setScore(score);

        i = paperstateService.update(paperstateModel);
        if(i == 0) return ResponseUtil.error("提交失败");
        return ResponseUtil.ok("提交成功");
    }

}
