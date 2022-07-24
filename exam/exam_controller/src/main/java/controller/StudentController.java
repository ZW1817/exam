package controller;

import com.kaifamiao.model.StudentModel;
import com.kaifamiao.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@ResponseBody
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping("/update")
    @CrossOrigin
    public int update(StudentModel studentModel){
        return studentService.update(studentModel);
    }
}
