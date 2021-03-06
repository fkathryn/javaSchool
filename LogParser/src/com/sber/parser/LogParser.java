package com.sber.parser;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

public class LogParser implements IPQuery {

    private static final Logger logger = Logger.getLogger(LogParser.class.getName());

    private final ArrayList<Log> logs;

    public LogParser(String filename) {
        BufferedReader reader;
        this.logs = new ArrayList<>(100);
        try {
            logger.info("open the file for read");
            reader = new BufferedReader(new FileReader(filename));
            String line;
            logger.info("starting reading from file");
            while ((line = reader.readLine()) != null) {
                String[] valuesLine = line.split("\t");
                logsToArray(valuesLine);
            }
            writeDoneTaskToFile();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void logsToArray(String[] line) {
        Log log = new Log();
        log.setIp(line[0]);
        log.setUsername(line[1]);
        log.setDate(line[2]);
        log.setEvent(line[3]);
        log.setStatus(line[4]);
        logs.add(log);
    }

    private void writeDoneTaskToFile() {
        FileWriter writer;
        try {
            logger.info("creating a file to write");
            writer = new FileWriter("src/done_tasks.log", false);
            logger.info("writing to the created file");
            for (Log log : logs) {
                String text = selectionByDoneTask(log);
                if (text.length() != 0) {
                    writer.write(text + '\n');
                }
                writer.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String selectionByDoneTask(Log log) {
        String text = "";
        switch (log.getEvent()) {
            case DONE_TASK, SOLVE_TASK -> text = log.getIp() + "\t"
                    + log.getUsername() + "\t"
                    + log.getDate() + "\t"
                    + log.getEvent() + " " + log.getNumberTask() + "\t"
                    + log.getStatus();
        }
        switch (log.getStatus()) {
            case ERROR, FAILED -> text = "";
        }
        return text;
    }

    @Override
    public int getNumberOfUniqueIPs(Date after, Date before) {
        Set<String> set = getUniqueIPs(after, before);
        return set.size();
    }

    @Override
    public Set<String> getUniqueIPs(Date after, Date before) {
        Set<String> set = new HashSet<>(logs.size());
        if (after == null & before == null) {
            for (Log log : logs) {
                set.add(log.getIp());
            }
            return set;
        }
        for (Log log : logs) {
            if (after == null) {
                if (log.getDate().compareTo(before) < 0)
                    set.add(log.getIp());
            } else if (before == null) {
                if (log.getDate().compareTo(after) >= 0)
                    set.add(log.getIp());
            } else if ((log.getDate().compareTo(after) >= 0) && (log.getDate().compareTo(before) < 0))
                set.add(log.getIp());
        }
        return set;
    }

    @Override
    public Set<String> getIPsForUser(String user, Date after, Date before) {
        Set<String> set = new HashSet<>(logs.size());
        if (after == null & before == null) {
            for (Log log : logs) {
                if (log.getUsername().equals(user))
                    set.add(log.getIp());
            }
            return set;
        }
        for (Log log : logs) {
            if (after == null) {
                if (log.getDate().compareTo(before) < 0 && log.getUsername().equals(user))
                    set.add(log.getIp());
            } else if (before == null) {
                if (log.getDate().compareTo(after) >= 0  && log.getUsername().equals(user))
                    set.add(log.getIp());
            } else if ((log.getDate().compareTo(after) >= 0) && (log.getDate().compareTo(before) < 0) && log.getUsername().equals(user))
                set.add(log.getIp());
        }
        return set;
    }

    @Override
    public Set<String> getIPsForEvent(Event event, Date after, Date before) {
        Set<String> set = new HashSet<>(logs.size());
        if (after == null & before == null) {
            for (Log log : logs) {
                if (log.getEvent().equals(event))
                    set.add(log.getIp());
            }
            return set;
        }
        for (Log log : logs) {
            if (after == null) {
                if (log.getDate().compareTo(before) < 0 && log.getEvent().equals(event))
                    set.add(log.getIp());
            } else if (before == null) {
                if (log.getDate().compareTo(after) >= 0  && log.getEvent().equals(event))
                    set.add(log.getIp());
            } else if ((log.getDate().compareTo(after) >= 0) && (log.getDate().compareTo(before) < 0) && log.getEvent().equals(event))
                set.add(log.getIp());
        }
        return set;
    }

    @Override
    public Set<String> getIPsForStatus(Status status, Date after, Date before) {
        Set<String> set = new HashSet<>(logs.size());
        if (after == null & before == null) {
            for (Log log : logs) {
                if (log.getStatus().equals(status))
                    set.add(log.getIp());
            }
            return set;
        }
        for (Log log : logs) {
            if (after == null) {
                if (log.getDate().compareTo(before) < 0 && log.getStatus().equals(status))
                    set.add(log.getIp());
            } else if (before == null) {
                if (log.getDate().compareTo(after) >= 0 && log.getStatus().equals(status))
                    set.add(log.getIp());
            } else if ((log.getDate().compareTo(after) >= 0) && (log.getDate().compareTo(before) < 0) && log.getStatus().equals(status))
                set.add(log.getIp());
        }
        return set;
    }
}
