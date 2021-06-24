package com.tt.threaddemo.thread;

import lombok.Data;

/**
 * @author hansiyuan
 * @date 2021年06月18日 16:14
 */
@Data
public class ThreadContext {
    private String userId;
    private Long transactionId;

    private static ThreadLocal threadLocal = ThreadLocal.withInitial(ThreadContext::new);

    public static ThreadContext get() {
        return (ThreadContext) threadLocal.get();
    }
}
