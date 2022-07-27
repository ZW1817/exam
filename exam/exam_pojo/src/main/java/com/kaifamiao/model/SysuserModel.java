package com.kaifamiao.model;

import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName sysuser
 */
@Data
public class SysuserModel implements Serializable {
    /**
     * 
     */
    private Integer id;

    /**
     * 
     */
    private String email;

    /**
     * 
     */
    private String password;

    /**
     * 
     */
    private String realname;

    /**
     * 
     */
    private String sex;

    /**
     * 
     */
    private String tell;

    /**
     * 
     */
    private String username;

    /**
     * 
     */
    private String photo;

    private static final long serialVersionUID = 1L;
}