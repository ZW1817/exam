package com.kaifamiao.service;

import com.kaifamiao.model.TeacherModel;
import com.kaifamiao.provider.TeacherProvider;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;

import java.util.List;

public interface TeacherService {

    int insert(TeacherModel record);

    int delete(String tno);

    int update(TeacherModel record);

    List<TeacherModel> findAll(TeacherModel record);
}
