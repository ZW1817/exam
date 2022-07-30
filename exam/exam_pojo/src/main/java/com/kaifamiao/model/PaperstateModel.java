package com.kaifamiao.model;

import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName paperstate
 */
@Data
public class PaperstateModel implements Serializable {
    /**
     * 
     */
    private Integer id;

    /**
     * 
     */
    private Integer shijuanid;

    /**
     * 
     */
    private Integer dstate;

    /**
     * 
     */
    private Integer ystate;

    /**
     * 
     */
    private String stno;

    private double score;

    private static final long serialVersionUID = 1L;
}