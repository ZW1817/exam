package com.kaifamiao.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class AnswerModel implements Serializable {

    private String shijuanid;

    private String starttime;

    private String title;

    private String name;

    private Boolean ystate;

    private String submittime;

    private Integer defen;

    private  double score;
}
