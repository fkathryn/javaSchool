package com.sber.parser;

import com.sber.parser.Status;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Log {
    private String ip;
    private String username;
    private Date date;
    private Event event;
    private Status status;
    private int numberTask;

    public void setNumberTask(String numberTask) {
        try {
            this.numberTask = Integer.parseInt(numberTask);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }
    public void setIp(String ip) {
        this.ip = ip;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public void setDate(String date) {
        try {
            String format = "dd.mm.yyyy hh:mm:ss";
            this.date = new SimpleDateFormat(format).parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    public void setEvent(String event) {
        switch (event) {
            case "LOGIN" -> this.event = Event.LOGIN;
            case "DOWNLOAD_PLUGIN" -> this.event = Event.DOWNLOAD_PLUGIN;
            case "WRITE_MESSAGE" -> this.event = Event.WRITE_MESSAGE;
        }
        if (this.event == null) {
            if (event.substring(0, 10).equals("SOLVE_TASK")) {
                this.event = Event.SOLVE_TASK;
                setNumberTask(event.substring(11));
            } else if (event.substring(0, 9).equals("DONE_TASK")) {
                this.event = Event.DONE_TASK;
                setNumberTask(event.substring(10));
            }
        }
    }
    public void setStatus(String status) {
        switch (status) {
            case "OK" -> this.status = Status.OK;
            case "FAILED" -> this.status = Status.FAILED;
            case "ERROR" -> this.status = Status.ERROR;
        }
    }
    public String getIp() {
        return ip;
    }
    public String getUsername() {
        return username;
    }
    public Date getDate() {
        return date;
    }
    public Event getEvent() {
        return event;
    }
    public Status getStatus() {
        return status;
    }
    public int getNumberTask() {
        return numberTask;
    }
}
