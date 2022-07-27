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

    public  String delete(int id){
        return new SQL(){{
            DELETE_FROM("banji");
            WHERE("id = #{id}");
        }}.toString();
    }

    public String update(BanjiModel record){
        return new SQL(){{
            UPDATE("banji");
            if(record != null){
                if(record.getName() != null) SET("name","#{name}");
                if(record.getTno() != null) SET("tno","#{tno}");
                if(record.getId() != null) WHERE("id = #{id}");
            }
        }}.toString();
    }

    public String selectOne(int id){
        return new SQL(){{
            SELECT("*");
            FROM("banji");
            WHERE("id = #{id}");
        }}.toString();
    }

    public String selectAll(BanjiModel record){
        return new SQL(){{
            SELECT("banji.*, teacher.name teachername");
            FROM("banji");
            LEFT_OUTER_JOIN("teacher on teacher.tno = banji.tno");
            if(record != null){
                if(record.getTno() != null) WHERE("banji.tno = #{tno}");
            }
        }}.toString();
    }
}
