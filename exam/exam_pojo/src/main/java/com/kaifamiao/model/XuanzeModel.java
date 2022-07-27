package com.kaifamiao.model;

import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName xuanze
 */
@Data
public class XuanzeModel implements Serializable {
    /**
     * 
     */
    private Integer id;

    /**
     * 
     */
    private String choicea;

    /**
     * 
     */
    private String choiceb;

    /**
     * 
     */
    private String choicec;

    /**
     * 
     */
    private String choiced;

    /**
     * 
     */
    private String daan;

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
    private Double diffact;

    private static final long serialVersionUID = 1L;
}