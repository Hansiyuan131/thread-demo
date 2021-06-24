package com.tt.threaddemo.utils.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

/**
 * @author hansiyuan
 * @date 2021年06月21日 14:48
 */
public class DateTimeTest {
    public static void main(String[] args) throws ParseException {
        String birthday = "1997年-04月-04日";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年-MM月-dd日");
        Date date = dateFormat.parse(birthday);
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();

        LocalDate localDate = instant.atZone(zoneId).toLocalDate();
        System.out.println("LocalDate = " + localDate);
        System.out.println();
    }
}
