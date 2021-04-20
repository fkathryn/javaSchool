import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int[] array = {1, 13, 43, 54, 33, 303, 77, 5, 10};
        int biggest = array[0];
        int secondBiggest = array[0];
        for  (int i = 1; i < array.length; i++) {
            if (array[i] > biggest) {
                secondBiggest = biggest;
                biggest = array[i];
            }
            else if (array[i] > secondBiggest && array[i] != biggest) {
                secondBiggest = array[i];
            }
        }
        System.out.println("biggest = " + biggest + " secondBiggest = " + secondBiggest);
    }

//    public static void main(String[] args) {
//        Scanner scan = new Scanner(System.in);
//        String str = scan.nextLine();
//        String[] words = str.split(" ");
//        HashMap<String, Integer> map = new HashMap<>();
//        for (String word : words) {
//            if (map.containsKey(word)) {
//                int count = map.get(word);
//                map.put(word, count + 1);
//            } else {
//                map.put(word, 1);
//            }
//        }
//        System.out.println(map);
//    }
}
