package com.kaifamiao.provider;

import org.apache.ibatis.builder.annotation.ProviderMethodResolver;
import org.apache.ibatis.jdbc.SQL;

public class AnswerProvider implements ProviderMethodResolver {

    public String selectAllAnswer(){
        SQL sql = new SQL();
        sql.SELECT("s.starttime ,s.title,t.name,p.ystate,d.submittime,d.defen");
        sql.FROM("shijuan s");
        sql.LEFT_OUTER_JOIN("teacher t on s.tno = t.tno");
        sql.LEFT_OUTER_JOIN("paperstate p on s.id = p.shijuanid");
        sql.LEFT_OUTER_JOIN("dajuanitem d on s.id = d.shijuanid");
        return sql.toString();
    }
}
