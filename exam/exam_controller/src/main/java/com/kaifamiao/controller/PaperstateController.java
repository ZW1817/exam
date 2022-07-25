package com.kaifamiao.controller;

import com.kaifamiao.service.PaperstateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/paperstate")
@CrossOrigin
public class PaperstateController {
    @Autowired
    private PaperstateService paperstateService;

    @RequestMapping("/findALL")
    @CrossOrigin
    public List<Map<String, Object>> findALL(){
        return paperstateService.selectStdudent();
    }
}
