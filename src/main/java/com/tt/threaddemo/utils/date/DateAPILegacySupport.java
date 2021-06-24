package com.tt.threaddemo.utils.date;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

/**
 * @author hansiyuan
 * @date 2021年06月17日 14:33
 */
public class DateAPILegacySupport {
    public static void main(String[] args) {
        Instant timestamp = new Date().toInstant();
        LocalDateTime date = LocalDateTime.ofInstant(timestamp,
                ZoneId.of(ZoneId.SHORT_IDS.get("PST")));
        System.out.println("Date = " + date);
        Instant time = Calendar.getInstance().toInstant();
        System.out.println(time);
        ZoneId defaultZone = TimeZone.getDefault().toZoneId();
        System.out.println(defaultZone);
        ZonedDateTime gregorianCalendarDateTime = new GregorianCalendar().toZonedDateTime();
        System.out.println(gregorianCalendarDateTime);
        Date dt = Date.from(Instant.now());
        System.out.println(dt);
        TimeZone tz = TimeZone.getTimeZone(defaultZone);
        System.out.println(tz);
        GregorianCalendar gc = GregorianCalendar.from(gregorianCalendarDateTime);
        System.out.println(gc);
    }
}
