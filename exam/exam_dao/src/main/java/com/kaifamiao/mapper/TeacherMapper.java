package com.kaifamiao.mapper;

import com.kaifamiao.model.TeacherModel;
import com.kaifamiao.provider.TeacherProvider;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
* @author HP1
* @description 针对表【teacher】的数据库操作Mapper
* @createDate 2022-07-23 16:03:34
* @Entity com.kaifamiao.model.Teacher
*/
public interface TeacherMapper {

    @InsertProvider(type = TeacherProvider.class,method = "insert")
    int insert(TeacherModel record);

    @Delete("delete from teacher where tno =#{tno}")
    int delete(String tno);

    @DeleteProvider(type = TeacherProvider.class,method = "update")
    int update(TeacherModel record);

    @SelectProvider(type = TeacherProvider.class,method = "selectAll")
    List<TeacherModel> selectAll(TeacherModel record);

}
