package com.sber.parser;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;


class LogParserTest {

    private final LogParser parse = new LogParser("src/log.log");
    private final String format = "dd.mm.yyyy hh:mm:ss";
    private String after = "30.08.2012 16:08:40";
    private String before = "12.12.2013 21:56:30";
    private Date dateAfter;
    private Date dateBefore;

    LogParserTest() throws ParseException {
        dateAfter = new SimpleDateFormat(format).parse(after);
        dateBefore = new SimpleDateFormat(format).parse(before);
    }

    private void printResult(Set<String> set) {
        for (String str : set) {
            System.out.println(str);
        }
    }

    @Test
     void getNumberOfUniqueIPs() throws ParseException {

        int expected = parse.getNumberOfUniqueIPs(dateAfter, dateBefore);
        int actual = 2;
        Assertions.assertEquals(expected, actual);

        expected = parse.getNumberOfUniqueIPs(null, null);
        actual =  6;
        Assertions.assertEquals(expected, actual);

        after = "01.01.2002 00:09:00";
        before = "31.12.2015 01:00:00";
        dateAfter = new SimpleDateFormat(format).parse(after);
        dateBefore = new SimpleDateFormat(format).parse(before);

        expected = parse.getNumberOfUniqueIPs(dateAfter, dateBefore);
        actual = 4;
        Assertions.assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void getUniqueIPs() {
        Set<String> set = parse.getUniqueIPs(null, null);
        printResult(set);
        System.out.println("-----------");
        set = parse.getUniqueIPs(dateAfter, null);
        printResult(set);
        System.out.println("-----------");
        set = parse.getUniqueIPs(dateAfter, dateBefore);
        printResult(set);
    }

    @org.junit.jupiter.api.Test
    void getIPsForUser() {
        Set<String> set = parse.getIPsForUser("Eduard Petrovich Morozko", null, null);
        printResult(set);
        System.out.println("----------");
        set = parse.getIPsForUser("Eduard Petrovich Morozko", dateAfter, dateBefore);
        printResult(set);
        System.out.println("----------");
        set = parse.getIPsForUser("Eduard Petrovich Morozko", null, dateBefore);
        printResult(set);
        System.out.println("----------");
        set = parse.getIPsForUser("fkathryn", null, dateBefore);
        printResult(set);
        System.out.println("----------");
        set = parse.getIPsForUser("Vasya Pupkin", dateAfter, dateBefore);
        printResult(set);
    }

    @org.junit.jupiter.api.Test
    void getIPsForEvent() {
        Set<String> set;
        for (Event event : Event.values()) {
            System.out.println(Event.valueOf(event.name()));
            set = parse.getIPsForEvent(event, null, dateBefore);
            printResult(set);
            System.out.println("----------");
            set = parse.getIPsForEvent(event, dateAfter, dateBefore);
            printResult(set);
            System.out.println("----------");
            set = parse.getIPsForEvent(event, null, null);
            printResult(set);
        }
    }

    @org.junit.jupiter.api.Test
    void getIPsForStatus() {
        Set<String> set;
        for (Status status : Status.values()) {
            System.out.println(Status.valueOf(status.name()));
            set = parse.getIPsForStatus(status, null, dateBefore);
            printResult(set);
            System.out.println("----------");
            set = parse.getIPsForStatus(status, dateAfter, dateBefore);
            printResult(set);
            System.out.println("----------");
            set = parse.getIPsForStatus(status, null, null);
            printResult(set);
        }
    }
}