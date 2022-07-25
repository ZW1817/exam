package com.kaifamiao.model;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName examlog
 */
@Data
public class Examlog implements Serializable {
    /**
     * 
     */
    private Integer id;

    /**
     * 开始答卷时间
     */
    private Date kstime;

    /**
     * 
     */
    private Integer sjid;

    /**
     * 
     */
    private String stno;

    /**
     * 
     */
    private String tno;

    /**
     * 
     */
    private Integer kmid;

    private static final long serialVersionUID = 1L;
}