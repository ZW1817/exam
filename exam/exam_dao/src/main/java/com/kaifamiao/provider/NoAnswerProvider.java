package com.kaifamiao.provider;

import com.kaifamiao.model.NoAnswerModel;
import org.apache.ibatis.builder.annotation.ProviderMethodResolver;
import org.apache.ibatis.jdbc.SQL;

public class NoAnswerProvider implements ProviderMethodResolver {

    public String selectAll(){
        SQL sql = new SQL();
        sql.SELECT("s.starttime,s.title,t.name,p.dstate");
        sql.FROM("shijuan s");
        sql.LEFT_OUTER_JOIN("teacher t on s.tno = t.tno");
        sql.LEFT_OUTER_JOIN("paperstate p on s.id = p.shijuanid");
        return sql.toString();
    }
}
