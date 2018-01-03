package com.hello.ibatis.test;

import java.io.Serializable;

/**
 * Created by wangjb-c on 2017/5/15.
 */
public class Dept implements Serializable{
    private Integer id;
    private String name;
    private String code;
    private int order;

    public Dept() {
    }

    public Dept(Integer id, String name, String code, int order) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.order = order;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }
}
