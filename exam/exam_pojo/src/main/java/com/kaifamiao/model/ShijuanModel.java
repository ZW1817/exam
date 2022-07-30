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
    private Date starttime;

    /**
     * 难易程度
     */
    private Double diffaclt;

    private static final long serialVersionUID = 1L;
}