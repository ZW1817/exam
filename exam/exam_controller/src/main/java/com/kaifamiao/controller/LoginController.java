package com.kaifamiao.controller;

import com.kaifamiao.Utils.MD5Util;
import com.kaifamiao.model.BanjiModel;
import com.kaifamiao.service.BanjiService;
import com.kaifamiao.utils.ResponseUtil;
import com.kaifamiao.utils.StnoUtil;
import com.kaifamiao.utils.TnoUtil;
import com.kaifamiao.model.StudentModel;
import com.kaifamiao.model.SysuserModel;
import com.kaifamiao.model.TeacherModel;
import com.kaifamiao.service.StudentService;
import com.kaifamiao.service.SysuserService;
import com.kaifamiao.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@ResponseBody
public class LoginController {

    @Autowired
    private SysuserService sysuserService;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private BanjiService banjiService;
    @Autowired
    private TnoUtil tnoUtil;
    @Autowired
    private StnoUtil stnoUtil;

    @RequestMapping("/login")
    @CrossOrigin("*")
    public ResponseUtil login(@RequestParam(value = "role", required = false) String role,
                              @RequestParam("password") String  password,
                              @RequestParam("username") String username){
        if("0".equals(role)){
//            role = "管理员";
            SysuserModel sysuserModel = new SysuserModel();
            sysuserModel.setUsername(username);
            sysuserModel.setPassword(password);
            sysuserModel = sysuserService.findAll(sysuserModel).get(0);
            if(sysuserModel != null){
                return ResponseUtil.ok(1,"登录成功",sysuserModel);       //账户密码都正确,管理员唯一返回的data为固定id
            }
        }else if("1".equals(role)){
//            role = "学生";
            StudentModel studentModel = new StudentModel();
            studentModel.setStno(username);
            studentModel.setPassword(password);
            studentModel = studentService.findAll(studentModel).get(0);
            if(studentModel != null) return ResponseUtil.ok(1,"登录成功",studentModel);        //传学号
        }else{
//            role = "老师";
            TeacherModel teacherModel = new TeacherModel();
            teacherModel.setTno(username);
            teacherModel.setPassword(password);
            teacherModel = teacherService.findAll(teacherModel).get(0);
            if(teacherModel != null) return ResponseUtil.ok(1,"登录成功",teacherModel);        //传教师号
        }
        return ResponseUtil.error("...");
    }

    @RequestMapping("/sign")
    @CrossOrigin
    public String sign(@RequestParam("role")String role,
                     @RequestParam("username")String username,
                     @RequestParam("password")String password,
                       @RequestParam("zhuanye")String zhuanye){
        String no= null;
        if("1".equals(role)){
            Integer classid = banjiService.selectByName(zhuanye).getId();
            String stno = stnoUtil.createStno();
            StudentModel studentModel = new StudentModel();
            studentModel.setName(username);
            studentModel.setStno(stno);
            studentModel.setPassword(password);
            studentModel.setClassid(classid);
            int state = studentService.insert(studentModel);
            no = state > 0 ? stno : no;
            return no;
        }else{
            String tno = tnoUtil.createTno();
            TeacherModel teacherModel = new TeacherModel();
            teacherModel.setName(username);
            teacherModel.setTno(tno);
            teacherModel.setPassword(password);
            int state = teacherService.insert(teacherModel);
            tno = state > 0 ? tno : no;
            return tno;
        }
    }

    @RequestMapping("/banji")
    @CrossOrigin
    public List<BanjiModel> banjiSelect(){
        return banjiService.selectAll(null);
    }

}
