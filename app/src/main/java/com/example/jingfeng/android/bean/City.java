package com.example.jingfeng.android.bean;

import java.io.Serializable;

/**
 * Created by MyStudio on 2015/7/16.
 */
public class City implements Serializable {
    private Integer id;
    private String name;
    private String acronym;

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

    public String getAcronym() {
        return acronym;
    }

    public void setAcronym(String acronym) {
        this.acronym = acronym;
    }
}
