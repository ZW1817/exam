package com.kaifamiao.model;

import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName kemu
 */
@Data
public class KemuModel implements Serializable {
    /**
     * 
     */
    private Integer id;

    /**
     * 
     */
    private String name;

    private static final long serialVersionUID = 1L;
}