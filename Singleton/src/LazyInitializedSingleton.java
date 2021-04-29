public class LazyInitializedSingleton {
    private static LazyInitializedSingleton instance;
    private String name;

    private LazyInitializedSingleton(){}

    public static LazyInitializedSingleton getInstance() {
        if(instance == null) {
            System.out.println("new instance");
            instance = new LazyInitializedSingleton();
        }
        return instance;
    }

    @Override
    public String toString() {
        return "LazyInitializedSingleton{" +
                "name='" + name + '\'' +
                '}';
    }
}
