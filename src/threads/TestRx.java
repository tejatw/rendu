package threads;

import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;

public class TestRx {

    public static void main(String... args) {

        long startTime = System.currentTimeMillis();

        Flowable.range(1, 100000)
                .observeOn(Schedulers.computation())
                .map(v -> v * v)
                .blockingSubscribe(System.out::println);

        long endTime = System.currentTimeMillis();

        System.out.println("time taken is " + (endTime - startTime));
    }
}
