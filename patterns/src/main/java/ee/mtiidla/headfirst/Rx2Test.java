package ee.mtiidla.headfirst;

import io.reactivex.BackpressureStrategy;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;

class Rx2Test {

    public static void main(String[] args) {

        zipThreadsTest();

        Object mon = new Object();
        synchronized (mon) {
            try {
                mon.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static void zipThreadsTest() {

        PublishSubject<Integer> input = PublishSubject.create();

        input.toFlowable(BackpressureStrategy.LATEST)
                .toObservable() // buffers all events up to Long.MAX_VALUE
                .observeOn(Schedulers.computation()) // can also be used to buffer a Flowable, by passing in 3rd parameter
                .map((it) -> {
                    // consumer is slower than producer
                    Thread.sleep(10);
                    return it;
                })
                .subscribe((onNext) -> {
                    System.out.println("Receiving: " + onNext);
                }, (onError) -> {
                    System.out.println(onError);
                });

        for (int i = 0; i < 200; i++) {
            System.out.println("Sending: " + i);
            input.onNext(i);
        }
    }
}
