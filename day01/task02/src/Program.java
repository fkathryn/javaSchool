import java.util.Scanner;

public class Program {

    private static void printOutput(String m, String str) {
        if (m.equals("min")) {
            int min = 9;
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) < min + 48) {
                    min = str.charAt(i) - 48;
                }
            }
            System.out.println(min);
        } else {
            int max = 0;
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) > max + 48) {
                    max = str.charAt(i) - 48;
                }
            }
            System.out.println(max);
        }
    }

    private static void scanString() {
        Scanner in = new Scanner(System.in);
        String m = in.next();
        if (m.equals("min") || m.equals("max")) {
            String str = in.next();
            printOutput(m, str);
        }
        else {
            System.out.println("Incorrect first parameter. Need min or max");
        }
    }

    public static void main(String[] args) {
        scanString();
    }
}
