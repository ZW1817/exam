package controller;

import com.kaifamiao.Utils.StnoUtil;
import com.kaifamiao.Utils.TnoUtil;
import com.kaifamiao.model.StudentModel;
import com.kaifamiao.model.SysuserModel;
import com.kaifamiao.model.TeacherModel;
import com.kaifamiao.service.StudentService;
import com.kaifamiao.service.SysuserService;
import com.kaifamiao.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LoginController {

    private static List<String> list = List.of("管理员", "老师","学生"  );

    @Autowired
    private SysuserService sysuserService;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private StudentService studentService;

    @RequestMapping("/login")
    @CrossOrigin("*")
    public void login(@RequestParam("role")String role,
                      @RequestParam("username")String username,
                      @RequestParam("username")String password){
        if(list.get(0).equals(role)){
            SysuserModel sysuserModel = new SysuserModel();
            sysuserModel.setUsername(username);
            sysuserModel.setPassword(password);
            sysuserModel = sysuserService.findAll(sysuserModel).get(0);
        }else if(list.get(1).equals(role)){
            TeacherModel teacherModel = new TeacherModel();
            teacherModel.setTno(username);
            teacherModel.setPassword(password);
            teacherModel = teacherService.findAll(teacherModel).get(0);
        }else{
            StudentModel studentModel = new StudentModel();
            studentModel.setStno(username);
            studentModel.setPassword(password);
            studentModel = studentService.findAll(studentModel).get(0);
        }
    }

    @RequestMapping("/sign")
    @CrossOrigin
    public void sign(@RequestParam("role")String role,
                     @RequestParam("username")String username,
                     @RequestParam("username")String password){
        int state = 0;
        if(list.get(1).equals(role)){
            TeacherModel teacherModel = new TeacherModel();
            teacherModel.setName(username);
            teacherModel.setTno(TnoUtil.createTno());
            teacherModel.setPassword(password);
            state = teacherService.insert(teacherModel);
        }else{
            StudentModel studentModel = new StudentModel();
            studentModel.setName(username);
            studentModel.setStno(StnoUtil.createStno());
            studentModel.setPassword(password);
            studentModel.setClassid(1);
            state = studentService.insert(studentModel);
        }
    }


}
