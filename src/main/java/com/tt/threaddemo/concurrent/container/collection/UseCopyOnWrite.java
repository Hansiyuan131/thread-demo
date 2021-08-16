package com.tt.threaddemo.concurrent.container.collection;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author hansiyuan
 * @date 2021年08月13日 18:03
 */
public class UseCopyOnWrite {
    public static void main(String[] args) {
        CopyOnWriteArrayList<String> copyOnWriteArrayList = new CopyOnWriteArrayList<>();

        copyOnWriteArrayList.add("A");
    }
}
