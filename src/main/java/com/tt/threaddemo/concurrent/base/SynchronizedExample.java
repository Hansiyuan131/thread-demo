package com.tt.threaddemo.concurrent.base;

import org.apache.logging.log4j.spi.StandardLevel;
import sun.awt.windows.ThemeReader;

/**
 * 管程：Java互斥锁 Synchronized 的demo
 *
 * @author hansiyuan
 * @date 2021年06月24日 12:31
 */
public class SynchronizedExample {
    private long value = 0L;
    private volatile  boolean isRunning = false;

    public  void setRunning() {
        isRunning = true;
    }

    public  boolean getRunning() {
        return isRunning;
    }


    public synchronized long getValue() {
        return value;
    }

    public synchronized void addOne() {
        value += 1;
        System.out.println("add :" + value);
    }

    public static void main(String[] args) throws InterruptedException {
        SynchronizedExample example = new SynchronizedExample();
        new Thread(() -> {
            while (!example.getRunning()) {
                System.out.println("运行中....");
            }
            System.out.println("Thread 1 finished.");
        }).start();
        Thread.sleep(1000);
        new Thread(() -> {
            while (true) {
                example.setRunning();
            }
        }).start();
    }
}
