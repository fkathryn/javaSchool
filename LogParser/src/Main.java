import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        LogParser parse = new LogParser("src/log.log");
        try {
            Date dateAfter;
            Date dateBefore;
            String format = "dd.mm.yyyy hh:mm:ss";
            String after = "30.08.2012 16:08:40";
            String before = "12.12.2013 21:56:30";
            dateAfter = new SimpleDateFormat(format).parse(after);
            dateBefore = new SimpleDateFormat(format).parse(before);

            System.out.println("*** getNumberOfUniqueIPs() ***");
            System.out.println(parse.getNumberOfUniqueIPs(null, null));

            System.out.println("*** getUniqueIPs() ***");
            Set<String> set = parse.getUniqueIPs(null, null);
            for (String str : set) {
                System.out.println(str);
            }

            System.out.println("*** getIPsForUser() ***");
            set = parse.getIPsForUser("Eduard Petrovich Morozko", null, null);
            for (String str : set) {
                System.out.println(str);
            }

            System.out.println("*** getIPsForEvent() ***");
            Event event = Event.LOGIN;
            set = parse.getIPsForEvent(event, null, dateBefore);
            for (String str : set) {
                System.out.println(str);
            }

            System.out.println("*** getIPsForStatus() ***");
            Status status = Status.OK;
            set = parse.getIPsForStatus(status, dateAfter, dateBefore);
            for (String str : set) {
                System.out.println(str);
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
