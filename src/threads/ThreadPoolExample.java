/*
package threads;

import java.util.concurrent.LinkedBlockingQueue;

public class ThreadPoolExample {

    private final int nThreads;
    private final PoolWorker[] threads;
    private final LinkedBlockingQueue queue;

    public ThreadPoolExample(int nThreads) {

        this.nThreads = nThreads;
        queue = new LinkedBlockingQueue();
        threads = new PoolWorker[nThreads];

        for (int i = 0; i < nThreads; i++) {

            threads[i] = new PoolWorker();
            threads[i].start();
        }
    }

    public void execute(Runnable task) {

        synchronized (queue) {

            queue.add(task);
            queue.notify();
        }
    }

    private class PoolWorker extends Thread {

        public void run() {

            Runnable task;

            while (true) {

                synchronized (queue) {

                    while (queue.isEmpty()) {

                        try {

                            queue.wait();
                        } catch (InterruptedException e) {

                            System.out.println("Error while queue is waiting " + e.getMessage());
                        }
                    }

                    task = queue.poll();
                }

                try {
                    task.run();
                } catch (RuntimeException e) {

                    System.out.println("Thread pool is interrupted due to " + e.getMessage());
                }
            }
        }
    }

}
*/
