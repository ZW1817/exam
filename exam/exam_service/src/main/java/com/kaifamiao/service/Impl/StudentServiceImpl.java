package com.kaifamiao.service.Impl;

import com.kaifamiao.mapper.StudentMapper;
import com.kaifamiao.model.StudentModel;
import com.kaifamiao.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("studentService")
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public int insert(StudentModel record) {
        return studentMapper.insert(record);
    }

    @Override
    public int delete(String stno) {
        return studentMapper.delete(stno);
    }

    @Override
    public int update(StudentModel record) {
        return studentMapper.update(record);
    }

    @Override
    public List<StudentModel> findAll(StudentModel record){
        return studentMapper.selectAll(record);
    }


    public List<StudentModel> findAll(){return studentMapper.selectAll(null);}

    @Override
    public List<StudentModel> findAllStu() {
        return studentMapper.selectAllStu();
    }
}
