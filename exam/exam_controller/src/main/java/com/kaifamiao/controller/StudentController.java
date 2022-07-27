package com.kaifamiao.controller;

import com.kaifamiao.model.ShijuanitemModel;
import com.kaifamiao.model.StudentModel;
import com.kaifamiao.service.ShijuanitemService;
import com.kaifamiao.service.StudentService;
import com.kaifamiao.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/student")
@CrossOrigin
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private ShijuanitemService shijuanitemService;

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

}
