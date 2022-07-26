package com.kaifamiao.controller;

import com.kaifamiao.model.StudentModel;
import com.kaifamiao.service.StudentService;
import com.kaifamiao.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/student")
@CrossOrigin
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping("/update")
    public ResponseUtil update(StudentModel studentModel){
        if(studentService.update(studentModel) > 0){
            return ResponseUtil.ok(1,"修改成功",studentModel);
        }
        return ResponseUtil.error("修改失败");
    }

    @RequestMapping("/findALL")
    @CrossOrigin
    public List<StudentModel> findALL(){
        return studentService.findAll();
    }


}
