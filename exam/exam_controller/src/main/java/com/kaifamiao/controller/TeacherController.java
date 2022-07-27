package com.kaifamiao.controller;

import com.kaifamiao.model.ShijuanitemModel;
import com.kaifamiao.model.TeacherModel;
import com.kaifamiao.service.TeacherService;
import com.kaifamiao.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/teacher")
@CrossOrigin
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @RequestMapping("/update")
    @CrossOrigin
    public ResponseUtil update(TeacherModel teacherModel){
        if(teacherService.update(teacherModel) > 0) return ResponseUtil.ok("修改成功",1);
        return ResponseUtil.error("修改失败");
    }

//    @RequestMapping("/yue")
//    public List<ShijuanitemModel> yue(
////                                        @RequestParam("stno") String stno,
////                                      @RequestParam("tno") String tno,
////                                      @RequestParam("title") String title
//                                    ){
//        ShijuanitemModel shijuanitemModel = new ShijuanitemModel();
//        shijuanitemModel.setShijuanid(1);//查到当前学生做的卷子，从dajuanitem中找
//        shijuanitemModel.setQtype(0);
//    }
}
