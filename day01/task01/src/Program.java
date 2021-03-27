import java.util.Scanner;

public class Program{

    private static long calculate(int a, int b, char sign) {
        if (sign == '+')
            return (a + b);
        else if (sign == '-')
            return (a - b);
        else if (sign == '*')
            return (a * b);
        else if (sign == '/')
            return (a / b);
        return 0;
    }

    private static void scanInputParameters() {
        System.out.println("Введите <целое чило> <знак (+, -, *, /)> <целое чило>");
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        char sign = in.next().charAt(0);
        int b = in.nextInt();
        long res = calculate(a, b, sign);
        System.out.println(res);
    }

    public static void main(String[] args) {
        try {
            scanInputParameters();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
