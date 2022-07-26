package com.kaifamiao.model;

import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName tiankong
 */
@Data
public class TiankongModel implements Serializable {
    /**
     * 
     */
    private Integer id;

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