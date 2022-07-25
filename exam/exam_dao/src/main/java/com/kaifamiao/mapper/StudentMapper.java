package com.kaifamiao.mapper;

import com.kaifamiao.model.StudentModel;
import com.kaifamiao.model.TeacherModel;
import com.kaifamiao.provider.StudentProvider;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

import java.util.List;

/**
* @author HP1
* @description 针对表【student】的数据库操作Mapper
* @createDate 2022-07-23 16:03:34
* @Entity com.kaifamiao.model.Student
*/
public interface StudentMapper {

    @InsertProvider(type = StudentProvider.class, method = "insert")
    int insert(StudentModel record);

    @Delete("delete from student where stno = #{stno}")
    int delete(String stno);

    @UpdateProvider(type= StudentProvider.class,method = "update")
    int update(StudentModel record);

    @SelectProvider(type = StudentProvider.class,method = "selectAll")
    List<StudentModel> selectAll(StudentModel record);

    @SelectProvider(value = StudentProvider.class,method = "selectAllStu")
    List<StudentModel> selectAllStu();
}
