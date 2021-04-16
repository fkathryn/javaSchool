import java.io.*;
import java.util.ArrayList;

public class LogParser {
    private final ArrayList<Log> logs;

    public LogParser(String filename) {
        BufferedReader reader;
        this.logs = new ArrayList<>(100);
        try {
            reader = new BufferedReader(new FileReader( new File(filename)));
            String line = "";
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
            writer = new FileWriter("src/done_task.log", false);
            for (int i = 0; i < logs.size(); i++) {
                String text = selectionByDoneTask(logs.get(i));
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
        if (log.getEvent().length() > 9 && log.getEvent().substring(0, 9).equals("DONE_TASK") && log.getStatus().equals("OK")) {
            text = log.getIp() + "\t"
                    + log.getUsername() + "\t"
                    + log.getDate() + "\t"
                    + log.getEvent() + "\t"
                    + log.getStatus();

        }
        return text;
    }
}
