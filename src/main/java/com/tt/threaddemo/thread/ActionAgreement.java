package com.tt.threaddemo.thread;

/**
 * @author hansiyuan
 * @date 2021年06月19日 9:25
 */
public class ActionAgreement {
    public static void main(String[] args) {
        /*
         * 1. 多个线程（相同代码）操作同一个数据
         */
        ShareData shareData = new ShareData();
        for (int i = 0; i < 3; i++) {
            new Thread(new OperationData(shareData), "Thread " + i).start();
        }
    }
}
/**
 * 数据类 共同操作的数据类
 */
class ShareData {
    // 计数
    private int count = 0;

    public synchronized void inc() {
        count++;
        System.out.println(Thread.currentThread().getName() + "： 调用inc()方法 count=" + count);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

/**
 * 线程操作类
 */
class OperationData implements Runnable {

    private ShareData shareData;

    public OperationData(ShareData shareData) {
        this.shareData = shareData;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            shareData.inc();
        }
    }
}
