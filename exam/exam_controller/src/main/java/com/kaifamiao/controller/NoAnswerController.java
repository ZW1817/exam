package com.kaifamiao.controller;

import com.kaifamiao.model.NoAnswerModel;
import com.kaifamiao.service.INoAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/no")
public class NoAnswerController {

    @Autowired
    private INoAnswerService service;

    @RequestMapping("/findAll")
    @CrossOrigin
    public List<NoAnswerModel> findAll(){
        return service.findAll();
    }
}