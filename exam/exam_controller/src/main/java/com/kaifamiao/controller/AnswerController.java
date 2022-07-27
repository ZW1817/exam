package com.kaifamiao.controller;
import com.kaifamiao.model.AnswerModel;
import com.kaifamiao.service.IAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/an")
public class AnswerController {

    @Autowired
    private IAnswerService service;

//    当前学生已答试卷
    @RequestMapping("/findAllAnswer")
    @CrossOrigin
    public List<AnswerModel> findAllAnswer(){
        return service.findAllAnswer();
    }
}
