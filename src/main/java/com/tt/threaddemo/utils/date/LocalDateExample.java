package com.tt.threaddemo.utils.date;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;

/**
 * @author hansiyuan
 * @date 2021年06月17日 11:34
 */
public class LocalDateExample {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        System.out.println(today);
        LocalDate firstDay2014 = LocalDate.of(2014, Month.JULY,1);
        System.out.println(firstDay2014);
        LocalDate todayKolkata = LocalDate.now(ZoneId.of("Asia/Kolkata"));
        System.out.println(todayKolkata);
        LocalDate dateFromBase = LocalDate.ofEpochDay(365);
        System.out.println("365th day from base date= "+dateFromBase);
        LocalDate hundredDay2014 = LocalDate.ofYearDay(2014, 100);
        System.out.println("100th day of 2014="+hundredDay2014);
    }
}
