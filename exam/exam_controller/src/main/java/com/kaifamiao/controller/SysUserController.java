package com.kaifamiao.controller;


import com.kaifamiao.model.*;
import com.kaifamiao.service.*;
import com.kaifamiao.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sysUser")
@ResponseBody
@CrossOrigin("*")
public class SysUserController {

    @Autowired
    private SysuserService sysuserService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private BanjiService banjiService;
    @Autowired
    private KemuService kemuService;

    @RequestMapping("/findSysUser")
    public List<SysuserModel> findAllSysUser() {
        return sysuserService.findAll(null);
    }

    @RequestMapping("/update")
    @CrossOrigin("*")
    public ResponseUtil updatePass(SysuserModel sysuserModel) {
        int i = sysuserService.update(sysuserModel);
        return ResponseUtil.ok("修改成功！");
    }

    @RequestMapping("/findStudent")
    public List<StudentModel> findAllStudent() {
        return studentService.findAll(null);
    }

    @RequestMapping("/findTeacher")
    public List<TeacherModel> findAllTeacher() {
        return teacherService.findAll(null);
    }

    @RequestMapping("/findBanji")
    public List<BanjiModel> findAllBanji() {
        return banjiService.selectAll(null);
    }

    @RequestMapping("/findKemu")
    public List<KemuModel> findAllKemu() {
        return kemuService.findAll(null);
    }

    @RequestMapping("/deleteStudent")
    public ResponseUtil deleteStudent(@RequestParam("stno") String stno) {
        int i = studentService.delete(stno);
        if (i > 0) {
            return ResponseUtil.ok("删除成功，请重新刷新界面！");
        }
        return ResponseUtil.error("删除失败！");
    }


    @RequestMapping("/deleteTeacher")
    public ResponseUtil deleteTeacher(@RequestParam("tno") String tno){
        int i = teacherService.delete(tno);
        if(i > 0){
            return ResponseUtil.ok("删除成功，请重新刷新界面！");
        }
        return ResponseUtil.error("删除失败！");
    }

    @RequestMapping("/deleteCourse")
    public ResponseUtil deleteCourse(@RequestParam("id") String id) {
        Integer i = -1;
        if(id != null) i = Integer.valueOf(id);
        KemuModel model = new KemuModel();
        model.setId(i);
        int row = kemuService.delete(model);
        if (row > 0) {
            return ResponseUtil.ok("删除成功，请重新刷新界面！");
        }
        return ResponseUtil.error("删除失败！");
    }

    @RequestMapping("/deleteClass")
    public ResponseUtil deleteClass(@RequestParam("id") String id){
        Integer i = -1;
        if(id != null) i = Integer.valueOf(id);
        int row = banjiService.delete(i);
        if (row > 0) {
            return ResponseUtil.ok("删除成功，请重新刷新界面！");
        }
        return ResponseUtil.error("删除失败！");
    }
}