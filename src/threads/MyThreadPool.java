package threads;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class MyTask implements Runnable{

    private String name;

    public String getName() {

        return this.name;
    }

    public MyTask(String name) {
        this.name = name;
    }



    public void run(){

        try {

            System.out.println("Executing thread " + name + " at " + System.currentTimeMillis());
            Thread.sleep(10000);
        } catch (InterruptedException ie) {

            ie.printStackTrace();
        }
    }
}

public class MyThreadPool {

    public static void main(String... args) {

        MyTask task1 = new MyTask("1");
        MyTask task2 = new MyTask("2");
        MyTask task3 = new MyTask("3");
        MyTask task4 = new MyTask("4");


        ExecutorService threadPool = Executors.newFixedThreadPool(2);

        threadPool.execute(task1);
        threadPool.execute(task2);
        threadPool.execute(task3);
        threadPool.execute(task4);

        threadPool.shutdown();

    }
}
