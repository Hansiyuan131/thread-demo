package com.tt.threaddemo.concurrent.base;

/**
 * 死锁案例
 *
 * @author hansiyuan
 * @date 2021年06月24日 14:56
 */
public class DeadlockExample {
    private int balance;

    void transfer(DeadlockExample target, int amt) {
        synchronized (this) {
            synchronized (target) {
                if (this.balance > amt) {
                    this.balance -= amt;
                    target.balance += amt;
                }
            }
        }
    }
}
