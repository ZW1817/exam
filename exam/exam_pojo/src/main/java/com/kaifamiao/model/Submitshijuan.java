package com.kaifamiao.model;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class Submitshijuan implements Serializable {

    private List<ShijuanitemModel> papers;

    private String stno;
}
