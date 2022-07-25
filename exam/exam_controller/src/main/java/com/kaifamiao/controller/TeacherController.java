package com.kaifamiao.controller;

import com.kaifamiao.model.TeacherModel;
import com.kaifamiao.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @RequestMapping("/update")
    public int update(TeacherModel teacherModel){
        return teacherService.update(teacherModel);
    }
}
