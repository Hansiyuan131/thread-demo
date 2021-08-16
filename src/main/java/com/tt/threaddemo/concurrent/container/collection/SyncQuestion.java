package com.tt.threaddemo.concurrent.container.collection;

import java.util.Collection;
import java.util.Iterator;
import java.util.Vector;

/**
 * 同步集合
 *
 * @author hansiyuan
 * @date 2021年06月16日 10:23
 */
public class SyncQuestion {

    /**
     * 加强for循环遍历
     * 疑问？ v=1，3时报错 v=2时不报错
     */
    public Collection<String> loop01(Vector<String> vector) {
        for (String v : vector) {
            if ("1".equals(v)) {
                vector.remove(v);
            }
        }
        return vector;
    }

    /**
     * 迭代器迭代
     */
    public Collection<String> loop02(Vector<String> vector) {
        Iterator<String> iterator = vector.iterator();
        while (iterator.hasNext()) {
            String v = iterator.next();
            if ("1".equals(v)) {
                vector.remove(v);
            }
        }
        return vector;
    }

    /**
     * for循环迭代
     */
    public Collection<String> loop03(Vector<String> vector) {
        for (int i = 0; i < vector.size(); i++) {
            String v = vector.get(i);
            if ("1".equals(v)) {
                vector.remove(v);
            }
        }
        Iterator<String> iterator = vector.iterator();
        return vector;
    }


    public static void main(String[] args) {

        /*
         * 1. 同步容器类：Vector、HashTable
         * 2. 同步容器类 复合操作会造成 ConcurrentModificationException 异常
         */
        Vector<String> vector = new Vector<>();
        vector.add("1");
        vector.add("2");
        vector.add("3");
        SyncQuestion sq = new SyncQuestion();
        //Collection<String> ret1 = sq.loop01(vector);
        //System.err.println(ret1.toString());

        Collection<String> ret2 = sq.loop02(vector);
        System.err.println(ret2.toString());

        //Collection<String> ret3 = sq.loop03(vector);
        //System.err.println(ret3.toString());

    }
}
