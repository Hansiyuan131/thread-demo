package com.tt.threaddemo.utils.date;

import java.time.Duration;
import java.time.Instant;

/**
 * @author hansiyuan
 * @date 2021年06月17日 11:48
 */
public class InstantExample {
    public static void main(String[] args) {
        Instant timestamp = Instant.now();
        System.out.println("Current Timestamp = "+timestamp);
        Instant specificTime = Instant.ofEpochMilli(timestamp.toEpochMilli());
        System.out.println("Specific Time = "+specificTime);
        Duration thirtyDay = Duration.ofDays(30);
        System.out.println(thirtyDay);
    }
}
