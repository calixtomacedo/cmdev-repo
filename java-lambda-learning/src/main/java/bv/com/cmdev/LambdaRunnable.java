package bv.com.cmdev;

public class LambdaRunnable {

    public static void main(String[] args) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello World!");
            }
        }).run();

        new Thread(() -> System.out.println("Hello World 02!")).run();
    }
}
