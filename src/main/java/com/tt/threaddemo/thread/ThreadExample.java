package com.tt.threaddemo.thread;

/**
 * 要求： 子线程运行执行 10 次后，主线程再运行 5 次。这样交替执行三遍
 *
 * @author hansiyuan
 * @date 2021年06月18日 15:37
 */
public class ThreadExample {

    public static void main(String[] args) throws InterruptedException {
        //要求： 子线程运行执行 10 次后，主线程再运行 5 次。这样交替执行三遍
        final ThreadTask threadTask = new ThreadTask();
        new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                threadTask.subTask();
            }
        }).start();
        for (int i = 0; i < 3; i++) {
            threadTask.mainTask();
        }
    }


}

class ThreadTask {
    private static boolean subFlag = true;

    public synchronized void subTask() {
        try {
            if (!subFlag) {
                wait();
            }
            System.out.print("子线程：");
            for (int i = 1; i <= 10; i++) {
                System.out.print(" " + i + " ");
            }
            Thread.sleep(1000);
            System.out.println();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        subFlag = false;
        notify();
    }

    public synchronized void mainTask() throws InterruptedException {
        if (subFlag) {
            wait();
        }
        System.out.print("主线程：");
        for (int i = 1; i <= 5; i++) {
            System.out.print(" " + i + " ");
        }
        Thread.sleep(1000);
        System.out.println();
        subFlag = true;
        notify();
    }
}
