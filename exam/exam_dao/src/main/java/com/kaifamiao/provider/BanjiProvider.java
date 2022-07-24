package com.kaifamiao.provider;

import com.kaifamiao.model.BanjiModel;
import org.apache.ibatis.jdbc.SQL;

public class BanjiProvider {

    public String insert(BanjiModel record){
        return new SQL(){{
            INSERT_INTO("banji");
            if(record != null){
                if(record.getName() != null) VALUES("name","#{name}");
                if(record.getTno() != null) VALUES("tno","#{tno}");
            }
        }}.toString();
    }

    public  String deleteByPrimaryKey(int id){
        return new SQL(){{
            DELETE_FROM("banji");
            WHERE("id = #{id}");
        }}.toString();
    }

    public String selectByPrimaryKey(int id){
        return new SQL(){{
            SELECT("*");
            FROM("banji");
            WHERE("id = #{id}");
        }}.toString();
    }

    public String updateByPrimaryKey(BanjiModel record){
        return new SQL(){{
            UPDATE("banji");
            if(record != null){
                if(record.getName() != null) SET("name","#{name}");
                if(record.getTno() != null) SET("tno","#{tno}");
                if(record.getId() != null) WHERE("id = #{id}");
            }
        }}.toString();
    }
}
