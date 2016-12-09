package com.example.jingfeng.android.bean;

import java.io.Serializable;

/**
 * Created by MyStudio on 2015/7/16.
 */
public class CityArea implements Serializable {

    private Integer id;
    private String name;
    private String areaCode;

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

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }
}
