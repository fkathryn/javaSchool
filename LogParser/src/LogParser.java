import java.io.*;
import java.util.ArrayList;


public class LogParser {

    private ArrayList<Log> logs;
    private int counter = 0;

    public LogParser(String filename) {
        BufferedReader reader;
        this.logs = new ArrayList<>(100);
        try {
            reader = new BufferedReader(new FileReader( new File(filename)));
            String line = "";
            while ((line = reader.readLine()) != null) {
                String[] valuesLine = line.split("\t");
                parseLogs(valuesLine);
            }
            selectionByDoneTask();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void parseLogs(String[] line) {
        Log log = new Log();
        log.setIp(line[0]);
        log.setUsername(line[1]);
        log.setDate(line[2]);
        log.setEvent(line[3]);
        log.setStatus(line[4]);
        logs.add(log);
    }

    private void selectionByDoneTask() {

        try (FileWriter writer = new FileWriter("src/done_task.log", false)) {

            for (int i = 0; i < logs.size(); i++) {
                System.out.println(logs.get(i).getEvent());
                if (logs.get(i).getEvent().equals("DONE_TASK")) {
                    String text = logs.get(i).getIp()
                            + logs.get(i).getUsername()
                            + logs.get(i).getDate()
                            + logs.get(i).getEvent()
                            + logs.get(i).getStatus();
                    writer.write(text + '\n');
                }
                writer.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
