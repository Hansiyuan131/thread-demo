package com.tt.threaddemo.concurrent.container.collection;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * ConcurrentHashMap 的简单使用
 *
 * @author hansiyuan
 * @date 2021年06月16日 16:51
 */
public class UseConcurrentHashMap {
    public static void main(String[] args) {
        ConcurrentHashMap<String, Object> map = new ConcurrentHashMap<>();
        map.put("k1", "v1");
        map.put("k2", "v1");
        // 存在默认覆盖
        map.put("k1", "vv1");
        // 如果元素已经存在则不覆盖
        map.putIfAbsent("k1", "vvv1");

        for (Map.Entry<String, Object> me : map.entrySet()) {
            System.err.println("key: " + me.getKey() + ", value: " + me.getValue());
        }
        map.size();
    }
}
