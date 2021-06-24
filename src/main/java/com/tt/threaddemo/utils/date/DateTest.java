package com.tt.threaddemo.utils.date;

import java.text.SimpleDateFormat;
import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

/**
 * @author hansiyuan
 * @date 2021年06月17日 9:37
 */
public class DateTest {


    public static void calendarTest() {
        //Calendar cal = new GregorianCalendar();
        Calendar cal = new GregorianCalendar(TimeZone.getTimeZone("UTC-8"));
        System.out.println(cal.get(Calendar.YEAR));
        System.out.println(cal.get(Calendar.MONTH) + 1);
        System.out.println(cal.get(Calendar.DATE));
        System.out.println(cal.get(Calendar.HOUR_OF_DAY));
        System.out.println(cal.get(Calendar.MINUTE));
        System.out.println(cal.get(Calendar.SECOND));
        System.out.println(cal.getTime());
        System.out.println(cal.getTimeInMillis());
        System.out.println(Calendar.getInstance().getTimeInMillis());
        System.out.println(System.currentTimeMillis());
        System.out.println(Clock.systemDefaultZone().millis());
    }

    public static void localDateTimeTest() {
        LocalDateTime ld = LocalDateTime.now();
        System.out.println(ld.getYear());
        System.out.println(ld.getMonthValue());
        System.out.println(ld.getDayOfMonth());
        System.out.println(ld.getHour());
        System.out.println(ld.getMinute());
        System.out.println(ld.getSecond());

    }

    public static void getMonthLastDay() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.add(Calendar.MONTH,0);
        c.set(Calendar.DAY_OF_MONTH, 1);
        String first = format.format(c.getTime());
        System.out.println("===============first:" + first);

        Calendar ca = Calendar.getInstance();
        ca.set(Calendar.DAY_OF_MONTH, ca.getActualMaximum(Calendar.DAY_OF_MONTH));
        String last = format.format(ca.getTime());
        System.out.println("===============last:" + last);

        LocalDate today = LocalDate.now();
        LocalDate firstday = LocalDate.of(today.getYear(), today.getMonth(), 1);
        LocalDate lastDay = today.with(TemporalAdjusters.lastDayOfMonth());
        System.out.println("本月的第一天" + firstday);
        System.out.println("本月的最后一天" + lastDay);
    }

    public static void dateFormatter() {
        SimpleDateFormat oldFormatter = new SimpleDateFormat("yyyy/MM/dd");
        Date date1 = new Date();
        System.out.println(oldFormatter.format(date1));

        DateTimeFormatter newFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate date2 = LocalDate.now();
        System.out.println(date2.format(newFormatter));
    }


    public static void main(String[] args) {
        //calendarTest();
        //localDateTimeTest();
        //getMonthLastDay();
        //dateFormatter();
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);
        System.out.println(cal.getTime());

        LocalDateTime today = LocalDateTime.now();
        LocalDateTime yesterday = today.minusDays(1);
        System.out.println(yesterday);

    }
}
