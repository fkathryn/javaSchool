public class Main {

    public static void main(String[] args) {

        System.out.println("🌝 int");
        MyArrayList<Integer> list = new MyArrayList<>(10);
        System.out.println("Size = " + list.getSize());
        list.set(0, 33);
        list.set(1, 323);
        list.set(2, 3);
        list.set(3, 313);
        list.set(4, 133);
        list.set(5, 332);
        list.set(6, 13);
        list.set(7, 31);
        list.set(8, 331);
        list.set(9, 133);

        for (int i = 0; i < list.getSize(); i++)
            System.out.println("Index = " + i + " : " + list.get(i));

        System.out.println("*** delete ***");
        list.delete(5);
        for (int i = 0; i < list.getSize(); i++)
            System.out.println("Index = " + i + " : " + list.get(i));

        System.out.println("*** sort ***");
        list.sort(new MyComparatorInteger());
        for (int i = 0; i < list.getSize(); i++)
            System.out.println("Index = " + i + " : " + list.get(i));
        System.out.println(list.iterator().next());
        System.out.println(list.iterator().next());
        System.out.println(list.iterator().next());
        System.out.println(list.iterator().next());


        System.out.println("🌝 String");
        MyArrayList<String> list1 = new MyArrayList<>(10);
        System.out.println("Size = " + list1.getSize());
        list1.set(0, "Users");
        list1.set(1, "qwerty");
        list1.set(2, "Hello");
        list1.set(3, "hello!");
        list1.set(4, "fkathryn");
        list1.set(5, "Library");
        list1.set(6, "VirtualMachines");
        list1.set(7, "Contents");
        list1.set(8, "Home");
        list1.set(9, "java");

        for (int i = 0; i < list1.getSize(); i++)
            System.out.println("Index = " + i + " : " + list1.get(i));

        System.out.println("*** delete ***");
        list1.delete(6);
        for (int i = 0; i < list1.getSize(); i++)
            System.out.println("Index = " + i + " : " + list1.get(i));
    }
}
