package com.kaifamiao.service;

import com.kaifamiao.model.TeacherModel;
import com.kaifamiao.provider.TeacherProvider;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = false,propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT)
public interface TeacherService {

    int insert(TeacherModel record);

    int delete(String tno);

    int update(TeacherModel record);

    @Transactional(readOnly = true,propagation = Propagation.SUPPORTS,isolation = Isolation.DEFAULT)
    List<TeacherModel> findAll(TeacherModel record);
}
