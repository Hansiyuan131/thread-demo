package com.tt.threaddemo.concurrent.base;

import javax.print.attribute.standard.PrinterURI;

/**
 * Java内存模型
 *
 * @author hansiyuan
 * @date 2021年06月24日 10:17
 */
public class MemoryModelExample {
    private int count = 0;
    private boolean isChange = false;
    private final Object lock = new Object();

    public void changeCount() {
        synchronized (lock) {
            isChange = true;
            count = 42;
        }
    }

    public void getCount() {
        if (isChange) {
            System.out.println(count);
        } else {
            System.out.println(count);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        /*
         * Java 内存模型 Happens-Before 规则
         *  1. 程序的顺序性规则：程序前面对某个变量的修改一定是对于后续操作可见的
         *  2. volatile 变量规则：volatile 变量的写操作，Happens-Before 于后续对这个volatile变量的读操作
         *  3. 传递性：A Happens-Before B，且 B Happens-Before C,那么 A Happens-Before C
         *  4. 管程中锁的规则：一个锁的解锁Happens-Before于后续对这个锁的加锁
         *  5. 线程 start() 规则：主线程A启动子线程B后，子线程B能够看到主线程在启动子线程B前的操作
         *  6. 线程 join() 规则:主线程可以看到子线程的操作，即对共享变量的操作
         */
        for (int i = 0; i < 10; i++) {
            System.out.println("========================");
            MemoryModelExample example = new MemoryModelExample();
            Thread t1 = new Thread(() -> {
                example.changeCount();
            });

            Thread t2 = new Thread(() -> {
                example.getCount();
            });
            t1.start();
            t2.start();
            t1.join();
            t2.join();
            System.out.println("========================");
        }
        Thread.sleep(1000000);
    }

}
