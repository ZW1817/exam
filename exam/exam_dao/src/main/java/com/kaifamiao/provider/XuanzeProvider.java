package com.kaifamiao.provider;

import com.kaifamiao.model.XuanzeModel;
import org.apache.ibatis.jdbc.SQL;

public class XuanzeProvider {

    private static final String tableName = "xuanze";

    public String insert(XuanzeModel record){
        return new SQL(){{
            INSERT_INTO(tableName);
            if(record != null){
                if(record.getId() != null) VALUES("id","#{id}");
                if(record.getDaan() != null) VALUES("daan","#{daan}");
                if(record.getDiffact() != null) VALUES("diffact","#{diffact}");
                if(record.getKmid() != null) VALUES("kmid","kmid");
                if(record.getTitle() != null) VALUES("title","#{title}");
                if(record.getChoicea() != null) VALUES("choicea", "#{choicea}");
                if(record.getChoiceb() != null) VALUES("choiceb", "#{choiceb}");
                if(record.getChoicec() != null) VALUES("choicec", "#{choicec}");
                if(record.getChoiced() != null) VALUES("choiced", "#{choiced}");
            }
        }}.toString();
    }

    public String delete(XuanzeModel record){
        return new SQL(){{
            DELETE_FROM(tableName);
            if(record != null){
                if(record.getId() != null) WHERE("id = #{id}");
                if(record.getDaan() != null) WHERE("daan = #{daan}");
                if(record.getDiffact() != null) WHERE("diffact = #{diffact}");
                if(record.getKmid() != null) WHERE("kmid = kmid");
                if(record.getTitle() != null) WHERE("title = #{title}");
                if(record.getChoicea() != null) WHERE("choicea = #{choicea}");
                if(record.getChoiceb() != null) WHERE("choiceb = #{choiceb}");
                if(record.getChoicec() != null) WHERE("choicec = #{choicec}");
                if(record.getChoiced() != null) WHERE("choiced = #{choiced}");
            }
        }}.toString();
    }

    public String update(XuanzeModel record){
        return new SQL(){{
            UPDATE(tableName);
            if(record != null){
                if(record.getId() != null) WHERE("id = #{id}");
                if(record.getDaan() != null) SET("daan = #{daan}");
                if(record.getDiffact() != null) SET("diffact = #{diffact}");
                if(record.getKmid() != null) SET("kmid = kmid");
                if(record.getTitle() != null) SET("title = #{title}");
                if(record.getChoicea() != null) SET("choicea = #{choicea}");
                if(record.getChoiceb() != null) SET("choiceb = #{choiceb}");
                if(record.getChoicec() != null) SET("choicec = #{choicec}");
                if(record.getChoiced() != null) SET("choiced = #{choiced}");
            }
        }}.toString();
    }

    public String selectAll(XuanzeModel record) {
        return new SQL() {{
            SELECT("*");
            FROM(tableName);
            if (record != null) {
                if (record.getId() != null) WHERE("id = #{id}");
                if (record.getDaan() != null) WHERE("daan = #{daan}");
                if (record.getDiffact() != null) WHERE("diffact = #{diffact}");
                if (record.getKmid() != null) WHERE("kmid = kmid");
                if (record.getTitle() != null) WHERE("title = #{title}");
                if (record.getChoicea() != null) WHERE("choicea = #{choicea}");
                if (record.getChoiceb() != null) WHERE("choiceb = #{choiceb}");
                if (record.getChoicec() != null) WHERE("choicec = #{choicec}");
                if (record.getChoiced() != null) WHERE("choiced = #{choiced}");
            }
        }}.toString();
    }
}
