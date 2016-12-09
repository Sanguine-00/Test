package com.example.test;

/**
 * Created by 张高强 on 2016/12/6.
 * 邮箱: zhang.gaoqiang@mobcb.com
 */

public class JniTest {

    static {
        System.loadLibrary("hello");
    }

    public native String helloworldFromC();

    public native int add(int x, int y);

    public native String sayHelloInC(String str);

}
