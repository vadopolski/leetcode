package npsk;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        final A a = new A();
        Runnable r = new Runnable() {
            public void run() {
                for (int i = 0; i < 10_000_000; i++) {
                    a.a++;
                }
                System.out.println("Test a: " + a.a);
            }
        };
        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("Test a: " + a.a);
    }

    static class A {
        int a = 0;
    }
}