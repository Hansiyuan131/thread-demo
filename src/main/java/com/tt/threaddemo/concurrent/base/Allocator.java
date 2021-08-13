package com.tt.threaddemo.concurrent.base;

import java.util.List;

/**
 * 单例的资源分配器
 *
 * @author hansiyuan
 * @date 2021年06月27日 20:10
 */
public class Allocator {
    private List<Object> als;

    /**
     * 一次性申请资源
     */
    synchronized void apply(Object from, Object to) {
        // 经典写法 满足条件时
        while (als.contains(from) || als.contains(to)) {
            try {
                wait();
            } catch (Exception ignored) {

            }
        }
        als.add(from);
        als.add(to);
    }

    synchronized void free(Object from, Object to) {
        als.remove(from);
        als.remove(to);
        notifyAll();
    }


}
