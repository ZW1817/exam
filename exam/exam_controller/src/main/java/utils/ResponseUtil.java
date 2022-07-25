package utils;

import lombok.Data;
import org.apache.ibatis.annotations.Param;

@Data
public class ResponseUtil {
    private Integer code;
    private Object msg;
    private Object data;

    public ResponseUtil(){}
    public ResponseUtil(@Param("state") Integer id, @Param("message") Object msg, @Param("Object") Object data){
        this.code=code;
        this.msg=msg;
        this.data=data;
    }
}
