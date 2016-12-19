package com.example.test.jingfeng.bean;

import java.util.List;

/**
 * Created by MyStudio on 2015/7/16.
 * 城市分店列表
 */
public class CityBranches {
    private Integer cityId;
    private String acronym;
    private String cityName;
    private List<MallInfoSimple> branches;

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public String getAcronym() {
        return acronym;
    }

    public void setAcronym(String acronym) {
        this.acronym = acronym;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public List<MallInfoSimple> getBranches() {
        return branches;
    }

    public void setBranches(List<MallInfoSimple> branches) {
        this.branches = branches;
    }
}
