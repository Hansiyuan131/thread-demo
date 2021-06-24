package com.tt.threaddemo.thread;

/**
 * @author hansiyuan
 * @date 2021年06月18日 16:10
 */
public class SerialNum {
    private static int nextSerialNum = 0;

    private static ThreadLocal serialNum = new ThreadLocal() {
        @Override
        protected synchronized Object initialValue() {
            return nextSerialNum++;
        }
    };

    public static int get() {
        return (Integer) (serialNum.get());
    }
}
