package ee.mtiidla.headfirst;

import java.util.HashSet;
import java.util.Set;

import rx.Observable;
import rx.functions.Func2;
import rx.schedulers.Schedulers;

class RxTest {

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

        Observable<String> multi = Observable.from(new String[]{"Multi one", "Multi two"})
                .map(s -> {
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException ignored) { }

                    String name = Thread.currentThread().getName();
                    System.out.println(s + " Work by: " + name);
                    return name;
                });

        Observable<String> first = Observable.zip(Observable.fromCallable(() -> {
            String first1 = "first";
            Thread.sleep(2000);
            return first1;
        }).map(s -> {
            String name = Thread.currentThread().getName();
            System.out.println("First Work by: " + name);
            return name;
        }), multi.subscribeOn(Schedulers.newThread()), new Func2<String, String, String>() {
            @Override
            public String call(String s, String s2) {
                String name = Thread.currentThread().getName();
                System.out.println("SMALL ZIP Function by: " + name);
                return name;
            }
        });
//                .subscribeOn(Schedulers.computation());

        Observable<String> second = Observable.fromCallable(() -> {
            String second1 = "second";
            Thread.sleep(2000);
            return second1;
        }).map(s -> {
            String name = Thread.currentThread().getName();
            System.out.println("Second Work by: " + name);
            return name;
        }).subscribeOn(Schedulers.io());

        Observable<String> third = Observable.fromCallable(() -> {
            String third1 = "third";
            Thread.sleep(2000);
            return third1;
        }).map(s -> {
            String name = Thread.currentThread().getName();
            System.out.println("Third Work by: " + name);
            return name;
        });

        Observable.zip(first, second, third, (s, s2, s3) -> {
            String name = Thread.currentThread().getName();
            System.out.println("ZIP Function by: " + name);
            return name;
        }).subscribeOn(Schedulers.computation())
                .subscribe(System.out::println);

    }

    private static void mergeScanThreadsTest() {
        Observable<String> first = Observable.fromCallable(() -> {
            String first1 = "first";
            Thread.sleep(2000);
            return first1;
        }).map(s -> {
            String name = Thread.currentThread().getName();
            System.out.println("First Work by: " + name);
            return name;
        }).subscribeOn(Schedulers.computation())

                ;
        Observable<String> second = Observable.fromCallable(() -> {
            String second1 = "second";
            Thread.sleep(2000);
            return second1;
        }).map(s -> {
            String name = Thread.currentThread().getName();
            System.out.println("Second Work by: " + name);
            return name;
        }).subscribeOn(Schedulers.io())

                ;

        Observable<String> third = Observable.fromCallable(() -> {
            String third1 = "third";
            Thread.sleep(2000);
            return third1;
        }).map(s -> {
            String name = Thread.currentThread().getName();
            System.out.println("Third Work by: " + name);
            return name;
        }).subscribeOn(Schedulers.newThread())

                ;


        System.out.println("Start merge");
        Observable<String> merge = Observable.merge(first, second, third);
        merge.scan("initial", (s, s2) -> {
            System.out.println("Scan by: "  + Thread.currentThread().getName());
            return "";
        })
                .subscribeOn(Schedulers.newThread())
                .observeOn(Schedulers.immediate())
                .subscribe(System.out::println);
    }

}
