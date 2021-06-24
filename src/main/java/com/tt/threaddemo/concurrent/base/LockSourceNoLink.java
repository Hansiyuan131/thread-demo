package com.tt.threaddemo.concurrent.base;

/**
 * 锁定两个没有关系的资源
 * <p>
 * - 账户里的两种资源：余额、支付密码
 *
 * @author hansiyuan
 * @date 2021年06月24日 14:21
 */
public class LockSourceNoLink {
    private Integer balance;
    private String password;
    private final Object balanceLock = new Object();
    private final Object passwordLock = new Object();

    public void withdraw(Integer amt) {
        synchronized (balanceLock) {
            if (this.balance >= amt) {
                this.balance -= amt;
            }
        }
    }

    public Integer getBalance() {
        synchronized (balance) {
            return balance;
        }
    }

    public void updPassword(String pwd) {
        synchronized (passwordLock) {
            this.password = pwd;
        }
    }

    public String getPassword() {
        synchronized (passwordLock) {
            return password;
        }
    }
}
