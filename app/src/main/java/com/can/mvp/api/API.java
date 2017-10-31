package com.can.mvp.api;

/**
 * Created by wangjiafeng on 17-7-10.
 */

public class API {

    public static boolean login(String username, String password) {
        if ("test".equals(username) && "123456".equals(password)) {
            return true;
        }
        return false;
    }

    public static String getResult() {
        return "hello world";
    }
}
