package threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class ReadFile implements Runnable{

    private String threadName;

    public ReadFile(String threadName){

        this.threadName = threadName;
    }

    public void run(){

        for (int i = 0; i < 5; i++) {

            System.out.println("Thread " + threadName + " iteration " + i);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class ThreadPoolReadFile {

    static final int MAX_SIZE=3;

    public static void main(String... args) {

        Runnable r1 = new ReadFile("thread1");
        Runnable r2 = new ReadFile("thread2");
        Runnable r3 = new ReadFile("thread3");
        Runnable r4 = new ReadFile("thread4");
        Runnable r5 = new ReadFile("thread5");

        ExecutorService pool = Executors.newFixedThreadPool(MAX_SIZE);

        pool.execute(r1);
        pool.execute(r2);
        pool.execute(r3);
        pool.shutdownNow();
        pool.execute(r4);
        pool.execute(r5);

//        pool.shutdown();

    }

}
