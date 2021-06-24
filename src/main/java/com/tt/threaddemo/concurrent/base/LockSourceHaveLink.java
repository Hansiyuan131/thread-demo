package com.tt.threaddemo.concurrent.base;

/**
 * 保护有关联关系的多个资源
 * 两个账户转帐
 *
 * @author hansiyuan
 * @date 2021年06月24日 14:32
 */
public class LockSourceHaveLink {
    private int balance;

    void transfer(LockSourceHaveLink target, int amt) {
        if (this.balance >= amt) {
            this.balance -= amt;
            target.balance += amt;
        }
    }
}
