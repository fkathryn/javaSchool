import java.util.Scanner;

public class Main {

    private static int fibonacci(int n) {
        int x = 1;
        int y = 0;
        for (int i = 0; i < n; i++) {
            x += y;
            y = x - y;
        }
        return y;
    }

    private static int lastDigitFibonacci(int n) {
        int x = 1;
        int y = 0;
        for (int i = 0; i < n; i++) {
            x += y % 10;
            y = (x - y) % 10;
        }
        return y;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println(fibonacci(n));
        System.out.println(lastDigitFibonacci(n));
    }
}
