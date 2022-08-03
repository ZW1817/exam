package com.kaifamiao.provider;

import com.kaifamiao.model.KemuModel;
import org.apache.ibatis.jdbc.SQL;

public class KemuProvider {
    private static  final String tableName = "kemu";

    public String insert(KemuModel record){
        return new SQL(){{
            INSERT_INTO(tableName);
            if(record != null){
                if(record.getId() != null) VALUES("id","#{id}");
                if(record.getName() != null) VALUES("name","#{name}");
            }
        }}.toString();
    }

    public String delete(KemuModel record){
        return new SQL(){{
            DELETE_FROM(tableName);
            if(record != null){
                if(record.getId() != null) WHERE("id = #{id}");
                if(record.getName() != null) WHERE("name = #{name}");
            }
        }}.toString();
    }

    public String update(KemuModel record){
        return new SQL(){{
            UPDATE(tableName);
            if(record != null){
                if(record.getId() != null) WHERE("id = #{id}");
                if(record.getName() != null) SET("name = #{name}");
            }
        }}.toString();
    }

    public String selectAll(KemuModel record){
        return new SQL(){{
            SELECT("*");
            FROM(tableName);
            if(record != null){
                if(record.getId() != null) WHERE("id = #{id}");
                if(record.getName() != null) WHERE("name = #{name}");
            }
        }}.toString();
    }
}
