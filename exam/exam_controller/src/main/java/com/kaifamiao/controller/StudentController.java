package com.kaifamiao.controller;

import com.kaifamiao.model.StudentModel;
import com.kaifamiao.service.StudentService;
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
    public int update(StudentModel studentModel){
        return studentService.update(studentModel);
    }

    @RequestMapping("/findALL")
    @CrossOrigin
    public List<StudentModel> findALL(){
        return studentService.findAll();
    }


}
