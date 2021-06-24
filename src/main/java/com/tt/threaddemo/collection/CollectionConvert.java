package com.tt.threaddemo.collection;

import java.util.*;

/**
 * 练习：将集合转换为线程安全的集合
 *
 * @author hansiyuan
 * @date 2021年06月16日 11:06
 */
public class CollectionConvert {

    public Collection<String> loop01(List<String> list) {
        for (String v : list) {
            if ("1".equals(v)) {
                list.remove(v);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        CollectionConvert cc = new CollectionConvert();
        List<String> list1 = Collections.synchronizedList(list);
        System.out.println(cc.loop01(list1));
    }
}
