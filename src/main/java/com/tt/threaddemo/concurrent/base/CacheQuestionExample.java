package com.tt.threaddemo.concurrent.base;

/**
 * （多核情况下）内存 与 CPU 数据一致性问题
 *
 * @author hansiyuan
 * @date 2021年06月23日 16:42
 */
public class CacheQuestionExample {
    private  long count;
    private final int loopCount = 100000;

    private synchronized void addOps() {
        int idx = 0;
        while (idx++ < loopCount) {
            count += 1;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        CacheQuestionExample test = new CacheQuestionExample();

        Thread t1 = new Thread(() -> {
            test.addOps();
        });
        Thread t2 = new Thread(() -> {
            test.addOps();
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println(test.count);
    }

}
