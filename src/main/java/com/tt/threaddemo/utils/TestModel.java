package com.tt.threaddemo.utils;

/**
 * @author hansiyuan
 * @date 2021年06月16日 20:12
 */
public class TestModel {

    public UserModel modify(UserModel user) {
        UserModel userNew = UserModel.builder().age(22).name("aaa").build();
        user = userNew;
        return user;
    }

    public static void main(String[] args) {
        UserModel user = UserModel.builder().age(11).name("hhh").build();
        TestModel aa = new TestModel();
        System.out.println(aa.modify(user));
        System.out.println(user);
    }
}
