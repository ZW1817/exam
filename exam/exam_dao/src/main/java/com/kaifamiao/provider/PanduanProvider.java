package com.kaifamiao.provider;

import com.kaifamiao.model.PanduanModel;
import org.apache.ibatis.jdbc.SQL;

public class PanduanProvider {
    private static final String tableName = "panduan";

    public String insert(PanduanModel record){
        return new SQL(){{
            INSERT_INTO(tableName);
            if(record != null){
                if(record.getId() != null) VALUES("id","#{id}");
                if(record.getDaan() != null) VALUES("daan","#{daan}");
                if(record.getDiffact() != null) VALUES("diffact","#{diffact}");
                if(record.getKmid() != null) VALUES("kmid","kmid");
                if(record.getTitle() != null) VALUES("title","#{title}");
            }
        }}.toString();
    }

    public String delete(PanduanModel record){
        return new SQL(){{
            DELETE_FROM(tableName);
            if(record != null){
                if(record.getId() != null) WHERE("id = #{id}");
//                if(record.getDaan() != null) WHERE("daan = #{daan}");
//                if(record.getDiffact() != null) WHERE("diffact = #{diffact}");
//                if(record.getKmid() != null) WHERE("kmid = kmid");
//                if(record.getTitle() != null) WHERE("title = #{title}");
            }
        }}.toString();
    }

    public String update(PanduanModel record){
        return new SQL(){{
            UPDATE(tableName);
            if(record != null){
                if(record.getId() != null) WHERE("id = #{id}");
                if(record.getDaan() != null) SET("daan = #{daan}");
                if(record.getDiffact() != null) SET("diffact = #{diffact}");
                if(record.getKmid() != null) SET("kmid = kmid");
                if(record.getTitle() != null) SET("title = #{title}");
            }
        }}.toString();
    }

    public String selectAll(PanduanModel record){
        return new SQL(){{
            SELECT("*");
            FROM(tableName);
            if(record != null){
                if(record.getId() != null) WHERE("id = #{id}");
                if(record.getDaan() != null) WHERE("daan = #{daan}");
                if(record.getDiffact() != null) WHERE("diffact = #{diffact}");
                if(record.getKmid() != null) WHERE("kmid = kmid");
                if(record.getTitle() != null) WHERE("title = #{title}");
            }
        }}.toString();
    }

    public String selectRandNum(Integer num) {
        return new SQL() {{
            SELECT("*");
            FROM(tableName);
            if (num !=null){
                ORDER_BY("RAND() LIMIT #{num}");
            }else{
                ORDER_BY("RAND() LIMIT 10");
            }
        }}.toString();
    }
}
