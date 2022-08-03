package com.kaifamiao.service.Impl;

import com.kaifamiao.Utils.MD5Util;
import com.kaifamiao.mapper.TeacherMapper;
import com.kaifamiao.model.TeacherModel;
import com.kaifamiao.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("teacherService")
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherMapper teacherMapper;

    @Override
    public int insert(TeacherModel record) {
        record.setPassword(MD5Util.encode(record.getPassword()));
        return teacherMapper.insert(record);
    }

    @Override
    public int delete(String tno) {
        return teacherMapper.delete(tno);
    }

    @Override
    public int update(TeacherModel record) {
        return teacherMapper.update(record);
    }

    @Override
    public List<TeacherModel> findAll(TeacherModel record) {
        return teacherMapper.selectAll(record);
    }
}
