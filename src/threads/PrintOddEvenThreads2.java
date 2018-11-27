package threads;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class PrintOddEvenThreads2 {

    static AtomicBoolean isEven = new AtomicBoolean(false);
    static AtomicInteger atomicNumber = new AtomicInteger(1);
    static Object object = new Object();

    public static void main(String[] args) {
        Runnable print = () -> {
            while (atomicNumber.get() < 10) {
                synchronized (object) {
                    if ((atomicNumber.get() % 2 == 0) && "Even".equals(Thread.currentThread().getName())) {
                        System.out.println("Even" + ":" + atomicNumber.getAndIncrement());
                    } else if ((atomicNumber.get() % 2 != 0) && "Odd".equals(Thread.currentThread().getName())) {
                        System.out.println("Odd" + ":" + atomicNumber.getAndIncrement());
                    }
                }
            }
        };

        Thread t1 = new Thread(print);
        t1.setName("Even");
        t1.start();
        Thread t2 = new Thread(print);
        t2.setName("Odd");
        t2.start();

    }
}