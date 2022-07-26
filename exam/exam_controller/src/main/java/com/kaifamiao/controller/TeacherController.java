package com.kaifamiao.controller;

import com.kaifamiao.model.TeacherModel;
import com.kaifamiao.service.TeacherService;
import com.kaifamiao.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
