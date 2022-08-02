package com.kaifamiao.model;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName shijuan
 */
@Data
public class ShijuanModel implements Serializable {
    /**
     * 
     */
    private Integer id;

    /**
     * 
     */
    private Integer kmid;

    /**
     * 
     */
    private String title;

    /**
     * 
     */
    private Integer zongfen;

    /**
     * 
     */
    private String tno;

    /**
     * 
     */
    private String starttime;

    /**
     * 难易程度
     */
    private Double diffaclt;

    private String endtime;

    private static final long serialVersionUID = 1L;
}