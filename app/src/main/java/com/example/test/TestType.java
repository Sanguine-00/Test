package com.example.test;

import java.lang.reflect.Type;

/**
 * Created by 张高强 on 2016/12/6.
 * 邮箱: zhang.gaoqiang@mobcb.com
 */

public class TestType {
    private String name = "zhangsan";
    private int age = 14;
    private char sex = '男';

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public static void main(String[] args) {
        String str = "我叫%1$s,今年%2$s岁!";
        System.out.println(str.format(str,"张三","3"));

    }
}
