import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class TestMultiThread {

    public TestMultiThread() {

    }
    Semaphore s = new Semaphore(0);
CyclicBarrier c = new CyclicBarrier(2);
    Object o = new Object();
    private static CountDownLatch second = new CountDownLatch(1);
    private static CountDownLatch third = new CountDownLatch(1);
    public static void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        third.countDown();
    }

    public static  void second(Runnable printSecond) throws InterruptedException {
        // printSecond.run() outputs "second". Do not change or remove this line.
//        s.acquire();
//        c.
//        s.release();
        second.await();
        printSecond.run();
    }

    public static void third(Runnable printThird) throws InterruptedException {
        third.await();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
        second.countDown();
    }

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(()->{
            System.out.println("first");
        });
        Thread t2 = new Thread(()->{
            System.out.println("second");
        });
        Thread t3 = new Thread(()->{
            System.out.println("third");
        });


    }
}
