package com.cj.jtsys.sys.common.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class Node implements Serializable {

    private static final long serialVersionUID = 866960018192305949L;
    private Integer id;
    private String name;
    private Integer parentId;

}
