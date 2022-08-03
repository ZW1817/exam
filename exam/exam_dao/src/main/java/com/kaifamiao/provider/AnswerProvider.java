package com.kaifamiao.provider;

import org.apache.ibatis.builder.annotation.ProviderMethodResolver;
import org.apache.ibatis.jdbc.SQL;

public class AnswerProvider implements ProviderMethodResolver {

    public String selectAllAnswer(String stno){
        SQL sql = new SQL();
        sql.SELECT("p.*, s.title,s.starttime,s.tno,t.name");
        sql.FROM("paperstate p");
        sql.LEFT_OUTER_JOIN("shijuan s on p.shijuanid = s.id");
        sql.LEFT_OUTER_JOIN("teacher t on t.tno = s.tno");
        sql.WHERE("p.dstate = 1");
        sql.WHERE("p.stno = #{stno}");
        return sql.toString();
    }
}
