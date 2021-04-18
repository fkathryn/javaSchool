package com.sber.parser;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;


class LogParserTest {

    @Test
     void getNumberOfUniqueIPs() throws ParseException {
        System.out.println("*** getNumberOfUniqueIPs() ***");

        LogParser parse = new LogParser("src/log.log");
        Date dateAfter;
        Date dateBefore;
        String format = "dd.mm.yyyy hh:mm:ss";
        String after = "30.08.2012 16:08:40";
        String before = "12.12.2013 21:56:30";
        dateAfter = new SimpleDateFormat(format).parse(after);
        dateBefore = new SimpleDateFormat(format).parse(before);

        int expected = parse.getNumberOfUniqueIPs(dateAfter, dateBefore);
        int actual = 2;
        Assertions.assertEquals(expected, actual);

        expected = parse.getNumberOfUniqueIPs(null, null);
        actual =  6;
        Assertions.assertEquals(expected, actual);

    }

    @org.junit.jupiter.api.Test
    void getUniqueIPs() throws ParseException {
//        LogParser parse = new LogParser("src/log.log");
//        System.out.println("*** getUniqueIPs() ***");
//
//        Date dateAfter;
//        Date dateBefore;
//        String format = "dd.mm.yyyy hh:mm:ss";
//        String after = "30.08.2012 16:08:40";
//        String before = "12.12.2013 21:56:30";
//        dateAfter = new SimpleDateFormat(format).parse(after);
//        dateBefore = new SimpleDateFormat(format).parse(before);
//
//        Set<String> set = parse.getUniqueIPs(null, null);
//        for (String str : set) {
//            System.out.println(str);
//        }
    }

    @org.junit.jupiter.api.Test
    void getIPsForUser() throws ParseException {
//        LogParser parse = new LogParser("src/log.log");
//        System.out.println("*** getIPsForUser() ***");
//
//        Date dateAfter;
//        Date dateBefore;
//        String format = "dd.mm.yyyy hh:mm:ss";
//        String after = "30.08.2012 16:08:40";
//        String before = "12.12.2013 21:56:30";
//        dateAfter = new SimpleDateFormat(format).parse(after);
//        dateBefore = new SimpleDateFormat(format).parse(before);
//
//        Set<String> set = parse.getIPsForUser("Eduard Petrovich Morozko", null, null);
//        for (String str : set) {
//            System.out.println(str);
//        }
    }

    @org.junit.jupiter.api.Test
    void getIPsForEvent() throws ParseException {
//        LogParser parse = new LogParser("src/log.log");
//        System.out.println("*** getIPsForEvent() ***");
//
//        Date dateAfter;
//        Date dateBefore;
//        String format = "dd.mm.yyyy hh:mm:ss";
//        String after = "30.08.2012 16:08:40";
//        String before = "12.12.2013 21:56:30";
//        dateAfter = new SimpleDateFormat(format).parse(after);
//        dateBefore = new SimpleDateFormat(format).parse(before);
//
//        Event event = Event.LOGIN;
//        Set<String> set = parse.getIPsForEvent(event, null, dateBefore);
//        for (String str : set) {
//            System.out.println(str);
//        }
    }

    @org.junit.jupiter.api.Test
    void getIPsForStatus() throws ParseException {
//        LogParser parse = new LogParser("src/log.log");
//        System.out.println("*** getIPsForStatus() ***");
//
//        Date dateAfter;
//        Date dateBefore;
//        String format = "dd.mm.yyyy hh:mm:ss";
//        String after = "30.08.2012 16:08:40";
//        String before = "12.12.2013 21:56:30";
//        dateAfter = new SimpleDateFormat(format).parse(after);
//        dateBefore = new SimpleDateFormat(format).parse(before);
//
//        Status status = Status.OK;
//        Set<String> set = parse.getIPsForStatus(status, dateAfter, dateBefore);
//        for (String str : set) {
//            System.out.println(str);
//        }
    }
}