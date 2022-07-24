package com.kaifamiao.mapper;

import com.kaifamiao.model.Examlog;

/**
* @author HP1
* @description 针对表【examlog】的数据库操作Mapper
* @createDate 2022-07-23 16:03:34
* @Entity com.kaifamiao.model.Examlog
*/
public interface ExamlogMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Examlog record);

    int insertSelective(Examlog record);

    Examlog selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Examlog record);

    int updateByPrimaryKey(Examlog record);

}
