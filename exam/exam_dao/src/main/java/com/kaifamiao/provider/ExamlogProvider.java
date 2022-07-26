package com.kaifamiao.provider;

import com.kaifamiao.model.ExamlogModel;
import org.apache.ibatis.jdbc.SQL;

public class ExamlogProvider {
    private static final String tableName = "examlog";

    public String insert(ExamlogModel record){
        return new SQL(){{
            INSERT_INTO(tableName);
            if(record != null){
                if(record.getId() != null) VALUES("id","#{id}");
                if(record.getKmid() != null) VALUES("kmid","#{kmid}");
                if(record.getSubmittime() != null) VALUES("submittime","#{submittime}");
                if(record.getSjid() != null) VALUES("sjid","#{sjid}");
                if(record.getStno() != null) VALUES("stno" ,"#{stno}");
            }
        }}.toString();
    }

    public String delete(ExamlogModel record){
        return new SQL(){{
            DELETE_FROM(tableName);
            if(record != null){
                if(record.getId() != null) WHERE("id = #{id}");
                if(record.getKmid() != null) WHERE("kmid = #{kmid}");
                if(record.getSubmittime() != null) WHERE("submittime = #{submittime}");
                if(record.getSjid() != null) WHERE("sjid = #{sjid}");
                if(record.getStno() != null) WHERE("stno = #{stno}");
            }
        }}.toString();
    }

    public String update(ExamlogModel record){
        return new SQL(){{
            UPDATE(tableName);
            if(record != null){
                if(record.getId() != null) WHERE("id = #{id}");
                if(record.getStno() != null) WHERE("stno = #{stno}");
                if(record.getKmid() != null) SET("kmid = #{kmid}");
                if(record.getSubmittime() != null) SET("submittime = #{submittime}");
                if(record.getSjid() != null) SET("sjid = #{sjid}");
            }
        }}.toString();
    }

    public String selectAll(ExamlogModel record){
        return new SQL(){{
            SELECT("*");
            FROM(tableName);
            if(record != null){
                if(record.getId() != null) WHERE("id = #{id}");
                if(record.getStno() != null) WHERE("stno = #{stno}");
                if(record.getKmid() != null) SET("kmid = #{kmid}");
                if(record.getSubmittime() != null) SET("submittime = #{submittime}");
                if(record.getSjid() != null) SET("sjid = #{sjid}");
            }
        }}.toString();
    }
}
