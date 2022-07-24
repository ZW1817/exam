package com.kaifamiao.mapper;

import com.kaifamiao.model.Paperstate;

/**
* @author HP1
* @description 针对表【paperstate】的数据库操作Mapper
* @createDate 2022-07-23 16:03:34
* @Entity com.kaifamiao.model.Paperstate
*/
public interface PaperstateMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Paperstate record);

    int insertSelective(Paperstate record);

    Paperstate selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Paperstate record);

    int updateByPrimaryKey(Paperstate record);

}
