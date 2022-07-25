package com.kaifamiao.service;

import com.kaifamiao.mapper.StudentMapper;
import com.kaifamiao.model.StudentModel;
import com.kaifamiao.provider.StudentProvider;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.UpdateProvider;

import java.util.List;

public interface StudentService {

    int insert(StudentModel record);

    int delete(String stno);

    int update(StudentModel record);

    List<StudentModel> findAll(StudentModel record);

    List<StudentModel> findAll();

    List<StudentModel> findAllStu();
}
