package com.kaifamiao.service;

import com.kaifamiao.mapper.StudentMapper;
import com.kaifamiao.model.StudentModel;
import com.kaifamiao.provider.StudentProvider;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.UpdateProvider;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = false,propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT)
public interface StudentService {

    int insert(StudentModel record);

    int delete(String stno);

    int update(StudentModel record);

    @Transactional(readOnly = true,propagation = Propagation.SUPPORTS,isolation = Isolation.DEFAULT)
    List<StudentModel> findAll(StudentModel record);

    @Transactional(readOnly = true,propagation = Propagation.SUPPORTS,isolation = Isolation.DEFAULT)
    List<StudentModel> findAll();

    @Transactional(readOnly = true,propagation = Propagation.SUPPORTS,isolation = Isolation.DEFAULT)
    List<StudentModel> findAllStu();
}
