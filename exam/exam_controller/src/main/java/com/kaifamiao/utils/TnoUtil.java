package com.kaifamiao.utils;

import com.kaifamiao.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Calendar;

@Component
public class TnoUtil {

    private static final int len = 6;
    private static final String letter = "T";

    @Autowired
    private  TeacherService teacherService;

    public String createTno(){
        String year = "" + Calendar.getInstance().get(Calendar.YEAR);
        String size = "" + teacherService.findAll(null).size();
        for(int i = len - size.length(); i > 0;i --) year += 0;

        return letter + year + size;
    }
}
