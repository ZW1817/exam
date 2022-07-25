package com.kaifamiao.utils;

import com.kaifamiao.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Calendar;

@Component
public class StnoUtil {

    private static final int len = 7;
    @Autowired
    private  StudentService studentService;

    public  String createStno(){
        String year = "" + Calendar.getInstance().get(Calendar.YEAR);
        String size = "" + studentService.findAll(null).size();
        for(int i = len - size.length(); i > 0;i --) year += 0;

        return year + size;
    }

}
