package com.kaifamiao.Utils;

import com.kaifamiao.model.StudentModel;
import com.kaifamiao.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Calendar;

public class StnoUtil {

    private static final int len = 7;
    @Autowired
    private static StudentService studentService;

    public static String createStno(){
        String year = "" + Calendar.getInstance().get(Calendar.YEAR);
        String size = "" + studentService.findAll(null).size();
        for(int i = len - size.length(); i > 0;i --) year += 0;

        return year + size;
    }

}
