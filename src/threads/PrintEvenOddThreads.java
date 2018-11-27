package threads;

public class PrintEvenOddThreads {

    public static void main(String... args) throws InterruptedException {

        Printer print = new Printer();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while(true)
                        print.printEven();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while(true)
                        print.printOdd();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });
        t1.start();
        t2.start();

//        t1.join();
//        t2.join();
    }


}

class Printer {

    boolean isOdd = true;
    int number = 1;

    synchronized void printEven() throws InterruptedException {

        while(isOdd){

            try{
                wait();
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        System.out.println("Even:" + number);
        isOdd = true;
        number++;
        notify();
        Thread.sleep(1000);
    }

    synchronized void printOdd() throws InterruptedException {

        while (!isOdd) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Odd:" + number);
        isOdd = false;
        number++;
        notify();
        Thread.sleep(1000);
    }
}
